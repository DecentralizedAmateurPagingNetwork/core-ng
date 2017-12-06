package org.dapnet.core.cluster;

import java.util.Objects;

import org.dapnet.core.Service;

public final class ClusterService implements Service {

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
