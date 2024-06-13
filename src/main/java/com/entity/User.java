package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="login_credentials", uniqueConstraints = @UniqueConstraint(columnNames = {"username"}))
public class User {
	
	@Id
	private String username;
	private String password;
	private String status;
	
	public User() {}
	
	
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", status=" + status + "]";
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


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
		
}
