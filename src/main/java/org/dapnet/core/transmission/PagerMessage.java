package org.dapnet.core.transmission;

import java.time.Instant;

/**
 * This class represents a message to a specific pager address.
 * 
 * @author Philipp Thiel
 */
final class PagerMessage implements Comparable<PagerMessage> {

	public enum MessagePriority {
		EMERGENCY, TIME, CALL, NEWS, ACTIVATION, RUBRIC
	}

	public enum MessageType {
		NUMERIC, TONE, ALPHANUM, ACTIVATION
	}

	private final Instant timestamp;
	private final String text;
	private final MessagePriority priority;
	private final MessageType type;
	private final int address;
	private final PagerBaudRate baudRate;

	/**
	 * Creates a new message with the current timestamp.
	 * 
	 * @param text     Message text
	 * @param priority Message priority
	 * @param type     Message type
	 * @param address  Pager address
	 * @param baudRate Pager baud rate to use.
	 */
	public PagerMessage(String text, MessagePriority priority, MessageType type, int address, PagerBaudRate baudRate) {
		this(Instant.now(), text, priority, type, address, baudRate);
	}

	/**
	 * Creates a new message with the given timestamp.
	 * 
	 * @param timestamp Timestamp to use.
	 * @param text      Message text
	 * @param priority  Message priority
	 * @param type      Message type
	 * @param address   Pager address
	 * @param baudRate  Pager baud rate to use.
	 */
	public PagerMessage(Instant timestamp, String text, MessagePriority priority, MessageType type, int address,
			PagerBaudRate baudRate) {
		this.timestamp = timestamp;
		this.text = text;
		this.priority = priority;
		this.type = type;
		this.address = address;
		this.baudRate = baudRate;
	}

	/**
	 * Gets the message timestamp.
	 * 
	 * @return Timestamp
	 */
	public Instant getTimestamp() {
		return timestamp;
	}

	/**
	 * Gets the message text.
	 * 
	 * @return Text
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the message priority.
	 * 
	 * @return Priority
	 */
	public MessagePriority getPriority() {
		return priority;
	}

	/**
	 * Gets the message type.
	 * 
	 * @return Type
	 */
	public MessageType getType() {
		return type;
	}

	/**
	 * Gets the pager address.
	 * 
	 * @return Pager address
	 */
	public int getAddress() {
		return address;
	}

	/**
	 * Gets the pager baud rate to use.
	 * 
	 * @return Pager baud rate
	 */
	public PagerBaudRate getBaudRate() {
		return baudRate;
	}

	@Override
	public int compareTo(PagerMessage o) {
		if (priority.ordinal() < o.priority.ordinal()) {
			return -1;
		} else if (priority.ordinal() > o.priority.ordinal()) {
			return 1;
		} else if (timestamp.isBefore(o.timestamp)) {
			return -1;
		} else if (timestamp.isAfter(o.timestamp)) {
			return 1;
		} else {
			return 0;
		}
	}

}
