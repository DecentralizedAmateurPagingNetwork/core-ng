package org.dapnet.core;

import org.dapnet.core.config.ConfigurationManager;
import org.dapnet.core.events.EventManager;

/**
 * The core service locator provides acces to several global subsystems used by
 * DAPNET core.
 * 
 * @author Philipp Thiel
 */
public interface CoreServiceLocator {

	/**
	 * Gets a handle to the global configuration manager.
	 * 
	 * @return Configuration manager instance
	 */
	ConfigurationManager getConfigurationManager();

	/**
	 * Gets a handle to the global event manager.
	 * 
	 * @return Event manager instance
	 */
	EventManager getEventManager();

}
