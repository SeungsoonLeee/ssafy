package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ssafy.util.DBUtil;

public class InsertTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal, job, deptno) value(?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, 5555);  			//첫번째 ?에 정수타입으로 3333을 설정 
			stmt.setString(2, "ssafy");  	//두번째 ?에 문자열타입으로 ssafy을 설정 
			stmt.setInt(3, 3000);  			
			stmt.setString(4, "student");  	
			stmt.setInt(5, 40);  	
			int rows = stmt.executeUpdate();
			if(rows>0) {
				System.out.printf("%d행 수행되었습니다", rows);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}














