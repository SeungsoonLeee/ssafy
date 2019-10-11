/*
   데이타를 특정 컬럼의 데이타를 기준으로 group을 나눠서 group함수적용
   group by 컬럼명    지정한 컬럼의 데이타를 분류해서 group을 생성 
*/
select cno, count(*), avg(price)
from   goods
group by cno;

-- 부서별 급여 평균과, 최소 급여, 최대 급여를 조회 
select deptno, round(avg(sal),2), min(sal), max(sal)
from   emp
group by deptno;

-- 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회 
select job, count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by job ; 


/* havaing  
   - group의 값으로 조건 
   - 형식]  group by  컬럼, ...
           havaing   조건 
           
   where => 행 하나 하나에 대한 조건 처리         
*/

-- 업무별 급여 평균이 2500이상이 업무 조회 
select job, round(avg(sal),2) as avgSal
from   emp
group  by job
having avg(sal)>=2500;

-- 카테고리별 가격 평균을 조회 단, 가격 평균이 500000이상인 카테고리는 제외하고 조회한다. 
select cno, round(avg(price),2) as avgPrice
from   goods
group  by cno
having avg(price)<500000;

-- 급여가 1500이상인 사원들의 부서별 급여 평균을 조회
-- 단 급여 평균이 2000이상인 부서만 조회 

select deptno,  round(avg(sal),2) as avgPrice
from   emp
where  sal >= 1500
group by deptno
having avg(sal) >=2000;


/*rollup :group별 통계에  전체 통계를 추가로 조회 
  형식] group by 컬럼명 with rollup;
 */
-- 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회
select job, count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by job with rollup;

/**oralce 버전
select ifnull(job,'total'), count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by rollup(job);
*/

/*grouping()
  rollup에 의해 조회된 데이타는 1 그렇지 않은 데이타는 0이 조회된다. 
*/
select cno, grouping(cno), round(avg(price),2) as avgPrice
from   goods
group  by cno with rollup;

-- cno가 null인 경우 미분류로 표시, 그렇지 않으면 카테고리 번호로 표시 
-- rollup에 의해 null인 경우 total 
select if(grouping(cno)=1, 'total', ifnull(cno,'미분류')) as cno
	 , round(avg(price),2) as avgPrice
from   goods
group  by cno with rollup;   


-- 부서별, 업무별 근무 인원, 급여 평균과, 최소 급여, 최대 급여를 조회 
select deptno, job, count(*), round(avg(sal),2), min(sal), max(sal)
from   emp
group by deptno, job with rollup
order by deptno ;

insert into emp (empno, job, sal) values(1111,'ANALYST', 3000);

/* 부서별 업무별 평균 급여를  Pivot  table로 표시 */
select if(grouping(deptno)=1, '전체통계', ifnull(deptno,'신입사원')) as deptno
	 , ifnull(round(avg(if( job='CLERK',sal,null)),2),0) as CLERK
     , ifnull(round(avg(if( job='MANAGER',sal,null)),2),0) as MANAGER
     , ifnull(round(avg(if( job='PRESIDENT',sal,null)),2),0) as PRESIDENT
     , ifnull(round(avg(if( job='ANALYST',sal,null)),2),0) as ANALYST
     , ifnull(round(avg(if( job='SALESMAN',sal,null)),2),0) as SALESMAN
     , round(avg(sal),2) as JobTotal
from   emp
group by deptno with rollup
order by deptno ;









