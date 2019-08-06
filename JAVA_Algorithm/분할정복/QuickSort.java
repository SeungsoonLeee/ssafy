package com.ssafy.step1.divide;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] data = { 1, 3, 5, 2, 1, 9, 8, 7, 6, 5, 4, 5, 6, 1 };
		qSort(data, 0, data.length - 1);
		System.out.println(Arrays.toString(data));
	}

	public static void qSort(int[] arr, int start, int end) {
		if (start >= end) {
			return;
		} else {
			int pivot = start; // pivot을 가장 왼쪽의 idx로 설정.
			int left = start;
			int right = end;
			while (left < right) {
				// pivot에 위치한 값보다 크거나 같은 값을 만날 때까지 left증가
				while (arr[pivot] > arr[left] && left < right)
					left++;
				// pivot에 위치한 값보다 작은 값을 만날 떼까지 right감소
				while (arr[pivot] <= arr[right] && left < right)
					right--;
				// left와 right를 swap
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
			// pivot을 right로 바꾸어주고 pivot을 기준으로 다시 나누어 정렬
			qSort(arr, start, right - 1);
			qSort(arr, right + 1, end);
		}
	}
}
