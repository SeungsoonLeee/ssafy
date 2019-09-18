package chapter14;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// DB연결
			con = DBUtil.getConnection();
			// sql 실행을 위한 pstmt 생성
			pstmt = con.prepareStatement("select * from emp");
			// sql 실행
			rs = pstmt.executeQuery();
			// 결과 처리
			System.out.println("사원번호\t이름\t급여\t부서번호\t업부");
			while (rs.next()) {
				System.out.println(rs.getInt("empno") + "\t" 
						+ rs.getString("ename") + "\t" 
						+ rs.getInt("sal") + "\t"
						+ rs.getInt("deptno") + "\t" 
						+ rs.getString("job"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs);
			DBUtil.close(pstmt);
			DBUtil.close(con);
		}
	}
}
