package com.tracker.entity;

import org.springframework.stereotype.Component;

@Component

public class MonthlyLimitTable {
	private String limitCategory;
	private int limitAmount;
	private String username;
	public MonthlyLimitTable() {
		super();
	}
	public MonthlyLimitTable(String limitCategory, int limitAmount, String username) {
		super();
		this.limitCategory = limitCategory;
		this.limitAmount = limitAmount;
		this.username = username;
	}
	public String getLimitCategory() {
		return limitCategory;
	}
	public void setLimitCategory(String limitCategory) {
		this.limitCategory = limitCategory;
	}
	public int getLimitAmount() {
		return limitAmount;
	}
	public void setLimitAmount(int limitAmount) {
		this.limitAmount = limitAmount;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "MonthlyLimitTable [limitCategory=" + limitCategory + ", limitAmount=" + limitAmount + ", username="
				+ username + "]";
	}
	
	

}
