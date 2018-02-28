package org.dapnet.core.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Pager")
@Table(name = "PAGERS")
public class Pager {

	/**
	 * This enumeration contains the supported pager types.
	 * 
	 * @author Philipp Thiel
	 */
	public enum Type {
		UNKNOWN, SKYPER, ALPHAPOC, QUIX, SWISSPHONE, SCALL_XT
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", nullable = false, updatable = false)
	private int id;
	@Column(name = "RIC", unique = true, nullable = false)
	private int ric;
	@Column(name = "NAME", nullable = false, length = 20)
	private String name;
	@Column(name = "TYPE", nullable = false)
	private Type type;
	@Column(name = "IS_ENABLED", nullable = false)
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
