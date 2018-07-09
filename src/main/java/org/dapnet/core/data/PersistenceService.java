package org.dapnet.core.data;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;

/**
 * This class provides the persistence service.
 * 
 * @author Philipp Thiel
 */
public final class PersistenceService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final PersistenceConfiguration config;
	private volatile boolean running = false;

	/**
	 * Creates a new persistence service instance.
	 * 
	 * @param config Service configuration
	 */
	public PersistenceService(PersistenceConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		LOGGER.info("Starting persistence service");
		running = true;
	}

	@Override
	public void shutdown() throws Exception {
		LOGGER.info("Stopping persistence service");
		running = false;
	}

}
