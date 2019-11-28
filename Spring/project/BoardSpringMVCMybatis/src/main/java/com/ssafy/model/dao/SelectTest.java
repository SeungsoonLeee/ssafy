package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.ssafy.util.DBUtil;

public class SelectTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
			String sql =" select * from emp ";
			stmt = con.prepareStatement(sql);
			
			rs = stmt.executeQuery();
			System.out.println("사원번호\t이름\t업무\t급여\t부서번호");
			//next() : 다음 행이 없으면 false, 있으면 커서를 다음 행으로 이동 후 true 리턴 
			while(rs.next()) {
				System.out.printf("%d\t%s\t%s\t%d\t%d\n", rs.getInt("empno")
														, rs.getString("ename")
														, rs.getString("job")
														, rs.getInt("sal")
														, rs.getInt("deptno"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}
}











