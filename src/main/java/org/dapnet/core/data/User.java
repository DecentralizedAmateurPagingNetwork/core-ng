package org.dapnet.core.data;

public class User implements NamedObject {

	private String name;
	private String hash;
	private String mail;
	private boolean admin;

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getNormalizedName() {
		if (name != null) {
			return name.toLowerCase();
		} else {
			return null;
		}
	}

}
