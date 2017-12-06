package org.dapnet.core.rest;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;

public final class RestService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final RestSettings settings;

	public RestService(RestSettings settings) {
		this.settings = Objects.requireNonNull(settings);
	}

	@Override
	public void start() throws Exception {
	}

	@Override
	public void shutdown() {
	}

}
