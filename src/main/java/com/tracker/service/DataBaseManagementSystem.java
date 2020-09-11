package com.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tracker.DAO.DAOlayer;
import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;

@Service
public class DataBaseManagementSystem {

	

	public static boolean addUser(UserData user) {
		return DAOlayer.addUserData(user);

	}
	public static boolean checkUser(UserData user) {
		return DAOlayer.checkLoginCredential(user);

	}
	public static void addIncome(IncomeTable income,String user) {
		DAOlayer.addIncomeDAO(income,user);
	}
	public static void addExpense(ExpenseTable expense,String user) {
		DAOlayer.addExpenseDAO(expense,user);
	}
	public static void deleteIncome(int id)
	{
		DAOlayer.deleteIncome(id);
	}
	public static void deleteExpense(int id)
	{
		DAOlayer.deleteExpense(id);
	}
	public static void addCategory(String function,String category) {
		DAOlayer.addCategory(function,category);
	}
	public static void addLimit(MonthlyLimitTable limit) {
		DAOlayer.addLimit(limit);
	}
	public static void deleteLimit(String category,String username) {
		DAOlayer.deleteLimit(category,username);
	}
	public static List<chartsData> getChartsData(String username,String function,String period) {
		
		List<chartsData> list=DAOlayer.getChartsData(username,function,period);
		return list;
		
	}
public static List<chartsData> getSearchData(String username,String month) {
		
		List<chartsData> list=DAOlayer.getSearchData(username,month);
		return list;
		
	}

public static List<chartsData> getSearchYearData(String username,String year) {
	
	List<chartsData> list=DAOlayer.getSearchYearData(username,year);
	return list;
	
}
	
}
