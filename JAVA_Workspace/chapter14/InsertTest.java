package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InsertTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "insert into emp(empno, ename, sal)"
					+ "values(?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, 3333);
			pstmt.setString(2, "GRAY");
			pstmt.setInt(3, 4500);
			int row = pstmt.executeUpdate();
			System.out.println(row + "행이 수행됐습니다.");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
}
