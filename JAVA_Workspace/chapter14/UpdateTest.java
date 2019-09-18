package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			String sql = "update emp set ename = ?, sal = ? where empno = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "SSAFY");
			pstmt.setInt(2, 5000);
			pstmt.setInt(3, 3333);
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
