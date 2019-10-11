create table product(
	no int primary key
	,name varchar(50)
	,price int
	,count int
	,description varchar(500)
);

insert into product values(1, '귤', 3000, 20, '');
insert into product values(2, '사과', 1500, 10, '');
insert into product values(3, 'TV', 2000000, 5, '');
insert into product values(4, '노트북', 1000000, 10, '');
insert into product values(5, '휴지', 1000, 80, '');

select name, price * 0.85 as salePrice from product;

update product set price = price * 0.8 where name like '%TV%';
select * from product;

select sum(price) as totalPrice from product;