package com.ssafy.dp;

import java.util.Scanner;

public class knapsackTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int W = sc.nextInt();

		int[] weights = { 6, 5, 3, 4 }; // new int[N + 1];
		int[] prices = { 30, 10, 50, 40 }; // new int[N + 1];

		int[][] D = new int[N + 1][W + 1];

		int itemW;
		int itemP;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= W; j++) {
				itemW = weights[i - 1];
				itemP = prices[i - 1];
				if (itemW <= j) {
					D[i][j] = Math.max(D[i - 1][j - itemW] + itemP, D[i - 1][j]);
				} else {
					D[i][j] = D[i - 1][j];
				}
			}
		}

		System.out.println(D[N][W]);
	}
}
