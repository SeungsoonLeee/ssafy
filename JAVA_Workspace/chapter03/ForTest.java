package chapter03;

import java.util.Scanner;

public class ForTest {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += 1;
		}
		System.out.println(sum);
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.print("라인 수를 입력하세요 : ");
		int line = sc.nextInt();
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();

		for (int i = line; i > 0; i--) {
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
	}
}
