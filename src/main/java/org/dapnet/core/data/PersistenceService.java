package org.dapnet.core.data;

import java.util.Objects;

import org.dapnet.core.Service;

/**
 * This class provides the persistence service.
 * 
 * @author Philipp Thiel
 */
public final class PersistenceService implements Service {

	private final PersistenceConfiguration config;

	/**
	 * Creates a new persistence service instance.
	 * 
	 * @param config Service configuration
	 */
	public PersistenceService(PersistenceConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public void start() throws Exception {

	}

	@Override
	public void shutdown() {
	}

}
