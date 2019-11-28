package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.DBUtil;

public class MemberDaoImpl implements MemberDao {
	public void insertMember(Member member){
		
	}
	public void updateMember(Member member){
		
	}
	public void deleteMember(String id){
	}
	public Member search(String id){
		return null;
	}
	public List<Member> searchAll(PageBean bean){
		return null;
	}
	/** 
	 * 검색 조건에 따른 게시글의 개수   ==> 페이징 처리 
	 * */
	public int getCount(PageBean bean) {
		return 0;
	}
}













