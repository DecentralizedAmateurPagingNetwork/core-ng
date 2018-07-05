package org.dapnet.core.config;

import java.io.IOException;
import java.util.Objects;

import org.dapnet.core.ObjectRegistry;

/**
 * This class manages the configuration system.
 * 
 * @author Philipp Thiel
 */
public final class ConfigurationManager extends ObjectRegistry<Configuration> {

	private final PropertyReaderImpl properties;

	/**
	 * Creates a new {@code ConfigurationManager} instance.
	 * 
	 * @param filename Configuration file to load
	 * @throws IOException if the configuration file could not be loaded.
	 */
	public ConfigurationManager(String filename) throws IOException {
		properties = PropertyReaderImpl.fromFile(Objects.requireNonNull(filename));
	}

	@Override
	public <T extends Configuration> T put(T object) {
		object = super.put(object);
		object.loadConfiguration(properties);
		return object;
	}

}
