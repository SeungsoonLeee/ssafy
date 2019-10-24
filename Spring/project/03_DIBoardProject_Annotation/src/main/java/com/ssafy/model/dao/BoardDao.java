package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;

public interface BoardDao {
	public int getBoardNo(Connection con) throws SQLException;
	public void insertBoard(Connection con, Board board) throws SQLException;
	public void insertBoardFile(Connection con, List<BoardFile> files, int bno) throws SQLException;
	public Board search(String no) throws SQLException;
	public List<Board> searchAll(PageBean bean) throws SQLException;
	public int count(PageBean bean) throws SQLException;
	public void updateBoard(Connection con, Board board) throws SQLException;
	public void deleteBoard(Connection con, String no) throws SQLException;
	public void deleteBoardFile(Connection con, int bno) throws SQLException;
	
}













