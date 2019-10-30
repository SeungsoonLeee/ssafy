package com.ssafy.model.dto;

public class MemberException extends RuntimeException {
	public MemberException() {
		super("사원 정보 처리 중 오류 발생");
	}
	public MemberException(String msg) {
		super(msg);
	}
}
