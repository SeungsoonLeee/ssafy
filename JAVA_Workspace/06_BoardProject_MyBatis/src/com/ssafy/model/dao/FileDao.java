package com.ssafy.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ssafy.model.dto.FileBean;

public interface FileDao {
	public void insertFile(SqlSession session, List<FileBean> files, int bno);
	public void deleteFile(SqlSession session, String bno);
}
