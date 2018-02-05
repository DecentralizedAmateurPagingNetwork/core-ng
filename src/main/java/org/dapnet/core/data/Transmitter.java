package org.dapnet.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Transmitter")
@Table(name = "transmitters")
public class Transmitter implements Serializable {

	private static final long serialVersionUID = 3286378919799304494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id;
	@Column(unique = true, nullable = false)
	private String name;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
