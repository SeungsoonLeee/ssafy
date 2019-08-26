# DisjointSet

- 서로소 또는 상호배타 집합들은 서로 중복 포함된 원소가 없는 집합들이다. 즉, 교집합이 없다.
- 집합에 속한 하나의 특정 멤버를 통해 각 집합들을 구분한다.

```java
import java.util.Arrays;
import java.util.Scanner;

public class DisjointSetTest {
	static int[] parents;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = sc.nextInt();
		parents = new int[N];

		// 1. set 만들기
		Arrays.fill(parents, -1);

		for (int i = 0; i < count; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			System.out.println(union(a, b));
		}

	}

	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);

		if (aRoot != bRoot) {
			parents[bRoot] = aRoot;
			return true;
		}
		return false;
	}

	private static int find(int f) {
		if (parents[f] < 0) // 음수인 경우 root라는 의미이므로 자기 자신을 리턴
			return f;
		return parents[f] = find(parents[f]); // path compression
	}
}
```

