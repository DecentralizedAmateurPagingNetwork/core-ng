package org.dapnet.core.rest;

import java.util.Objects;

import org.dapnet.core.Service;

public final class RestService implements Service {

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
