package org.dapnet.core.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.dapnet.core.Service;

/**
 * This class provides the persistence service.
 * 
 * @author Philipp Thiel
 */
public final class PersistenceService implements Service {

	private final PersistenceConfiguration config;
	private EntityManagerFactory emf;
	private UserManager userManager;

	/**
	 * Creates a new persistence service instance.
	 * 
	 * @param config
	 *            Service configuration
	 */
	public PersistenceService(PersistenceConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	/**
	 * Gets the {@link EntityManagerFactory} instance.
	 * 
	 * @return Entity manager factory instance
	 */
	EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	private Properties loadAdditionalConfig() throws IOException {
		String fileName = config.getConfigFileName();
		if (fileName == null) {
			return null;
		}

		Properties props = new Properties();
		try (FileInputStream in = new FileInputStream(fileName)) {
			props.load(in);
		}

		return props;
	}

	@Override
	public void start() throws Exception {
		Properties props = loadAdditionalConfig();
		if (props == null) {
			emf = Persistence.createEntityManagerFactory("dapnet-core");
		} else {
			emf = Persistence.createEntityManagerFactory("dapnet-core", props);
		}

		userManager = new UserManager(this);
	}

	@Override
	public void shutdown() {
		if (emf != null) {
			emf.close();
		}
	}

}
