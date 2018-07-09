package org.dapnet.core.rest;

import java.net.URI;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * This class provides the REST API service.
 * 
 * @author Philipp Thiel
 */
public final class RestApiService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final Object lockObject = new Object();
	private final RestApiConfiguration config;
	private volatile boolean running = false;
	private HttpServer server;

	/**
	 * Creates a new REST API service instance.
	 * 
	 * @param config Configuration to use.
	 */
	public RestApiService(RestApiConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		if (running) {
			LOGGER.debug("REST API service already started.");
			return;
		}

		LOGGER.info("Starting REST API service on port {}", config.getPort());

		URI endpoint = new URI("http", null, config.getHostname(), config.getPort(), config.getPath(), null, null);
		ResourceConfig rcfg = new RestResourceConfig(config);

		synchronized (lockObject) {
			server = GrizzlyHttpServerFactory.createHttpServer(endpoint, rcfg);
		}

		running = true;
	}

	@Override
	public void shutdown() throws Exception {
		LOGGER.info("Stopping REST API service");

		synchronized (lockObject) {
			if (server != null) {
				server.shutdownNow();
			}
		}

		running = false;
	}

}
