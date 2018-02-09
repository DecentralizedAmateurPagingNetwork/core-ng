package org.dapnet.core.plugins;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

public final class PluginConfiguration extends Configuration {

	private boolean enabled;

	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("plugins.enabled", true);
	}

}
