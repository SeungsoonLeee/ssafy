package chapter03;

import java.util.Arrays;

/**
 * 다차원 배열
 * 	[] 차원 표시
 * 	{} 데이터 할달할 때 차원 표시
 *
 */
public class ArrayTest2 {
	public static void main(String[] args) {
		int[][] arr1 = new int[2][3];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {
				System.out.printf("arr1[%d][%d] = %d\n", i, j, arr1[i][j]);
			}
			System.out.println();
		}
		
		
		// 행마다 다른 길이의 열을 구성하고 싶을 때
		int[][] arr2 = new int[3][];
		arr2[0] = new int[5];
		arr2[1] = new int[1];
		arr2[2] = new int[3];
		for (int i = 0; i < arr2.length; i++) {
			for (int j = 0; j < arr2[i].length; j++) {
				System.out.printf("arr2[%d][%d] = %d\n", i, j, arr2[i][j]);
			}
			System.out.println();
		}
		
		
		// 배열의 사이즈는 조절되지 않으므로 이미 크기가 설정된 배열에 더 많은 데이터를 저장하고 싶다면,
		// 더 큰 크기의 배열을 생성하여 배열을 복사해야 한다.
		// System 클래스에 arraycopy() 이용.
		// System.arraycopy(src, srcPos, dest, destPos, length);
		// src : 복사할 배열
		// srcPos : 복사 시작 위치
		// dest : 목적 배열
		// destPos : 목적 배열 시작 위치
		// length : 복사할 길이
		int[] arr3 = {1, 2, 3};
		int[] arr4 = new int[10];
		System.arraycopy(arr3, 0, arr4, 0,  arr3.length);
		System.out.println(Arrays.toString(arr4));
		
		
		// Arrays에도 copy 메서드가 있다.
		// Arrays.copyOf(original, newLength)
		// original : 복사할 배열
		// newLength : 복사할 길이
		int[] arr5 = new int[10];
		arr5 = Arrays.copyOf(arr3, 5);
	}
}
