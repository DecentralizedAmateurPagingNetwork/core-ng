package org.dapnet.core.transmission;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

final class TransmitterServerHandler extends SimpleChannelInboundHandler<String> {

	private final TransmitterEventListener listener;
	private volatile TransmitterClient client;

	public TransmitterServerHandler(TransmitterEventListener listener) {
		this.listener = listener;
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		client = new TransmitterClient(ctx.channel());
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		listener.onDisconnect(client);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if (client != null) {
			listener.onException(client, cause);
		}
	}

}
