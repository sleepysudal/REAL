create table ajaxboard (num number(3) primary key,
writer varchar2(20), subject varchar2(100), story varchar2(1000),
avata varchar2(50), writeday date);

commit;

drop table ajaxboard;
create sequence seq_1;

insert into ajaxboard values(seq_1.nextval,'해리','오늘영화보실분','오늘쿠폰이 지급됩니다','../avata/b1.png',sysdate);

select * from ajaxboard;

