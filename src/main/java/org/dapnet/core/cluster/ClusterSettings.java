package org.dapnet.core.cluster;

import org.dapnet.core.AbstractSettings;
import org.dapnet.core.SettingsManager;

/**
 * This class contains the cluster settings.
 * 
 * @author Philipp Thiel
 */
public final class ClusterSettings extends AbstractSettings {

	public ClusterSettings(SettingsManager file) {
		super(file);
	}

	/**
	 * Whether the cluster service is enabled or not.
	 * 
	 * @return {@code true} if the cluster is enabled.
	 */
	public boolean isEnabled() {
		return getBoolean("cluster.enabled", false);
	}

	/**
	 * Gets the path to the cluster configuration file.
	 * 
	 * @return Path to the cluster configuration file.
	 */
	public String getConfigFile() {
		return getString("cluster.configuration_file");
	}

}
