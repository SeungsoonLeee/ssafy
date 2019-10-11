/*
날짜 기본값 설정
 - 5.6.5.미만 now()
 - 5.6.5 이상 current_timestamp
  -> 년, 월, 일, 시, 분, 초로 설정되므로 타입은 datetiem 또는 timestamp로 저장
*/
create table semp(
	empno int auto_increment primary key
    ,name varchar(50)
    ,sal int
    ,hiredate datetime default current_timestamp
    ,deptno int
);

create table members(
	id varchar(30) primary key
    ,password varchar(30) not null
    ,email varchar(30)
    ,phone varchar(16)
    ,address varchar(200)
);

create table orders(
	ono int auto_increment primary key
    ,odate datetime default current_timestamp
    ,id varchar(30) -- references members(id)
    ,gno int not null
    ,quantity int default 1
    ,address varchar(200) not null
    ,foreign key fk_orders_id(id) references members(id)
    ,foreign key fk_orders_gno(gno) references goods(gno)
);

/*
constraint : 제약 조건
 constraint 제약조건명 check (컬럼명 제약조건)
*/
create table cemp(
	empno int primary key
    ,ename varchar(30) not null
    ,sal int default 1500
    ,commission_pct numeric(4,2)
    ,constraint check (commission_pct in (10, 10.5, 12, 12.5, 15))
    ,constraint check (sal >= 1000)
);


/*
테이블 변경
alter table 테이블명 add|modify|change|drop 컬럼명
*/
-- 컬럼 추가 (add)
alter table cemp add deptno int;

-- 컬럼 타입 변경
alter table cemp modify deptno varchar(10);

-- 컬럼 이름과 타입 변경
alter table cemp change deptno deptname varchar(30);
alter table cemp change deptname deptno int;



/*
테이블 삭제
drop table 테이블명;
 - 참조하고 있는 테이블이 있는 경우 삭제 안됨
*/
drop table goods; -- orders 테이블이 참조하고 있어서 삭제 불가


/*
테이블 복제
create table 테이블명 as select문
 - select문을 수행된 결과 테이블이 복제됨
 - 단, 제약조건은 복제되지 않는다.
*/
create table testemp
as select empno, ename, sal, deptno
from emp;


-- truncate : 테이블의 모든 데이터 삭제, 복구 불가
truncate emp;






