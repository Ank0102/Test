package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.CashBookBean;
import com.project.Bean.ExpensesCategoryBean;
import com.project.Bean.IncomeBean;
import com.project.Bean.UsersBean;
import com.project.utilities.ConnectionPool;

// import Server.CashBook;

public class CashBookDAO {
	
	
	
	public int addCashbook(CashBookBean cb)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into cashbook(acid,account,transaction_date,amount,userid,operation) values('"+cb.getAcid()+"','"+cb.getAccount()+"','"+cb.getTransaction_date()+"','"+cb.getAmount()+"','"+cb.getUserid()+"','"+cb.getOperation()+"')";
		
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
	
	public String sumCash() {
		Connection con=ConnectionPool.connectDB();
		String sum="";
		String sql="SELECT SUM(amount) FROM cashbook";
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					
					
					sum=rs.getString(1);
				}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sum;
	}
	
	
	
	public ArrayList<CashBookBean> findAll(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from cashbook";
		ArrayList<CashBookBean> al = new ArrayList<CashBookBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				CashBookBean cb = new CashBookBean();
				cb.setAcid(rs.getInt("acid"));
				cb.setAccount(rs.getString("account"));
				cb.setTransaction_date(rs.getString("transaction_date"));
				cb.setAmount(rs.getDouble("amount"));
				cb.setUserid(rs.getInt("userid"));
				cb.setOperation(rs.getString("operation"));
			al.add(cb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	public ArrayList <CashBookBean> findByDate(String date1,String date2) {
		Connection con=ConnectionPool.connectDB();
		String sql="select * from cashbook where transaction_date >= '"+date1+"' and transaction_date <= '"+date2+"'";
		ArrayList<CashBookBean> al = new ArrayList<CashBookBean>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				CashBookBean cb = new CashBookBean();
				cb.setAcid(rs.getInt("acid"));
				cb.setAccount(rs.getString("account"));
				cb.setTransaction_date(rs.getString("transaction_date"));
				cb.setAmount(rs.getDouble("amount"));
				cb.setUserid(rs.getInt("userid"));
				cb.setOperation(rs.getString("operation"));
				al.add(cb);

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

public static void main(String args[]) {
	
	CashBookBean cb = new CashBookBean();
	CashBookDAO cd = new CashBookDAO();
	
	ArrayList<CashBookBean> result = cd.findByDate("01-10-2022", "01-11-2022");
	for(CashBookBean ub : result) {
		System.out.println(ub);
	
}
}
}
