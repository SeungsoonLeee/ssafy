-- 업무별 급여 평균이 2000이상인 업무들을 조회
select job, avg(sal) as avgSal
from emp
group by job
having avgSal >= 2000;

-- 부서별 급여 평균과, 전체 급여 평균을 조회하시오  
-- 단 부서가 없는 사원은 프리랜서로 표시
select if(grouping(deptno)=0, ifnull(deptno, '프리랜서'), '전체평균') as deptno, avg(sal) as avgSal
from emp
group by deptno with rollup;


-- 사원번호, 이름, 급여, 부서번호, 부서명을 조회하시오
-- 단 부서에 배치되지 않은 사원도 조회하시오
select empno, ename, sal, e.deptno, d.dname
from emp as e left join dept as d
on e.deptno = d.deptno;


-- 게시글 3번에 대해 게시글번호, 작성자, 타이틀, 작성일(연-월-일), 내용
-- 작성자가 올린파일 이름, 시스템에 저장된 파일 이름을 조회하시오
select b.no, id, title, date_format(regdate, '%y-%m-%d') as date, contents
from board b left join boardfile bf
on b.no = bf.no
where b.no = 3;


/* SubQuery
   - Query문 내에 작성하는 Query를 SubQuery라고한다.
   - 기본적으로 외부 Query가 수행되기 전에 SubQuery가 먼저 수행되고 그결과를 
     외부 Query에서 사용한다. 
     단, 상호 연관 쿼리는 외부 Query한행에 대해 SubQuery가 수행되므로
         SubQuery는 외부 Query의 행 수만큼 수행된다. 
   - 종류
     - where절에서 사용하는 단일행, 다중행, 다중열, 상호 연관 subquery
     - from절에서 사용하는 inline view
     - 스칼라 서브쿼리(단일행, 단일열)로 조회되는 sub query
   - sub query가 사용되는 위치 
     select절, from절, where절, having절, order절  => group by절 빼고 
     create table문, insert문, update문, delete문
   - 규칙
     sub query를 작성시 ()내에 작성해야 한다. 
 */
 
/*
  select절의 sub query(스칼라 서브쿼리)
  - outer join한것과 같은 효과 
*/
 -- 사원번호, 이름, 급여, 부서번호, 부서명을 조회 
select empno, ename, sal, e.deptno
	,(select dname from dept where e.deptno = dept.deptno) as dname
    ,(select loc from dept where e.deptno = dept.deptno) as loc
from emp e;

 
 /*
   where절 sub Query
   - sub query를 수행한 결과를 where절에서 비교 데이타로 사용 
   - 종류
     단일 행 서브쿼리 
       - 서브 쿼리로 부터 수행된 결과 행이 하나일 때
       - 비교 조건 =, >, >=, <, <=, != 
     다중 행 서브쿼리 
       - 서브 쿼리로 부터 수행된 결과 행이 둘 이상일 때
       - 비교 조건 in, any, all
     다중 열 서브쿼리 
       - 서브 쿼리로 부터 수행된 결과 열이 둘 이상일 때 
     상호 연관 서브쿼리 
       - 외부 질의에서 사용 하는 컬럼을 subquery의 조건으로 사용 
 */
 
 -- 단일 행 서브쿼리 
 -- 사원번호가 7369인 사원의 업무와 같은 업무를 하는 사원의 모든 조회
 select *
 from emp
 where job = (select job from emp where empno = 7369);
 
 select * from emp where empno=7369;
 
 
 -- 평균 급여보다 많이 받는 사원의 모든 정보를 조회
 select *
 from emp
 where sal > (select avg(sal) from emp);
  
select avg(sal) from emp;


-- 업무가 'MANAGER'인 사원들 중 전체 사원의 평균 급여보다 많이 받는 사원들에 대해
-- 사원번호, 업무, 급여, 급여 등급을 조회
select empno, job, sal, grade
from emp join salgrade
on sal between losal and hisal
where job = 'MANAGER' and sal > (select avg(sal) from emp);



/* 다중행 sub qeury
   - in 
     sub query를 통해 조회된 여러 데이타 중 하나와 일치하면 조회된다. 
   - all 
	 >(>=) all  sub query를 통해 조회된 모든 데이타 보다 커야 한다. 
				=> 가장 큰 값 보다 커야한다.
     <(<=) all  sub query를 통해 조회된 모든 데이타 보다 작아야 한다.
				=> 가장 작은 값보다 작아야한다.
   - any
     >(>=) any  sub query를 통해 조회된 데이타 중 하나라도 커야 한다.  
				=> 가장 작은 값보다 커야한다. 
     <(<=) any  sub query를 통해 조회된 데이타 중 하나라도 작아야 한다
				=> 가장 큰값 보다 작아야 한다. 
     = any => in과 같으므로 잘 안씀.
*/

-- in  
-- 부서 번호 10번에 근무하는 사원들과 같은 급여를 받는 사원들을 조회하세요
select *
from emp
where sal in (select sal from emp where deptno = 10);


-- 다음 관리자들이 관리하는 사원들의 모든 정보를 조회.
-- SCOTT, CLARK 
select *
from emp
where mgr in (select empno from emp where ename in ('SCOTT','CLARK'));


