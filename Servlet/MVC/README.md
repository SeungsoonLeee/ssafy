# MVC Model2  
Model, View, Controller로 구성된 디자인 패턴  

## 1. Model  
**1. Service**  
**2. DAO**  
**3. DTO**  

## 2. View  
**1. HTML**  
**2. JSP**  

## 3. Controller  
**1. Servlet**  
 - 요청 데이터 추출  
 - 모델 수행  
 - request에 저장  
 - 페이지 이동  
 - 예외 처리  

### 3.1. FrontController  

```java
// 1. 요청 url
try{
	// 2. 코드 수행
}catch (Exception e){
	// 3. 예외 처리
}
// 4. 페이지 이동
```