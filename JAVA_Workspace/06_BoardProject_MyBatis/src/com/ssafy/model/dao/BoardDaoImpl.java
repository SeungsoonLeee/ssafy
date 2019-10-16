package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public class BoardDaoImpl implements BoardDao {
	SqlSession session = MyBatis.getSqlSession();

	// transaction 구간 : 2개 이상의 DML이 실행될 때에는 2개 모두가 완료되어야 commit이다.
	public void insertBoard(SqlSession session, Board board) {
		session.insert("board.insert", board);
		// service에서 commit하거나 rollback 할 예정
	}

	// transaction 구간 : 2개 이상의 DML이 실행될 때에는 2개 모두가 완료되어야 commit이다.
	public void updateBoard(SqlSession session, Board board) {
		session.update("board.update", board);
		// service에서 commit하거나 rollback 할 예정
	}

	public void deleteBoard(String no) {
		session.delete("board.delete", no);
		session.commit(); // delete는 cascade 옵션이 걸려있기 때문에 바로 commit해도 됨
	}

	public Board search(String no) {
		return session.selectOne("board.search", no);
	}

	public List<Board> searchAll(PageBean bean) {
		RowBounds rows = new RowBounds(bean.getStart() - 1, bean.getInterval());
		return session.selectList("board.searchAll", bean, rows);
	}

	public int getBoardNo(SqlSession session) {
		return session.selectOne("board.boardNo");
	}

	public int count(PageBean bean) {
		return session.selectOne("board.count", bean);
	}
}
