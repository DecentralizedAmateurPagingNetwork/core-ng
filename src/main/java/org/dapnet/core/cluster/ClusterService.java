package org.dapnet.core.cluster;

import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public final class ClusterService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final ClusterConfiguration config;
	private boolean running = false;
	private Channel channel;

	public ClusterService(ClusterConfiguration config) {
		this.config = Objects.requireNonNull(config);
	}

	@Override
	public boolean isRunning() {
		return running;
	}

	@Override
	public void start() throws Exception {
		// Setup factory
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost(config.getServername());
		factory.setUsername(config.getUsername());
		factory.setPassword(config.getPassword());
		// Create connection
		Connection conn = factory.newConnection();
		channel = conn.createChannel();
		channel.exchangeDeclare("calls", "fanout");
	}

	@Override
	public void shutdown() throws Exception {
	}

}
