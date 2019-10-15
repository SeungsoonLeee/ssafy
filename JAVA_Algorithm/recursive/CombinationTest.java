package com.ssafy.step1.combination;

import java.util.Arrays;
import java.util.Scanner;

public class CombinationTest {
	static int n, r;
	static int[] nums;

	public static void main(String[] args) {
		// nCr : n까지의 수중 r개 추출(순서 상관X)
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		nums = new int[r];

		combination(0, 0);
	}

	private static void combination(int before, int idx) {
		if (idx == nums.length) {
			System.out.println(Arrays.toString(nums));
			return;
		}
		for (int i = before + 1; i <= n; i++) {
			nums[idx] = i;
			combination(i, idx + 1);
		}
	}
}
