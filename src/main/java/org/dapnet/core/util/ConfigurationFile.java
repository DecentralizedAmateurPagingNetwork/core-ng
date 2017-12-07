package org.dapnet.core.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

/**
 * This class manages access to the configuration file.
 * 
 * @author Philipp Thiel
 */
final class ConfigurationFile implements PropertyReader, PropertyWriter {

	private final Properties props = new Properties();
	private final String filename;

	/**
	 * Creates a new instance using the given file name. The configuration will not
	 * be loaded unless the {@link #loadFromFile()} method is called.
	 * 
	 * @param filename
	 *            Configuration file to use.
	 */
	public ConfigurationFile(String filename) {
		this.filename = filename;
	}

	/**
	 * Gets the configuration file name.
	 * 
	 * @return File name
	 */
	public String getFilename() {
		return filename;
	}

	/**
	 * Loads the configuration file.
	 * 
	 * @throws IOException
	 */
	public void loadFromFile() throws IOException {
		try (FileInputStream in = new FileInputStream(filename)) {
			props.load(in);
		}
	}

	/**
	 * Saves the configuration file.
	 * 
	 * @throws IOException
	 */
	public void saveToFile() throws IOException {
		try (FileOutputStream out = new FileOutputStream(filename)) {
			props.store(out, null);
		}
	}

	@Override
	public void setProperty(String key, boolean value) {
		props.setProperty(key, Boolean.toString(value));
	}

	@Override
	public void setProperty(String key, int value) {
		props.setProperty(key, Integer.toString(value));
	}

	@Override
	public void setProperty(String key, double value) {
		props.setProperty(key, Double.toString(value));
	}

	@Override
	public void setProperty(String key, String value) {
		// Passing null as value to the map will result in an exception
		if (value == null) {
			value = "";
		}

		props.setProperty(key, value);
	}

	@Override
	public void removeProperty(String key) {
		props.remove(key);
	}

	@Override
	public boolean getBoolean(String key, boolean defaultValue) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public boolean getBoolean(String key) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public double getDouble(String key, double defaultValue) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public double getDouble(String key) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public int getInteger(String key, int defaultValue) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public int getInteger(String key) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public String getString(String key, String defaultValue) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			return defaultValue;
		}
	}

	@Override
	public String getString(String key) {
		String value = props.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			throw new NoSuchElementException(key);
		}
	}

}
