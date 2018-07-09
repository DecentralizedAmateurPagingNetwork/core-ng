package org.dapnet.core;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Deque;
import java.util.LinkedList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.cluster.ClusterConfiguration;
import org.dapnet.core.cluster.ClusterService;
import org.dapnet.core.config.ConfigurationManager;
import org.dapnet.core.data.PersistenceConfiguration;
import org.dapnet.core.data.PersistenceService;
import org.dapnet.core.plugins.PluginConfiguration;
import org.dapnet.core.rest.RestApiConfiguration;
import org.dapnet.core.rest.RestApiService;
import org.dapnet.core.scheduler.SchedulerConfiguration;
import org.dapnet.core.scheduler.SchedulerService;

/**
 * This class contains the application entry point.
 * 
 * @author Philipp Thiel
 */
public final class Program {

	private static final String CORE_VERSION = getVersionFromPackage();
	private static final Instant STARTUP_TIME = Instant.now();
	// private static final String API_VERSION = getApiVersionFromPackage();
	private static final Logger LOGGER = LogManager.getLogger();
	private static final Deque<Service> startedServices = new LinkedList<>();
	private static String coreName;

	/**
	 * Returns the configured core name. This value is only available after core
	 * startup has completed.
	 * 
	 * @return Core node name
	 */
	public static String getCoreName() {
		return coreName;
	}

	/**
	 * Returns the DAPNET core version number.
	 * 
	 * @return Version number
	 */
	public static String getCoreVersion() {
		return CORE_VERSION;
	}

	/**
	 * Returns the time since the program has started.
	 * 
	 * @return Uptime
	 */
	public static Duration getCoreUptime() {
		return Duration.between(STARTUP_TIME, Instant.now());
	}

	/**
	 * Creates a {@link ConfigurationManager} instance.
	 * 
	 * @param configFile Configuration file to load.
	 * @return Configuration manager instance.
	 * @throws IOException if the configuration file could not be loaded.
	 */
	private static ConfigurationManager createConfigManager(String configFile) throws IOException {
		LOGGER.debug("Loading configuration from {}", configFile);

		ConfigurationManager config = new ConfigurationManager(configFile);
		config.put(new CoreConfiguration());
		config.put(new PersistenceConfiguration());
		config.put(new ClusterConfiguration());
		config.put(new SchedulerConfiguration());
		config.put(new RestApiConfiguration());
		config.put(new PluginConfiguration());

		return config;
	}

	/**
	 * Shuts down all started services in reverse order of starting.
	 */
	private static void shutdownServices() {
		while (!startedServices.isEmpty()) {
			try {
				Service service = startedServices.removeLast();
				service.shutdown();
			} catch (Exception ex) {
				LOGGER.error("Service shutdown failed.", ex);
			}
		}
	}

	/**
	 * Loads the core configuration.
	 * 
	 * @param manager Configuration manager
	 */
	private static void loadCoreConfiguration(ConfigurationManager manager) {
		CoreConfiguration config = manager.get(CoreConfiguration.class);

		coreName = config.getName();

		if (config.isPreferIpv4()) {
			System.setProperty("java.net.preferIPv4Stack", "true");
		}
	}

	/**
	 * Starts the persistence service.
	 * 
	 * @param manager Configuration manager
	 */
	private static void startPersistenceService(ConfigurationManager manager) throws Exception {
		PersistenceConfiguration config = manager.get(PersistenceConfiguration.class);
		PersistenceService service = new PersistenceService(config);
		service.start();
		startedServices.addLast(service);
	}

	/**
	 * Starts the cluster service.
	 * 
	 * @param manager Configuration manager
	 */
	private static void startClusterService(ConfigurationManager manager) throws Exception {
		ClusterConfiguration config = manager.get(ClusterConfiguration.class);
		if (!config.isEnabled()) {
			LOGGER.info("Cluster service is disabled.");
			return;
		}

		Service service = new ClusterService(config);
		service.start();
		startedServices.addLast(service);
	}

	/**
	 * Starts the scheduler service.
	 * 
	 * @param manager Configuration manager.
	 * @throws Exception on error
	 */
	private static void startSchedulerService(ConfigurationManager manager) throws Exception {
		SchedulerConfiguration config = manager.get(SchedulerConfiguration.class);
		if (!config.isEnabled()) {
			LOGGER.info("Scheduler service is disabled.");
			return;
		}

		Service service = new SchedulerService(config);
		service.start();
		startedServices.addLast(service);
	}

	/**
	 * Starts the REST API service.
	 * 
	 * @param manager Configuration manager
	 */
	private static void startRestApiService(ConfigurationManager manager) throws Exception {
		RestApiConfiguration config = manager.get(RestApiConfiguration.class);
		if (!config.isEnabled()) {
			LOGGER.info("REST API service is disabled.");
			return;
		}

		Service service = new RestApiService(config);
		service.start();
		startedServices.addLast(service);
	}

	public static void main(String[] args) {
		Options opts = new Options();
		opts.addOption("h", "help", false, "print help text");
		opts.addOption("v", "version", false, "print version information");
		opts.addOption("c", "config", true, "configuration file to use");

		CommandLineParser parser = new DefaultParser();
		CommandLine cli = null;
		try {
			cli = parser.parse(opts, args);
		} catch (ParseException ex) {
			LOGGER.fatal("Failed to parse command line arguments.", ex);
			return;
		}

		if (cli.hasOption("help")) {
			HelpFormatter formatter = new HelpFormatter();
			formatter.printHelp("dapnet-core [options]", opts);
			return;
		} else if (cli.hasOption("version")) {
			System.out.println("DAPNET Core " + CORE_VERSION);
			return;
		}

		LOGGER.info("Starting DAPNET Core version {}", CORE_VERSION);

		try {
			registerShutdownHook();

			String value = cli.getOptionValue("c", "dapnet-core.properties");
			ConfigurationManager configManager = createConfigManager(value);

			loadCoreConfiguration(configManager);
			startPersistenceService(configManager);
			startClusterService(configManager);
			startSchedulerService(configManager);
			startRestApiService(configManager);
		} catch (Exception ex) {
			LOGGER.fatal("Core startup failed.", ex);
		}
	}

	private static String getVersionFromPackage() {
		String ver = Program.class.getPackage().getImplementationVersion();
		return ver != null ? ver : "UNKNOWN";
	}

//	private static String getApiVersionFromPackage() {
//		String ver = Program.class.getPackage().getSpecificationVersion();
//		return ver != null ? ver : "UNKNOWN";
//	}

	private static void registerShutdownHook() {
		Runnable r = () -> {
			shutdownServices();
			// Log4j automatic shutdown hook is disabled, call it manually
			LogManager.shutdown();
		};

		Runtime.getRuntime().addShutdownHook(new Thread(r));
	}

}
