package org.dapnet.core.plugins;

import org.dapnet.core.util.AbstractConfiguration;
import org.dapnet.core.util.PropertyReader;
import org.dapnet.core.util.PropertyWriter;

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
