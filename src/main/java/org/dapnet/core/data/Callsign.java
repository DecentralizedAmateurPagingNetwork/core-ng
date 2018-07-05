package org.dapnet.core.data;

import java.io.Serializable;

public class Callsign implements Serializable {

	private static final long serialVersionUID = 6487591500834299950L;

	private int id;
	private String name;
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
