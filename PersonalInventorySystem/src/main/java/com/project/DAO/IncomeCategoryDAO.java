 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.Bean.IncomeCategoryBean;
import com.project.utilities.ConnectionPool;

public class IncomeCategoryDAO {
	
	
	public int addIncomeCategory(IncomeCategoryBean icb)
	{
		Connection con=ConnectionPool.connectDB();
		int r=0;
		String sql="insert into incomecategory (inc_catid,inc_catname,inc_catdetails,userid) values('"+icb.getInc_catid()+"','"+icb.getInc_catname()+"','"+icb.getInc_catdetails()+"','"+icb.getUserid()+"')";
		
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
	
	
	
	public int updateIncomeCategory(IncomeCategoryBean icb) {
		Connection con=ConnectionPool.connectDB();
		String sql= "UPDATE  IncomeCategory SET inc_catname='" + icb.getInc_catname()+ "' ,inc_catdetails='" + icb.getInc_catdetails()+ "' WHERE inc_catid='" + icb.getInc_catid() + "'";
	
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
	
	
	
	public int deleteIncomeCategory(int inc_catid) {
		Connection con=ConnectionPool.connectDB();
		String sql="delete from IncomeCategory where inc_catid='"+inc_catid+"'";
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
	
	

	public ArrayList<IncomeCategoryBean> findAll(){
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from IncomeCategory";
		ArrayList<IncomeCategoryBean> al = new ArrayList<IncomeCategoryBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				IncomeCategoryBean icb = new IncomeCategoryBean();
				icb.setInc_catid(rs.getInt("inc_catid"));
				icb.setInc_catname(rs.getString("inc_catname"));
				icb.setInc_catdetails(rs.getString("inc_catdetails"));
				icb.setUserid(rs.getInt("userid"));
				al.add(icb);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return al;
	}
	
	
	
	public IncomeCategoryBean findByIncCatId(int inc_catid) {
		Connection con=ConnectionPool.connectDB();
		String sql="select * from IncomeCategory where inc_catid='"+inc_catid+"'";
		IncomeCategoryBean icb=new IncomeCategoryBean();
		try {
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()) {
				icb.setInc_catid(rs.getInt("inc_catid"));
				icb.setInc_catname(rs.getString("inc_catname"));
				icb.setInc_catdetails(rs.getString("inc_catdetails"));
				icb.setUserid(rs.getInt("userid"));
			
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return icb;
	}
	
	
	
	
	
	
	
	
	
	
	public static void main(String args[]) {
		IncomeCategoryBean icb = new IncomeCategoryBean();
icb.setInc_catname("b");
icb.setInc_catdetails("bb");
icb.setInc_catid(1);
IncomeCategoryDAO icd = new IncomeCategoryDAO();
icd.updateIncomeCategory(icb);
	
	}

}
