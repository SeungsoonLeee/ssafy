package com.ssafy.step1.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest4 {
	static int totalCount;
	static int[] num;
	static boolean[] selected;
	static int n, r;

	public static void main(String[] args) {
		// 1, 2, 3 세 수 중 3자리 순열 구하기 by 재귀
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		totalCount = 0;
		num = new int[r];
		selected = new boolean[n + 1];
		permutation(0);

	}

	public static void permutation(int index) {
		if (index == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 1; i <= n; ++i) {
			if (!selected[i]) {
				selected[i] = true;
				num[index] = i;
				permutation(index + 1);
				selected[i] = false;
			}
		}
	}
}
