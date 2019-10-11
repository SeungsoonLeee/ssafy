/*
  DDL문 (Data Defintion Language)
  - Database에서 사용하는 다양한 객체를 생성, 삭제, 변경하는 문
  - 수행하면 DB에 바로 반영됨
  - 종류 : table, index, sequence, view, synonim
  - 생성    : create 객체  객체명;
    ex) create sequence board_no;
  - 삭제    : drop  객체  객체명;
    ex) drop sequence board_no;
*/

/* 테이블 
   - 데이타를 관리할 최소 단위 
   - 생성 
	 create table 테이블명(
        컬럼명   데이타타입   [[CONSTRAINT 제약조건이름] 컬럼레벨 제약조건]
        , ...
        ,[[CONSTRAINT 제약조건이름] 테이블레벨 제약조건] 
     );
*/

/* 주문 테이블 
 ono 		: 주문번호          primairy key
 odate 		: 주문일
 id			: 주문한 고객 아이디  foreign key
 gno		: 상품 번호 		   foreign key
 quantity	: 주문한 수량 
 address	: 배송지
*/

-- 날짜 기본값 설정  5.6.5 미만은 now()
-- 날짜 기본값 설정  5.6.5 이상은 current_timestamp
create table orders(
	 ono 		int primary key auto_increment
    ,odate		datetime  default current_timestamp
    ,id  		varchar(30) 
    ,gno		int	not null
    ,quantity	int
    ,address	varchar(200)
    ,foreign key fk_orders_id(id)	references member(id)
    ,foreign key fk_orders_gno(gno)	references goods(gno)
);


create table s_emp(
	 empno	int 			primary key
    ,ename	varchar(30)		not null
    ,salary	decimal(11,2)
    ,commission_pct	decimal(4,2 ) 
    ,constraint check (commission_pct in (10, 12.5, 15, 17.5, 20))
    ,constraint check (salary >= 1000)
);

/* 테이블 변경 
   alter table 테이블명( add | modify , change, drop) 컬럼이름
*/

-- s_emp 테이블에 deptno 추가 
alter table s_emp add deptno int;

desc s_emp;

-- 컬럼 타입 변경 
alter table s_emp modify deptno varchar(30);

-- 컬럼 이름 변경   alter table 테이블이름 change  이전컬럼이름  변경할_컬럼이름 변경할_타입;
alter table s_emp change deptno address varchar(200);

-- 컬럼 삭제  alter table 테이블이름 drop 칼럼이름 
alter table s_emp drop address;


/*
테이블 삭제
drop table 테이블명;
주의점 : 부모테이블인 경우 삭제가 안됨.   => 자식 테이블 삭제후 부모 테이블을 삭제해야 한다.
ex)
  member(부모), goods(부모), orders(자식)
  orders 삭제 => member or goods 삭제
*/
drop table s_emp;
drop table member;   -- orders 테이블이 참조하고 있어서 삭제가 안됨. 


/*
truncate
- 테이블의 모든 데이타를 삭제
- 복구 할 수 없다. 
 */
truncate 테이블명; 

-- 테이블의 구조와 데이터 복제
create table emp2 as select * from emp;

select * from emp2;
-- 테이블의 데이타만 삭제
truncate emp2;
rollback;  -- truncate을 통해 삭제된 데이타는 rollback을 해도 복구되지 않는다. 


/* index 
 * - 인덱스는 결국 지정한 컬럼들을 기준으로 메모리 영역에 일종의 목차를 생성하는 것입니다. 
 *   select (Query)의 성능을 향상시킵니다.
 * - primary key와 foreign key는 자동 index됨. 
 * 형식]  CREATE INDEX 인덱스명 ON 테이블명 (컬럼명,..);
 */




