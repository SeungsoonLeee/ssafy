package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;

public class BoardDaoImpl implements BoardDao {
	public int getBoardNo(Connection con) throws SQLException {
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String sql = " select max(no)+1 as no  from board ";
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("no");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
//			connection을 close하면 transaction에서 같이 처리될 다른 기능에서 오류 남... 
		}
		return 1;
	}

	public void insertBoard(Connection con, Board board) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into board(no, id, title, contents)  values(?,?,?,?) ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, board.getNo());
			stmt.setString(2, board.getId());
			stmt.setString(3, board.getTitle());
			stmt.setString(4, board.getContents());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	public void insertBoardFile(Connection con, List<BoardFile> files, int bno) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " insert into boardfile(rfilename, sfilename, bno) values(?,?,?) ";
			stmt = con.prepareStatement(sql);
			for (BoardFile boardFile : files) {
				stmt.setString(1, boardFile.getRfilename());
				stmt.setString(2, boardFile.getSfilename());
				stmt.setInt(3, bno);
				stmt.addBatch();
			}
			stmt.executeBatch();
		} finally {
			DBUtil.close(stmt);
		}
	}

	public Board search(String no) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select a.* , rfilename, sfilename, f.no as fileno               \n");
			sql.append(" from   boardfile f                                              \n");
			sql.append(" right join  (select no, id, title, contents                     \n");
			sql.append(" 					, date_format(regdate, '%y-%m-%d') as regdate\n");
			sql.append(" 			 from   board                                        \n");
			sql.append(" 			 where  no = ? ) a                                   \n");
			sql.append(" on   a.no = bno                                                 \n");
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql.toString());
			stmt.setString(1, no);
			rs = stmt.executeQuery();
			Board board = null;
			boolean isFirst = true;
			ArrayList<BoardFile> files = new ArrayList<BoardFile>();
			while (rs.next()) {
				if (isFirst) {
					board = new Board(Integer.parseInt(no), rs.getString("id"), rs.getString("title"),
							rs.getString("regdate"), rs.getString("contents"), files);
					isFirst = false;
				}
				String rfilename = rs.getString("rfilename");
				if (rfilename != null) {
					files.add(new BoardFile(rs.getInt("fileNo"), rfilename, rs.getString("sfilename")));
				}
			}
			return board;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public List<Board> searchAll(PageBean bean) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			int interval = bean.getInterval();
			int start = bean.getStart();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select no, id, title, date_format(regdate, '%Y-%m-%d') as regdate from board   ");
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					sql.append(" where id = ? ");
				} else if (key.equals("title")) {
					sql.append(" where title like  ? ");
				} else if (key.equals("contents")) {
					sql.append(" where contents like  ? ");
				}
			}
			sql.append(" order by no desc limit ?,? ");
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					stmt.setString(idx++, word);
				} else {
					stmt.setString(idx++, "%" + word + "%");
				}
			}
			stmt.setInt(idx++, start);
			stmt.setInt(idx++, interval);
			rs = stmt.executeQuery();
			ArrayList<Board> boards = new ArrayList<Board>(interval);
			while (rs.next()) {
				boards.add(
						new Board(rs.getInt("no"), rs.getString("id"), rs.getString("title"), rs.getString("regdate")));
			}
			return boards;
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
	}

	public int count(PageBean bean) throws SQLException {
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			String key = bean.getKey();
			String word = bean.getWord();
			StringBuilder sql = new StringBuilder(100);
			sql.append(" select count(*) as cnt from board   ");
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					sql.append(" where id = ? ");
				} else if (key.equals("title")) {
					sql.append(" where title like  ? ");
				} else if (key.equals("contents")) {
					sql.append(" where contents like  ? ");
				}
			}
			con = DBUtil.getConnection();
			stmt = con.prepareStatement(sql.toString());
			int idx = 1;
			if (key != null && !key.equals("all") && word != null && !word.trim().equals("")) {
				if (key.equals("id")) {
					stmt.setString(idx++, word);
				} else {
					stmt.setString(idx++, "%" + word + "%");
				}
			}
			rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} finally {
			DBUtil.close(rs);
			DBUtil.close(stmt);
			DBUtil.close(con);
		}
		return 0;
	}

	public void updateBoard(Connection con, Board board) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " update board set title=?, contents=?, regdate=now() where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContents());
			stmt.setInt(3, board.getNo());
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	public void deleteBoard(Connection con, String no) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from board where no=? ";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, no);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}

	public void deleteBoardFile(Connection con, int bno) throws SQLException {
		PreparedStatement stmt = null;
		try {
			String sql = " delete from boardfile where bno=? ";
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, bno);
			stmt.executeUpdate();
		} finally {
			DBUtil.close(stmt);
		}
	}
}
