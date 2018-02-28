package org.dapnet.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Rubric")
@Table(name = "RUBRICS")
public class Rubric implements Serializable {

	private static final long serialVersionUID = -3014611684027989942L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private int id;
	@Column(name = "NUMBER", unique = true, nullable = false)
	private int number;
	@Column(name = "NAME", unique = true, nullable = false, length = 20)
	private int name;
	@Column(name = "LABEL", nullable = false, length = 11)
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
