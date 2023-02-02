 package com.project.utilities;
import java.sql.*;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConnectionPool {
	static Connection con = null;

	public static Connection connectDB() {
	try {
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/personalinvsystem","root","1234");

	System.out.println("Database Connected");

	} catch (ClassNotFoundException e) {
	System.out.println(e);
	
	} catch (SQLException e) {
	e.printStackTrace();
	}
	return con;
	}
	public static void main(String args[]) {
	connectDB();
	}
	
}
