create table category(
	cno  char(2) primary key,
  name varchar(50)
);

-- category data ----------------------------- 
insert into category (cno, name) values('10','음식');
insert into category (cno, name) values('20','전자제품');
insert into category (cno, name) values('30','책');
insert into category (cno, name) values('40','서적');

create table goods(
gno   int auto_increment primary key,
brand varchar(100) not null,
price int          default 0,
maker varchar(50),
image varchar(50),
info  varchar(300),
cno		char(2),
foreign key fk_goods_cno(cno) references category(cno)
);

-- goods data ----------------------------- 
insert into goods (brand, price, maker, image, info, cno)
values('목캔디', 1200,'롯데', 'throatCandy.png','목아플때 먹는','10');
insert into goods (brand, price, maker, image, info, cno)
values('마우스', 9700,'LG', 'lgMouse.png','컴퓨터 입력장치','20');
insert into goods (brand, price, maker, image, info, cno)
values('태양의 마테차', 1700,'코카콜라', 'sun.png','다이어트할 때 좋아요','10');
insert into goods (brand, price, maker,cno)
values('울트라북', 1500000,'삼성','20');
insert into goods (brand, price, maker,  image)
values('이것이 자바다', 30000,'한빛미디어','java.png');
insert into goods (brand, price, maker,  image, cno)
values('오후에 마시는 마테차', 9000,'동글실업','afternoonTea.png', 10);
insert into goods (brand, price, maker,  image, cno)
values('usb 마우스', 12000,'삼성전자','usbmouse.png', 20);
insert into goods (brand, price, maker,  image, cno)
values('사무용 데스크', 85000,'PATRA','par_desk.png', 40);
