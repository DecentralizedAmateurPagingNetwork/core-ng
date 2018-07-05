package org.dapnet.core.scheduler;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public final class SchedulerService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final SchedulerConfiguration config;
	private final Scheduler scheduler;
	private volatile boolean running = false;

	public SchedulerService(SchedulerConfiguration config) throws SchedulerException {
		this.config = Objects.requireNonNull(config);
		scheduler = StdSchedulerFactory.getDefaultScheduler();
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		scheduler.start();
		running = true;
		LOGGER.info("Scheduler service has been started.");
	}

	@Override
	public void shutdown() throws Exception {
		try {
			scheduler.shutdown();
		} catch (SchedulerException ex) {
			LOGGER.error("Failed to stop scheduler service.", ex);
		} finally {
			running = false;
		}
	}

}
