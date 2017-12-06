package org.dapnet.core.cluster;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;

public final class ClusterService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final ClusterSettings settings;

	public ClusterService(ClusterSettings settings) {
		this.settings = Objects.requireNonNull(settings);
	}

	@Override
	public void start() throws Exception {
	}

	@Override
	public void shutdown() {
	}

}
