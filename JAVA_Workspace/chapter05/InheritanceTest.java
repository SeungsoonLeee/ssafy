package chapter05;

import chapter04.Customer;

public class InheritanceTest {
	public static void main(String[] args) {
		Customer c = new Customer("가나다", 19 ,"강남역");
		MainCustomer mc = new MainCustomer("홍길동", 29, "역삼역", "코딩");
		
		System.out.println(c.CustomerInfo());
		System.out.println(mc.CustomerInfo());
	}
}
