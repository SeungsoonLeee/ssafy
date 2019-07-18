package chapter03;

import java.util.Scanner;

public class IfTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력: ");

		int score = sc.nextInt();
		if (score < 0 || score > 100) {
			System.out.println("0~100 사이로 입력 하세요.");
		} else {
			System.out.printf("%d점은 ", score);
			if (score >= 90) {
				System.out.println("A입니다.");
			} else if (score >= 80) {
				System.out.println("B입니다.");
			} else {
				System.out.println("C입니다.");
			}
		}
	}
}
