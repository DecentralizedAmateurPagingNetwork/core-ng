package org.dapnet.core.data;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

/**
 * This class provides the configuration for the {@link PersistenceService}.
 * 
 * @author Philipp Thiel
 */
public final class PersistenceConfiguration extends Configuration {

	private String configFileName;

	/**
	 * Gets the optional configuration file name.
	 * 
	 * @return File name or {@code null}.
	 */
	public String getConfigFileName() {
		return configFileName;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		configFileName = reader.getString("persistence.config", null);
	}

}
