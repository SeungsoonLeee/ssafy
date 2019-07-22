package com.ssafy.step1.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class CountingSort {
	public static void main(String[] args) throws FileNotFoundException {
		// 카운팅 정렬
		// 시간 복잡도 : O(n+k), k = 최대정수값
		// 제한 : 정수형만 정렬 가능, 정렬할 수 중 가장 큰 수를 알아야 함.

		// 1. 각 숫자를 카운팅
		// 2. 카운팅한 숫자를 누적 집계
		// 3. 누적 집계한 값을 인덱스로 하여 정렬

		System.setIn(new FileInputStream("countingTest.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int max = Integer.MIN_VALUE;
		int[] data = new int[n];
		int[] temp = new int[n];

		// data 입력
		for (int i = 0; i < n; i++) {
			data[i] = sc.nextInt();
			if (max < data[i])
				max = data[i];
		}
		int[] count = new int[max + 1];

		// 정수 카운팅
		for (int i = 0; i < n; i++) {
			count[data[i]]++;
		}

		// 카운팅 누적
		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		// 카운팅 정렬
		for (int i = n - 1; i >= 0; i--) {
			temp[--count[data[i]]] = data[i];
		}

		System.out.println(Arrays.toString(temp));
	}
}
