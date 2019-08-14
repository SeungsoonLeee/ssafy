select floor(3.14), ceil(3.1), round(3.1), round(3.5)
from dual;

-- 인상된 가격 기준으로 오름차순, 소수점 1자리까지 반올림
select gno, brand, price
,round(case when price < 10000 then price * 1.5
when price <= 200000 then price * 1.1
else price * 1.05
end, 1) as IncPrice
from goods
order by IncPrice;


/*
문자열 연결
 concat ('문자열', '문자열', '문자열', . . .) : 주어진 문자열을 하나로 연결
*/
select concat(brand, ' 상품은 ', maker, ' 제조사에서 생산') as str
from goods;


/*
문자열 추출
 left ('문자열', 추출할 갯수) : 왼쪽부터 지정한 개수까지 문자열 추출
 right ('문자열', 추출할 갯수) : 오른쪽부터 지정한 개수까지 문자열 추출
 substring ('문자열', 시작 위치, 추출할 개수) : 시작 위치부터 지정한 개수까지 문자열 추출(시작위치는 1부터 시작)
*/
select brand, right(brand, 2), left(brand, 2), substr(brand, 1, 3), substring(brand, 1, 3)
from goods;


-- repeat('문자열', 수) : 문자열을 지정한 수 만큼 반복
select repeat(brand , 2)
from goods;


-- length() : 문자열 길이
-- reverse() : 문자열 거꾸로
-- uppder() : 대문자로
-- lower() : 소문자로
select length('hello'), reverse('hello'), upper('hello'), lower('HELLO')
from dual;


/*
공백 삭제
 rtrim('문자열') : 오른쪽 공백 삭제
 ltrim('문자열') : 왼쪽 공백 삭제
 trim('문자열') : 양쪽 공백 삭제
*/
select rtrim('   hello   '), ltrim('   hello   '), trim('   hello   ')
from dual;


/*
 if(논리식, 참일 때, 거짓일 때) : mySQL 조건문
 decode(논리식, 참일 때, 거짓일 때) : Oracle 조건문, decode는 이어서 이중 조건 처리 가능
*/
select gno, brand, price
, if(price < 10000, price * 1.15
, if(price <= 200000, price * 1.1, price * 1.05)) as IncPrice
from goods
order by IncPrice;


select gno, brand, price, cno
, if(cno = 10, '음식'
, if(cno = 20, '전자 제품'
, if(cno = 30, '서적'
, if(cno = 40, '가구', '미분류')))) as '분류'
from goods;


/*
null을 검사하는 if 조건문
ifnull(문자 or colums, 대체 정보) : 데이터가 null이면 대체 정보 삽입
*/
select gno, brand, if(cno is null, '미분류', cno) as cno
from goods;

select gno, brand, ifnull(cno, '미분류') as cno
from goods;

-- coalesce(값1, 값2, 값3, ..., 대체 정보) : 값들 중 처음으로 null이 아닌 값을 반환
select gno, brand, coalesce(cno, '미분류') as cno
from goods;

select gno, brand, coalesce(image, cno, '미분류') as cno
from goods;




-- 오늘 날짜 추출
select now(), sysdate(), current_timestamp(), curdate(), curtime()
from dual;

/*
날짜 계산(년월일)
 data_add(날짜, interval 값 기준값) or adddate(날짜, interval 값 기준값)
 data_sub(날짜, interval 값 기준값) or subdate(날짜, interval 값 기준값)
 기준값 : year, month, day, hour, minute, second
 
 Oracle 날짜 난술연산 수(일)
 달 연산 add_month(날짜, 숫자(달))
*/

select adddate(sysdate(), interval 1 day) as 내일
, subdate(sysdate(), interval 1 day) as 어제
, adddate(sysdate(), interval 1 month) as  다음달
, subdate(sysdate(), interval 1 month) as 지난달
from dual;


select year(sysdate()) as '올해'
,month(sysdate()) as '이번달(숫자)'
,monthname(sysdate()) as '번달(영어)'
,day(sysdate()) as '오늘(숫자)'
,dayname(sysdate()) as '오늘'
from dual;

-- dayofyear(날짜) : 1월 1일부터 해당 날짜까지 날 수
select dayofyear(sysdate()) from dual;


/*
*/


/*
group(aggregation) 함수
 - 지정한 group에 함수 기능을 처리하여 1개의 데이터가 조회.
 - group의 수와 다른 데이터를 조회하면 mySQL은 의미 없는 데이터로 결과 조회, 다른 db는 error 발생
 - group by로 그룹을 지정하지 않으면 전체 데이터가 1개의 group으로 지정
 max() : null을 제외한 그룹내의 모든 데이터를 처리하여 반환
 min()
 avg()
 sum()
 count(*) : null을 포함한 모든 행의 수를 반환
 count(컬럼명) : null을 제외한 컬럼 행의 수를 반환
*/
select count(*), count(cno), max(price), min(price), avg(price), sum(price)
from goods;


-- cno별 상품 개수, 최고가 최저가, 평균 가격 조회
select cno, count(*), max(price), min(price), avg(price)
from goods
group by cno;