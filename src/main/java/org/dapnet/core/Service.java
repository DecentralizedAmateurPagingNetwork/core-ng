package org.dapnet.core;

/**
 * Service interface.
 * 
 * @author Philipp Thiel
 */
public interface Service {

	/**
	 * Starts the service.
	 * 
	 * @throws Exception
	 *             On error during startup.
	 */
	void start() throws Exception;

	/**
	 * Shuts down the service. This method must not throw exceptions.
	 */
	void shutdown();

}
