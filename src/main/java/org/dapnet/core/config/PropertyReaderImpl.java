package org.dapnet.core.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Properties;

/**
 * This class provides simplified methods to access properties.
 * 
 * @author Philipp Thiel
 */
final class PropertyReaderImpl implements PropertyReader {

	private final Properties properties;

	/**
	 * Creates a new instance of the adapter using the given {@link Properties}
	 * object.
	 * 
	 * @param properties
	 *            Properties to use.
	 */
	public PropertyReaderImpl(Properties properties) {
		this.properties = Objects.requireNonNull(properties);
	}

	/**
	 * Creates a {@link PropertyReaderImpl} from a configuration file.
	 * 
	 * @throws IOException
	 *             if the configuration could not be loaded.
	 */
	public static PropertyReaderImpl fromFile(String filename) throws IOException {
		Objects.requireNonNull(filename, "filename");

		Properties props = new Properties();
		try (FileInputStream in = new FileInputStream(filename)) {
			props.load(in);
		}

		return new PropertyReaderImpl(props);
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
