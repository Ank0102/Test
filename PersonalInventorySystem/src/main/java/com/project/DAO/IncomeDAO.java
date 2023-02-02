 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.BankBookBean;
import com.project.Bean.CashBookBean;
import com.project.Bean.ExpensesBean;
import com.project.Bean.IncomeBean;
import com.project.Bean.UsersBean;
import com.project.utilities.ConnectionPool;

public class IncomeDAO {
	public int addIncome(IncomeBean ib)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into income(inc_id,inc_ac,inc_category,userid,inc_catid,amount,transaction_date,receivby,remark) values('"+ib.getInc_id()+"','"+ib.getInc_ac()+"','"+ib.getInc_category()+"','"+ib.getUserid()+"','"+ib.getInc_catid()+"','"+ib.getAmount()+"','"+ib.getTransaction_date()+"','"+ib.getReceivby()+"','"+ib.getRemark()+"')";
		
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
	
	public ArrayList<IncomeBean> findAll(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from income";
		ArrayList<IncomeBean> al = new ArrayList<IncomeBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				IncomeBean ib = new IncomeBean();

				ib.setInc_id(rs.getInt("inc_id"));
				ib.setInc_catid(rs.getInt("inc_id"));
				ib.setInc_ac(rs.getString("inc_ac"));
				ib.setInc_category(rs.getString("inc_category"));
				ib.setUserid(rs.getInt("userid"));
				ib.setInc_catid(rs.getInt("inc_catid"));
				ib.setAmount(rs.getDouble("amount"));
				ib.setTransaction_date(rs.getString("transaction_date"));
				ib.setReceivby(rs.getString("receivby"));
				ib.setRemark(rs.getString("remark"));
				
			al.add(ib);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	
	public ArrayList<IncomeBean> findCash(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from income where receivby='cash'";
		ArrayList<IncomeBean> al = new ArrayList<IncomeBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				IncomeBean ib = new IncomeBean();

				
				ib.setInc_catid(rs.getInt("inc_id"));
				ib.setInc_ac(rs.getString("inc_ac"));
				ib.setInc_category(rs.getString("inc_category"));
				ib.setUserid(rs.getInt("userid"));
				ib.setInc_catid(rs.getInt("inc_catid"));
				ib.setAmount(rs.getDouble("amount"));
				ib.setTransaction_date(rs.getString("transaction_date"));
				ib.setReceivby(rs.getString("receivby"));
				ib.setRemark(rs.getString("remark"));
				
			al.add(ib);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	
	
	
	public ArrayList <IncomeBean> findByDate(String date1,String date2) {
		Connection con=ConnectionPool.connectDB();
		String sql="select * from income where transaction_date >= '"+date1+"' and transaction_date <= '"+date2+"'";
		ArrayList<IncomeBean> al = new ArrayList<IncomeBean>();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				IncomeBean ib = new IncomeBean();

				
				ib.setInc_catid(rs.getInt("inc_id"));
				ib.setInc_ac(rs.getString("inc_ac"));
				ib.setInc_category(rs.getString("inc_category"));
				ib.setUserid(rs.getInt("userid"));
				ib.setInc_catid(rs.getInt("inc_catid"));
				ib.setAmount(rs.getDouble("amount"));
				ib.setTransaction_date(rs.getString("transaction_date"));
				ib.setReceivby(rs.getString("receivby"));
				ib.setRemark(rs.getString("remark"));
				
			al.add(ib);
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return al;
	}
	
	
	
	
	
	
public static void main (String args[]) {
IncomeBean ic= new IncomeBean();
IncomeDAO id = new IncomeDAO();
ArrayList<IncomeBean> result = id.findCash();
	for(IncomeBean ub : result) {
		System.out.println(ub);
	}
}
}
