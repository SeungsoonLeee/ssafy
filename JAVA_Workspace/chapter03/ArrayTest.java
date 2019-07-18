package chapter03;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String[] args) {
		// 배열은 생성 시 기본값으로 초기화 된다.
		// 정수 = 0, 문자 = \u0000, 논리 = false, 참조 = null
		int[] arr1 = new int[3];

		for (int i = 0; i < arr1.length; i++) {
			System.out.printf("arr1[%d] = %d\n", i, arr1[i]);
		}
		// 배열에서 .을 이용한 접근은 매번 heap에 있는 hash table을 참조하기 때문에 배열의 길이가 큰 경우 성능이 저하될 수 있다.
		// 따라서 아래와 같이 수정하면 stack에서 값을 불러오기 때문에 성능 저하를 막을 수 있다.
		// for (int i = 0, size = arr1.length; i < size; i++) {
		// }

		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		// arr1[3] = 40; //ArrayIndexOutOfBoundsException 발생
		System.out.println(Arrays.toString(arr1));

		int[] arr2 = { 0, 1, 2, 3, 4, 5, 6 };
		System.out.println(Arrays.toString(arr2));

		String[] names = { "가나다", "라마바", "사아자", "차카타", "파하" };
		int[] scoers1 = { 90, 80, 70, 85, 95 };
		int[] scoers2 = { 95, 90, 100, 92, 99 };
		int[] total = new int[names.length];
		double[] avg = new double[names.length];
		for (int i = 0, size = names.length; i < size; i++) {
			total[i] =scoers1[i] + scoers2[i];
			avg[i] = (double)total[i] / 2d;
			System.out.printf("이름 : %s \t총점 : %d \t평균 : %.2f\n", names[i], total[i], avg[i]);
		}

	}
}
