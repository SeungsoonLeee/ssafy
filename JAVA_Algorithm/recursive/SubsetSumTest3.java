package com.ssafy.step1.subset;

import java.util.Scanner;

public class SubsetSumTest3 {
	static int[] nums = { 5, 6, 10, 11, 16 };
	static int cnt = 0;
	static int targetSum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		targetSum = sc.nextInt();
//		for (int i = 0; i < N; i++) {
//			nums[i] = sc.nextInt();
//		}

//		subsetSum(0, 0);
		subsetSum2(0, 0, "");
		System.out.printf("부분집합의 합이 %d이 되는 경우의 수 : %d\n", targetSum, cnt);

	}

	// 조건을 주어 가지를 치면 재귀를 끝가지 돌지 않고 끝낼 수 있다.
	public static void subsetSum2(int index, int sum, String str) {
		if (sum == targetSum) {
			cnt++;
			System.out.println("부분집합 :" + str);
			return;
		} else if (sum > targetSum) {
			return;
		}

		if (index >= nums.length) {
			return;
		} else {
			// 선택한 수는 sum에 더하고
			subsetSum2(index + 1, sum + nums[index], str + " " + nums[index]);
			// 선택하지 않은 수는 그냥 보냄
			subsetSum2(index + 1, sum, str);
		}
	}
}
