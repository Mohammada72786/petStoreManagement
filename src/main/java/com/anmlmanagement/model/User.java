package com.anmlmanagement.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class User extends BaseClass {
	
	@Column(unique=true)
	private String username;
	private String password;
	private String email;
	private String role;
	
	

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, Date createdAt, Date updatedAt, int isDeleted) {
		super(id, createdAt, updatedAt, isDeleted);
		// TODO Auto-generated constructor stub
	}
	public User(String username, String password, String email, String role) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.role = role;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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

}
