package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import com.ssafy.util.DBUtil;

public class SelectMetaDataTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = DBUtil.getConnection();
//			String sql =" select empno, ename, sal from emp ";
			String sql = " select * from board ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			/* ResultSet에 대한 MetaData를 제공함 */
			ResultSetMetaData rsmd = rs.getMetaData();
			int cnt = rsmd.getColumnCount();
			for (int i = 1; i <= cnt; i++) {
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println();
			//next() : 다음 행이 없으면 false, 있으면 커서를 다음 행으로 이동 후 true 리턴 
			while(rs.next()) {
				for (int i = 1; i <= cnt; i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
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











