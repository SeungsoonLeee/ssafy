package com.ssafy.step1.subset;

import java.util.Arrays;
import java.util.Scanner;

public class SubsetSumTest {
	static int N;
	static int[] nums = { 5, 6, 10, 11, 16 };
	static boolean[] selected;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		N = sc.nextInt(); // 숫자의 갯수를 입력
		selected = new boolean[nums.length];
//		nums = new int[N];
//		for (int i = 0; i < N; i++) {
//			nums[i] = sc.nextInt();
//		}
		subsetSum(0);
	}

	public static void subsetSum(int index) {
		if (index >= nums.length) {
			int sum = 0;
			int idx = 0;
			int[] temp = new int[index];
			for (int i = 0; i < index; i++) {
				if (selected[i]) {
					sum += nums[i];
					temp[idx++] = nums[i];
				}
			}
			if (sum == 21) {
				temp = Arrays.copyOf(temp, idx);
				System.out.println(Arrays.toString(temp));
			}
		} else {
			for (int i = 0; i < 2; i++) {
				selected[index] = i % 2 == 0 ? true : false;
				subsetSum(index + 1);
			}
		}

	}

	public static void subset(int index) {
		if (index >= nums.length) {
			int sum = 0;
			for (int i = 0; i < nums.length; ++i) {
				System.out.print((selected[i] ? nums[i] : "x") + " ");
				sum += selected[i] ? nums[i] : 0;
			}
			if (sum == 21)
				System.out.println("\t참");
			else
				System.out.println("\t거짓");
			return;
		} else {
			for (int i = 0; i < 2; i++) {
				selected[index] = i % 2 == 0 ? true : false;
				subset(index + 1);
			}
		}
	}
}
