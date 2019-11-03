package com.ssafy.pms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.pms.Phone;

@Repository
public class PhoneDAOImpl implements IPhoneDAO {
	@Autowired
	private SqlSession session;
	private String ns = "sql.pms.";
	@Override
	public void insert(Phone phone) {
		session.insert(ns + "insert", phone);
	}

	@Override
	public Phone search(String num) {
		return session.selectOne(ns + "search", num);
	}

	@Override
	public List<Phone> searchAll() {
		return session.selectList(ns + "searchAll");
	}

	@Override
	public void delete(String num) {
		session.delete(ns + "delete", num);
	}

	@Override
	public void delete2(List<String> num) {
//		for (String n : num) {
//			session.delete(ns + "delete", n);
//		}
		session.delete(ns + "delete2", num);
	}
}
