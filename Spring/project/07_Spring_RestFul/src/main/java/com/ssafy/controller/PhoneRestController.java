package com.ssafy.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.pms.Phone;
import com.ssafy.service.PhoneServiceImpl;

/**
 * @RestController : REST Ful 서비스를 위한 컨트롤러로 @ResponseBody 어노테이션을 쓰지 않아도 쓴 효과를 냄
 */
@RestController
public class PhoneRestController {
	@Autowired
	private PhoneServiceImpl service;

	@ExceptionHandler
	public ResponseEntity<Map<String, Object>> handleException(Exception e) {
		return handleFail(e.getMessage(), HttpStatus.OK);
	}

	@GetMapping("/phone")
	public ResponseEntity<Map<String, Object>> phones() {
		List<Phone> list = service.searchAll();
		return handleSuccess(list);
	}

	public ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "ok");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	public ResponseEntity<Map<String, Object>> handleFail(Object data, HttpStatus state) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("state", "fail");
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, state);
	}
}
