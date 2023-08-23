create sequence seq_1;

create table info(num number(5) primary key,
name varchar2(20), hp varchar2(20),
age number(3),photo varchar2(100));

insert into info values(seq_1.nextval,'옥동자','010-111-2222',22,'../img/01.png');
insert into info values(seq_1.nextval,'김선범','010-222-3333',23,'../img/02.png');
insert into info values(seq_1.nextval,'김석진','010-444-5555',24,'../img/04.png');
insert into info values(seq_1.nextval,'나영석','010-666-7777',25,'../img/05.png');
insert into info values(seq_1.nextval,'강호동','010-888-9999',26,'../img/07.png');

commit;

//테이블삭제
drop table info;

//테이블 결과 출력
select *from info;

create table team (num number(5) primary key,
name varchar2(20), addr varchar2(50),writeday date);

insert into team values (seq_1.nextval, '길동이','서울시 강남구' , sysdate);
insert into team values (seq_1.nextval, '길서', '서울시 강서구' , sysdate);
insert into team values (seq_1.nextval, '길북이','서울시 강북구' , sysdate);
insert into team values (seq_1.nextval, '길쭉이','서울시 강쭉구' , sysdate);
insert into team values (seq_1.nextval, '길종이','서울시 강종구' , sysdate);

commit;
--굿