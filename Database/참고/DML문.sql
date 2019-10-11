/*
 DML문(Data Manipulation language)
 - data를 insert, update, delete하는 문장
 - dml문을 수행하면 수행된 내용이 임시저장소에 저장되어 실제 DB에는 반영되지 않는다. 
 - DML문을 수행후 TCL(Transaction Controll language)을 수행해야한다. 
	TCL문 
     commit         	 : 디비에 반영
     savepoint 이름  		 : 임시 저장 위치 
     rollback       	 : 작업한 모든 dml문 수행 취소
     rollback 세이브포인트이름: 지정한 savepoint까지 취소 
 - update, delete문을 수행하면 commit 또는 rollback하기 전까지 
   해당 행은 locking된다. 


mysql workbanch는 auto commit
 edit=> preference => sql editor => sql Execution=> New connection use auto commit mode 해제
*/

/*
데이타 추가 
insert into 테이블명(컬럼명, ....) values(값,...)
- 테이블에 지정한 컬럼에 지정한 값으로 추가 

insert into 테이블명 values(값,...)
- 테이블 구조에 설정된 모든 컬럼에 구조에 지정된 순서대로 값이 설정되서 insert됨
*/
insert into goods(brand, price, maker, cno) 
values('핸디형 선풍기',22000,'카카오프렌즈', 20);

rollback;    -- 작업한 dml 문 취소

select * from goods;
commit;
/*
delete 문 
- 전체 데이타 삭제 
  delete from 테이블명;
   edit=> preference => sql editor => safe update 체크 해제 
   
- 조건에 맞는 데이타만 삭제 
  delete from 테이블명  where 조건;
*/

delete from emp;
delete from emp where sal <2000;
rollback;
select * from emp;

/*
-전체 데이타 수정 
updata 테이블명 set 컬럼명=value;   
-조건에 맞는 데이타만 수정 
updata 테이블명 set 컬럼명=value where 조건;   
*/

update goods set price = 5000 where gno=2;
commit;
