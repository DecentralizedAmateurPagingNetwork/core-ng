package org.dapnet.core.data;

import java.io.Serializable;

public class Rubric implements Serializable {

	private static final long serialVersionUID = -3014611684027989942L;

	private int id;
	private int number;
	private int name;
	private String label;

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
