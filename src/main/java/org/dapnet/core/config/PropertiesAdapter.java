package org.dapnet.core.config;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/**
 * This class provides simplified methods to access properties.
 * 
 * @author Philipp Thiel
 */
final class PropertiesAdapter implements PropertyReader, PropertyWriter {

	private final Properties properties;

	/**
	 * Creates a new instance of the adapter using the given {@link Properties}
	 * object.
	 * 
	 * @param properties
	 *            Properties to use.
	 */
	public PropertiesAdapter(Properties properties) {
		this.properties = Objects.requireNonNull(properties);
	}

	/**
	 * Creates a {@link PropertiesAdapter} from a configuration file.
	 * 
	 * @throws IOException
	 *             if the configuration could not be loaded.
	 */
	public static PropertiesAdapter fromFile(String filename) throws IOException {
		Objects.requireNonNull(filename, "filename");

		Properties props = new Properties();
		try (FileInputStream in = new FileInputStream(filename)) {
			props.load(in);
		}

		return new PropertiesAdapter(props);
	}

	/**
	 * Writes the configuration from a {@link PropertiesAdapter} to a configuration
	 * file.
	 * 
	 * @throws IOException
	 *             if the configuration could not be saved.
	 */
	public void toFile(String filename) throws IOException {
		Objects.requireNonNull(filename, "filename");
		try (FileOutputStream out = new FileOutputStream(filename)) {
			properties.store(out, null);
		}
	}

	@Override
	public void setProperty(String key, boolean value) {
		properties.setProperty(key, Boolean.toString(value));
	}

	@Override
	public void setProperty(String key, int value) {
		properties.setProperty(key, Integer.toString(value));
	}

	@Override
	public void setProperty(String key, double value) {
		properties.setProperty(key, Double.toString(value));
	}

	@Override
	public void setProperty(String key, String value) {
		// Passing null as value to the map will result in an exception
		if (value == null) {
			value = "";
		}

		properties.setProperty(key, value);
	}

	@Override
	public void removeProperty(String key) {
		properties.remove(key);
	}

	@Override
	public boolean getBoolean(String key, boolean defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public boolean getBoolean(String key) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Boolean.parseBoolean(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public double getDouble(String key, double defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public double getDouble(String key) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Double.parseDouble(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public int getInteger(String key, int defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			return defaultValue;
		}
	}

	@Override
	public int getInteger(String key) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return Integer.parseInt(value);
		} else {
			throw new NoSuchElementException(key);
		}
	}

	@Override
	public String getString(String key, String defaultValue) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			return defaultValue;
		}
	}

	@Override
	public String getString(String key) {
		String value = properties.getProperty(key);
		if (value != null && !value.isEmpty()) {
			return value;
		} else {
			throw new NoSuchElementException(key);
		}
	}

}
