package service;

import java.sql.SQLException;

import model.dao.MemberMgrImpl;
import model.dto.DuplicateException;
import model.dto.Food;
import model.dto.InfoNotFoundException;
import model.dto.Member;
import model.dto.MemberException;

public class MemberServiceImp implements MemberService {
	private MemberMgrImpl dao = MemberMgrImpl.getInstance();
	public String getAllergyIngredients(Food food, String allergies) {
		return dao.getAllergyIngredients(food, allergies);
	}
	public Member search(String id) throws Exception {
		try {
			Member member = dao.search(id);
			if(member == null) {
				throw new InfoNotFoundException();
			} else {
				return member;
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}


	public boolean login(String id, String pw) throws Exception {
		try {
			Member member = dao.search(id);
			if(member == null) {
				throw new InfoNotFoundException();
			}else {
				if(pw.equals(member.getPassword())) {
					return true;
				}else {
					throw new MemberException("비밀 번호 오류");
				}
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public boolean checkID(String id) throws Exception {
		try {
			Member member = dao.search(id);
			if(member == null) {
				return false;
			}else {
				return true;
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}
	public void add(Member member) throws Exception {
		try {
			Member find = dao.search(member.getId());
			if(find != null) {
				throw new DuplicateException();
			}else {
				dao.add(member);
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}
	public void update(Member member) throws Exception {
		try {
			Member find = dao.search(member.getId());
			if(find == null) {
				throw new MemberException("수정할 회원 정보가 없습니다.");
			}else {
				dao.update(member);
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}

	public void remove(String id) throws Exception {
		try {
			Member find = dao.search(id);
			if(find == null) {
				throw new MemberException("탈퇴할 회원 정보가 없습니다.");
			}else {
				dao.remove(id);
			}
		} catch (SQLException e) {
			throw new SQLException();
		}
	}





}
