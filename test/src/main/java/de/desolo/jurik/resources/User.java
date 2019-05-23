package de.desolo.jurik.resources;

import javax.persistence.Column;
//import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
//public class User implements Serializable {
public class User {

	public String login;

	public String password;
	public byte permission;

	public User() {
	}

	public User(String login, String password, byte permission) {
		this.login = login;
		this.password = password;
		this.permission = permission;
	}

	@Id
	@Column(name = "user")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "permission")
	public byte getPermission() {
		return permission;
	}

	public void setPermission(byte permission) {
		this.permission = permission;
	}
}
