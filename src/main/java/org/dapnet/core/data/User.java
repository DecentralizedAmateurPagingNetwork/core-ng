package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * This class represents a user account.
 * 
 * @author Philipp Thiel
 */
@Entity(name = "User")
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = 7574094449661279629L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(updatable = false, nullable = false)
	private int id;
	@Column(length = 50, unique = true, nullable = false)
	private String name;
	@Column(length = 50, nullable = false)
	private String password;
	@Column(nullable = false, length = 255)
	private String email;
	@Column(name = "is_admin", nullable = false)
	private boolean admin;
	@Column(name = "is_enabled", nullable = false)
	private boolean enabled;
	@Column(name = "created_on", nullable = false)
	private Instant createdOn;
	@Column(name = "last_login")
	private Instant lastLogin;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Instant getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
	}

}
