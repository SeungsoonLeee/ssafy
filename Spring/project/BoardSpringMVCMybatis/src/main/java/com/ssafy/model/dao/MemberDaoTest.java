package com.ssafy.model.dao;

import java.util.List;

import com.ssafy.model.dto.Member;
import com.ssafy.model.dto.PageBean;

public class MemberDaoTest {
	public static void main(String[] args) {
		MemberDao dao = new MemberDaoImpl();
		try {
			List<Member> list = dao.searchAll(new PageBean());
			for (Member member : list) {
				System.out.println(member);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
