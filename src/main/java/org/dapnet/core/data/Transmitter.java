package org.dapnet.core.data;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Transmitter")
@Table(name = "TRANSMITTERS")
public class Transmitter implements Serializable {

	private static final long serialVersionUID = 3286378919799304494L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private int id;
	@Column(name = "NAME", unique = true, nullable = false, length = 20)
	private String name;
	@Column(name = "AUTH_KEY", length = 64, nullable = false)
	private String authKey;
	@Enumerated(EnumType.STRING)
	@Column(name = "STATUS", nullable = false)
	private DeviceStatus status = DeviceStatus.UNKNOWN;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthKey() {
		return authKey;
	}

	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}

}
