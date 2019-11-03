package com.ssafy.pms.dao;

import java.util.List;

import com.ssafy.pms.Phone;

public interface IPhoneDAO {

	public void insert(Phone phone);

	public Phone search(String num);

	public List<Phone> searchAll();

	public void delete(String num);
	
	public void delete2(List<String> num);
}
