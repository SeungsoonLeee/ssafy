# Spring Framework

## 1. Spring  

### 1.1. Spring Container  
- 정의 : 빈 객체를 저장하고 있으며 각 객체간의 의존관계를 관리  
- 특징 : 컨테이너에 객체를 담아두고, 필요할 때에 컴테이너로부터 객체를 가져와 사용  
- 주요 인터페이서 : BeanFactoty < ApplicationContext < WebApplicationContext  

### 1.2. BeanFactory 인터페이스  
- 정의 : 빈 객체를 관리하고 각 빈 객체간의 의존관계를 설정해주는 기능을 제공  
- XmlBeanFactory 클래스
- 테스트
 
### Factory Pattern  

```java
public class ArticleFactory{
	public static ArticleDao getInstance(){
		return new MysqlArticleDao();
	}
}

public class XXXServiceImp{
	ArticleDao dao = ArticleFactory.getInstance();
}
```

### DI(Dependency Injection)  
의존하는 객체(속성)를 직접 생성하지 않고 생성자나 setter 메서드를 통해 받음.  
의존 : 클래스 내에 있는 함수나 속성이 아닌 다른 클래스의 함수나 속성을 사용  
-> 상속, 속성, 인자로 다른 클래스를 사용  

