package com.smcm.models;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User extends Model implements Serializable {
	private static final long serialVersionUID = 1L;

	private static final String tableName = "User";

	private int userId;
	private String email;
	private String password;
	private String name;
	private String position;

	public static void init() {
		String sql = "CREATE TABLE IF NOT EXISTS User ("
				+ "userId INT NOT NULL AUTO_INCREMENT,"
				+ "email VARCHAR(32) NOT NULL,"
				+ "password VARCHAR(128) NOT NULL,"
				+ "name VARCHAR(16) NOT NULL,"
				+ "position VARCHAR(8) NOT NULL, PRIMARY KEY (userId))";
		initTable(tableName, sql);
	}

	public User() {
	}

	public User(int id, String email, String password, String name,
			String position) {
		super();
		this.userId = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.position = position;
	}

	public int getUserId() {
		return userId;
	}

	@XmlElement
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	@XmlElement
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@XmlElement
	public void setPassword(String password) {
		this.password = password;
	}

	public String getPosition() {
		return position;
	}

	@XmlElement
	public void setPosition(String position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	@XmlElement
	public void setName(String name) {
		this.name = name;
	}
}