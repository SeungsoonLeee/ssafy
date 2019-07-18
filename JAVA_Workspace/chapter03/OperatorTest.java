package chapter03;

public class OperatorTest {
	public static void main(String[] args) {
		// >> : 우측으로 bit 이동(2의 n승을 나눈 효과, 이동한 곳에는 sign bit가 채워짐)
		// ex) 8 >> 2 -> 2
		int n1 = 8;
		int n2 = -8;
		System.out.printf("%d %d", n1 >> 2, n2 >> 2); // 2 -2
		System.out.println();

		// << : 좌측으로 bit 이동(2의 n승을 곱한 효과, 이동한 곳에는 0이 채워짐)
		// ex) 1 << 2 -> 4
		System.out.printf("%d %d", n1 << 2, n2 << 2); // 2 -2
		System.out.println();

		// >>> : 우측으로 bit 이동, 빈자리를 0으로 채우므로 음수의 경우 양수로 바뀜
		System.out.printf("%d %d", 8 >>> 2, -8 >>> 2); // 2 -2
		System.out.println();

		// 논리 연산
		// 앞의 조건이 false이기 때문에 이미 false로 확정, 뒤 조건은 수행하지 않고 넘어감.
		boolean result = n1++ > 8 && n2++ > -8;
		System.out.printf("result:%b   n1:%d   n2:%d", result, n1, n2);
		System.out.println();
		// &로 하게되면 뒤에 조건도 본다.
		n1 = 8;
		n2 = -8;
		boolean result2 = n1++ > 8 & n2++ > -8;
		System.out.printf("result2:%b   n1:%d   n2:%d", result2, n1, n2);
	}
}
