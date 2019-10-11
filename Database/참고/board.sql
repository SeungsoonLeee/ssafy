-- 게시판 (board)
create table board(
  no        int  primary key,					-- 게시물 번호
  id        varchar(30),						-- 작성자 id
  title     varchar(200),						-- 제목
  regdate   datetime default CURRENT_TIMESTAMP,	-- 작성일
  contents  varchar(3000),						-- 내용
  foreign key fk_board_id (id) references member(id)
);
-- 게시물에 올린 파일 정보(boardfile)
create table boardfile(
  no       		int auto_increment primary key,	-- 파일 번호
  rfilename		varchar(100),					-- 사용자가 올린 파일 이름
  sfilename     varchar(100),					-- 시스템에 저장된 파일 이름
  bno           int,							-- 게시물 번호
  foreign key fk_boardfile_bno (bno) references board(no)   on delete cascade
);

select * from member;

-- board data ----------------------------- 
insert into board(no, id, title, regdate, contents)
values(1,'jaen','hello', now(), '처음하는 게시판');
insert into board(no,id, title, regdate, contents)
values(2, 'jaen','hello', sysdate(), '처음하는 게시판');
insert into board(no,id, title, regdate, contents)
values(3, 'ssafy','mysql이란?', sysdate(), '데이타 베이스의 한 종류이면서 공짜야');
insert into board(no,id, title, regdate, contents)
values(4, 'ssafy','hello world', sysdate(), '잘되나?');
