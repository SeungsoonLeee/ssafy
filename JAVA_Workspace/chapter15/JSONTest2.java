package chapter15;

import com.google.gson.Gson;

import chapter05.Customer;

public class JSONTest2 {
	public static void main(String[] args) {
		String JsonData = "{\"name\":\"SSAFY\",\"age\":2,\"address\":\"강남 역삼역\"}";
		Gson gson = new Gson();
		Customer c = gson.fromJson(JsonData, Customer.class);
		System.out.println(c);

		String JsonData2 = "[{\"name\":\"SSAFY\",\"age\":2,\"address\":\"강남 역삼역\"},{\"name\":\"홍길동\",\"age\":23,\"address\":\"활빈당\"}]";
		Customer[] cs;
		cs = gson.fromJson(JsonData2, Customer[].class);
		for (Customer customer : cs) {
			System.out.println(customer);
		}
	}
}
