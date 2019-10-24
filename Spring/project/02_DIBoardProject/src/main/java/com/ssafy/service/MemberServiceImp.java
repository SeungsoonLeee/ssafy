package com.ssafy.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.model.dao.MemberDAO;
import com.ssafy.model.dao.MemberDAOImp;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.MemberException;

public class MemberServiceImp implements MemberService {
	private MemberDAO dao;

	public MemberServiceImp() {
	}

	public MemberServiceImp(MemberDAO dao) {
		this.dao = dao;
	}

	public MemberDAO getDao() {
		return dao;
	}

	public void setDao(MemberDAO dao) {
		this.dao = dao;
	}

	public Member search(String id) {
		try {
			Member member = dao.search(id);
			if (member == null) {
				throw new MemberException("등록되지 않은 아이디입니다.");
			} else {
				return member;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException();
		}
	}

	public List<Member> searchAll() {
		try {
			return dao.searchAll();
		} catch (SQLException e) {
			throw new MemberException();
		}
	}

	public boolean login(String id, String pw) {
		try {
			Member member = dao.search(id);
			if (member == null) {
				throw new MemberException("등록되지 않은 회원 아이디입니다.");
			} else {
				if (pw.equals(member.getPassword())) {
					return true;
				} else {
					throw new MemberException("비밀 번호 오류");
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new MemberException();
		}
	}

	public boolean checkID(String id) {
		try {
			Member member = dao.search(id);
			if (member == null) {
				return false;
			} else {
				return true;
			}
		} catch (SQLException e) {
			throw new MemberException();
		}
	}

	public void add(Member member) {
		try {
			Member find = dao.search(member.getId());
			if (find != null) {
				throw new MemberException("이미 등록된 아이디입니다.");
			} else {
				dao.add(member);
			}
		} catch (SQLException e) {
			throw new MemberException();
		}
	}

	public void update(Member member) {
		try {
			Member find = dao.search(member.getId());
			if (find == null) {
				throw new MemberException("수정할 회원 정보가 없습니다.");
			} else {
				dao.update(member);
			}
		} catch (SQLException e) {
			throw new MemberException();
		}
	}

	public void remove(String id) {
		try {
			Member find = dao.search(id);
			if (find == null) {
				throw new MemberException("탈퇴할 회원 정보가 없습니다.");
			} else {
				dao.remove(id);
			}
		} catch (SQLException e) {
			throw new MemberException();
		}
	}

}
