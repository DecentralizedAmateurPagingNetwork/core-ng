package org.dapnet.core.rest.model;

import java.io.Serializable;
import java.time.Duration;

import org.dapnet.core.Program;

import com.fasterxml.jackson.annotation.JsonGetter;

public final class CoreStatusResponse implements Serializable {

	private static final long serialVersionUID = 7722555100203113778L;
	private final String name;
	private final String version;
	private final Duration uptime;

	public CoreStatusResponse() {
		this.name = Program.getCoreName();
		this.version = Program.getCoreVersion();
		this.uptime = Program.getCoreUptime();
	}

	@JsonGetter
	public String getName() {
		return name;
	}

	@JsonGetter
	public String getVersion() {
		return version;
	}

	@JsonGetter
	public Duration getUptime() {
		return uptime;
	}

}
