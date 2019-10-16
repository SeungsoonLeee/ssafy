package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;
public interface BoardDao {
	public void insertBoard(SqlSession session, Board board);
	public void updateBoard(SqlSession session, Board board);
	public void deleteBoard(String no);
	public Board search(String no);
	public List<Board> searchAll(PageBean bean);
	public int  getBoardNo(SqlSession session);
	public int  count(PageBean bean);
}
