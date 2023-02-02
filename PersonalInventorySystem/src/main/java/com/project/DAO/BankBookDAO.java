 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.BankBookBean;
import com.project.utilities.ConnectionPool;

public class BankBookDAO {
		
		
		public int addBankbook(BankBookBean bb)
		{
			Connection con=ConnectionPool.connectDB();
			int r=0;
			String sql="insert into bankbook(acid,account,transaction_date,amount,userid,operation) values('"+bb.getAcid()+"','"+bb.getAccount()+"','"+bb.getTransaction_date()+"','"+bb.getAmount()+"','"+bb.getUserid()+"','"+bb.getOperation()+"')";
			
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
			String sql="SELECT SUM(amount) FROM bankbook";
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
		
		
		
		
		
		
		
		
		public ArrayList<BankBookBean> findAll(){
			Connection con = ConnectionPool.connectDB();
			String sql = "select * from bankbook";
			ArrayList<BankBookBean> al = new ArrayList<BankBookBean>();
			try {
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()) {
					BankBookBean bb = new BankBookBean();
					bb.setAcid(rs.getInt("acid"));
					bb.setAccount(rs.getString("account"));
					bb.setTransaction_date(rs.getString("transaction_date"));
					bb.setAmount(rs.getDouble("amount"));
					bb.setUserid(rs.getInt("userid"));
					bb.setOperation(rs.getString("operation"));
				al.add(bb);
				}
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			return al;
		}
		
		
		
		public ArrayList <BankBookBean> findByDate(String date1,String date2) {
			Connection con=ConnectionPool.connectDB();
			String sql="select * from bankbook where transaction_date >= '"+date1+"' and transaction_date <= '"+date2+"'";
			ArrayList<BankBookBean> al = new ArrayList<BankBookBean>();
			try {
				Statement stmt=con.createStatement();
				ResultSet rs=stmt.executeQuery(sql);
				while(rs.next()) {
					BankBookBean bb = new BankBookBean();
					bb.setAcid(rs.getInt("acid"));
					bb.setAccount(rs.getString("account"));
					bb.setTransaction_date(rs.getString("transaction_date"));
					bb.setAmount(rs.getDouble("amount"));
					bb.setUserid(rs.getInt("userid"));
					bb.setOperation(rs.getString("operation"));
					al.add(bb);

				}
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return al;
		}
		
		
		
		
	}

