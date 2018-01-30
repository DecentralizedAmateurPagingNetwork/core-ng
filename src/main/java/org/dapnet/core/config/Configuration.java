package org.dapnet.core.config;

/**
 * Abstract base class for configuration objects.
 * 
 * @author Philipp Thiel
 */
public abstract class Configuration {

	/**
	 * Loads the configuration.
	 * 
	 * @param reader
	 *            Property reader instance
	 */
	public abstract void loadConfiguration(PropertyReader reader);

	/**
	 * Saves the configuration.
	 * 
	 * @param writer
	 *            Property writer instance
	 */
	public abstract void saveConfiguration(PropertyWriter writer);

}
