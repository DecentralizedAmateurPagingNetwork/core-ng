package org.dapnet.core.transmission;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.dapnet.core.events.EventManager;

public final class TransmitterService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final PagerProtocolSettings protocolSettings;
	private final EventManager eventManager;
	private volatile boolean running = false;

	public TransmitterService(TransmissionConfiguration transmissionSettings, PagerProtocolSettings protocolSettings,
			EventManager eventManager) {
		this.protocolSettings = Objects.requireNonNull(protocolSettings);
		this.eventManager = eventManager;
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		running = true;
	}

	@Override
	public void shutdown() throws Exception {
		running = false;
	}

}
