package com.ssafy.model.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public interface MemberDao {
	public Member search(String id);

	public List<Member> searchAll(PageBean bean);

	public void insertMember( Member member);

	public void updateMember(Member member);

	public void deleteMember( String id);
	
	public int count(PageBean nean);
}
