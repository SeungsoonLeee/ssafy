package com.ssafy.model.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImpl;
import com.ssafy.model.dto.BoardException;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.PageUtility;

public class MemberServiceImpl implements MemberService {
	private MemberDao dao = new MemberDaoImpl();
	public boolean login(String id, String pw) {
		return false;
	}
	public boolean idCheck(String id) {
		return false;
	}
	public Member search(String id) {
		return null;
	}
	public List<Member> searchAll(PageBean bean) {
		return null;
	}
	public void insertMember(Member member) {
	}
	public void updateMember(Member member) {
	}
	public void deleteMember(String id) {
	}
}
