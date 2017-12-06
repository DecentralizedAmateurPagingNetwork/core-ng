package org.dapnet.core.rest;

import org.dapnet.core.AbstractSettings;
import org.dapnet.core.SettingsManager;

public final class RestSettings extends AbstractSettings {

	public RestSettings(SettingsManager file) {
		super(file);
	}

	public boolean isEnabled() {
		return getBoolean("rest.enabled", true);
	}

	public int getPort() {
		return getInteger("rest.port", 8080);
	}

	public String getEndpoint() {
		return getString("rest.endpoint", "http://localhost/");
	}

}
