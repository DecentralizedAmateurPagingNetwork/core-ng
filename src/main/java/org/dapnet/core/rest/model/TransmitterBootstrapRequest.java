package org.dapnet.core.rest.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TransmitterBootstrapRequest implements Serializable {

	private static final long serialVersionUID = 2649488721605515890L;
	private String callsign;
	@JsonProperty("auth_key")
	private String authKey;
	private VersionInfo software;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getCallsign() {
		return callsign;
	}

	public String getAuthKey() {
		return authKey;
	}

	public VersionInfo getSoftware() {
		return software;
	}

}
