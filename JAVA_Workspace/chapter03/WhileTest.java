package chapter03;

import java.util.Scanner;

public class WhileTest {
	public static void main(String[] args) {
		int sum = 0, cnt = 0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);

		while (true) {
			int num = sc.nextInt();
			sum += num;
			cnt++;
			if (num >= 100)
				break;
		}

		avg = (double) sum / (double) cnt;
		System.out.printf("%d\n%.1f", sum, avg);
	}
}
