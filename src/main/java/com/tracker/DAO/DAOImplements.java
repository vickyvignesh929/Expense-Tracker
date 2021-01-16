package com.tracker.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.tracker.entity.ExpenseTable;
import com.tracker.entity.IncomeTable;
import com.tracker.entity.MonthlyLimitTable;
import com.tracker.entity.UserData;
import com.tracker.entity.chartsData;
import com.utilities.DB;

@Component
public class DAOImplements implements DAO {
	static PreparedStatement pst = null;
	static int flag = 0;
	static Connection con = null;

	public boolean addUserData(UserData user) {
		try {
			con = DB.getConnection();
			pst = con.prepareStatement("insert into userdata values('" + user.getUsername() + "','" + user.getPassword()
					+ "','" + user.getEmail() + "'," + user.getAmount() + ")");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (flag > 0) ? true : false;

	}

	public boolean checkLoginCredential(UserData user) {
		try {
			con = DB.getConnection();
			ResultSet rs = con.prepareStatement("select email from userdata where username='" + user.getUsername()
					+ "'and password='" + user.getPassword() + "'").executeQuery();
			return (rs.next() ? true : false);
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public boolean addIncomeDAO(IncomeTable income, String user) {
		try {
			con = DB.getConnection();
			pst = con.prepareStatement(
					"insert into income_table(income_date,income_category,income_description,income_amount,username) value('"
							+ income.getDate() + "','" + income.getCategory() + "','" + income.getDescription() + "',"
							+ income.getAmount() + ",'" + user + "')");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return (flag > 0) ? true : false;

	}

	public boolean addExpenseDAO(ExpenseTable expense, String user) {
		try {
			con = DB.getConnection();
			pst = con.prepareStatement(
					"insert into expense_table(expense_date,expense_category,expense_description,expense_amount,username) value('"
							+ expense.getDate() + "','" + expense.getCategory() + "','" + expense.getDescription()
							+ "'," + expense.getAmount() + ",'" + user + "')");
			flag = pst.executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return false;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return (flag > 0) ? true : false;

	}

	public void deleteIncome(int id) {
		try {
			con = DB.getConnection();
			DB.getConnection().prepareStatement("delete from income_table where income_id=" + id + "").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteExpense(int id) {
		try {
			con = DB.getConnection();
			con.prepareStatement("delete from expense_table where expense_id=" + id + "").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addCategory(String function, String category) {
		try {
			con = DB.getConnection();
			con.prepareStatement("insert into " + function + "_category values ('" + category + "')").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void addLimit(MonthlyLimitTable limit) {
		try {
			con = DB.getConnection();
			con.prepareStatement("insert into monthly_limit_table values ('" + limit.getLimitCategory() + "','"
					+ limit.getLimitAmount() + "','" + limit.getUsername() + "')").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void deleteLimit(String category, String username) {
		try {
			con = DB.getConnection();
			con.prepareStatement("delete from monthly_limit_table where limit_category='" + category
					+ "' and username='" + username + "'").executeUpdate();
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
		}

	}

	public List<chartsData> getChartsData(String user, String function, String period) {
		try {
			List<chartsData> list = new ArrayList<>();
			con = DB.getConnection();
			ResultSet rs = con
					.prepareStatement(
							"select " + function + "_category as category,sum(" + function + "_amount) as amount  from "
									+ function + "_table where username='" + user + "'  and " + period + "(" + function
									+ "_date) = " + period + "(CURRENT_DATE()) group by " + function + "_category")
					.executeQuery();
			while (rs.next()) {
				chartsData data = new chartsData();
				data.setCategory(rs.getString("category"));
				data.setAmount(rs.getInt("amount"));
				list.add(data);

			}

			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<chartsData> getSearchData(String user, String month) {
		try {
			con=DB.getConnection();
			List<chartsData> list = new ArrayList<>();
			ResultSet rs = con.prepareStatement(
					"select expense_category as category,sum(expense_amount) as amount from expense_table where username='"
							+ user + "' and expense_date like '" + month + "%'  group by expense_category")
					.executeQuery();
			while (rs.next()) {
				chartsData data = new chartsData();
				data.setCategory(rs.getString("category"));
				data.setAmount(rs.getInt("amount"));
				list.add(data);

			}

			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public List<chartsData> getSearchYearData(String user, String year) {
		try {
			con=DB.getConnection();
			List<chartsData> list = new ArrayList<>();
			ResultSet rs = con.prepareStatement(
					"select month(expense_date) as category,sum(expense_amount) as amount from expense_table where username='"
							+ user + "' and YEAR(expense_date) ='" + year + "'  group by category order by category")
					.executeQuery();
			while (rs.next()) {
				chartsData data = new chartsData();
				int monthNumber = Integer.parseInt(rs.getString("category"));
				String month = Month.of(monthNumber).name();

				data.setCategory(month);
				data.setAmount(rs.getInt("amount"));
				list.add(data);

			}

			return list;
		} catch (SQLException | ClassNotFoundException e) {
			System.out.println(e);
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
