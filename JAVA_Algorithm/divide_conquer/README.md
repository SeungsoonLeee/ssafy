# 분할정복 알고리즘

**① 분할(Divide)** : 해결할 ㅁ누제를 여러개의 작은 부분으로 나눔.  
**② 정복(Conquer)** : 나눈 작은 문제를 해결.  
**③ 통합(Combine)** : 해결된 답을 다시 통합.  
ex) 거듭제곱, 퀵정렬

>거듭제곱 구현

```java
//거듭제곱 구현
private static int power(int base, int exp) {
	if (exp <= 0)
		return 1;
	int halfExp = exp / 2;
	int result = power(base, halfExp);
	result *= result;
	if (exp % 2 == 1)
		result *= base;
	return result;
}
````

>퀵정렬 구현

```java
//퀵정렬
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

}
````