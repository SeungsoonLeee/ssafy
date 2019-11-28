package com.ssafy.model.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.ssafy.model.dao.FAQDao;
import com.ssafy.model.dto.FAQ;
import com.ssafy.model.dto.FAQException;

@Service
public class FAQServiceImpl implements FAQService {
	@Autowired
	FAQDao dao;

	public void insert(FAQ faq) {
		try {
			dao.insert(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 입력 중 오류 발생");
		}
	}

	public void update(FAQ faq) {
		try {
			dao.update(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 수정 중 오류 발생");
		}
	}

	public void reply(FAQ faq) {
		try {
			dao.reply(faq);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 답변 처리 중 오류 발생");
		}
	}

	public void delete(String no) {
		try {
			dao.delete(no);
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 삭제 중 오류 발생");
		}
	}

	public FAQ search(String no) {
		try {
			FAQ faq = dao.search(no);
			if (faq != null) {
				return faq;				
			}
			return null;
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 검색 중 오류 발생");
		}
	}

	public List<FAQ> searchAll() {
		try {
			return dao.searchAll();
		} catch (Exception e) {
			e.printStackTrace();
			throw new FAQException("FAQ 목록 조회 중 오류 발생");
		}
	}

}
