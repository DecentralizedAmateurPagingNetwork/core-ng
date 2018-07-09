package org.dapnet.core.rest.model;

import java.io.Serializable;

public class VersionInfo implements Serializable {

	private static final long serialVersionUID = -8607283480691912208L;
	private String name;
	private String version;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
