package org.dapnet.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Callsign")
@Table(name = "CALLSIGNS")
public class Callsign implements Serializable {

	private static final long serialVersionUID = 6487591500834299950L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private int id;
	@Column(name = "NAME", nullable = false, unique = true, length = 20)
	private String name;
	@Column(name = "DESCRIPTION", length = 100)
	private String description;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
