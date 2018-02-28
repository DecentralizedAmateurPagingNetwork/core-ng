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
@Table(name = "USERS")
public class User implements Serializable {

	private static final long serialVersionUID = 7574094449661279629L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", updatable = false, nullable = false)
	private int id;
	@Column(name = "NAME", length = 50, unique = true, nullable = false)
	private String name;
	@Column(name = "PASSWORD", length = 50, nullable = false)
	private String password;
	@Column(name = "EMAIL", nullable = false, length = 255)
	private String email;
	@Column(name = "IS_ADMIN", nullable = false)
	private boolean admin;
	@Column(name = "IS_ENABLED", nullable = false)
	private boolean enabled;
	@Column(name = "CREATED_ON", nullable = false, updatable = false)
	private Instant createdOn;
	@Column(name = "LAST_LOGIN")
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
	 * @param name
	 *            Username
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
	 * @param password
	 *            Password
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
	 * @param email
	 *            Email address
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
	 * @param createdOn
	 *            Creation date
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
	 * @param admin
	 *            Administrative rights enabled
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
	 * @param enabled
	 *            User enabled
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
