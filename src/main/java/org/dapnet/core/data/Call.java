package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Call")
@Table(name = "CALLS")
public class Call implements Serializable {

	public enum Priority {
		LOW, NORMAL, HIGH
	}

	private static final long serialVersionUID = -7925017927529220L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;
	@Column(name = "TEXT", nullable = false, length = 100)
	private String text;
	@Column(name = "PRIORITY", nullable = false)
	@Enumerated(EnumType.STRING)
	private Priority priority = Priority.NORMAL;
	@Column(name = "IS_EMERGENCY", nullable = false)
	private boolean emergency;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POSTED_BY", nullable = false)
	private User owner;
	@Column(name = "POSTED_ON", nullable = false)
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
