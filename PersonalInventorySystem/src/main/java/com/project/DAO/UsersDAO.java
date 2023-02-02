package com.project.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.project.utilities.*;
import com.project.Bean.UsersBean;

public class UsersDAO {
	public int addUser(UsersBean ub) {
		Connection con = ConnectionPool.connectDB();
		int r = 0;
		String sql = "insert into users(userid,username,password,name,address,mobile,email) values('" + ub.getUserid()
				+ "','" + ub.getUsername() + "','" + ub.getPassword() + "','" + ub.getName() + "','" + ub.getAddress()
				+ "','" + ub.getMobile() + "','" + ub.getEmail() + "')";

		try {
			Statement stmt = con.createStatement();
			r = stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return r;
	}

	public int updateUser(UsersBean ub) {
		Connection con = ConnectionPool.connectDB();
		String sql = "UPDATE  USERS SET username='" + ub.getUsername() + "' ,password='" + ub.getPassword()
				+ "', name='" + ub.getName() + "', address='" + ub.getAddress() + "', mobile='" + ub.getMobile()
				+ "', email='" + ub.getEmail() + "' WHERE USERID='" + ub.getUserid() + "'";

		int r = 0;
		try {
			Statement stmt = con.createStatement();
			r = stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return r;

	}

	public int deleteUser(int userid) {
		Connection con = ConnectionPool.connectDB();
		String sql = "delete from users where userid='" + userid + "'";
		int r = 0;
		try {
			Statement stmt = con.createStatement();
			r = stmt.executeUpdate(sql);
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;

	}

	public ArrayList<UsersBean> findAll() {
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from users";
		ArrayList<UsersBean> al = new ArrayList<UsersBean>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				UsersBean ub = new UsersBean();
				ub.setUserid(rs.getInt("userid"));
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setName(rs.getString("name"));
				ub.setAddress(rs.getString("address"));
				ub.setMobile(rs.getString("mobile"));
				ub.setEmail(rs.getString("email"));

				al.add(ub);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return al;
	}

	public UsersBean findByUserid(int userid) {
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from users where userid='" + userid + "'";
		UsersBean ub = new UsersBean();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ub.setUserid(rs.getInt("userid"));
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setName(rs.getString("name"));
				ub.setAddress(rs.getString("address"));
				ub.setMobile(rs.getString("mobile"));
				ub.setEmail(rs.getString("email"));

			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}

	public UsersBean findByUserName(String username) {
		Connection con = ConnectionPool.connectDB();
		String sql = "select * from users where username='" + username + "'";
		UsersBean ub = new UsersBean();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				ub.setUserid(rs.getInt("userid"));
				ub.setUsername(rs.getString("username"));
				ub.setPassword(rs.getString("password"));
				ub.setName(rs.getString("name"));
				ub.setAddress(rs.getString("address"));
				ub.setMobile(rs.getString("mobile"));
				ub.setEmail(rs.getString("email"));
			}
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ub;
	}

	public static void main(String args[]) {
		/* UsersBean u = new UsersBean(); */
		/*
		 * u.setUserid(2); u.setUsername("Ram0102"); u.setPassword("123");
		 * u.setName("Ram Raj"); u.setAddress("Bhopal"); u.setMobile("9893618080");
		 * u.setEmail("Ram2@gmail.com");
		 */

		 UsersDAO ud = new UsersDAO(); 
		// insert
		/*
		 * int x = ud.addUser(u); if (x > 0) {
		 * System.out.println("Data insert success"); } else {
		 * System.out.println("Data insert fail"); }
		 */
		// int x=ud.deleteUser(4);
//	ud.findByUserName("shankar");

		/*
		 * if(x>0) { System.out.println("Data Update Success");
		 * 
		 * } else { System.out.println("Data failed");
		 * 
		 * }
		 */
		
		  UsersBean ub = ud.findByUserName("Ankit0102"); System.out.println(ub);
		  
		  
		  /* ArrayList<UsersBean> result = ud.findAll(); for (UsersBean ub : result) {
		 * System.out.println(ub); }
		 */
	}
}
