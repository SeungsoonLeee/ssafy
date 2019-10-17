# Spring Framework

## 1. Spring  

### 1.1. Spring Container  
- 정의 : 빈 객체를 저장하고 있으며 각 객체간의 의존관계를 관리  
- 특징 : 컨테이너에 객체를 담아두고, 필요할 때에 컴테이너로부터 객체를 가져와 사용  
- 주요 인터페이서 : BeanFactoty < ApplicationContext < WebApplicationContext  

### 1.2. BeanFactory 인터페이스  
- 정의 : 빈 객체를 관리하고 각 빈 객체간의 의존관계를 설정해주는 기능을 제공  
- XmlBeanFactory 클래스  
	- BeanFactory 인터페이스 구현 클래스  
	- 외부 자원으로부터 설정 정보를 읽어와 빈 객체를 생성  
	- Resource를 이용하여 XmlBeanFactory에 설정 정보를 전달  

### 1.3. ApplicationContext 인터페이스  
- 정의 : BeanFactory가 제공하는 빈 관리 기능 이외에 파일과 같은 자원 처리, 추상화, 메시지 지원 및 국제화 지원, 이벤트 지원 등의 기능을 제공  

### 1.3. WebApplicationContext 인터페이스  
- 웹 어플리케이션을 위한 ApplicationContext  
- 웹 어플리케이션을 취해 추가적으로 제공되는 빈 영역을 정의  
- 하나의 웹 어플리케이션마다 한 개의 WebApplicationContext가 존재  
- XmlWebApplicationContext 클리스  
	- 웹 으폴리케이션에 위치한 XML 파일로부터 설정 정보를 로딩  

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

