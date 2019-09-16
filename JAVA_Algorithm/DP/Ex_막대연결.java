package com.ssafy.dp;

import java.util.Scanner;

public class Ex_막대연결 {
	public static void main(String[] args) {
		// 1파 1노 2빨
		// 이 막대들을 연결하여 길이가 Ncm인 막대를 만드는 방법의 수를 f(n)
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N + 1];
		D[0] = 1;
		D[1] = 2;

		for (int i = 2; i <= N; i++) {
			D[i] = D[i - 1] * 2 + D[i - 2];
		}
		System.out.println(D[N]);

	}
}
