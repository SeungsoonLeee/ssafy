package com.ssafy.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.Member;

@Repository
public class memberDAOImpl{
	@Autowired
	private SqlSession session;
	private String ns = "sql.pms.";
	
	public Member searchMember(String id) {
		return session.selectOne(ns + "searchMember", id);
	}
}
