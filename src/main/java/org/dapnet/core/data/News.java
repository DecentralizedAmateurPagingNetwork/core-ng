package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "News")
@Table(name = "NEWS")
public class News implements Serializable {

	private static final long serialVersionUID = -3899020943398914569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private long id;
	@Column(name = "TEXT", nullable = false, length = 100)
	private String text;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "POSTED_BY", nullable = false)
	private User owner;
	@Column(name = "POSTED_ON", nullable = false)
	private Instant timestamp;
	@Column(name = "SLOT", nullable = false)
	private int slot;

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

}
