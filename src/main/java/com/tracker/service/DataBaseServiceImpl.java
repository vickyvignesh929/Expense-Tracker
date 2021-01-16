package com.tracker.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.tracker.DAO.DAOImplements;
import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;

@Service
public class DataBaseServiceImpl implements DataBaseService {

	DAOImplements daoImplements=new DAOImplements();

	public boolean addUser(UserData user) {
		return daoImplements.addUserData(user);

	}
	public  boolean checkUser(UserData user) {
		return daoImplements.checkLoginCredential(user);

	}
	public  void addIncome(IncomeTable income,String user) {
		daoImplements.addIncomeDAO(income,user);
	}
	public  void addExpense(ExpenseTable expense,String user) {
		daoImplements.addExpenseDAO(expense,user);
	}
	public  void deleteIncome(int id)
	{
		daoImplements.deleteIncome(id);
	}
	public  void deleteExpense(int id)
	{
		daoImplements.deleteExpense(id);
	}
	public void addCategory(String function,String category) {
		daoImplements.addCategory(function,category);
	}
	public  void addLimit(MonthlyLimitTable limit) {
		daoImplements.addLimit(limit);
	}
	public void deleteLimit(String category,String username) {
		daoImplements.deleteLimit(category,username);
	}
	public  List<chartsData> getChartsData(String username,String function,String period) {
		
		List<chartsData> list=daoImplements.getChartsData(username,function,period);
		return list;
		
	}
public  List<chartsData> getSearchData(String username,String month) {
		
		List<chartsData> list=daoImplements.getSearchData(username,month);
		return list;
		
	}

public List<chartsData> getSearchYearData(String username,String year) {
	
	List<chartsData> list=daoImplements.getSearchYearData(username,year);
	return list;
	
}

	
}
