package com.ssafy.model.dao;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dto.Member;

public interface MemberDAO {
	public Member search( String id) throws SQLException;
	public List<Member> searchAll( ) throws SQLException;
	public void add(Member member)	 throws SQLException;
	public void update(Member member)throws SQLException;
	public void remove(String id)    throws SQLException;
}












