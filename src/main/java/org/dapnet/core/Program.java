package org.dapnet.core;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.util.ConfigurationManager;

public final class Program {

	private static final Logger LOGGER = LogManager.getLogger();

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
			// Load configuration file
			String configFile = cli.getOptionValue("c", "dapnet-core.properties");
			LOGGER.debug("Loading configuration from {}", configFile);
			ConfigurationManager configManager = new ConfigurationManager(configFile);
		} catch (Exception ex) {
			LOGGER.fatal("Core startup failed.", ex);
		}
	}

}
