# Singleton Pattern

객체를 항상 하나만 유지하는 디자인 패턴.

client와 server사이에 netClient라는 객체로 client를 관리한다고 하자.

client마다 netClient를 생성하여 관리하게 되면 100명의 client가 있으면

100개의 netClient를 생성하하고 각 client가 어느 netClient와 이어져있는지 모두 알아야하는 비효율성이 있다.

이러한 경우, 하나의 netClient를 생성하여 client를 관리하는데 이것을 singleton pattern이라고 한다.

**- Singleton Pattern 구현**
1. private 생성자 작성.
2. private static 으로 클래스내에 인스턴스 멤버 선언.
3. public static 으로 2에서 선언한 intance를 반환하는 getter 작성.
4. getter를 이용하여 객체 접근.

```
public class MySingleton{
	private static MySingleton instance;
	private MySingleton(){}
	public static MySingleton getInstance(){
		if(instance != null){
			return instance;
		}
	}
}
```
