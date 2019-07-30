package com.ssafy.step1.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest5 {
	static int totalCount;
	static int[] num;
	static int n, r;

	public static void main(String[] args) {
		// 비트마스킹을 활용한 순열 구하기
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		totalCount = 0;
		num = new int[r];
		permutation(0, 0);

	}

	public static void permutation(int index, int flag) {
		if (index == r) {
			System.out.println(Arrays.toString(num));
			return;
		}
		for (int i = 1; i <= n; ++i) {
			// i가 기존 순열 안에서 사용중이지 않다면,
			if ((flag & 1 << i) == 0) {
				num[index] = i;
				permutation(index + 1, flag | 1 << i);
			}
		}
	}
}