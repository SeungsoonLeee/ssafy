package controller;

import model.dto.Member;
import service.MemberService;
import service.MemberServiceImp;

public class Main {

	public static void main(String[] args) {
		MemberService service = new MemberServiceImp();
		try {
			service.update(new Member("gud305", "1111", "박형준"
					, "gud305@gmail.com", "010-7999-4426", "강동구 명일로 300", "당분"));
		} catch (Exception e) {
			e.printStackTrace();
		}
//		service.add(new Food(1, "하하", "하하", "하하", 200, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 1.1, 2017, "하하.img"));
//		service.login("asda", "11");
	}
}
