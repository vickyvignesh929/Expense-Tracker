package com.tracker.entity;

import org.springframework.stereotype.Component;

@Component
public class UserData {
	private String email;
	private String username;
	private String password;
	private  int amount;
	public UserData(String email, String username, String password, int amount) {
		super();
		this.email = email;
		this.username = username;
		this.password = password;
		this.amount = amount;
	}
	public UserData() {
		super();
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	


}
