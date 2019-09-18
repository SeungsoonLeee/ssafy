package chapter15;

import com.google.gson.Gson;

import chapter05.Customer;

public class JSONTest {
	public static void main(String[] args) {
		Customer c = new Customer("SSAFY", 2, "강남 역삼역");
		Gson gson = new Gson();

		// toJson(Object o) : 파라미터로 전달된 객체를 JSON 데이터로 변경
		String json = gson.toJson(c);
		System.out.println(json);

		Customer[] cs = { c, new Customer("홍길동", 23, "활빈당") };
		System.out.println(gson.toJson(cs));
	}
}
