package org.dapnet.core.util;

import java.io.IOException;

public final class ConfigurationManager extends ObjectRegistry<AbstractConfiguration> {

	private final ConfigurationFile configFile;

	public ConfigurationManager(String filename) throws IOException {
		configFile = new ConfigurationFile(filename);
		configFile.loadFromFile();
	}

	@Override
	public <T extends AbstractConfiguration> T put(T object) {
		object = super.put(object);
		object.loadConfiguration(configFile);
		return object;
	}

}
