package com.ssafy.step1.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationByNextPermutation {
	static int n, r;
	static int[] nums;
	static int[] temp;

	public static void main(String[] args) {
		// nCr : n까지의 수중 r개 추출(순서 상관X)
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		nums = new int[r];
		temp = new int[n];
		for (int i = 0; i < temp.length; i++) {
			if (i >= temp.length - r)
				temp[i] = 1;
		}
		combination();
	}

	private static void combination() {
		do {
			nums = new int[r];
			int idx = 0;
			for (int i = 0; i < temp.length; ++i) {
				if (temp[i] == 1)
					nums[idx++] = i + 1;
			}
			System.out.println(Arrays.toString(nums));
		} while (nextPermutation());
	}

	private static boolean nextPermutation() {
		int i = temp.length - 1;
		while (i > 0 && temp[i - 1] >= temp[i])
			--i;
		if (i == 0)
			return false;

		int j = temp.length - 1;
		while (temp[i - 1] >= temp[j])
			--j;
		swap(i - 1, j);

		j = temp.length - 1;
		while (i < j)
			swap(i++, j--);

		return true;
	}

	private static void swap(int i, int j) {
		int t = temp[i];
		temp[i] = temp[j];
		temp[j] = t;
	}
}
