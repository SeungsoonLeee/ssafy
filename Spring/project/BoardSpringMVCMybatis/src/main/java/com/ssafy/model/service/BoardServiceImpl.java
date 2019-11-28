package com.ssafy.model.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.model.dao.BoardDao;
import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.PageUtility;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDao dao;

	public void insertBoard(Board board) {
		int no = dao.getBoardNo();
		board.setNo(no);
		List<BoardFile> files = board.getFiles();
		if (files != null && files.size() > 0) {
			dao.insertBoardFile(files, no);
		}

//		File[] realFile = null;
//		int size = 0;
//		try {
//			int no = dao.getBoardNo();
//			board.setNo(no);
//			dao.insertBoard(board);
//
//			MultipartFile[] fileups = board.getFileup();
//			size = fileups.length;
//			if (fileups != null && size > 0) {
//				List<BoardFile> files = new ArrayList<BoardFile>(size);
//				realFile = new File[size];
//				int idx = 0;
//				for (MultipartFile file : fileups) {
//					String rfileName = file.getOriginalFilename();
//					String sfileName = String.format("%d%s", System.currentTimeMillis(), rfileName);
//					String savePath = String.format("%s/resources/upload/%s", board.getDir(), sfileName);
//					files.add(new BoardFile(rfileName, sfileName));
//					realFile[idx] = new File(savePath);
//					file.transferTo(realFile[idx++]);
//				}
////				if(true) { throw new RuntimeException("file 삭제 되나요....?");}
//				dao.insertBoardFile(files, no);
//			}
//		} catch (Exception e) {
//			if (realFile != null && size > 0) {
//				for (File file : realFile) {
//					if (file.exists()) {
//						file.delete();
//					}
//				}
//			}
//			throw new BoardException("게시글 작성 중 오류 발생");
//		}
	}

	public void updateBoard(Board board) {
		dao.updateBoard(board);
		dao.deleteBoardFile(board.getNo());
		List<BoardFile> files = board.getFiles();
		if (files != null) {
			dao.insertBoardFile(files, board.getNo());
		}
	}

	public void deleteBoard(String no) {
		dao.deleteBoard(no);
		dao.deleteBoardFile(Integer.parseInt(no));
	}

	public Board search(String no) {
		return dao.search(no);
	}

	public List<Board> searchAll(PageBean bean) {
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "images/");
			bean.setPageLink(bar.getPageBar());
			return dao.searchAll(bean);
		} catch (Exception e) {
			throw new BoardException("게시물 검색 중 오류 발생");
		}
	}

	public static void main(String[] args) {
		BoardService service = new BoardServiceImpl();
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
		try {
			ArrayList<BoardFile> files = new ArrayList<BoardFile>();
			files.add(new BoardFile("c.txt", "c.txt"));
			files.add(new BoardFile("d.txt", "d.txt"));
			Board board = new Board(6, "ssafy", "수정하는 MVC", "잘 되나요?");
			board.setFiles(files);
			service.updateBoard(board);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println(service.search("6"));
		} catch (Exception e) {
		}
		try {
			System.out.println("==================게시글 목록=================");
//			List<Board> boards = service.searchAll(new PageBean("title", "h", 1));
//			List<Board> boards = service.searchAll(new PageBean("id", "ssafy", 1));
			List<Board> boards = service.searchAll(new PageBean(null, null, 1));
			for (Board board : boards) {
				System.out.println(board);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
