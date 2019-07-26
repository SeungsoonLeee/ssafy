package chapter05;

public class PolymorphismTest {
	public static void main(String[] args) {
		/**
		 *  Reference Polymorphism
		 *   - super 타입의 변수로 sub 타입의 객체를 찹조할 수 있다.
		 *   
		 *  Shadow Impact
		 *   - 다형성 관계에서 sub에 추가된 속성이나 메서드에 접근 불가.
		 *    -> 형변환을 해주어야 한다.
		 *    
		 *  Reference Type 형변환
		 *   암시적 형변환(=자동 형변환, up-casting) : sub에서 super로 형변환 될 때 자동으로 형변환이 이루어짐.
		 *   명시적 형변환(down-casting) : super에서 sub로 형변환 될 때 형변환을 명시해주어야 함.
		 */
		
		Employee emp1 = new Employee();
		// super = new sub;
		emp1 = new Manager(); // 다형성
		emp1 = new Engineer(); // 다형성
		// Engineer eng1 = new Employee(); // 다형성X, 에러남
		// Engineer eng1 = new Manager(); // 다형성X, 에러남

		// System.out.println(emp1.getSkill()); // Shadow Impact로 접근 불가
		
		Manager mng1 = new Manager();
		Employee emp2 = mng1; // 자동 형변환

		Engineer eng1 = new Engineer();
		emp2 = eng1; // 자동 형변환

		Engineer eng2 = (Engineer) emp2; // 자동 형변환이 이루어지지 않고 명시적으로 해주어야 함.
		System.out.println(eng2.getSkill());
		
		// Manager mng2 = (Manager) emp2; // 컴파일 에러는 아니지만 ClassCastError가 발생함. down cast가 아님.
		
		
		/**
		 * Reference Type의 형검사
		 *  - Intanceof : 객체가 해당 클래스 타입이면 true, 아니면 false
		 *  - 객체 Instanceof 클래스타입
		 *  - 주의 : super 타입으로 형검사를 하게 되면 sub는 super를 상속받은 것이기 떄문에 무조건 true를 반환한다.
		 */
		
		if (mng1 instanceof Manager) {
			Manager mng = (Manager) mng1;
			System.out.println("mng1는 Manager입니다.");
		} else if (emp2 instanceof Engineer) {
			Engineer eng = (Engineer) emp2;
			System.out.println("emp2는 Engineer입니다.");
		}
		
		
		/**
		 * Virtual Invocation(=Dynamic Binding = Dynamic Linking)
		 *  다형성 관계에서 메서드가 Overriding되었다면 Override된 메서드가 호출됨.
		 */
	}
}
