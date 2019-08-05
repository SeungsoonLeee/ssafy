package com.ssafy.step1.divide;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] data = { 9, 4, 6, 1, 2, 7, 9, 7, 5 };
		qSort(data, 0, data.length - 1);
		System.out.println(Arrays.toString(data));
	}

	public static void qSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int pivot = start;
			int left = start;
			int right = end;
			while (left < right) {
				while (arr[pivot] > arr[left] && left < right)
					left++;
				while (arr[pivot] <= arr[right] && left < right)
					right--;
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			qSort(arr, start, right - 1);
			qSort(arr, right + 1, end);
		}
	}
}
