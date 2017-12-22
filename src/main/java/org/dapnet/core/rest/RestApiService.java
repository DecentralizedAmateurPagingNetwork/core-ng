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
	private HttpServer server;

	/**
	 * Creates a new REST API service instance.
	 * 
	 * @param config
	 *            Configuration to use.
	 */
	public RestApiService(RestApiConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public void start() throws Exception {
		LOGGER.info("Starting REST API service on port {}", config.getPort());

		URI endpoint = new URI("http", null, config.getHostname(), config.getPort(), config.getPath(), null, null);
		ResourceConfig config = new RestResourceConfig();

		synchronized (lockObject) {
			server = GrizzlyHttpServerFactory.createHttpServer(endpoint, config);
		}
	}

	@Override
	public void shutdown() {
		LOGGER.info("Stopping REST API service");

		synchronized (lockObject) {
			if (server != null) {
				server.shutdownNow();
			}
		}
	}

}
