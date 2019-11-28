package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.BoardFile;
import com.ssafy.model.dto.PageBean;

@Mapper
public interface BoardDao {
	public int  getBoardNo();
	public void insertBoard(Board board);
	public void insertBoardFile(List<BoardFile> files, int bno);
	public Board search(String no);
	public List<Board> searchAll(PageBean bean);
	public int  count(PageBean bean);
	public void updateBoard(Board board);
	public void deleteBoard(String no) ;
	public void deleteBoardFile(int bno);
}













