package com.ssafy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class DBUtil {
	public static String url="jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8";
	public static String user="ssafy";
	public static String password="ssafy";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			System.out.println("드라이버 로딩 실패!!!");
			e.printStackTrace();
		}
	}
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {rs.close(); } catch (Exception e) {}
		}
	}
	public static void close(PreparedStatement stmt) {
		if(stmt != null) {
			try {stmt.close(); } catch (Exception e) {}
		}
	}
	public static void close(Connection con) {
		if(con != null) {
			try {con.close(); } catch (Exception e) {}
		}
	}
	public static void autoClose(Connection con) {
		if(con != null) {
			try {
				if(!con.getAutoCommit()) {
					con.setAutoCommit(true);
				}
				con.close(); 
			} catch (Exception e) {}
		}
	}
	public static void rollback(Connection con) {
		if(con != null) {
			try {
				con.rollback();
			} catch (Exception e) {}
		}
	}
}


























