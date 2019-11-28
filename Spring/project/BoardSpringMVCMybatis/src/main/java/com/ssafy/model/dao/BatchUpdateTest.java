package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ssafy.util.DBUtil;

/**
 * Batch : 일괄 처리 
 *
 */
public class BatchUpdateTest {
	public static void main(String[] args) {
		
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DBUtil.getConnection();
			String sql = " insert into emp(empno, ename, sal, job, deptno) value(?,?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			for (int i =1; i <= 3; i++) {
				stmt.setInt(1, 30+i);
				stmt.setString(2, "30"+i);
				stmt.setInt(3, 3000+i);
				stmt.setString(4, "student");
				stmt.setInt(5, 40);
				stmt.addBatch();       //설정한 데이타를 추가  
			}
			stmt.executeBatch();	   //여러개 설정한 데이타를 한번에 일괄 처리하는 기능;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}









