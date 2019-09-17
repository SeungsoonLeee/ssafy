package com.ssafy.dp;

import java.util.Scanner;

public class BionomialCoefTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] coef = new int[N + 1][N + 1];

		for (int i = 0; i <= N; i++) {
			int end = i < K ? i : K;
			for (int j = 0; j <= end; j++) {
				if (j == 0 || j == i)
					coef[i][j] = 1;
				else
					coef[i][j] = coef[i - 1][j - 1] + coef[i - 1][j];
			}
		}

		System.out.println(coef[N][K]);
	}
}
