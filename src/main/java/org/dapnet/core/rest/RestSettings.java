package org.dapnet.core.rest;

import org.dapnet.core.AbstractSettings;
import org.dapnet.core.SettingsManager;

/**
 * This class contains the settings related to the REST service.
 * 
 * @author Philipp Thiel
 */
public final class RestSettings extends AbstractSettings {

	public RestSettings(SettingsManager file) {
		super(file);
	}

	/**
	 * Whether the REST service is enabled or not.
	 * 
	 * @return {@code true} if the REST service is enabled.
	 */
	public boolean isEnabled() {
		return getBoolean("rest.enabled", true);
	}

	/**
	 * Gets the port to listen on.
	 * 
	 * @return REST server port
	 */
	public int getPort() {
		return getInteger("rest.port", 8080);
	}

	/**
	 * Gets the REST service base path.
	 * 
	 * @return REST base path
	 */
	public String getPath() {
		return getString("rest.path", "/");
	}

	/**
	 * Gets the hostname to listen for.
	 * 
	 * @return Hostname
	 */
	public String getHostname() {
		return getString("rest.hostname", "localhost");
	}

}
