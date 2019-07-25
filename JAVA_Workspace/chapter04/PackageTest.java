package chapter04;

public class PackageTest {
	public static void main(String[] args) {
		// 같은 package 내의 클래스는 클래스명으로만 참조가 가능.
		Customer c = new Customer();
		
		// 다른 package의 클래스는
		// 1. package명.클래스명 또는
		// 2. 가장 상단에 import문으로 클래스 등록후 클래스명
		//   import package명.클래스명;
		//   import package명.*;
		// 으로 접근해야 한다.
		chapter03.DataTypeTest.main(null);
		
	}
}
