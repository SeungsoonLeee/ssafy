-- 1. 부서정보를저장하기위한DEPT 테이블을생성해보자.
create table dept(
	DEPT_NO char(8) not null
    ,DEPT_NAME varchar(100) not null
    ,DEPT_LOC varchar(100) not null
    ,DEPT_TEL_NO varchar(100) not null
);

-- 2. DEPT 테이블의PK를설정하는구문을추가해보자. (단, PK명은DEPT_PK로한다)
alter table dept
add constraint DEPT_PK primary key(DEPT_NO);

-- 3. 데이터를DEPT 테이블에추가해보자.
insert into detp values('10', 'SALES', 'SEOUL', '02-671-1111');
insert into detp values('20', 'FINANCE', 'SEOUL', '02-862-2222');
insert into detp values('30', 'HR', 'BUSAN', '051-111-1111');
insert into detp values('40', 'PURCHASE', 'BUSAN', '051-222-2222');
insert into detp values('50', 'MANAGEMENT', 'SEOUL', '02-383-3333');

-- 4. 아래와 같은 EMP 테이블을 생성해보자.
create table EMP(
	EMP_NO varchar(20) not null
    ,EMP_NAME varchar(20) not null
    ,EMP_MGE varchar(20)
    ,HIREDATE date
    ,SAL int
    ,DEPT_NO char(8)
);

-- 5. EMP 테이블의 Constaint PK, FK를 추가해보자.(단 PK는 EMP_PK, FK는 EMP_FK로 한다.)
alter table emp
add constraint EMP_PK primary key emp(EMP_NO)
,add constraint EMP_FK foreign key emp(DEPT_NO)
references dept(DEPT_NO);

desc emp;

-- 6. 4번 테이블과 같이 데이터를 추가해보자.
insert into emp(emp_no, emp_name, emp_mge, hiredate, sal, dept_no)
values('1001', 'KIM', '1003', '2005-01-15', 4750, '20');
insert into emp values('1002', 'LEE', '1003', '2008-06-05', 3000, '30');
insert into emp values('1003', 'PARK', '1001', '2007-11-28', 3500, '10');

-- 7. HR 부서가 MANAGEMENT부서로 통합되었다. HR 부서 직원에 대한 소속 부서를 MANAGEMENT 부서로 변경해보자.
update emp
set DEPT_NO = (select DEPT_NO from DEPT where DEPT_NAME = 'HR')
where DEPT_NO = (select DEPT_NO from DEPT where DEPT_NAME = 'MANAGEMENT');

-- 8. HR 부서를 DEPT 테이블에서 삭제해보자.
delete from emp
where DEPT_NO = (select DEPT_NO from DEPT where DEPT_NAME = 'HR');

-- 9. 아래의 데이터를 EMP 테이블에 추가해보자. 추가 시 입사일은 시스템의 현재일자를 자동으로 가져와서 부여하도록 하며, ‘년-월-일’의 형태로 작성해보자.
insert into emp(emp_no, emp_name, emp_mge, hiredate, sal, dept_no)
values('2001', 'chung', '1001', current_date(), 3000, '50');
