package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;

//@Component("boardOracleDao")
@Repository("boardOracleDao")
public class BoardOracleDaoImpl implements BoardDao {

	@Override
	public int getBoardNo(Connection con) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void insertBoard(Connection con, Board board) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertBoardFile(Connection con, List<BoardFile> files, int bno) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public Board search(String no) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Board> searchAll(PageBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count(PageBean bean) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateBoard(Connection con, Board board) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoard(Connection con, String no) throws SQLException {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBoardFile(Connection con, int bno) throws SQLException {
		// TODO Auto-generated method stub

	}

}
