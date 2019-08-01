package chapter05;

public class StringTest {
	public static void main(String[] args) {
		// String은 유일하게 new 생성자() 없이 객체를 사용할 수 있다.
		// String은 유일하게 + 연산을 이용하여 문자열을 연결할 수 있다.
		//  new 생성자() : 매번 heap에 객체가 생성된다.
		//  new 생성자()를 사용하지 않는 경우 : 
		//   -> Constance Pool에 존재하면 해당 객체의 참조값만 전달 받고 존재하지 않으면 새로 생성.
		
		String str1 = "hello";
		String str2 = "hello";
		String str3 = new String("hello");
		String str4 = new String("hello");
		
		System.out.println(str1 == str2); // constance pool에 같은 문자열이 있기 떄문에 참조값을 전달받았기 때문에 true
		System.out.println(str1 == str3); // new는 무조건 새로 객체를 생성하기 때문에 hashcode값이 달라 false
		System.out.println(str3 == str4);
		
		str1 += " world!";
		System.out.println(str1);

		// 아래 두 객체는 동일한 기능을 하나 Buffer는 suncronized가 되어 있고 builder는 그렇지 않다.
		StringBuffer sbf;
		StringBuilder sbd;
		
		/**
		 *  public String[] split(구분자)
		 *  문자를 구분자를 기준으로 subString하는 기능
		 */
		String[] tokens = str1.split(" ");
		for (String s : tokens) {
			System.out.println(s);
		}
		
		/**
		 *  format(String format, Object ...)
		 *  
		 */
		System.out.println(String.format("오늘은 %d일", 31));
		
	}
}
