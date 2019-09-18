package chapter15;

import java.util.List;

import chapter05.Customer;

public class CustomerTest {
	public static void main(String[] args) {
		List<Customer> cs = CustomerSAXParser.parse("res/CustomerList.xml");
		for (Customer customer : cs) {
			System.out.println(customer);
		}
	}
}
