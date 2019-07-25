package chapter04;

public class Main {
	public static void main(String[] args) {
		Customer c1;

		// local 변수는 초기화를 하지 않고 연산이 불가.
		// 메서드 인자, 리턴값으로 전달하면 컴파일 오류
		c1 = new Customer();
		
		// 객체는 생성 시 기본값으로 초기화
		// 정수:0,  실수:0.0,  문자:'\u0000',  논리:false,  참조:null
		System.out.println(c1.CustomerInfo());
		
		c1.name = "홍길동";
		c1.age = 29;
		c1.address = "서울특별시 강남";
		System.out.println(c1.CustomerInfo());
		
		// 지속적인 사용이 목적이 아닌 1회성으로는 생성자로 생성 후 바로 접근하여 사용한다.
		System.out.println(new Customer().CustomerInfo());

		System.out.println(new Customer("홍길동", 19, "율도국").CustomerInfo());
		
		Customer c2 = new Customer("김길동", 20, "강남");
		System.out.println(c2.equals(c1));
	}
}
