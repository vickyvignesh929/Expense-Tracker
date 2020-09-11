package com.tracker.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;
import com.utilities.DB;

public class DAOlayer {
	static PreparedStatement pst = null;
	static int flag = 0;

	public static boolean addUserData(UserData user) {
		try {

			pst = DB.getConnection().prepareStatement("insert into userdata values('" + user.getUsername() + "','"
					+ user.getPassword() + "','" + user.getEmail() + "'," + user.getAmount() + ")");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		}
		return (flag > 0) ? true : false;

	}

	public static boolean checkLoginCredential(UserData user) {
		try {
			ResultSet rs = DB.getConnection().prepareStatement("select email from userdata where username='"
					+ user.getUsername() + "'and password='" + user.getPassword() + "'").executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean addIncomeDAO(IncomeTable income, String user) {
		try {
			System.out.println("here");
			pst = DB.getConnection().prepareStatement(
					"insert into income_table(income_date,income_category,income_description,income_amount,username) value('"
							+ income.getDate() + "','" + income.getCategory() + "','" + income.getDescription() + "',"
							+ income.getAmount() + ",'" + user + "')");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		}
		return (flag > 0) ? true : false;

	}

	public static boolean addExpenseDAO(ExpenseTable expense, String user) {
		try {
			System.out.println("here");
			pst = DB.getConnection().prepareStatement(
					"insert into expense_table(expense_date,expense_category,expense_description,expense_amount,username) value('"
							+ expense.getDate() + "','" + expense.getCategory() + "','" + expense.getDescription()
							+ "'," + expense.getAmount() + ",'" + user + "')");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		}
		return (flag > 0) ? true : false;

	}

	public static void deleteIncome(int id) {
		try {
			DB.getConnection().prepareStatement("delete from income_table where income_id=" + id + "").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public static void deleteExpense(int id) {
		try {
			DB.getConnection().prepareStatement("delete from expense_table where expense_id=" + id + "")
					.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public static void addCategory(String function, String category) {
		try {
			DB.getConnection().prepareStatement("insert into " + function + "_category values ('" + category + "')")
					.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public static void addLimit(MonthlyLimitTable limit) {
		try {
			DB.getConnection().prepareStatement("insert into monthly_limit_table values ('" + limit.getLimitCategory()
					+ "','" + limit.getLimitAmount() + "','" + limit.getUsername() + "')").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public static void deleteLimit(String category, String username) {
		try {
			System.out.println(category + username);
			DB.getConnection().prepareStatement("delete from monthly_limit_table where limit_category='" + category
					+ "' and username='" + username + "'").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public static List<chartsData> getChartsData(String user,String function,String period) {
		try {
			System.out.println("here");
			System.out.println(user);
			List<chartsData> list=new ArrayList<>();
			ResultSet rs = DB.getConnection().prepareStatement("select "+function+"_category as category,sum("+function+"_amount) as amount  from "+function+"_table where username='"+user+"'  and "+period+"("+function+"_date) = "+period+"(CURRENT_DATE()) group by "+function+"_category").executeQuery();
			while(rs.next()) {
				chartsData data=new chartsData();
				data.setCategory(rs.getString("category"));
				data.setAmount(rs.getInt("amount"));
				list.add(data);
			
			}
			 
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	
	public static List<chartsData> getSearchData(String user,String month) {
		try {
			System.out.println("here");
			System.out.println(user);
			List<chartsData> list=new ArrayList<>();
			ResultSet rs = DB.getConnection().prepareStatement("select expense_category as category,sum(expense_amount) as amount from expense_table where username='"+user+"' and expense_date like '"+month+"%'  group by expense_category" ).executeQuery();
			while(rs.next()) {
				chartsData data=new chartsData();
				data.setCategory(rs.getString("category"));
				data.setAmount(rs.getInt("amount"));
				list.add(data);
			
			}
			 
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
		
	}
	
	public static List<chartsData> getSearchYearData(String user,String year) {
		try {
			System.out.println("here");
			System.out.println(user);
			List<chartsData> list=new ArrayList<>();
			ResultSet rs = DB.getConnection().prepareStatement("select month(expense_date) as category,sum(expense_amount) as amount from expense_table where username='"+user+"' and YEAR(expense_date) ='"+year+"'  group by category order by category" ).executeQuery();
			while(rs.next()) {
				chartsData data=new chartsData();
				int monthNumber = Integer.parseInt(rs.getString("category"));
				String month=Month.of(monthNumber).name();
				
				data.setCategory(month);
				data.setAmount(rs.getInt("amount"));
				list.add(data);
			
			}
			 
			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}
		
	}
}
