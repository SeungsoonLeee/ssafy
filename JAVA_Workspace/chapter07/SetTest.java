package chapter07;

import java.util.HashSet;

import chapter05.Employee;

public class SetTest {
	public static void main(String[] args) {
		/**
		 * add(Object obj), contains(Object obj), remove(Object obj)
		 * 중복확인을 위해 equals(Object obj)와 hashCode()를 호출한다.
		 * equals와 hashcode를 상황에 맞게 오버라이디하여 사용해야 한다.
		 */
		HashSet<Object> hs = new HashSet<Object>();
		System.out.println(hs.add("hello"));
		System.out.println(hs.add("hello"));
		System.out.println(hs.add(123));
		System.out.println(hs.add(3.14));
		System.out.println(hs.add(new Employee("1", "ssafy", 20)));
		System.out.println(hs.add(new Employee("1", "ssafy", 20))); //hashcode가 다르기 때문에 다른 객체로 생각하여 저장이 됨.
		// hashcode를 상황에 맞게 override하면 저장되지 않는다.
		System.out.println(hs);
	}
}
