package chapter03;

public class castTest {

	public static void main(String[] args) {
		// 형변환의 경우 작은 단위에서 큰단위는 암시적으로 되지만
		// 큰단위에서 작은단위로는 명시적으로 해주어야 함.
		// 단, boolean은 형변환이 불가하다.
		byte b1 = 10, b2 = 20;
		int i1 = b1 + b2; // 암시적 형변환
		byte b3 = (byte) (b1 + b2); // 명시적 형변환

		char c1 = 'a';
		int i2 = c1 + 1;
		System.out.println((char) i2); // b
		long l1 = i1; // 암시적 형변환
		float f1 = l1; // 암시적 형변환
	}

}
