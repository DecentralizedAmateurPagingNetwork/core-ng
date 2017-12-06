package org.dapnet.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class manages the configuration system.
 * 
 * @author Philipp Thiel
 */
public final class SettingsManager {

	private final String filename;
	private final Properties props = new Properties();

	/**
	 * Creates a new settings manager instance using the given file name. The
	 * configuration will not be loaded unless the {@link #loadSettings()} method is
	 * called.
	 * 
	 * @param filename
	 *            Configuration file to use.
	 */
	public SettingsManager(String filename) {
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
	public void loadSettings() throws IOException {
		try (FileInputStream in = new FileInputStream(filename)) {
			props.load(in);
		}
	}

	/**
	 * Saves the configuration file.
	 * 
	 * @throws IOException
	 */
	public void saveSettings() throws IOException {
		try (FileOutputStream out = new FileOutputStream(filename)) {
			props.store(out, null);
		}
	}

	/**
	 * Gets a property value.
	 * 
	 * @param key
	 *            Property to get.
	 * @return Value Property value (can be {@code null})
	 */
	String getValue(String key) {
		return props.getProperty(key);
	}

	/**
	 * Sets a property value.
	 * 
	 * @param key
	 *            Property to set.
	 * @param value
	 *            Value to set.
	 */
	void setValue(String key, String value) {
		props.setProperty(key, value);
	}

	/**
	 * Removes a property.
	 * 
	 * @param key
	 *            Property to remove.
	 */
	void remove(String key) {
		props.remove(key);
	}
}
