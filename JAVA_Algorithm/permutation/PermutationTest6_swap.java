package com.ssafy.step1.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest6_swap {
	static int n;
	static int[] num;

	public static void main(String[] args) {
		n = 4;
		num = new int[] { 1, 2, 3, 4 };
		permutation(0);
	}

	private static void permutation(int idx) {
		if (idx == n) {
			System.out.println(Arrays.toString(num));
			return;
		}

		for (int i = idx; i < n; i++) {
			swap(idx, i);
			permutation(idx + 1);
			swap(i, idx);
		}
	}

	private static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}