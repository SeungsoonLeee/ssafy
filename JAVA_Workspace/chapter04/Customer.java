package chapter04;

public class Customer {
	String name;
	int age;
	String address;
	/**
	 * 생성자
	 * - 객체 생성시 new에 의해 호출
	 * - 객체의 초기화를 담담
	 * - 생성자를 정의하지 않았다면 컴파일러가 인자가 없고 내용이 없는 생성자를 컴파일 시 자동 추가
	 * - 생서자가 정의되어 있다면 컴파일러는 default constructor(생성자)를 추가하지 않음.
	 */
	public Customer() {
	}

	// constructor overloading
	// 인자가 다른 생성자를 정의하면 인자에 맞는 생성자를 overloading 하여 클래스 생성
	public Customer(String name, int age, String address) {
		super();
		// this : this를 사용한 클래스로부터 생성된 객체 중 현재 사용중인 객체를 참조
		//  1. 로컬변수와 속성명이 같을 때 구별을 위해 속성명 앞에 this.를 붙임
		//  2. 인자가 다른 생성자를 호출. 단, 생성자 호출은 생성자의 첫번째 명령에서만 가능.
		//   this(~);
		//  3. 클래스 내에서 해당 클래스 객체가 필요할 때(이벤트 처리)
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	// this의 3번 유형
	public boolean equals(Customer c) {
		return this == c;
	}

	public String CustomerInfo() {
		return "이름 : " + name + "  나이 : " + age + "  주소 : " + address;
	}
}
