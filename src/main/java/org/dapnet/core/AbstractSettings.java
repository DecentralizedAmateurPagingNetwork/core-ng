package org.dapnet.core;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Abstract base class for accessing the configuration.
 * 
 * @author Philipp Thiel
 */
public abstract class AbstractSettings {

	private final SettingsManager manager;

	/**
	 * Creates a new instance using the given settings manager.
	 * 
	 * @param file
	 *            Settings manager to use.
	 */
	protected AbstractSettings(SettingsManager manager) {
		this.manager = Objects.requireNonNull(manager);
	}

	/**
	 * Gets an optional boolean from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @param defaultValue
	 *            Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	protected boolean getBoolean(String key, boolean defaultValue) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			return defaultValue;
		}
	}

	/**
	 * Gets a mandatory boolean from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException
	 *             If key not found or value is null.
	 */
	protected boolean getBoolean(String key) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	/**
	 * Gets an optional double from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @param defaultValue
	 *            Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	protected double getDouble(String key, double defaultValue) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			return defaultValue;
		}
	}

	/**
	 * Gets a mandatory double from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException
	 *             If key not found or value is null.
	 */
	protected double getDouble(String key) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	/**
	 * Gets an optional int from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @param defaultValue
	 *            Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	protected int getInteger(String key, int defaultValue) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			return defaultValue;
		}
	}

	/**
	 * Gets a mandatory int from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException
	 *             If key not found or value is null.
	 */
	protected int getInteger(String key) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	/**
	 * Gets an optional string from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @param defaultValue
	 *            Defult value if key does not exist or has no value.
	 * @return Assigned value or given default value if key not found or property
	 *         not set.
	 */
	protected String getString(String key, String defaultValue) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			return defaultValue;
		}
	}

	/**
	 * Gets a mandatory string from the configuration.
	 * 
	 * @param key
	 *            Key to look for.
	 * @return Assigned value
	 * @throws NoSuchElementException
	 *             If key not found or value is null.
	 */
	protected String getString(String key) {
		String value = manager.getValue(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			throw new NoSuchElementException(key);
		}
	}

	/**
	 * Sets a boolean property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	protected void setProperty(String key, boolean value) {
		manager.setValue(key, Boolean.toString(value));
	}

	/**
	 * Sets an integer property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	public void setProperty(String key, int value) {
		manager.setValue(key, Integer.toString(value));
	}

	/**
	 * Sets a double property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	protected void setProperty(String key, double value) {
		manager.setValue(key, Double.toString(value));
	}

	/**
	 * Sets a string property.
	 * 
	 * @param key
	 *            Property key
	 * @param value
	 *            Property value
	 */
	public void setProperty(String key, String value) {
		// Passing null as value to the map will result in an exception
		if (value == null) {
			value = "";
		}

		manager.setValue(key, value);
	}

	/**
	 * Removes a property from the configuration.
	 * 
	 * @param key
	 *            Property to remove.
	 */
	protected void removeProperty(String key) {
		manager.remove(key);
	}

}
