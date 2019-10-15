package com.ssafy.step1.permutation;

import java.util.Arrays;
import java.util.Scanner;

public class PermutationTest7_swap2 {
	static int n;
	static int[] num;

	public static void main(String[] args) {
		num = new int[] { 1, 2, 3, 4, 5 };

		do {
			System.out.println(Arrays.toString(num));
		} while (nextPermutation());
	}

	private static boolean nextPermutation() {

		// 1. 뒤쪽부터 탐색하며 감소하는 시작점(i, 꺾인점) 찾기
		int i = num.length - 1;
		while (i > 0 && num[i - 1] >= num[i])
			--i;
		if (i == 0)
			return false;

		// 2. i-1 위치에 올 바로 다음 큰 수 찾기
		int j = num.length - 1;
		while (num[i - 1] >= num[j])
			--j;
		swap(i - 1, j);

		// 3. j위치부터 뒤에 있는 수들을 오름차순 정렬
		j = num.length - 1;
		while (i < j) {
			swap(i++, j--);
		}

		return true;
	}

	private static void swap(int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}