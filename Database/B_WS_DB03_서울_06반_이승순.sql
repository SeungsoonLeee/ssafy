-- 3. emp와 dept Table을 JOIN하여 이름, 급여, 부서명을 검색하세요.
select ename, sal, dname
from emp as e left join dept as d
on e.deptno = d.deptno;

-- 4. 이름이 ‘KING’인 사원의 부서명을 검색하세요.
select dname
from dept
where deptno = (select deptno from emp where ename = 'KING');

-- 5. dept Table에 있는 모든 부서를 출력하고, emp Table에 있는 DATA와 JOIN하여 모든 사원의 이름, 부서번호, 부서명, 급여를 출력 하라.
select dname from dept;
select ename, e.deptno, dname, sal
from emp e left join dept d
on e.deptno = d.deptno;

-- 6. emp Table에 있는 empno와 mgr을 이용하여 서로의 관계를 다음과 같이 출력되도록 쿼리를 작성하세요. ‘SCOTT의 매니저는 JONES이다’
select ename
from emp
where mgr = (select empno from emp where ename='JONES');

-- 7. 'SCOTT'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 검색하세요.
select ename, dname, sal, job
from emp e join dept d
on e.deptno = d.deptno
where e.job = (select job from emp where ename='SCOTT');

-- 8. 'SCOTT’가 속해 있는 부서의 모든 사람의 사원번호, 이름, 입사일, 급여를 검색하세요.
select empno, ename, hiredate, sal
from emp e join dept d
on e.deptno = d.deptno
where e.deptno = (select deptno from emp where ename='SCOTT');

-- 9. 전체 사원의 평균급여보다 급여가 많은 사원의 사원번호, 이름,부서명, 입사일, 지역, 급여를 검색하세요.
select empno, ename, dname, hiredate, loc, sal
from emp e left join dept d
on e.deptno = d.deptno
where e.sal > (select avg(sal) from emp);

-- 10. 30번 부서와 같은 일을 하는 사원의 사원번호, 이름, 부서명,지역, 급여를 급여가 많은 순으로 검색하세요.
select ename, dname, loc, sal
from emp e left join dept d
on e.deptno = d.deptno
where e.job in (select job from emp where deptno = '30')
order by sal desc;

-- 11. 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일, 지역을 검색하세요.
select empno, ename, dname, hiredate, loc
from emp e left join dept d
on e.deptno = d.deptno
where e.deptno = 10 and e.job not in (select job from emp where deptno = 30);

-- 12. ‘KING’이나 ‘JAMES'의 급여와 같은 사원의 사원번호, 이름,급여를 검색하세요.
select empno, ename, sal
from emp
where sal in (select sal from emp where ename in ('KING','JAMES'));

-- 13. 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호,이름, 급여를 검색하세요.
select empno, ename, sal
from emp
where sal > (select max(sal) from emp where deptno = 30);

-- 14. 이름 검색을 보다 빠르게 수행하기 위해 emp 테이블 ename에 인덱스를 생성하시오.
create index idx_emp_ename on emp(ename);

-- 15. 이름이 'ALLEN'인 사원의 입사연도가 같은 사원들의 이름과 급여를 출력하세요.
select ename, sal
from emp
where date_format(hiredate, '%y') = (select date_format(hiredate, '%y') from emp where ename='ALLEN');

-- 16. 부서별 급여의 합계를 출력하는 View를 작성하세요.
create view empview
as select deptno, sum(sal) as sumSal
from emp
group by deptno;

select * from empview;
drop view empview;

-- 17. 16번에서 작성된 View를 이용하여 부서별 급여의 합계가 큰 1~3순위를 출력하세요.
select *
from empview
order by sumSal desc
limit 0, 3;
