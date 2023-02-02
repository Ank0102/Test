 package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.project.utilities.*;


public class LoginDAO {
	public int login(String un,String ps) {
		Connection conn=ConnectionPool.connectDB();
		String sql="select id from users where username='"+un+"' and password='"+ps+"'";
		int r=0;
		try {
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()) {
			r= rs.getInt("id");
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return r;
	}
	

}
