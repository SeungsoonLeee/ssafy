package com.ssafy.step3.sort;

import java.util.Arrays;

public class InsertionSort {
	public static void main(String[] args) {
		int[] data = { -1, -2, 6, 1, 2, 7, 3, 3, 3 };
		iSort(data);
		System.out.println(Arrays.toString(data));
	}

	public static void iSort(int[] list) {
		final int SIZE = list.length;
		for (int i = 0; i < SIZE; i++) { // U집합
			int temp = list[i];
			for (int j = 0; j < i; j++) { // S집합
				if (temp < list[j]) { // 삽입위치
					for (int k = i - 1; k >= j; k--) { // S집합의 끝부터 삽입위치까지 뒤로 밈
						list[k + 1] = list[k];
					}
					list[j] = temp;
					break;
				}
			}
		}
	}
}
