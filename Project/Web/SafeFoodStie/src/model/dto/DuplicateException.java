package model.dto;

public class DuplicateException extends RuntimeException {
	public DuplicateException() {
		super("이미 존재하는 정보입니다");
	}
	public DuplicateException(String msg) {
		super(msg);
	}
}
