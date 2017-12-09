package org.dapnet.core.cluster;

import org.dapnet.core.config.AbstractConfiguration;
import org.dapnet.core.config.PropertyReader;
import org.dapnet.core.config.PropertyWriter;

/**
 * This class contains the cluster configuration.
 * 
 * @author Philipp Thiel
 */
public final class ClusterConfiguration extends AbstractConfiguration {

	private boolean enabled;
	private String clusterConfigFile;

	/**
	 * Whether the cluster service is enabled or not.
	 * 
	 * @return {@code true} if the cluster service is enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the path to the jgroups cluster configuration file.
	 * 
	 * @return Path to the jgroups cluster configuration file.
	 */
	public String getConfigFile() {
		return clusterConfigFile;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("cluster.enabled", false);
		clusterConfigFile = reader.getString("cluster.configuration_file");
	}

	@Override
	public void saveConfiguration(PropertyWriter writer) {
		writer.setProperty("cluster.enabled", enabled);
		writer.setProperty("cluster.configuration_file", clusterConfigFile);
	}

}
