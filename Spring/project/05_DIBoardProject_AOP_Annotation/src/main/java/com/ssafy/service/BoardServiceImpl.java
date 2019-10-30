package com.ssafy.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dao.BoardDaoImpl;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;
import com.ssafy.util.PageUtility;

@Component
public class BoardServiceImpl implements BoardService {
	@Qualifier("boardDao")
	@Autowired
	BoardDao dao;

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

	public void insertBoard(Board board) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false); // 트랜잭션 처리를 위해 자동 커밋이 안된게 설정한다.
			int no = dao.getBoardNo(con);
			board.setNo(no);
			dao.insertBoard(con, board);
			List<BoardFile> files = board.getFiles();
			if (files != null) {
				dao.insertBoardFile(con, files, no);
			}
			con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	public void updateBoard(Board board) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			dao.updateBoard(con, board);
			List<BoardFile> files = board.getFiles();
			if (files != null) {
				dao.deleteBoardFile(con, board.getNo());
				dao.insertBoardFile(con, files, board.getNo());
			}
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	public void deleteBoard(String no) {
		Connection con = null;
		try {
			con = DBUtil.getConnection();
			con.setAutoCommit(false);
			dao.deleteBoard(con, no);
			dao.deleteBoardFile(con, Integer.parseInt(no));
			con.commit();
		} catch (SQLException e) {
			DBUtil.rollback(con);
		} finally {
			DBUtil.close(con);
		}
	}

	public Board search(String no) {
		try {
			return dao.search(no);
		} catch (SQLException e) {
			throw new BoardException("게시물 검색 중 오류 발생");
		}
	}

	public List<Board> searchAll(PageBean bean) {
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPagelink(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new BoardException("게시물 검색 중 오류 발생");
		}
	}

	public static void main(String[] args) {
//		BoardService service = new BoardServiceImpl();
//		try {
//			ArrayList<BoardFile>  files = new ArrayList<>();
//			files.add(new BoardFile("a.txt", "a.txt"));
//			files.add(new BoardFile("b.txt", "b.txt"));
//			Board board = new Board("ssafy", "처음하는 MVC", "잘 되나요?");
//			board.setFiles(files);
//			service.insertBoard(board);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		try {
//			service.deleteBoard("5");
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			ArrayList<BoardFile>  files = new ArrayList<BoardFile>();
//			files.add(new BoardFile("c.txt", "c.txt"));
//			files.add(new BoardFile("d.txt", "d.txt"));
//			Board board = new Board(6, "ssafy", "수정하는 MVC", "잘 되나요?");
//			board.setFiles(files);
//			service.updateBoard(board);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		try {
//			System.out.println(service.search("6"));
//		} catch (Exception e) {
//		}
//		try {
//			System.out.println("==================게시글 목록=================");
////			List<Board> boards = service.searchAll(new PageBean("title", "h", 1));
////			List<Board> boards = service.searchAll(new PageBean("id", "ssafy", 1));
//			List<Board> boards = service.searchAll(new PageBean(null, null, 1));
//			for (Board board : boards) {
//				System.out.println(board);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
