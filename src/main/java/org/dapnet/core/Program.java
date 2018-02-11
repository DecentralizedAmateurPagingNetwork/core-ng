package org.dapnet.core;

import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.cluster.ClusterConfiguration;
import org.dapnet.core.config.ConfigurationManager;
import org.dapnet.core.data.PersistenceConfiguration;
import org.dapnet.core.data.PersistenceService;
import org.dapnet.core.plugins.PluginConfiguration;
import org.dapnet.core.rest.RestApiConfiguration;
import org.dapnet.core.rest.RestApiService;
import org.dapnet.core.scheduler.SchedulerConfiguration;

/**
 * This class contains the application entry point.
 * 
 * @author Philipp Thiel
 */
public final class Program {

	private static final Logger LOGGER = LogManager.getLogger();

	/**
	 * Creates a {@link ConfigurationManager} instance.
	 * 
	 * @param configFile
	 *            Configuration file to load.
	 * @return Configuration manager instance.
	 * @throws IOException
	 *             if the configuration file could not be loaded.
	 */
	private static ConfigurationManager createConfigManager(String configFile) throws IOException {
		LOGGER.debug("Loading configuration from {}", configFile);
		ConfigurationManager config = new ConfigurationManager(configFile);
		config.put(new PersistenceConfiguration());
		config.put(new ClusterConfiguration());
		config.put(new SchedulerConfiguration());
		config.put(new RestApiConfiguration());
		config.put(new PluginConfiguration());

		return config;
	}

	private static void startPersistenceService(ConfigurationManager manager) {
		PersistenceConfiguration config = manager.get(PersistenceConfiguration.class);
		PersistenceService service = new PersistenceService(config);
		try {
			service.start();
		} catch (Exception ex) {
			LOGGER.catching(ex);
		}
	}

	private static void startRestApiService(ConfigurationManager manager) {
		RestApiConfiguration config = manager.get(RestApiConfiguration.class);
		if (!config.isEnabled()) {
			LOGGER.debug("REST API service is disabled.");
			return;
		}

		Service service = new RestApiService(config);
		try {
			service.start();
		} catch (Exception ex) {
			LOGGER.catching(ex);
		}
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
			System.out.println("TODO Version");
			return;
		}

		try {
			String value = cli.getOptionValue("c", "dapnet-core.properties");
			ConfigurationManager configManager = createConfigManager(value);

			// startPersistenceService(configManager);
			startRestApiService(configManager);
		} catch (Exception ex) {
			LOGGER.fatal("Core startup failed.", ex);
		}
	}

}
