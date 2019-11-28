create table todolist
(
	no int primary key auto_increment,
    content varchar(200) not null,
	userid varchar(12),
    write_date datetime,
    end_date date,
    done char(1)
);

insert into todolist(content,userid,write_date,end_date,done)
values('할일1','java',now(),current_date()+7,'N');

insert into todolist(content,userid,write_date,end_date,done)
values('할일2','java',now(),current_date()+8,'N');

insert into todolist(content,userid,write_date,end_date,done)
values('할일3','java',now(),current_date()+9,'N');

insert into todolist(content,userid,write_date,end_date,done)
values('공부','ssafy',now(),current_date()+9,'N');

commit;