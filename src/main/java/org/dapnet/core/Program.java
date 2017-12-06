package org.dapnet.core;

import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
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

		CommandLineParser parser = new DefaultParser();
		parser.parse(opts, args);

		return opts;
	}

	public static void main(String[] args) {
		Options opts = null;
		try {
			opts = parseArgs(args);
		} catch (ParseException ex) {
			ex.printStackTrace();
		}

		// Register shutdown hook
		Runtime.getRuntime().addShutdownHook(new Thread(Program::shutdownHandler));

		loadSettings();
	}

}
