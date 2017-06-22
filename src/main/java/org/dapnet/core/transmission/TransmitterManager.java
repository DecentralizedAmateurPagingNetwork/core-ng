package org.dapnet.core.transmission;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.dapnet.core.events.Event;
import org.dapnet.core.events.EventArgs;
import org.dapnet.core.events.EventListener;
import org.dapnet.core.events.SimpleEvent;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public final class TransmitterManager implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final EventLoopGroup workerGroup = new NioEventLoopGroup();
	private final Event<TransmitterEventArgs> connectEvent = new SimpleEvent<>();
	private final Event<TransmitterEventArgs> disconnectEvent = new SimpleEvent<>();
	private final Event<TransmitterErrorEventArgs> errorEvent = new SimpleEvent<>();
	private final TransmitterEventListener listener = new ListenerImpl();
	private final int port;

	public TransmitterManager(int port) {
		this.port = port;
	}

	public void addConnectListener(EventListener<TransmitterEventArgs> listener) {
		connectEvent.addListener(listener);
	}

	public void addDisconnectListener(EventListener<TransmitterEventArgs> listener) {
		disconnectEvent.addListener(listener);
	}

	public void addErrorListener(EventListener<TransmitterErrorEventArgs> listener) {
		errorEvent.addListener(listener);
	}

	@Override
	public void start() throws Exception {
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(workerGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new ServerInitializer(listener));
			b.childOption(ChannelOption.SO_KEEPALIVE, true);
			b.bind(port).sync();

			LOGGER.info("Server started on port: {}", port);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();

			LOGGER.error("Server startup has been interrupted.");
		} catch (Exception ex) {
			LOGGER.fatal("Failed to start the server.", ex);
		}
	}

	@Override
	public void shutdown() {
		try {
			workerGroup.shutdownGracefully().sync();
		} catch (InterruptedException ex) {
			LOGGER.warn("Server shutdown interrupted.");
			// Thread.currentThread().interrupt();
		} catch (Exception e) {
			LOGGER.warn("Failed to shut down worker group.", e);
		}

		LOGGER.info("Server stopped.");
	}

	private final class ListenerImpl implements TransmitterEventListener {

		@Override
		public void onConnect(TransmitterClient client) {
			connectEvent.raiseEvent(this, new TransmitterEventArgs(client));
		}

		@Override
		public void onDisconnect(TransmitterClient client) {
			disconnectEvent.raiseEvent(this, new TransmitterEventArgs(client));
		}

		@Override
		public void onException(TransmitterClient client, Throwable cause) {
			errorEvent.raiseEvent(this, new TransmitterErrorEventArgs(client, cause));
		}

	}

	/**
	 * This class represents the transmitter event arguments.
	 * 
	 * @author Philipp Thiel
	 */
	public static class TransmitterEventArgs extends EventArgs {

		private final TransmitterClient client;

		private TransmitterEventArgs(TransmitterClient client) {
			this.client = client;
		}

		/**
		 * Gets the associated transmitter client.
		 * 
		 * @return Transmitter client
		 */
		public TransmitterClient getClient() {
			return client;
		}

	}

	/**
	 * This class represents the transmitter error event arguments.
	 * 
	 * @author Philipp Thiel
	 */
	public static class TransmitterErrorEventArgs extends TransmitterEventArgs {

		private final Throwable cause;

		private TransmitterErrorEventArgs(TransmitterClient client, Throwable cause) {
			super(client);
			this.cause = cause;
		}

		/**
		 * Gets the exception that caused the error event.
		 * 
		 * @return Exception
		 */
		public Throwable getCause() {
			return cause;
		}

	}

	/**
	 * This class provides the channel initializer for transmitter channels.
	 * 
	 * @author Philipp Thiel
	 */
	private static final class ServerInitializer extends ChannelInitializer<SocketChannel> {

		private static final StringEncoder STRING_ENCODER = new StringEncoder(StandardCharsets.US_ASCII);
		private static final StringDecoder STRING_DECODER = new StringDecoder(StandardCharsets.US_ASCII);
		private static final MessageEncoder MSG_ENCODER = new MessageEncoder();
		private final TransmitterEventListener listener;

		public ServerInitializer(TransmitterEventListener listener) {
			this.listener = listener;
		}

		@Override
		protected void initChannel(SocketChannel ch) throws Exception {
			ChannelPipeline p = ch.pipeline();
			p.addLast(new DelimiterBasedFrameDecoder(2048, Delimiters.lineDelimiter()));
			p.addLast(STRING_DECODER);
			p.addLast(STRING_ENCODER);
			p.addLast(MSG_ENCODER);
			p.addLast(new TransmitterServerHandler(listener));
		}

	}

}
