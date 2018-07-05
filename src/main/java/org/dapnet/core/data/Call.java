package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

public class Call implements Serializable {

	public enum Priority {
		LOWEST, LOWER, NORMAL, HIGHER, HIGHEST
	}

	private static final long serialVersionUID = -7925017927529220L;

	private long id;
	private String text;
	private Priority priority = Priority.NORMAL;
	private boolean emergency;
	private User owner;
	private Instant timestamp;

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

	public boolean isEmergency() {
		return emergency;
	}

	public void setEmergency(boolean emergency) {
		this.emergency = emergency;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

}
