 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.ExpensesCategoryBean;
import com.project.utilities.ConnectionPool;

public class ExpensesCategoryDAO {
	
	public int addExpensesCategory(ExpensesCategoryBean ecb)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into ExpensesCategory(exp_catid,exp_catname,exp_catdetails,userid) values('"+ecb.getExp_catid()+"','"+ecb.getExp_catname()+"','"+ecb.getExp_catdetails()+"','"+ecb.getUserid()+"')";
		
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
	
	
	
	
	public int updateExpensesCategory(ExpensesCategoryBean ecb) {
		Connection con=ConnectionPool.connectDB();
		String sql= "UPDATE  ExpensesCategory SET exp_catname='" + ecb.getExp_catname()+ "' ,exp_catdetails='" + ecb.getExp_catdetails()+ "' WHERE exp_catid='" + ecb.getExp_catid() + "'";
	
		int r=0;
		try {
			Statement  stmt=con.createStatement();
			r=stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return r;
		
	}
	
	
	
	
	public int deleteExpensesCategory(int exp_catid) {
		Connection con=ConnectionPool.connectDB();
		String sql="delete from ExpensesCategory where exp_catid='"+exp_catid+"'";
		int r=0;
		try {
			Statement  stmt=con.createStatement();
			r=stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
		
	}
	
	
	
	public ArrayList<ExpensesCategoryBean> findAll(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from ExpensesCategory";
		ArrayList<ExpensesCategoryBean> al = new ArrayList<ExpensesCategoryBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				ExpensesCategoryBean ecb = new ExpensesCategoryBean();
				ecb.setExp_catid(rs.getInt("exp_catid"));
				ecb.setExp_catname(rs.getString("exp_catname"));
				ecb.setExp_catdetails(rs.getString("exp_catdetails"));
				ecb.setUserid(rs.getInt("userid"));
			al.add(ecb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	public ExpensesCategoryBean findByExpCatId(int exp_catid) {
		Connection con=ConnectionPool.connectDB();
		String sql="select * from ExpensesCategory where exp_catid='"+exp_catid+"'";
		ExpensesCategoryBean ecb=new ExpensesCategoryBean();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				ecb.setExp_catid(rs.getInt("exp_catid"));
				ecb.setExp_catname(rs.getString("exp_catname"));
				ecb.setExp_catdetails(rs.getString("exp_catdetails"));
				ecb.setUserid(rs.getInt("userid"));
			
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ecb;
	}
	
	
	public static void main(String args[]) {
		ExpensesCategoryBean ecb=new ExpensesCategoryBean();
//		ecb.setExp_catname("Myself");
//		ecb.setExp_catdetails("food");
//		ecb.setExp_catid(47);
//
	ExpensesCategoryDAO ecd=new ExpensesCategoryDAO();
	//int r=   ecd.updateExpensesCategory(ecb);
	
	//	ExpensesCategoryBean eb=ecd.findByExpCatId(1);
	//	System.out.println(eb);
		
	//int x=ecd.deleteExpensesCategory(2);
		
		
		//if//(x>0) {
		//	System.out.println("Data Update Success");
		//}else {
			//System.out.println("Data updation fail");
		//}
		
		//delete
		
//		int x=ed.deleteEmployee(114);
//		if(x>0) {
//			System.out.println("Data Deletion Success");
//		}
//		else {
//			System.out.println("Data Deletion Fail");
//		}
		//*/
		//ec.findAll();
	//	ExpensesCategoryBean eb=ecd.findByExpCatId(1);
		//System.out.println(eb);
		
		ArrayList<ExpensesCategoryBean> result=ecd.findAll();
		for(ExpensesCategoryBean eb:result) {
System.out.println(" "+ecb.getExp_catid()+"   "+eb.getExp_catname()+"   "+eb.getExp_catdetails()+" ");	
		}
	}
}
