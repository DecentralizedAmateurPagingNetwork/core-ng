package org.dapnet.core.transmission;

/**
 * This class represents a message to a specific transmitter.
 * 
 * @author Philipp Thiel
 */
final class TransmitterMessage {

	private final int sequenceNumber;
	private final PagerMessage message;
	private int retryCount;

	/**
	 * Creates a new message.
	 * 
	 * @param sequenceNumber Sequence number for this message.
	 * @param message        The actual pager message.
	 */
	public TransmitterMessage(int sequenceNumber, PagerMessage message) {
		this.sequenceNumber = sequenceNumber;
		this.message = message;
	}

	/**
	 * Gets the sequence number of this message.
	 * 
	 * @return Sequence number
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Gets the associated pager message.
	 * 
	 * @return Pager message
	 */
	public PagerMessage getMessage() {
		return message;
	}

	/**
	 * Gets the number of times this message has been retransmitted.
	 * 
	 * @return Retry count
	 */
	public int getRetryCount() {
		return retryCount;
	}

	/**
	 * Increments the retry count and returns the new value.
	 * 
	 * @return The new retry count.
	 */
	public int retry() {
		return ++retryCount;
	}

}
