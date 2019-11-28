package com.ssafy.pms.dao;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.pms.Member;

@Mapper
public interface IMemberDAO {
	public Member searchMember(String id);
}
