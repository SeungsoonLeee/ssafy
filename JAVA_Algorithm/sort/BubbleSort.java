package com.ssafy.step1.algo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class BubbleSort {
	public static void main(String[] args) throws FileNotFoundException {
		// 버블정렬
		// 시간 복잡도 : O(n²)
		
		// 1회				2회				3회
		// 43 66 8 2 45		43 8 2 45 66	8 2 43 45 66
		// 43 66 8 2 45		8 43 2 45 66	2 8 43 45 66
		// 43 8 66 2 45		8 2 43 45 66	2 8 43 45 66
		// 43 8 2 66 45		8 2 43 45 66	2 8 43 45 66
		// 43 8 2 45 66		8 2 43 45 66	2 8 43 45 66
		
		System.setIn(new FileInputStream("bubbleTest.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[] bubble = new int[5];
		for (int i = 0; i < bubble.length; i++) {
			bubble[i] = sc.nextInt();
		}
		
		for (int count = bubble.length - 1; count > 0; count--) {
			for (int i = 0; i < count; i++) {
				if (bubble[i] > bubble[i + 1]) {
					int temp = bubble[i];
					bubble[i] = bubble[i + 1];
					bubble[i + 1] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(bubble));
	}
}
