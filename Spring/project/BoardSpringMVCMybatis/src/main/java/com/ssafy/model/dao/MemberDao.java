package com.ssafy.model.dao;

import java.util.List;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
public interface MemberDao {
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String id);
	public Member search(String id);
	public List<Member> searchAll(PageBean bean);
	public int  getCount(PageBean bean);
}














