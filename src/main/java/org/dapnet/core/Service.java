package org.dapnet.core;

/**
 * Service interface.
 * 
 * @author Philipp Thiel
 */
public interface Service {

	/**
	 * Checks if the service is running.
	 * 
	 * @return {@code true} if the service is running.
	 */
	boolean isRunning();

	/**
	 * Starts the service.
	 * 
	 * @throws Exception On error during startup.
	 */
	void start() throws Exception;

	/**
	 * Shuts down the service.
	 * 
	 * @throws Exception If the service failed to shut down.
	 */
	void shutdown() throws Exception;

}
