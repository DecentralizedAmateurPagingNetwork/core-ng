package org.dapnet.core.config;

import java.util.NoSuchElementException;

/**
 * This interface provides methods to read properties.
 * 
 * @author Philipp Thiel
 */
public interface PropertyReader {

	/**
	 * Gets an optional boolean from the configuration.
	 * 
	 * @param key          Key to look for.
	 * @param defaultValue Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	boolean getBoolean(String key, boolean defaultValue);

	/**
	 * Gets a mandatory boolean from the configuration.
	 * 
	 * @param key Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException If key not found or value is null.
	 */
	boolean getBoolean(String key);

	/**
	 * Gets an optional double from the configuration.
	 * 
	 * @param key          Key to look for.
	 * @param defaultValue Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	double getDouble(String key, double defaultValue);

	/**
	 * Gets a mandatory double from the configuration.
	 * 
	 * @param key Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException If key not found or value is null.
	 */
	double getDouble(String key);

	/**
	 * Gets an optional int from the configuration.
	 * 
	 * @param key          Key to look for.
	 * @param defaultValue Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	int getInteger(String key, int defaultValue);

	/**
	 * Gets a mandatory int from the configuration.
	 * 
	 * @param key Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException If key not found or value is null.
	 */
	int getInteger(String key);

	/**
	 * Gets an optional string from the configuration.
	 * 
	 * @param key          Key to look for.
	 * @param defaultValue Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	String getString(String key, String defaultValue);

	/**
	 * Gets a mandatory string from the configuration.
	 * 
	 * @param key Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException If key not found or value is null.
	 */
	String getString(String key);

}
