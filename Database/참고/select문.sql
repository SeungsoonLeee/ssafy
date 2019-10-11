create table member(
	 id 		varchar(30) primary key
	,password	varchar(30) not null
    ,name		varchar(30) not null
    ,email		varchar(50) 
    ,address	varchar(200)
    ,phone		varchar(15)
);

-- 테이블 구조    desc 테이블이름;
desc member;

insert into member(id, password, name, email, address, phone)
values('jaen','1111','자앤','jaen@andoridjava.com','서울시 서초구','02');

insert into member(id, password, name, email, address, phone)
values('ssafy','1111','싸피','ssafy@andoridjava.com','서울시 강남구','02');

insert into member(id, password, name, email, address, phone)
values('kdg','1111','김동근','kdg@andoridjava.com','서울시 성북구','010');

/**
  select문 
  select [distinct]   *|컬럼명 [as alias]
  from   테이블명 [alias],..
  [where  조건]
  [group by 컬럼명, .. [having 조건]]
  [order by 컬럼명 [asc|desc]], ...]
*/

-- member 테이블의 모든행, 모든 열 정보를 조회
select * from member;

-- member 테이블의 모든 회원의 아이디, 이름 , 이메일을 조회 
select id, name, email 
from   member;

select * from category;

select * from goods;

-- 전체 상품에 대해서 상품번호, 상품명, 가격, 10% 인상한 가격을 조회
select gno, brand, price,  price *1.1 as INC_Price
from goods;

-- where절을 이용해서 조건에 맞는 행만 추출     
-- 조건 연산자   같음 =, 다름 !=  <> , >, >=, <, <=
--            and   or
-- 가격이 5000원 이상이 되는 상품들의 상품번호, 상품명, 가격
select gno, brand, price
from   goods
where  price >= 5000;

-- id가 kdg가 아닌 회원들의 모든 정보 조회 
select * from member
where  id <> 'kdg';

select * from member
where  id != 'kdg';

-- is null     : null인 정보를 조회 
-- is not null : null이 아닌 정보를 조회 

-- 분류 번호가 없는 상품 정보 조회 
select * from goods where cno is null;

-- 분류 번호가 있는 상품들의 모든 정보 조회 
select * from goods where cno is not null;

-- distinct  중복 값 제거 
-- 상품이 있는 분류 번호 조회 
select distinct cno from goods;

-- 가격이 5000원 이상 15000이하인 제품들의 모든 조회 
select * 
from   goods
where  price <= 15000 and price >= 5000 ;

/*
* between  범위 검사 
* 작은값 이상 큰값 이하의 데이타를 조회할 때 사용 
* 형식] 컬럼명 between 작은값 and 큰값
*/

-- 가격이 5000원 이상 15000이하인 제품들의 모든 조회 
select * 
from   goods
where  price between 5000 and 15000;

-- 큰값 and 작은값  => 죄회가 안됨 
select * 
from   goods
where  price between 15000 and 5000;

-- 분류번호(cno)가 10번이거나 20번인 상품들의 상품번호, 이름, 가격, 분류 번호를 조회 
select gno, brand, price, cno
from   goods
where  cno = '10' or cno = '20';

/* in : 열거형 데이타로 조회할 때 
		주어진 데이타 중 하나라도 일치하면 조회 됨. 
   형식]   컬럼명  in (값, 값,...)

   not in 
        주어진 데이타와 모두 일치하지 않으면 조회 됨. 
*/
select gno, brand, price, cno
from   goods
where  cno in ('10','20');

-- 분류번호가 10, 20번이 아닌 상품들을 조회 
select gno, brand, price, cno
from   goods
where  cno!='10' and cno !='20';

select gno, brand, price, cno
from   goods
where  cno not in ('10', '20');

-- 제조사가 LG나 롯데가 아닌 상품들을 조회 
select gno, brand,maker, price, cno
from   goods
where  maker not in ('LG','롯데');

/*
  like  
  - 제공한 조건이 포함되어 있는 데이타를 조회 
  - 대체 문자 (와일드 카드)를 사용해야 한다.
    _ : 한문자를 대체 
    % : 문자 길이 상관 없음
    ex)  '김__'  : 성이 김씨이고 이름이 2자인 사람 조회 
		 '김%'   : 성이 김씨인 모든 사람 조회 
*/

-- 삼성이라는 글자가 들어가 제조사 모든 제품을 조회 
select * 
from   goods
where  maker like '%삼성%';

-- 삼품명이 마우스인 제품들을 조회 
select * 
from   goods
where  brand like '%마우스%';


select * 
from   goods
where  maker not like '%삼성%';

/*
 case ~ when ~ then    : when에 지정된 조건이 참이면 then이 수행됨. 
 형식]
   case  
       when  조건  then 수행할 값, 연산식
       when ...
       else  주어진 조건이 모두 아닌 경우 수행될 값, 연산식
   end    
*/

/* 분류 번호가 10인 경우  음식
   10인 경우 전자제품
   30인 경우 책
   40인 경우 가구  */

select gno, brand, price
      ,case
         when cno='10'  then '음식'
         when cno='20'  then '전자제품'
         when cno='30'  then '책'
         when cno='40'  then '가구'
         else '미분류'
       end as 분류명
from goods;    


/* 
   상품번호, 상품명, 인상전 가격, 인상후 가격을 조회 하시오.	
   가격 인상은 다음과 같다. 
   가격이 10000원 미만이면 15%을 가격을 인상하고 10000원 이상은 10% 가격을 인상하시오
*/

select gno, brand, price as "인상전 가격" -- alias 부여시 공백이 들어간 컬럼명은 ""로 표시
	  ,case
         when  price <10000  then price *1.15
         when  price >=10000 then price *1.1
	   end  as "인상후 가격"
from goods;       

/*
  order by : 정렬
    - 기본적으로 오름 차순으로 정렬 한다. 
    - asc : 오름 차순    desc : 내림 차순 
*/

-- 가격을 기준으로 오름 차순 정렬
select  gno, brand, price
from    goods
order by price;   -- 기본이 오름차순이므로  asc는 생략해도 됨. 

-- 내림 차순
select  gno, brand, price
from    goods
order by price desc; 

-- 분류번호를 기준으로 내림 차순 정렬, 같은 분류내에서는 제품명을 기준으로 오름 차순 
select  gno, brand, price, maker, cno
from    goods
order by cno desc, brand;

/* 
   상품번호, 상품명, 인상전 가격, 인상후 가격을 조회 하시오.	
   가격 인상은 다음과 같다. 
   가격이 10000원 미만이면 15%을 가격을 인상하고 10000원 이상은 10% 가격을 인상하시오
   인상된 가격을 기준으로 오름 차순으로 정렬하시오
*/

select gno, brand, price
	  ,case
         when  price <10000  then price *1.15
         when  price >=10000 then price *1.1
	   end  as INC_price
from goods
order by INC_price asc;






   
