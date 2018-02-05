package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "News")
@Table(name = "news")
public class News implements Serializable {

	private static final long serialVersionUID = -3899020943398914569L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false, updatable = false)
	private long id;
	@Column(nullable = false)
	private String text;
	@Column(nullable = false, updatable = false)
	private Instant timestamp;
	@Column(nullable = false)
	private int number;

	public long getId() {
		return id;
	}

}
