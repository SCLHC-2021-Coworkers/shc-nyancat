package com.smcm.models;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
public class User extends Model implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String email;
	private String password;
	private String name;
	private String position;

	public static void init() {
		//
	}

	public User() {
		super();
	}

	public User(int id, String email, String password, String name, String position) {
		this();
		this.id = id;
		this.email = email;
		this.password = password;
		this.name = name;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	@XmlElement
	public void setId(int id) {
		this.id = id;
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