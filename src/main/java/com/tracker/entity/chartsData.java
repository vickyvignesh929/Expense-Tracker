package com.tracker.entity;

public class chartsData {
	private String Category;
	private int amount;
	public chartsData(String category, int amount) {
		super();
		Category = category;
		this.amount = amount;
	}
	public chartsData() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "chartsData [Category=" + Category + ", amount=" + amount + "]";
	}

}
