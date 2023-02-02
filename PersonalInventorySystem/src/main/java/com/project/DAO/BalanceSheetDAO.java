 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.BalanceSheetBean;
import com.project.Bean.BankBookBean;
import com.project.utilities.ConnectionPool;

public class BalanceSheetDAO {

	
	public int addBalanceSheet(BalanceSheetBean bsb)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into balancesheet(incomes,Inc_amount,expenses,Exp_amount) values('"+bsb.getIncomes()+"','"+bsb.getInc_amount()+"','"+bsb.getExpenses()+"','"+bsb.getExp_amount()+"')";
		
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
