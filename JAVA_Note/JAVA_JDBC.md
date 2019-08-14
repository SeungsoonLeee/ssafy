# JDBC (Java DataBase Connection)  

## 1. Database  

### 1.1. Mysql  

#### 1.1.1. 명령어  
- **SHOW DATABASES;** : <현재 있는 데이터 베이스 이름을 본다.>  
- **USE 데이터베이스이름;** : <데이터베이스이름를 사용한다.>  
- **CREATE DATABASE 데이터베이스이름;** : <데이터베이스이름으로 데이터베이스를 만듬.>  
- **DROP DATABASE 데이터베이스이름;** : <데이터베이스이름의 데이터베이스를 삭제>  
- **USE 데이터베이스이름;** : <데이터베이스 선택>  
- **SHOW TABLES;** : <데이터베이스안에 선언한 테이블 이름이 출력.>  
- **DESC 테이블이름;** : <데이터베이스안의 테이블이름의 구조를 본다.>  

#### 1.1.2. sql문  
**1) select문**  

```
select [distinct] {* | column[ as Alias], ....}
from table명
[where 조건]
[group by 컬럼명]
[order by 컬럼명 [asc|desc]
```

```
Ex)
Select * from employee;
select ename, sal from emp;
```

**2) insert문**  

```
insert into 테이블명 [(컬럼명, ….)] values(값1, …)
```

```
Ex)
insert into member(id, password, name, email, address)
values('jaen','1111','자앤','jaen@androidjava.com','서울시 서초구');
```

**3) update문**  

```
update 테이블명 set 컬럼명=value, … [where 조건];
```

```
Ex)
update member set address=’서울시 강남구’ where id=’jaen’;
```

**4) delete문**

```
delete from 테이블명 [where 조건];
```

```
Ex)
delete from member where id=’jaen’;
```

