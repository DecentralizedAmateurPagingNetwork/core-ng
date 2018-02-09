package org.dapnet.core.cluster;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

/**
 * This class contains the cluster configuration.
 * 
 * @author Philipp Thiel
 */
public final class ClusterConfiguration extends Configuration {

	private boolean enabled;

	/**
	 * Whether the cluster service is enabled or not.
	 * 
	 * @return {@code true} if the cluster service is enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("cluster.enabled", false);
	}

}
