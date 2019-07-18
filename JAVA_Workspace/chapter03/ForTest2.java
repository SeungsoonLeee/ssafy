package chapter03;

import java.util.Scanner;

public class ForTest2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("진열할 총 상품수를 입력 : ");
		int total = sc.nextInt();
		System.out.print("한 라인에 진열할 상품 수 입력 : ");
		int num = sc.nextInt();

		for (int i = 0; i < total;) {
			for (int j = 0; j < num; j++) {
				System.out.print("♥ ");
				i++;
				if (i >= total)
					break;
			}
			System.out.println();
		}
		System.out.println();

		
		for (int i = 1; i <= total; ++i) {
			System.out.print("* ");
			if (i % num == 0)
				System.out.println();
		}
	}
}
