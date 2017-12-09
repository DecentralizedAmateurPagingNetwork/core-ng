package org.dapnet.core.plugins;

import org.dapnet.core.config.AbstractConfiguration;
import org.dapnet.core.config.PropertyReader;
import org.dapnet.core.config.PropertyWriter;

public final class PluginConfiguration extends AbstractConfiguration {

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("plugins.enabled", true);
	}

	@Override
	public void saveConfiguration(PropertyWriter writer) {
		writer.setProperty("plugins.enabled", enabled);
	}

}
