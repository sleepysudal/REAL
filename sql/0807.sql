create table memo(num number(3) primary key,
writer varchar2(20),
story varchar2(1000),
avata varchar2(50),
writeday date);

commit;

select * from memo;
drop table memo;
create sequence seq1;

insert into memo values(seq1.nextval,'김석진','돌아와','../avata/b1.png',sysdate);
commit; 
--커밋필수
--0808 어렵다 ㅠ

