package org.dapnet.core.data;

import java.io.Serializable;

public final class Node implements NamedObject, Serializable {

	public enum Status {
		UNKNOWN, OFFLINE, ONLINE
	}

	private static final long serialVersionUID = -7074417111402696260L;

	private Status status = Status.UNKNOWN;
	private String name;

	public Status getStatus() {
		return status;
	}

	@Override
	public String getNormalizedName() {
		return name;
	}

}