-- 각 부서의 평균 급여들 보다 많이 받는 사원의 정보를 조회
select *
from emp
where sal > all(select avg(sal) from emp group by deptno);

select * from emp;

-- 급여 평균 중 가장 낮은 업무의 평균 급여보다 많이 받는 사원의 정보를 추출

select avg(sal) from emp group by job;

-- 각 업무별 평균 급여들 보다 낮게 받는 사원의 정보를 조회 
 
/*
 다중 열 서브쿼리 (pairwise)
 - 서브 쿼리를 통해 조회된 열이 두개 이상인 경우 
 - 조회된 모든열과 일치해야 됨. 
 형식]  where  (컬럼, 컬럼,..) 비교 조건(select 컬럼, 컬럼,.. from ~)
*/
-- ADAMS 사원의 업무와 부서가 같은 사원의 정보를 조회하시오
select *
from emp
where (job, deptno) = (select job, deptno from emp where ename = 'ADAMS');


/*
  상호 연관(correlate) sub query
  - 외부쿼리(기본쿼리)의 컬럼을 sub query의 비교 조건으로 사용 
  - 외부 쿼리 행의 수만큼 sub query가 수행된다.  
*/

-- 사원이 소속된 부서의 평균 급여보다 많이 받는 사원의 정보를 조회
select *
from emp e
where sal > (select avg(sal) from emp e2 where e.deptno = e2.deptno);
-- 아래도 같은 결과(from 절의 sub query로 변경)
select *
from emp e, (select avg(sal) as avgSal, deptno as avgdeptno from emp group by deptno) d
where sal > avgSal and deptno = avgdeptno;

select deptno, avg(sal)
from emp
group by deptno;


-- 부서별 최저 임금을 받는 사원의 모든 정보를 조회 



select deptno, min(sal)
from   emp
group by deptno;

/* exists 
   - sub query에 대한 결과 집합이 발결되면 true가 되어  더 이상 쿼리를 수행하지 않고
     결과 집합이 없으면 계속 검사하고 마지막까지 없으면 false
*/

-- 부하직원이 있는 사원에 대한 정보 추출 
select *
from emp e
where exists (select 1 from emp e2 where e.empno = e2.mgr);


-- 판매된적이 있는 상품의 정보를 조회하시오                 
select *
from goods g
where exists (select 1 from orders o where g.gno = o.gno);

/*
	not exists 
   - sub query에 대한 결과 집합이 발결되면 fasle가 되어 더 이상 쿼리를 수행하지 않고
     결과 집합이 없으면 계속 검사하고 마지막까지 없으면 true
*/
-- 한번도 판매 되지 않은 상품을 조회 
select *
from   goods g
where  not exists  (select 1 from orders o where g.gno = o.gno);



/*
 from 절의 sub query(Inline View)
 - sub query의 수행 결과가 임시 테이블로 사용이 됨. 
*/
-- 평균 급여보다 많이 받는 사원의 모든 정보를 조회
 select * 
 from emp
 where  sal > (select avg(sal) from emp); 


-- 부서별 최저 급여를 받는 사원의 정보 조회 

 

-- 사원이 소속된 부서의 평균 급여보다 많이 받는 사원의 정보를 조회
-- 상호 연관으로 처리 
select *
from   emp e
where  sal > (select avg(sal) 
              from   emp  a
              where  e.deptno = a.deptno);
             

              
              
-- 부서별 최저 임금을 받는 사원의 모든 정보를 조회 
-- 상호 연관 
select *
from   emp e
where  sal <= all (select sal from emp d
                   where e.deptno = d.deptno );



                   
                   
             
/*
 N-top 
 mysql : limit  시작숫자,개수
         시작 숫자는 0부터 
 기타   : rownum
		 시작 숫자는 1부터 
 */

-- 급여가 높은 사원 5명 조회 
-- mysql 
select *
from emp
order by sal desc
limit 0, 5;
              
-- oralce , db, ms-sql             
select  rownum, a.*
from    (select empno, ename, sal
         from   emp
         order  by sal desc) a
where   rownum <=5;    

-- 급여가 높은 사원 6~10위까지 
-- mysql 


-- oralce , db, ms-sql   
select *          
from  ( select  rownum ro, a.*
		from    (select empno, ename, sal
				 from   emp
				 order  by sal desc) a
	   ) 
where   ro between 6 and 10;



-- 이번달에 판매한 상품의 번호, 수량을  많이 판매한 순으로 조회 하시오


-- 판매량이 가장 많은 상품 2개를 조회하여 상품 번호, 상품명
-- , 가격, 총 판매된 수량, 순위를 표시하시오.


-- 이번달에 판매량이 가장 많은 상품 2개를 조회하여 상품 번호, 상품명
-- , 가격, 총 판매된 수량, 순위를 표시하시오.


-- 제품의 판매 금액이 높은 상품 3개를 조회 하시오 


-- category(분류별) 판매 수량 구하기 
-- 분류코드(cno), 분류명(name), 판매수량, 판매 금액을
-- 판매 수량이 높은 순으로 조회하세요      

-- 상품을 기준으로 올해 판매한 상품들을 월별 Pivot테이블 형태로 조회 하시오 

