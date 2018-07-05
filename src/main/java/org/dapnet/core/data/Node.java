package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

public class Node implements Serializable {

	private static final long serialVersionUID = -7074417111402696260L;

	private int id;
	private String name;
	private DeviceStatus status = DeviceStatus.UNKNOWN;
	private Instant lastUpdate;
	private String version;
	private String latitude;
	private String longitude;

	public int getId() {
		return id;
	}

	public DeviceStatus getStatus() {
		return status;
	}

	public void setStatus(DeviceStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Instant getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

}
