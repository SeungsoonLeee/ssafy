package com.ssafy.pms.service;

import java.util.List;

import com.ssafy.pms.Phone;

public interface IPhoneService {

	public void insert(Phone phone);

	public Phone search(String num);

	public List<Phone> searchAll();

	public void delete(String num);
}
