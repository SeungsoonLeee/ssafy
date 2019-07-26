package chapter05;

import chapter05.Customer;

public class MainCustomer extends Customer {
	private String hoby;

	public MainCustomer() {
	}

	public MainCustomer(String name, int age, String address, String hoby) {
		// super를 통한 부모 생성자 호출
		// 생성자의 첫번째 명령에서만 호출이 가능하다.
		super(name, age, address);
		this.hoby = hoby;
	}

	public String getHoby() {
		return hoby;
	}

	public void setHoby(String hoby) {
		this.hoby = hoby;
	}

	public String toString() {
		return "MainCustomer [hoby=" + hoby + ", name=" + name + ", age=" + age + ", address=" + address + "]";
	}
	
	/**
	 * Overriding
	 * 상속받은 메서드와 기능이 동일하지만 상세 구현이 다른 경우, 새로운 메서드를 만들지 않고
	 * 메서드명과 인자, 리턴타입을 상속받은 메서드와 동일하게 선언.
	 * -> 기존의 코드를 변경하지 않고 수정된 내용을 반영한다.
	 * 
	 * 기능이 동일한 경우 부모, 자식 객체를 구분하지 않고 같은 메서드명으로 호출하고
	 * 기능이 다른 경우 overriding하여 호출한다.
	 * 
	 * - 규칙
	 *  1. 메서드 이름과 인자는 같아야 한다.
	 *  2. 리턴 타입
	 *   1.7버전 : 리턴 타입이 같아야 한다.
	 *   1.8버전 : 같은 타입이거나 sub를 리턴해야 한다.
	 *    ex) 부모 : public Customer getCustomer(){}
	 *        자식 : public Customer getCustomer(){} or public MainCustomer getCustomer(){}
	 *  3. access modifier는 같거나 보다 넓은 범위(public)으로 해야 한다.
	 *  4. 예외는 같은 예외를 던지거나 sub를 던지거나 던지지 않는다.
	 *   - super를 던지면 컴파일 에러
	 */
	public String CustomerInfo() {
//		return "이름 : " + name + "  나이 : " + age + "  주소 : " + address + "  취미 : " + hoby;
		// super. 으로 부모클래스에 접근하여 메서드를 사용할 수 있다.
		// private의 경우 집적 접근이 불가능 하기 떄문에 getter/setter를 활용한다.
		return super.CustomerInfo() + "  취미 : " + hoby;
	}
}
