package org.dapnet.core.transmission;

/**
 * Encodes a transmitter message into a network packet.
 * 
 * @author Philipp Thiel
 */
final class MessageEncoder {

	public static final int MT_SYNCREQUEST = 2;
	public static final int MT_SYNCORDER = 3;
	public static final int MT_SLOTS = 4;
	public static final int MT_NUMERIC = 5;
	public static final int MT_ALPHANUM = 6;

	public String encode(TransmitterMessage msg) throws Exception {
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

		return String.format("#%02X %d:%X:%X:%d:%s\n", msg.getSequenceNumber(), type, pm.getBaudRate().getCode(),
				pm.getAddress(), bits, pm.getText());
	}

}
