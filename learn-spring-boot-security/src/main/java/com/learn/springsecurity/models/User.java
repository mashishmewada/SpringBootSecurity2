package com.learn.springsecurity.models;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

//@Data
@Entity
public class User {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	String userName;
	String password;
	String email;
	String role;
	
	public User(String username, String password, String email) {
		super();
		this.userName = username;
		this.password = password;
		this.email = email;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	
	
	
	
}
