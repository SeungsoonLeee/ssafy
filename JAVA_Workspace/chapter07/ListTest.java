package chapter07;

import java.util.ArrayList;
import java.util.LinkedList;
import chapter05.Employee;


public class ListTest {
	public static void main(String[] args) {
//		ArrayList<Integer> al = new ArrayList<Integer>();
//		LinkedList<Integer> ll = new LinkedList<Integer>();

		ArrayList al = new ArrayList();
		al.add("hello");
		al.add("hello");
		al.add(123);
		al.add(3.14);
		al.add(new Employee("1", "ssafy", 20));
		System.out.println(al);

		LinkedList ll = new LinkedList();
		ll.add("hello");
		ll.add("hello");
		ll.add(123);
		ll.add(3.14);
		ll.add(new Employee("1", "ssafy", 20));
		System.out.println(ll);
		System.out.println(ll.get(3));

		/**
		 * indexOf(Object obj), lastIndexOf(Object obj), contains(Object obj), remove(Object obj)
		 * 함수들은 해당 기능을 수행하기 위해 equals(Object obj)를 호출해서 객체를 비교한다.
		 * 그러므로 해당 메서드를 제대로 사용하기 위해서는 equals 메서드를 상황에 맞게 오버라이딩 하여 구현해야 한다.
		 */
		System.out.println(ll.indexOf(123));
		
		
		/**
		 *  java 5부터 Collection에 Generic 적용. 생성 시에 다형성은 않됨. 하고나서 저장은 됨.
		 *   생성할 때 지정한 type으로 데이터 저장.
		 */
		ArrayList<Employee> al2 = new ArrayList<Employee>();
		LinkedList<Employee> ll2 = new LinkedList<Employee>();
		al2.add(new Employee("1", "ssafy", 10));
		// al2.add("123"); // 지정한 타입 외에 다른 형을 넣으면 에러 발생.
		al2.add(new Employee("2", "ssafy", 20));
		al2.add(new Employee("3", "ssafy", 30));
		System.out.println(al2);
		Employee emp = al2.get(0);
		System.out.println(emp);
	}
}
