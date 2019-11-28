package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.PageBean;

public interface BoardService {
	public void insertBoard(Board board);
	public void updateBoard(Board board);
	public void deleteBoard(String no);
	public Board search(String no);
	public List<Board> searchAll(PageBean bean);
}
