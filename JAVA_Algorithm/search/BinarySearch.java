package com.ssafy.step1.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("binaryTest.txt"));
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		int findNum = sc.nextInt();
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		
		int findIdx = getIdxByBinarySearch(nums, findNum);
		if(findIdx >= 0)	System.out.printf("%d는 %d번째 인덱스에 있습니다.\n", findNum, findIdx);
		else	System.out.println("찾는 숫자가 없습니다.");
		
		findIdx = getIdxByBinarySearchRecursive(nums, findNum, 0, nums.length - 1);
		if(findIdx >= 0)	System.out.printf("%d는 %d번째 인덱스에 있습니다.\n", findNum, findIdx);
		else	System.out.println("찾는 숫자가 없습니다.");
	}

	public static int getIdxByBinarySearch(int[] arr, int findNum) {
		int start = 0;
		int end = arr.length - 1;
		
		while (start <= end) {
			int mid = (start + end) / 2;
			if (findNum == arr[mid])	return mid;
			else if (findNum > arr[mid])	start = mid+1;
			else	end = mid-1;
		}
		return -1;
	}
	
	private static int getIdxByBinarySearchRecursive(int[] nums, int findNum, int start, int end) {
		if(start > end) {
			return -1;
		}
		else {
			int mid = (start + end) / 2;
			if(findNum == nums[mid]) return mid;
			if(findNum > nums[mid])	return getIdxByBinarySearchRecursive(nums, findNum, mid + 1, end);
			else	return getIdxByBinarySearchRecursive(nums, findNum, start, mid - 1);
		}
	}
}
