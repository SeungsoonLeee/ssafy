package chapter03;

public class DataTypeTest {
	public static void main(String[] args) {
		// 정수의 기본형은 int
		// byte와 short는 연산시 int로 자동 형변환.
		byte b1 = 1, b2 = 2;
		//byte b3 = b1 + b2; // int로 형변환되어 byte에 넣을 수 없다.

		
		// long의 경우 int범위를 벗어난 정수 숫자는 long 타입임을 명시해야 함.
		long l = 2222222222l; //or 2222222222L; 
		
		
		// 실수의 기본형은 double
		float f1 = 3.14f; //or 3.14F;
		double d1 = 3.14;
	}
}
