package chapter03;

public class LabelTest {
	public static void main(String[] args) {
		// label : 반복문에 label을 주고 중첩된 반복문으로부터 label이 달린 반복문을 제어 가능하게 함.
		first: for (int i = 1; i <= 100; i++) {
			second: for (int j = 1; j <= 100; j++) {
				System.out.printf("%d * %d = %d\n", i, j, i * j);
				if (i * j > 50)
					break first;
				else if (i * j > 30) {
					break;
				}
			}
		}
	}
}
