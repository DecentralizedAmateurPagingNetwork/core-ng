package org.dapnet.core;

import org.dapnet.core.config.Configuration;
import org.dapnet.core.config.PropertyReader;

/**
 * This class contains the core configuration.
 * 
 * @author Philipp Thiel
 */
public final class CoreConfiguration extends Configuration {

	private String name;
	private boolean preferIpv4;

	/**
	 * Gets the name of this core instance.
	 * 
	 * @return Name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Whether to prefer the IPv4 network stack.
	 * 
	 * @return {@code true} if the IPv4 stack should be preferred.
	 */
	public boolean isPreferIpv4() {
		return preferIpv4;
	}

	@Override
	public void loadConfiguration(PropertyReader reader) {
		name = reader.getString("core.name");
		preferIpv4 = reader.getBoolean("core.prefer_ipv4", false);
	}

}
