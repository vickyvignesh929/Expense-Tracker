package com.tracker.entity;

import org.springframework.stereotype.Component;

@Component
public class IncomeTable {
	private int id;
	private String date;
	private String category;
	private String description;
	private int amount;
	public IncomeTable(int id, String date, String category, String description, int amount) {
		super();
		this.id = id;
		this.date = date;
		this.category = category;
		this.description = description;
		this.amount = amount;
	}
	public IncomeTable() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "IncomeTable [id=" + id + ", date=" + date + ", category=" + category + ", description=" + description
				+ ", amount=" + amount + "]";
	}

	

}