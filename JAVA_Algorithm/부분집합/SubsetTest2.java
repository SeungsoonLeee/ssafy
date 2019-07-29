package com.ssafy.step1.subset;

import java.util.Scanner;

public class SubsetTest2 {
	static int N;
	static boolean[] selected;

	public static void main(String[] args) {
		// 1,2,3으로 만들수 있는 모든 부분집합을 구하라 by 재귀
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 숫자의 갯수를 입력
		selected = new boolean[N + 1];

		subset(1);
	}

	public static void subset(int n) {
		if (n > N) {
			for (int i = 1; i <= N; ++i) {
				System.out.print((selected[i] ? i : "x") + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < 2; i++) {
				selected[n] = i % 2 == 0 ? true : false;
				subset(n + 1);
			}
		}
	}
}
