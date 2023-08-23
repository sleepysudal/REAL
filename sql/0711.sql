--시퀀스
create sequence seq1;
--테이블(myinfo)
create table myinfo (num number(5) primary key, name varchar2(20), addr varchar2(30), sdate date);



--테이블(myshop)
create table myshop(shopnum number(5) primary key, sangpum varchar2(20),su number(5), price number(5), ipgo date);

select * from myshop;

--시퀀스
create sequence seq_stu;

--테이블(mystudent)
create table mystudent(stu_num number(5) primary key, stu_name varchar2(20), stu_grade number(5), hp varchar2(20), addr varchar2(30), age number(5), sdate date);

select * from mystudent; 
--굳