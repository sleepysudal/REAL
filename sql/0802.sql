create table myfood(num number(3) primary key,
foodname varchar2(20), foodphoto varchar2(50),
price number(5), cnt number(5)); 

insert into myfood values(seq_food.nextval, '에그샌드위치' , '../Food/1.jpg',1000,1);
insert into myfood values(seq_food.nextval, '꼬치구이','../Food/2.jpg',2000,2);
insert into myfood values(seq_food.nextval, '육개장','../Food/3.jpg',3000,3);
insert into myfood values(seq_food.nextval, '비프스튜','../Food/4.jpg',4000,4);
insert into myfood values(seq_food.nextval, '콘치즈','../Food/5.jpg',5000,5);

create table shop(num number(3) primary key,
sangpum varchar2(20),
color varchar2(20),
price number(5), imgname varchar2(50));

insert into shop values(seq1.nextval, '원피스', 'red',10000,'../img/01.png');
insert into shop values(seq1.nextval, '투피스', 'orange',20000,'../img/02.png');
insert into shop values(seq1.nextval, '쓰리피스', 'yellow',30000,'../img/03.png');
insert into shop values(seq1.nextval, '포피스', 'green',40000,'../img/04.png');
insert into shop values(seq1.nextval, '파이브피스', 'blue',50000,'../img/05.png');
/////////////////////////////////////////////////////////////////////////////////////
create table myfriend(num number(3) primary key,
fname varchar2(20), fhp varchar2(50),
faddr varchar2(50), gaipday date);

insert into myfriend values(seq1.nextval, '김선범','010-123-4567','서울시',sysdate);
insert into myfriend values(seq1.nextval, '남궁선범','010-234-7842','경기도',sysdate);
insert into myfriend values(seq1.nextval, '박선범','010-1321-4352','제주도',sysdate);
insert into myfriend values(seq1.nextval, '황선범','010-7897-123','경상북도',sysdate);
insert into myfriend values(seq1.nextval, '장선범','010-2358-4562','강원도',sysdate);

///////////////////////////////////////////////////////////////////////////////

create table sinsang(num number(5) primary key,
name varchar2(20),
addr varchar2(30),
sdate date);

insert into sinsang values(seq_1.nextval, '김선범', '강남구 논현시',sysdate);

commit;
--커밋은 필수