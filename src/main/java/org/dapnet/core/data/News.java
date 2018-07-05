package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

public class News implements Serializable {

	private static final long serialVersionUID = -3899020943398914569L;

	private long id;
	private String text;
	private User owner;
	private Instant timestamp;
	private int slot;
	private Instant scheduledFor;

	public long getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public int getSlot() {
		return slot;
	}

	public void setSlot(int slot) {
		this.slot = slot;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Instant getScheduledFor() {
		return scheduledFor;
	}

	public void setScheduledFor(Instant scheduledFor) {
		this.scheduledFor = scheduledFor;
	}

}
