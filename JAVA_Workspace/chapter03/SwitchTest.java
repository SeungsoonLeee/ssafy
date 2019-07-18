package chapter03;

import java.util.Scanner;

public class SwitchTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력: ");

		int score = sc.nextInt();
		int s = score / 10;
		if (score < 0 || score > 100) {
			System.out.println("0~100 사이로 입력 하세요.");
		} else {
			System.out.printf("%d점은 ", score);
			switch (s) {
			case 10:
			case 9:
				System.out.println("A입니다.");
				break;
			case 8:
				System.out.println("B입니다.");
				break;
			case 7:
				System.out.println("C입니다.");
				break;
			case 6:
				System.out.println("D입니다.");
				break;
			default:
				System.out.println("F입니다.");
				break;
			}
		}

	}
}
