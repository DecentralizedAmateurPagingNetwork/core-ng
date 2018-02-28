package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Node")
@Table(name = "NODES")
public class Node implements Serializable {

	private static final long serialVersionUID = -7074417111402696260L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private int id;
	@Column(name = "NAME", unique = true, nullable = false, length = 50)
	private String name;
	@Column(name = "STATUS", nullable = false)
	@Enumerated(EnumType.STRING)
	private DeviceStatus status = DeviceStatus.UNKNOWN;
	@Column(name = "LAST_UPDATE")
	private Instant lastUpdate;
	@Column(name = "VERSION", length = 20)
	private String version;
	@Column(name = "LATITUDE", length = 20)
	private String latitude;
	@Column(name = "LONGITUDE", length = 20)
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
