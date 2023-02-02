 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.ExpensesBean;
import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.IncomeBean;
import com.project.utilities.ConnectionPool;

public class ExpensesDAO {
	
	
	
	public int addExpenses(ExpensesBean eb)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into expenses(exp_id,exp_ac,exp_category,userid,exp_catid,amount,transaction_date,payby,remark) values('"+eb.getExp_id()+"','"+eb.getExp_ac()+"','"+eb.getExp_category()+"','"+eb.getUserid()+"','"+eb.getExp_catid()+"','"+eb.getAmount()+"','"+eb.getTransaction_date()+"','"+eb.getPayby()+"','"+eb.getRemark()+"')";
		
		try {
			Statement stmt=con.createStatement();
			 r=stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return r;
	}
	
	
	
	
	public ArrayList<ExpensesBean> findAll(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from expenses";
		ArrayList<ExpensesBean> al = new ArrayList<ExpensesBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ExpensesBean eb = new ExpensesBean();
								
				eb.setExp_id(rs.getInt("exp_id"));
				eb.setExp_ac(rs.getString("exp_ac"));
				eb.setExp_category(rs.getString("exp_category"));
				eb.setUserid(rs.getInt("userid"));
				eb.setExp_catid(rs.getInt("exp_catid"));
				eb.setAmount(rs.getDouble("amount"));
				eb.setTransaction_date(rs.getString("transaction_date"));
				eb.setPayby(rs.getString("payby"));
				eb.setRemark(rs.getString("remark"));
				
			al.add(eb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	
	
	public ArrayList <ExpensesBean> findByDate(String date1,String date2) {
		Connection con=ConnectionPool.connectDB();
		String sql="select * from expenses where transaction_date >= '"+date1+"' and transaction_date <= '"+date2+"'";
		ArrayList<ExpensesBean> al = new ArrayList<ExpensesBean>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				ExpensesBean eb = new ExpensesBean();

				
				eb.setExp_id(rs.getInt("exp_id"));
				eb.setExp_ac(rs.getString("exp_ac"));
				eb.setExp_category(rs.getString("exp_category"));
				eb.setUserid(rs.getInt("userid"));
				eb.setExp_catid(rs.getInt("exp_catid"));
				eb.setAmount(rs.getDouble("amount"));
				eb.setTransaction_date(rs.getString("transaction_date"));
				eb.setPayby(rs.getString("payby"));
				eb.setRemark(rs.getString("remark"));
				
			al.add(eb);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String args[]) {
//   ExpensesBean eb = new ExpensesBean();
//   eb.setExp_id(1);
//   eb.setExp_ac("self");
//   eb.setUserid(24);
//  eb.setExp_catid(75);
//   eb.setAmount(100);
//   eb.setTransaction_date("01-01-2022");
//   eb.setPayby("cash");
//   eb.setRemark("happy");
//   ExpensesDAO ed = new ExpensesDAO();

// int r=  ed.addExpenses(eb);
// if(r>0)
// {
//	 System.out.print("ok");
// }
// else {
//	 System.out.print("failed");
//
//	 
// }
//	}

}
