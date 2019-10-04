package service;

import java.sql.SQLException;

import model.dao.MemberMgrImpl;
import model.dto.DuplicateException;
import model.dto.InfoNotFoundException;
import model.dto.Member;
import model.dto.MemberException;

public interface MemberService  {
	public Member search(String id) throws Exception;
	public void add(Member member) throws Exception;
	public void update(Member member) throws Exception;
	public void remove(String id) throws Exception;
	

}
