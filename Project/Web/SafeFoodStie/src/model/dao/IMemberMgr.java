package model.dao;

import java.util.List;

import model.dto.DuplicateException;
import model.dto.InfoNotFoundException;
import model.dto.Member;



public interface IMemberMgr {
	public void add(Member member) throws Exception;
	public Member search(String id) throws Exception;
}
