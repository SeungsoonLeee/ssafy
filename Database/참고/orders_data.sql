insert into orders (odate, id, gno, quantity, address)
values( '20180818', 'ssafy', 2 , 1 ,'나주');
insert into orders (odate, id, gno, quantity, address)
values( '20180818', 'jaen', 4 , 2 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( '20180111', 'ssafy', 4 , 2 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( '20180115', 'ssafy', 1 , 20 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( '20180130', 'jaen', 2 , 20 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( '20180131', 'ssafy', 3 , 100 ,'나주');
insert into orders (odate, id, gno, quantity, address)
values( '20180212', 'jaen', 4 , 10 ,'나주');
insert into orders (odate, id, gno, quantity, address)
values( '20180322', 'jaen', 4 , 10 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( DATE_SUB(SYSDATE(), INTERVAL 3 MONTH ), 'ssafy', 1 , 40 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( DATE_SUB(SYSDATE(),INTERVAL 2 MONTH ), 'jaen', 4 , 2 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( DATE_SUB(SYSDATE(),INTERVAL 2 MONTH), 'jaen', 2 , 2 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( DATE_SUB(SYSDATE(),INTERVAL 1 MONTH), 'ssafy', 1 , 1 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( DATE_SUB(SYSDATE(), INTERVAL 1 MONTH), 'ssafy', 2 , 2 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( sysdate(), 'jaen', 1 , 1 ,'서울');
insert into orders (odate, id, gno, quantity, address)
values( sysdate(), 'ssafy', 2 , 2 ,'서울');