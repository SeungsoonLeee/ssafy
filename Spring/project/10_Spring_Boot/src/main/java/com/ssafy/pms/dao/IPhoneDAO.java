package com.ssafy.pms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.pms.Phone;

@Mapper // query.xml을 자동 매핑
public interface IPhoneDAO {

	public void insert(Phone phone);

	public Phone search(String num);

	public List<Phone> searchAll();

	public void delete(String num);
	
	public void delete2(List<String> num);
}
