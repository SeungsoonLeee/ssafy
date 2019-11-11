# 탐색(Search) 알고리즘

## 1. 2진 탐색(Binary Search)

정렬되어 있는 1차원 배열에서 특정 수를 찾는 탐색 알고리즘  
1) 배열(arr)의 중앙 위치(mid)와 찾는 값을 비교  
2) 찾는 값이 arr[mid]값보다 작으면 mid보다 왼쪽 만을, 크면 arr[mid]보다 오른쪽 만을 가지고 다시 탐색
3) 1, 2를 반복

**<코드>**  

```java
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
```

## 2. 2진 탐색 트리(Binary Search Tree)

노드의 데이터 값이 왼쪽 자식 노드 < 부모 노드 < 오른쪽 자식 노드 로 저장하여 특정 수를 찾는 탐색 알고리즘  
1) 루트에서 시작  
2) 탐색할 값과 루트값을 비교  
3) 탐색할 값이 루트값보다 작은 경우 왼쪽 자식노드를, 큰 경우 오른쪽 자식노드를 탐색
4) 2, 3을 반복  

**2진 탐색 트리를 위해서는 삽입 위치를 규칙에 맞게 저장하는 알고리즘이 필요하다**  

![BinarySearchTreeInsertionAlgorithmIMG](./BinarySearchTreeInsertionAlgorithm.PNG)

