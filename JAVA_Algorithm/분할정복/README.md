# 분할정복 알고리즘

**① 분할(Divide)** : 해결할 ㅁ누제를 여러개의 작은 부분으로 나눔.  
**② 정복(Conquer)** : 나눈 작은 문제를 해결.  
**③ 통합(Combine)** : 해결된 답을 다시 통합.  
ex) 거듭제곱, 퀵정렬

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