package org.dapnet.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Rubric")
@Table(name = "rubrics")
public class Rubric implements Serializable {

	private static final long serialVersionUID = -3014611684027989942L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rid", updatable = false, nullable = false)
	private int id;
	@Column(unique = true, nullable = false)
	private int number;
	@Column(unique = true, nullable = false)
	private int name;
	@Column(nullable = false)
	private String label;

	public int getId() {
		return id;
	}

}
