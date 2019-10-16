package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.FileBean;

public class FileDaoImp implements FileDao {
	public void insertFile(SqlSession session, List<FileBean> files, int bno) {
		for (FileBean fileBean : files) {
			fileBean.setBno(bno);
			session.insert("board.insertFile", fileBean);
		}
	}

	public void deleteFile(SqlSession session, String bno) {
		session.delete("board.deleteFile", bno);
	}

}
