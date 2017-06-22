package org.dapnet.core.scheduler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

public final class SchedulerManager implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final Scheduler scheduler;

	public SchedulerManager() throws SchedulerException {
		scheduler = StdSchedulerFactory.getDefaultScheduler();
	}

	@Override
	public void start() throws Exception {
		scheduler.start();
		LOGGER.info("Scheduler manager has been started.");
	}

	@Override
	public void shutdown() {
		try {
			scheduler.shutdown();
		} catch (SchedulerException ex) {
			LOGGER.error("Failed to stop scheduler manager.", ex);
		}
	}

}
