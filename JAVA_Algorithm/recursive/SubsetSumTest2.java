package com.ssafy.step1.subset;

import java.util.Scanner;

public class SubsetSumTest2 {
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

	// 백트래킹을 활용한 부분집한의 합 구하기.
	// 가장 끝에서 합을 비교한 기존의 방법과는 달리 그때그때 부분집합의 합을 구할 수 있다.
	public static void subsetSum(int index, int sum) {
		if (index >= nums.length) {
			if (sum == targetSum)
				cnt++;
			return;
		} else {
			// 선택한 수는 sum에 더하고
			subsetSum(index + 1, sum + nums[index]);
			// 선택하지 않은 수는 그냥 보냄
			subsetSum(index + 1, sum);
		}
	}
	
	// String을 이용하여 부분집합을 기록할 수 있다.
	public static void subsetSum2(int index, int sum, String str) {
		if (index >= nums.length) {
			if (sum == 21) {
				cnt++;
				System.out.println("부분집합 :" + str);
			}
			return;
		} else {
			// 선택한 수는 sum에 더하고
			subsetSum2(index + 1, sum + nums[index], str + " " + nums[index]);
			// 선택하지 않은 수는 그냥 보냄
			subsetSum2(index + 1, sum, str);
		}
	}
}
