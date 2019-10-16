package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public interface MemberService {
	public Member search(String id);
	public List<Member> searchAll(PageBean bean);
	public boolean login(String id, String pw);
	public boolean checkID(String id);
	public void add(Member member);
	public void update(Member member);
	public void remove(String id);
}
