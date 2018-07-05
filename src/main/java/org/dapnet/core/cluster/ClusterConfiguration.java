package org.dapnet.core.cluster;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

/**
 * This class contains the cluster service configuration.
 * 
 * @author Philipp Thiel
 */
public final class ClusterConfiguration extends Configuration {

	private boolean enabled;
	private String servername;
	private String username;
	private String password;

	/**
	 * Whether the cluster service is enabled or not.
	 * 
	 * @return {@code true} if the cluster service is enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Returns the name of the server to connect to.
	 * 
	 * @return RabbitMQ server address
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * Returns the username.
	 * 
	 * @return RabbitMQ user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Returns the password.
	 * 
	 * @return RabbitMQ password
	 */
	public String getPassword() {
		return password;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("cluster.enabled", false);
		servername = reader.getString("cluster.host");
		username = reader.getString("cluster.user");
		password = reader.getString("cluster.password");
	}

}
