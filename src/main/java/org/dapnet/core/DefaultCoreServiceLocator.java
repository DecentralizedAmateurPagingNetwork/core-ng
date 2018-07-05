package org.dapnet.core;

import org.dapnet.core.config.ConfigurationManager;
import org.dapnet.core.events.EventManager;

/**
 * Default core service locator implementation.
 * 
 * @author Philipp Thiel
 */
final class DefaultCoreServiceLocator implements CoreServiceLocator {

	private EventManager eventManager;
	private ConfigurationManager configManager;

	/**
	 * Sets the configuration manager to use.
	 * 
	 * @param manager Configuration manager instance
	 */
	public void setConfigurationManager(ConfigurationManager manager) {
		configManager = manager;
	}

	/**
	 * Sets the event manager to use.
	 * 
	 * @param manager Event manager instance
	 */
	public void setEventManager(EventManager manager) {
		eventManager = manager;
	}

	@Override
	public ConfigurationManager getConfigurationManager() {
		return configManager;
	}

	@Override
	public EventManager getEventManager() {
		return eventManager;
	}

}
