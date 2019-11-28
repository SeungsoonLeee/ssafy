package com.ssafy.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.pms.Phone;
import com.ssafy.pms.PhoneException;
import com.ssafy.pms.dao.IPhoneDAO;

@Service
public class PhoneServiceImpl implements IPhoneService {
	@Autowired
	private IPhoneDAO dao;

	@Override
	public void insert(Phone phone) {
		try {
			dao.insert(phone);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("폰 입력 중 오류 발생");
		}
	}

	@Override
	public Phone search(String num) {
		try {
			return dao.search(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("폰 조회 중 오류 발생");
		}
	}

	@Override
	public List<Phone> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("폰 전체 조회 중 오류 발생");
		}
	}

	@Override
	public void delete(String num) {
		try {
			dao.delete(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("폰 입력 중 오류 발생");
		}
	}
	
	public void delete2(List<String> num) {
		try {
			dao.delete2(num);
		} catch (Exception e) {
			e.printStackTrace();
			throw new PhoneException("여러폰 삭제 중 오류 발생");
		}
	}
}
