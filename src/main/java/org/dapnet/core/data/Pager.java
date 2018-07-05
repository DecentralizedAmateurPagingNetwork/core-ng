package org.dapnet.core.data;

import java.io.Serializable;

public class Pager implements Serializable {

	private static final long serialVersionUID = -8650746160115269108L;

	/**
	 * This enumeration contains the supported pager types.
	 * 
	 * @author Philipp Thiel
	 */
	public enum Type {
		UNKNOWN, SKYPER, ALPHAPOC, QUIX, SWISSPHONE, SCALL_XT
	}

	private int id;
	private int ric;
	private String name;
	private Type type;
	private boolean enabled;

	public int getId() {
		return id;
	}

	public int getRIC() {
		return ric;
	}

	public void setRIC(int number) {
		this.ric = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
