package com.tracker.service;

import java.util.List;

import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;

public interface DataBaseService {
	public boolean addUser(UserData user);

	public boolean checkUser(UserData user);

	public void addIncome(IncomeTable income, String user);

	public void addExpense(ExpenseTable expense, String user);

	public void deleteIncome(int id);

	public void deleteExpense(int id);

	public void addCategory(String function, String category);

	public void addLimit(MonthlyLimitTable limit);

	public void deleteLimit(String category, String username);

	public List<chartsData> getChartsData(String username, String function, String period);

	public List<chartsData> getSearchData(String username, String month);

	public List<chartsData> getSearchYearData(String username, String year);

}
