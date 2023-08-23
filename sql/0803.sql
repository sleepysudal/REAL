--myteam
create table myteam(num number(3) primary key,
tname varchar2(20),
driver varchar2(10),
taddr varchar2(50),
writeday date);

commit;

select * from myteam;


--mymall
create table mymall(no number(3) primary key,
sangpum varchar2(30),
photo varchar2(50),
price number(5),
ipgoday varchar2(20),
writeday date);

commit;

select * from mymall;

drop table mymall;




