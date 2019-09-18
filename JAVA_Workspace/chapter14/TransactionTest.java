package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TransactionTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			// 자동 commit 해제
			con.setAutoCommit(false);
			String sql1 = "select max(no)+1 as no from board";
			String sql2 = "insert into board(no, id, title, contents) values(?,?,?,?)";
			String sql3 = "insert into boardFile(rfilename, sfilename, bno) values(?,?,?)";

			pstmt1 = con.prepareStatement(sql1);
			rs = pstmt1.executeQuery();
			int no = 0;
			while (rs.next()) {
				no = rs.getInt("no");
			}

			pstmt2 = con.prepareStatement(sql2);
			pstmt2.setInt(1, no);
			pstmt2.setString(2, "ssafy");
			pstmt2.setString(3, "처음하는 jdbc");
			pstmt2.setString(4, "잘되나요?");
			pstmt2.executeUpdate();

			pstmt3 = con.prepareStatement(sql3);
			pstmt3.setString(1, "a.txt");
			pstmt3.setString(2, "a.txt");
			pstmt3.setInt(3, no);
			pstmt3.executeUpdate();

			// 수동으로 commit
			con.commit();

		} catch (Exception e) {
			e.printStackTrace();
			// 중간에 에러가 났으면 롤백처리
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt1);
			DBUtil.close(pstmt2);
			DBUtil.close(pstmt3);
			DBUtil.close(con);
		}
	}
}
