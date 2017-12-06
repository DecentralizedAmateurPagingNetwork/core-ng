package org.dapnet.core.plugins;

import org.dapnet.core.AbstractSettings;
import org.dapnet.core.SettingsManager;

public final class PluginSettings extends AbstractSettings {

	public PluginSettings(SettingsManager file) {
		super(file);
	}

	public boolean isEnabled() {
		return getBoolean("plugins.enabled", true);
	}

}
