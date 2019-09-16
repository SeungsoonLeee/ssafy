package com.ssafy.dp;

import java.util.Scanner;

public class Ex_아파트칠하기_Fibonachi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] D = new int[N + 1];
		D[0] = 1;
		D[1] = 2;
		// D[i][0] : i층을 노란색으로 색칠할 수 있는 경우의 수(i-1층의 노란색 경우의 수 + i-1층의 파란색 경우의 수)
		// D[i][0] = D[i-1][0] + D[i-1][1];

		// D[i][1] : i층을 파란색으로 색칠할 수 있는 경우의 수(i-1층의 노란색 경우의 수)
		// D[i-1][0];

		for (int i = 2; i <= N; i++) {
			D[i] = D[i - 2] + D[i - 1];
		}
		System.out.println(D[N]);
	}
}
