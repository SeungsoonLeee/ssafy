package com.ssafy.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.config.MyBatis;
import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dao.FileDao;
import com.ssafy.model.dao.FileDaoImp;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.FileBean;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.PageUtility;

public class BoardServiceImpl implements BoardService {
	BoardDao dao = new BoardDaoImpl();
	FileDao fileDao = new FileDaoImp();

	public BoardServiceImpl() {
	}

	public BoardServiceImpl(BoardDao dao) {
		super();
		this.dao = dao;
	}

	public BoardDao getDao() {
		return dao;
	}

	public void setDao(BoardDao dao) {
		this.dao = dao;
	}

	@Override
	public void insertBoard(Board board) {
		SqlSession session = null;
		try {
			session = MyBatis.getSqlSession();
			int no = dao.getBoardNo(session);
			board.setNo(no);
			dao.insertBoard(session, board);

			List<FileBean> files = board.getFiles();
			if (files != null && files.size() > 0) {
				fileDao.insertFile(session, files, no);
			}

			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			throw new BoardException("게시글 작성 중 오류 발생");
		}
	}

	@Override
	public void updateBoard(Board board) {
		SqlSession session = null;
		try {
			session = MyBatis.getSqlSession();
			dao.updateBoard(session, board);
			fileDao.deleteFile(session, "" + board.getNo());

			List<FileBean> files = board.getFiles();
			if (files != null && files.size() > 0) {
				fileDao.insertFile(session, files, board.getNo());
			}

			session.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			session.rollback();
			throw new BoardException("게시글 수정 중 오류 발생");
		}
	}

	@Override
	public void deleteBoard(String no) {
		try {
			dao.deleteBoard(no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BoardException("게시글 삭제 중 오류 발생");
		}
	}

	@Override
	public Board search(String no) {
		try {
			return dao.search(no);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BoardException("게시글 조회 중 오류 발생");
		}
	}

	@Override
	public List<Board> searchAll(PageBean bean) {
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "/images/");
			bean.setPageNo(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new BoardException("게시글 목록 검색 중 오류 발생");
		}
	}
}
