package org.dapnet.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pager")
@Table(name = "pagers")
public class Pager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private int id;
	@Column(unique = true, nullable = false)
	private int number;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private PagerType type;

	public int getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PagerType getType() {
		return type;
	}

	public void setType(PagerType type) {
		this.type = type;
	}

}
