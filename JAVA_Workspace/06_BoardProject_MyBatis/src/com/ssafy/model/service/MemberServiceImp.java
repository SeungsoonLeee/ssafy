package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dao.MemberDao;
import com.ssafy.model.dao.MemberDaoImp;
import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.MemberException;
import com.ssafy.model.dto.PageBean;
import com.ssafy.util.PageUtility;

public class MemberServiceImp implements MemberService {
	private MemberDao dao = new MemberDaoImp();

	@Override
	public Member search(String id) {
		try {
			return dao.search(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("회원 정보 검색 중 오류 발생");
		}
	}

	@Override
	public List<Member> searchAll(PageBean bean) {
		try {
			int total = dao.count(bean);
			PageUtility bar = new PageUtility(bean.getInterval(), total, bean.getPageNo(), "/images/");
			bean.setPageLink(bar.getPageBar());
			return dao.searchAll(bean);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("회원 정보 검색 중 오류 발생");
		}
	}

	public boolean login(String id, String pw) {
		try {
			Member member = dao.search(id);
			if (member == null)
				throw new MemberException("등록되지 않은 아이디입니다.");
			if (!pw.equals(member.getPassword()))
				throw new MemberException("비밀번호 오류");

			return true;
		} catch (Exception e) {
			// TODO: handle exception
			if (e instanceof MemberException) {
				throw e;
			} else {
				throw new MemberException("로그인 처리 중 오류 발생");
			}
		}
	}

	public boolean checkID(String id) {
		try {
			Member member = dao.search(id);
			if (member == null)
				return false;
			else
				return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("아이디 검사 중 오류 발생");
		}
	}

	public void update(Member member) {
		try {
			dao.updateMember(member);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("회원정보 수정 중 오류 발생");
		}
	}

	public void remove(String id) {
		try {
			dao.deleteMember(id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("회원정보 삭제 중 오류 발생");
		}
	}

	public void add(Member member) {
		try {
			dao.insertMember(member);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			throw new MemberException("회원정보 등록 중 오류 발생");
		}
	}
}
