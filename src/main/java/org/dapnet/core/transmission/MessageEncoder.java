package org.dapnet.core.transmission;

import java.util.List;
import java.util.Objects;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

/**
 * Encodes a transmitter message into a network packet.
 * 
 * @author Philipp Thiel
 * 
 */
@Sharable
final class MessageEncoder extends MessageToMessageEncoder<TransmitterMessage> {

	public static final int MT_SYNCREQUEST = 2;
	public static final int MT_SYNCORDER = 3;
	public static final int MT_SLOTS = 4;
	public static final int MT_NUMERIC = 5;
	public static final int MT_ALPHANUM = 6;
	private final PagerProtocolSettings settings;

	public MessageEncoder(PagerProtocolSettings settings) {
		this.settings = Objects.requireNonNull(settings);
	}

	@Override
	protected void encode(ChannelHandlerContext ctx, TransmitterMessage msg, List<Object> out) throws Exception {
		PagerMessage pm = msg.getMessage();

		int type = 0;
		int bits = 0;
		switch (pm.getType()) {
		case NUMERIC:
			type = MT_NUMERIC;
			bits = 0;
			break;
		case TONE:
			type = MT_ALPHANUM;
			bits = 1;
			break;
		case ACTIVATION:
			type = MT_ALPHANUM;
			bits = 2;
			break;
		case ALPHANUM:
			type = MT_ALPHANUM;
			bits = 3;
			break;
		}

		String encoded = String.format("#%02X %d:%X:%X:%d:%s\n", msg.getSequenceNumber(), type, settings.getBaudRate(),
				pm.getAddress(), bits, pm.getText());

		out.add(encoded);
	}

}
