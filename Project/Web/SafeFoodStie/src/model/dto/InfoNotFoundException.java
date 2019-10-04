package model.dto;

public class InfoNotFoundException extends RuntimeException {

	public InfoNotFoundException() {
		super("찾으려는 정보가 없습니다");
	}

	public InfoNotFoundException(String message) {
		super(message);
	}
}
