package com.ssafy.dp;

import java.util.Scanner;

public class Ex3_Coin_dp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] coins = { 1, 4, 6 };
		int[] C = new int[N + 1];

		for (int i = 1; i <= N; i++)
			C[i] = Integer.MAX_VALUE;

		for (int i = 0, size = coins.length; i < size; i++) {
			for (int j = coins[i]; j <= N; j++) {
				C[j] = Math.min(C[j], C[j - coins[i]] + 1);
			}
		}

		System.out.println(C[N]);
	}
}
