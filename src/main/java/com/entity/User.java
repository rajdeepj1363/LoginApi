package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
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
	
	
	
}
