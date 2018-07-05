package org.dapnet.core.transmission;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dapnet.core.Service;
import org.dapnet.core.events.Event;
import org.dapnet.core.events.EventManager;

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

public final class TransmitterService implements Service {

	private static final Logger LOGGER = LogManager.getLogger();
	private final EventLoopGroup workerGroup = new NioEventLoopGroup();
	private final TransmitterEventListener listener = new ListenerImpl();
	private final PagerProtocolSettings protocolSettings;
	private final EventManager eventManager;
	private final int port;
	private boolean running = false;

	public TransmitterService(TransmissionConfiguration transmissionSettings, PagerProtocolSettings protocolSettings,
			EventManager eventManager) {
		this.protocolSettings = Objects.requireNonNull(protocolSettings);
		this.eventManager = eventManager;
		this.port = Objects.requireNonNull(transmissionSettings).getServerPort();
	}

	@Override
	public boolean isRunning() {
		return running;
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

			running = true;

			LOGGER.info("Server started on port: {}", port);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();

			LOGGER.error("Server startup has been interrupted.");
		} catch (Exception ex) {
			LOGGER.fatal("Failed to start the server.", ex);
		}
	}

	@Override
	public void shutdown() throws Exception {
		try {
			workerGroup.shutdownGracefully().sync();
		} catch (InterruptedException ex) {
			LOGGER.warn("Server shutdown interrupted.");
			// TODO Reset interruption status?
			// Thread.currentThread().interrupt();
		} catch (Exception e) {
			LOGGER.warn("Failed to shut down worker group.", e);
		} finally {
			running = false;
			LOGGER.info("Server stopped.");
		}
	}

	private final class ListenerImpl implements TransmitterEventListener {

		@Override
		public void onConnect(TransmitterClient client) {
			if (eventManager != null) {
				eventManager.fireEvent(TransmitterService.this, new ConnectEvent());
			}
		}

		@Override
		public void onDisconnect(TransmitterClient client) {
			if (eventManager != null) {
				eventManager.fireEvent(TransmitterService.this, new DisconnectEvent());
			}
		}

		@Override
		public void onException(TransmitterClient client, Throwable cause) {
			if (eventManager != null) {
				eventManager.fireEvent(TransmitterService.this, new ErrorEvent(cause));
			}
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
		private static final MessageEncoder MESSAGE_ENCODER = new MessageEncoder();
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
			p.addLast(MESSAGE_ENCODER);
			p.addLast(new TransmitterServerHandler(listener));
		}

	}

	public static final class ConnectEvent extends Event {
		private static final long serialVersionUID = -2358646055141632404L;
	}

	public static final class DisconnectEvent extends Event {
		private static final long serialVersionUID = -2358646055141632405L;
	}

	public static final class ErrorEvent extends Event {
		private static final long serialVersionUID = -2358646055141632404L;
		private final Throwable cause;

		private ErrorEvent(Throwable cause) {
			this.cause = Objects.requireNonNull(cause);
		}

		public Throwable getCause() {
			return cause;
		}
	}

}
