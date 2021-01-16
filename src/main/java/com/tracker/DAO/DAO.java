package com.tracker.DAO;

import java.util.List;

import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;

public interface DAO {
	public  boolean addUserData(UserData user);
	public  boolean checkLoginCredential(UserData user);
	public  boolean addIncomeDAO(IncomeTable income, String user);
	public  boolean addExpenseDAO(ExpenseTable expense, String user);
	public  void deleteIncome(int id);
	public  void deleteExpense(int id);
	public void addCategory(String function, String category);
	public void addLimit(MonthlyLimitTable limit);
	public void deleteLimit(String category, String username);
	public List<chartsData> getChartsData(String user,String function,String period);
	public List<chartsData> getSearchData(String user,String month);
	public List<chartsData> getSearchYearData(String user,String year);
	
}
