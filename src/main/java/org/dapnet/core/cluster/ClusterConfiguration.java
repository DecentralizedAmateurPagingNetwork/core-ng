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
	private int port;
	private String username;
	private String password;
	private String virtualHost;

	/**
	 * Whether the cluster service is enabled or not.
	 * 
	 * @return {@code true} if the cluster service is enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Gets the name of the server to connect to.
	 * 
	 * @return RabbitMQ server address
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * Gets the port number to use.
	 * 
	 * @return RabbitMQ port number
	 */
	public int getPort() {
		return port;
	}

	/**
	 * Gets the username.
	 * 
	 * @return RabbitMQ user
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Gets the password.
	 * 
	 * @return RabbitMQ password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Gets the virtual host name.
	 * 
	 * @return Virtual host name
	 */
	public String getVirtualHost() {
		return virtualHost;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		enabled = reader.getBoolean("cluster.enabled", false);
		servername = reader.getString("cluster.host");
		port = reader.getInteger("cluster.port", 5672);
		username = reader.getString("cluster.user");
		password = reader.getString("cluster.password");
		virtualHost = reader.getString("cluster.virtual_host", "/");
		
		// TODO Use address list for definig mutliple servers
	}

}
