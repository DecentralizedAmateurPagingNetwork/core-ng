package org.dapnet.core.transmission;

import java.util.Collection;
import java.util.PriorityQueue;

import io.netty.channel.Channel;

final class TransmitterClient {

	public enum AckResponse {
		PENDING, OK, RETRY, ERROR;
	}

	private static final int MAX_RETRY_COUNT = 5;
	private final PriorityQueue<PagerMessage> messageQueue = new PriorityQueue<>();
	private final Channel channel;
	private TransmitterMessage currentMessage;
	private int nextSequenceNumber;

	public TransmitterClient(Channel channel) {
		this.channel = channel;
	}

	public Channel getChannel() {
		return channel;
	}

	public void sendMessage(PagerMessage message) {
		synchronized (messageQueue) {
			messageQueue.add(message);
			sendNext();
		}
	}

	public void sendMessages(Collection<PagerMessage> messages) {
		synchronized (messageQueue) {
			messageQueue.addAll(messages);
			sendNext();
		}
	}

	private void sendNext() {
		if (currentMessage == null) {
			PagerMessage msg = messageQueue.poll();
			if (msg != null) {
				currentMessage = new TransmitterMessage(getNextSequenceNumber(), msg);
			} else {
				return;
			}
		}

		channel.writeAndFlush(currentMessage);
	}

	public void ackMessage(int sequenceNumber, AckResponse response) {
		boolean valid = false;

		synchronized (messageQueue) {
			if (currentMessage == null) {
				// TODO Handle error?
				return;
			}

			switch (response) {
			case PENDING:
				// SHOULD NEVER HAPPEN :)
				break;
			case OK:
				valid = (currentMessage.getSequenceNumber() + 1) == sequenceNumber;
				currentMessage = null;
				break;
			case RETRY:
				valid = currentMessage.getSequenceNumber() == sequenceNumber;
				if (currentMessage.retry() == MAX_RETRY_COUNT) {
					// Too many retries, discard message
					currentMessage = null;
				}
				break;
			case ERROR:
				valid = currentMessage.getSequenceNumber() == sequenceNumber;
				// Discard message
				currentMessage = null;
				break;
			}

			sendNext();
		}

		if (!valid) {
			throw new RuntimeException("Invalid sequence number received.");
		}
	}

	private int getNextSequenceNumber() {
		int sn = nextSequenceNumber;
		nextSequenceNumber = (nextSequenceNumber + 1) % 256;
		return sn;
	}

}
