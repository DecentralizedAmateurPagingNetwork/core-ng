package org.dapnet.core.util;

/**
 * This interface defines methods to modify properties.
 * 
 * @author Philipp Thiel
 */
public interface PropertyWriter {

	/**
	 * Sets a boolean property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	void setProperty(String key, boolean value);

	/**
	 * Sets an integer property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	void setProperty(String key, int value);

	/**
	 * Sets a double property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	void setProperty(String key, double value);

	/**
	 * Sets a string property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	void setProperty(String key, String value);

	/**
	 * Removes a property from the configuration.
	 * 
	 * @param key
	 *            Property to remove.
	 */
	void removeProperty(String key);

}
