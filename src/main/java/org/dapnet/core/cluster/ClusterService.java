package org.dapnet.core.cluster;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * This class implements the cluster service that connects to the RabbitMQ
 * messaging queue.
 * 
 * @author Philipp Thiel
 */
public final class ClusterService implements Service {

	private static final String[] EXCHANGE_NAMES = { "dapnet.transmitters", "dapnet.telemetry" };
	private static final Logger LOGGER = LogManager.getLogger();
	private final ClusterConfiguration config;
	private volatile boolean running = false;
	private Connection connection;
	private Channel channel;

	/**
	 * Creates a new cluster service instance.
	 * 
	 * @param config Cluster service configuration
	 */
	public ClusterService(ClusterConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		if (running) {
			LOGGER.debug("Cluster service already started.");
			return;
		}

		LOGGER.info("Starting cluster service.");

		createConnection();

		try {
			createChannel();
			running = true;
		} catch (Exception ex) {
			closeConnection();

			throw ex;
		}
	}

	@Override
	public void shutdown() throws Exception {
		LOGGER.info("Stopping cluster service.");

		closeChannel();
		closeConnection();

		running = false;
	}

	/**
	 * Creates the cluster connection.
	 * 
	 * @throws Exception On error
	 */
	private void createConnection() throws Exception {
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(config.getServername());
		factory.setPort(config.getPort());
		factory.setUsername(config.getUsername());
		factory.setPassword(config.getPassword());
		factory.setVirtualHost(config.getVirtualHost());

		connection = factory.newConnection();
	}

	/**
	 * Creates the channel. Make sure to create the connection first.
	 * 
	 * @throws Exception On error
	 */
	private void createChannel() throws Exception {
		assert connection != null;

		try {
			channel = connection.createChannel();

			for (String exchange : EXCHANGE_NAMES) {
				LOGGER.trace("Declaring exchange {}", exchange);
				channel.exchangeDeclare(exchange, "topic", true);
			}
		} catch (Exception ex) {
			closeChannel();

			throw ex;
		}
	}

	/**
	 * Safely closes the channel.
	 */
	private void closeChannel() {
		try {
			if (channel != null) {
				channel.close();
				channel = null;
			}

			LOGGER.debug("Channel closed.");
		} catch (Exception ex) {
			LOGGER.error("Failed to close the channel.", ex);
		}
	}

	/**
	 * Safely closes the connection.
	 */
	private void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}

			LOGGER.debug("Connection closed.");
		} catch (Exception ex) {
			LOGGER.error("Failed to close the connection.", ex);
		}
	}

}
