package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
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
	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", status=" + status + "]";
	}
	
	
	
}
