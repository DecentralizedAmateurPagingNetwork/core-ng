package org.dapnet.core.data;

import java.io.Serializable;
import java.time.Instant;

/**
 * This class represents a user account.
 * 
 * @author Philipp Thiel
 */
public class User implements Serializable {

	private static final long serialVersionUID = 7574094449661279629L;

	private int id;
	private String name;
	private String password;
	private String email;
	private boolean admin;
	private boolean enabled;
	private Instant createdOn;
	private Instant lastLogin;

	/**
	 * Gets the user id.
	 * 
	 * @return User id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Gets the username.
	 * 
	 * @return Username
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the username.
	 * 
	 * @param name Username
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the password.
	 * 
	 * @return Password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 * 
	 * @param password Password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the email address.
	 * 
	 * @return Email address
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email address.
	 * 
	 * @param email Email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the creation date.
	 * 
	 * @return Creation date
	 */
	public Instant getCreatedOn() {
		return createdOn;
	}

	/**
	 * Sets the creation date.
	 * 
	 * @param createdOn Creation date
	 */
	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	/**
	 * Gets whether the user has administrative rights.
	 * 
	 * @return {@code true} if the user has administrative rights.
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Enables or disables administrative rights for the user.
	 * 
	 * @param admin Administrative rights enabled
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Gets whether the user is enabled.
	 * 
	 * @return {@code true} if the user is enabled.
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Enables or disables the user.
	 * 
	 * @param enabled User enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Gets the last login timestamp.
	 * 
	 * @return Last login timestamp
	 */
	public Instant getLastLogin() {
		return lastLogin;
	}

	/**
	 * Sets the last login timestamp.
	 * 
	 * @param lastLogin
	 */
	public void setLastLogin(Instant lastLogin) {
		this.lastLogin = lastLogin;
	}

}
