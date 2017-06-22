package org.dapnet.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class Program {

	private static final Logger LOGGER = LogManager.getLogger();

	public static void main(String[] args) {

	}

	private void shutdownHandler() {
		try {

		} catch (Exception ex) {
			LOGGER.catching(ex);
		}

		// Shutdown log4j
		LogManager.shutdown();
	}

}
