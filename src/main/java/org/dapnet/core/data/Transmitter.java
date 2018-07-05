package org.dapnet.core.data;

import java.io.Serializable;

public class Transmitter implements Serializable {

	private static final long serialVersionUID = 3286378919799304494L;

	private int id;
	private String name;
	private String authKey;
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

	public DeviceStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceStatus status) {
		this.status = status;
	}

}
