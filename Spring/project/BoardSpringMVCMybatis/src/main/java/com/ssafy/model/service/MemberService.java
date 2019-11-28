package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public interface MemberService {
	public boolean login(String id, String pw);
	public boolean idCheck(String id);	
	public Member search(String id);
	public List<Member> searchAll(PageBean bean);
	public void insertMember(Member member);
	public void updateMember(Member member);
	public void deleteMember(String id);
}
