show tables;

-- goods 테이블 속성 조회
desc goods;

-- 컬럼에 연산이나 함수 적용
-- 모든 상품의 상품번호, 상품이름, 가격, 10% 인상된 가격 조회
select gno, brand, price, price * 1.1 as IncPrice
from goods;

/*
where 절 : 조건에 맞는 행만 조회
- 비교 연산자
 =, !=, >, >=, <, <=
- 논리 연산자
 and, or
*/

-- 가격이 5000원 이상인 상품들의 상품번호, 상품명, 가격 조회
select gno, brand, price
from goods
where price >= 5000;

-- 10번에 속하지 않는 상품들의 모든 정보 조회
select *
from goods
where cno != 10;

select *
from goods
where cno <> 10;

/*
is null : null 이니?
in not null : null 이 아니니?
*/
-- 특정 분류에 속하지 않은 상품 정보 조회
select *
from goods
where cno is null;

-- 특정 분류에 속한 상품 정보 조회
select *
from goods
where cno is not null;

-- distict : 중복값 제거
-- 상품이 있는 분류 번호 조회
select distinct cno from goods;

-- 가격이 5000이상 15000원 이하인 제품들 조회
select *
from goods
where price between 5000 and 15000;

-- 분류 번호가 10이거나 20인 상품 조회
select *
from goods
where cno='10' or cno='20';

/*
in : 열거형 데이터 조회 할 때 사용. 주어지 데이터 중 하나라도 일치하면 조회가 가능
*/
select *
from goods
where cno in('10','20');

-- 분류번호가 10, 20번이 아닌 상품 조회
select *
from goods
-- where cno != '10' and cno != '20';
where cno not in('10','20');

/*
like
_ : 한문자 대체
% : 여러문자 대체
*/
-- 모든 마우스 제품 조회
select *
from goods
where brand like '%마우스%';

/*
case ~ when ~ then
 - when : 지정된 조건이 참이면 then 에 지정한 연산식이나 데이터가 처리
 - ANSI Query : 모든 데이터베이스에서 사용하는 표준 쿼리
 case
  when 조건 then 수행할 값, 연산식
  when ...
  else 주어진 조건이 아닌 경우 수행할 값, 연산식
 end
*/
/*
상품 번호, 이름, 가격, 분류 번호, 분류명
분류번호가 10번인 경우 음식
분류번호가 20번인 경우 전자제품
분류번호가 30번인 경우 서적
분류번호가 40번인 경우 가구
분류번호가 없으면 미분류
*/
select gno, brand, price, cno
,case when cno = '10' then '음식'
when cno = '20' then '전자제품'
when cno = '30' then '서적'
when cno = '40' then '가구'
else '미분류'
end as '분류명'
from goods;


/*
상품번호, 상품명, 인상전 가격, 인상 후 가격을 조회
가격이 10000원 미만이면 15%를 인상
가격이 10000원 이상 20만원 이하이면 10%를 인상
가격이 20만원 이상이면 5%를 인상
*/
select gno, brand, price
,case when price < 10000 then price * 1.15
when price <= 200000 then price * 1.1
else price * 1.05
end as IncPrice
from goods;


/*
order by : 데이터 정렬
 - 지정한 컬럼을 기준으로 정렬
 - 기본 : 오름차순
 - asc : 오름차순
 - desc : 내름차순
*/
-- 상품의 모든 데이터를 조회, 가격을 기준으로 오름차순
select *
from goods
order by price;

-- 상품의 모든 데이터를 조회, 가격을 기준으로 내림차순
select *
from goods
order by price desc;

-- 분류 번호 기중으로 내림차순, 같은 분류 내에서는 제품명으로 오름차순
select *
from goods
order by cno desc, brand asc;

-- 인상된 가격 기준으로 오름차순
select gno, brand, price
,case when price < 10000 then price * 1.5
when price <= 200000 then price * 1.1
else price * 1.05
end as IncPrice
from goods
order by IncPrice;

/*
dual table
 - 1개의 열과 1개의 행으로 구성된 더미 테이블
 - 조회는 불가능 하지만 사용은 가능
 - 연산이나 함수를 수행한 결과를 조회하기 위한 용도로 사용(select문으로)
 - 간단한 연산이나 함수를 조회할 때 select 문을 사용하면 from 테이블 수 만큼 처리 결과가 나온다.
*/
-- desc dual;
-- select * from dual;
select 10 * 100 from dual;


