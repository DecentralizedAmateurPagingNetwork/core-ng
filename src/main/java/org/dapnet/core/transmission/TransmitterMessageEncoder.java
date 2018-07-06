package org.dapnet.core.transmission;

/**
 * This interface is used to encode a transmitter message.
 * 
 * @author Philipp Thiel
 */
@FunctionalInterface
interface TransmitterMessageEncoder {

	/**
	 * Encodes a transmitter message.
	 * 
	 * @param msg Message to encode.
	 * @return Encoded message as a string.
	 * @throws Exception if the message could not be encoded.
	 */
	String encode(TransmitterMessage msg) throws Exception;

}
