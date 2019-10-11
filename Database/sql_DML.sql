/*
데이터 추가
insert into 테이블명(컬럼명, . . .) values(값, . . .)
- 테이블 구조에 설정된 모든 털럼에 구조에 지정된 순서대로 데이터 추가
*/
insert into goods(brand, price, maker, cno) values('테스트상품', 22000, '테스트메이커', 20);
select * from goods;

insert into orders(id, gno, quantity) values('lss', 1, 10);
-- orders 테이블의 id컬럼이 members 테이블의 id 컬럼을 참조하고 있음
-- 참조하는 테이블에 데이터 추가시 'lss'가 없으면 에러발생

savepoint insertGoods;


/*
데이터 삭제
 - 전체 데이터 삭제
 delete from 테이블;
 - 조건에 맞는 데이터만 삭제
 delete from 테이블 where 조건;
*/

delete from goods;
select * from goods;

rollback to insertGoods;
select * from goods;

delete from emp where empno=1111;
commit;


/*
데이터 수정
 - 데이터 전체 수정
 udpate 테이블명 set 컬럼명 = 값, . . .;
 - 조건에 맞는 데이터만 수정
 udpate 테이블명 set 컬럼명 = 값, . . . where 조건;
*/
update emp set sal = 30000;
select * from emp;


/*
index
 - select 문의 성능을 높이기 위해서 index를 만든다.
 create index 인덱스명 on 테이블명(컬럼명, . . .);
*/
-- goodsx테이블의 상품명에 indexing
create index idx_goods_brand on goods(brand);







