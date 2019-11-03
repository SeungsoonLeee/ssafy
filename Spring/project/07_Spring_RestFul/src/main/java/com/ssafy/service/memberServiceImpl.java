package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.memberDAOImpl;
import com.ssafy.pms.Member;
import com.ssafy.pms.PhoneException;

@Service
public class memberServiceImpl {
	@Autowired
	private memberDAOImpl dao;

	public boolean login(String id, String pw) {
		try {
			Member m = dao.searchMember(id);
			if (m == null) {
				throw new PhoneException("등록된 아이디가 없습니다.");
			}
			if (pw == null || !pw.equals(m.getPw())) {
				throw new PhoneException("비밀 번호 오류");
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			if (e instanceof PhoneException) {
				throw e;
			}
			throw new PhoneException("로그인 중 오류 발생");
		}
	}
}
