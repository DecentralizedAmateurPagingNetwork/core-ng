package org.dapnet.core;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Program {

	private static final Logger LOGGER = LogManager.getLogger();

	private static void loadSettings() {
	}

	private static void shutdownHandler() {
		try {

		} catch (Exception ex) {
			LOGGER.catching(ex);
		}

		// Shutdown log4j
		LogManager.shutdown();
	}

	private static Options parseArgs(String[] args) throws ParseException {
		Options opts = new Options();
		opts.addOption("h", "help", false, "print help text");
		opts.addOption("v", "version", false, "print version information");
		opts.addOption("c", "config", true, "configuration file to use");

		CommandLineParser parser = new DefaultParser();
		parser.parse(opts, args);

		return opts;
	}

	private static void showHelp(Options opts) {
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("dapnet-core [options]", opts);
	}

	private static void showVersion() {
		System.out.println("TODO Version");
	}

	public static void main(String[] args) {
		Options opts = null;
		try {
			opts = parseArgs(args);
		} catch (ParseException ex) {
			LOGGER.fatal("Failed to parse command line arguments.", ex);
			return;
		}

		if (opts.hasOption("help")) {
			showHelp(opts);
			return;
		} else if (opts.hasOption("version")) {
			showVersion();
			return;
		}

		// Register shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread(Program::shutdownHandler));

		loadSettings();
	}

}
