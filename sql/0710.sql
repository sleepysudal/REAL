--0710 문제
--q1.emp에서 ename을 empname으로 바꾸세요
alter table emp rename column ename to empname;
--q2. gift에서 7번 노트북을 아이패드로 바꾸세요
update gift set gname = '아이패드' where gno=7;
--q3. gift에서 10번 아이폰 900001~1000000 한행을 추가하세요
insert into gift values (10,'아이폰',900001,1000000);
--q4 member에서 1003 서새알 멤버를 삭제하시오
delete from member where no=1003 and name='서새알';
--q5 emp에서 입사일이 82/01/23인 사원의 이름,부서번호, 급여를 출력하시오
select empname 사원명,deptno 부서번호, sal 급여 
from emp 
where hiredate ='82/01/23'; 
--q6 emp에서 직무별로 최대급여,최소급여,총급여,평균 급여를 출력하시오
select  job 직무, max(sal) 최대급여, min(sal) 최소급여, sum(sal)총급여,avg(sal) 평균급여
from emp
group by job;


--Join

--1. emp와 dept를 조인해서 emp사람들의 부서명을 구해보자
--사원명 부서명 

--1
select e.empname,d.dname
from emp e,dept d
where e.deptno=d.deptno;

--2
select empname,dname --테이블의 고유명일 경우 e.d. 생략가능
from emp e,dept d
where e.deptno=d.deptno;

--student 와 professor 를 조인하여 다음과 같이 출력하시오
select s.studno 학번,s.name 학생명, p.name 교수명
from student s,professor p
where s.profno=p.profno;

--학번 학생명 제1전공명 제2전공명
select s.studno 학번, s.name 학생명, d.dname 제1전공명
from student s, department d
where s.deptno1=d.deptno; 

--교수명 직급 학과명
select p.name 교수명, p.position 직급, d. dname학과명
from professor p,department d
where p.deptno = d.deptno;

--사원번호 사원명 근무도시 
--e1111 smtih newyork
select e.empno 사원번호, e.empname 사원명 , d.loc 근무도시
from emp e, dept d
where e.deptno=d.deptno;

--판매테이블
--판매일자 과자명 전체판매액
select pan.p_date 판매일자, pro.p_name 과자명, pan.p_total 전체판매액
from product pro, panmae pan 
where pro.p_code=pan.p_code;

--primary 키와 forign키를 생성한 조인테이블 (부모,자식) 만들어보기

--시퀀스
create sequence seq_shop;

--shop 테이블 (부모)
create table shop(shop_num number(5) primary key,
sangname varchar2(30),color varchar2(20));

--5개의 상품추가
insert into shop values(seq_shop.nextval, '요가매트','pink');
insert into shop values(seq_shop.nextval, '신라면','red');
insert into shop values(seq_shop.nextval, '삼양라면','blue');
insert into shop values(seq_shop.nextval, '진라면','mint');
insert into shop values(seq_shop.nextval, '사노라면','purple');
commit;


--cart1... 상품정보는 shop 테이블의 shop_num값을 외부키로 지정
create table cart1(idx number(5) primary key,
shop_num number(5) constraint cart_fk_shopnum references shop(shop_num), 
cnt number(5), guipday date);
--cart2 ...상품정보는 shop테이블의 shop_num값을 외부키로 지정
--부모테이블의 상품을 지우면 그상품과 연결된 카트를 자동으로 지워준다
create table cart2(idx number(5) primary key,
shop_num number(5) REFERENCES shop(shop_num) on delete CASCADE,
cnt number(5), guipday date);

--cart1에 상품추가_1번
insert into cart1 values(seq_shop.nextval,1,2,sysdate);
insert into cart1 values(seq_shop.nextval,3,4,sysdate);
insert into cart1 values(seq_shop.nextval,2,1,sysdate);
insert into cart1 values(seq_shop.nextval,4,3,sysdate);
insert into cart1 values(seq_shop.nextval,5,5,sysdate);

delete from cart1 where shop_num=3;
delete from cart1 where shop_num=4;

--cart2에 상품추가_2번
insert into cart2 values(seq_shop.nextval,5,1,sysdate);
insert into cart2 values(seq_shop.nextval,4,2,sysdate);
insert into cart2 values(seq_shop.nextval,3,3,sysdate);
insert into cart2 values(seq_shop.nextval,2,4,sysdate);
insert into cart2 values(seq_shop.nextval,1,5,sysdate);

delete from cart2 where shop_num=4;
commit;


--cart1: 부모 1,2,5 존재 cart2: 부모 1,2,3,5 존재
--shop의 1번 상품 삭제?
--무결성 제약조건(SUDAL.CART_FK_SHOPNUM)이 위배되었습니다- 자식 레코드가 발견되었습니다
delete from shop where shop_num=1;

--cart2에서 3번 데이터 지워보자
--ON DELETE CASCADE 때문에 제약없이 삭제가된다.
--외부키로 테이블이 연결되어있다 하더라도
--부모테이블의 데이타를 삭제하면 자식테이블의 데이타까지도 자동으로
--삭제시켜주는 기능이다.

delete from cart2 where shop_num=3;
rollback;


--cart1에 담긴 상품을 shop테이블과 join해서 자세히 출력
select c1.idx,s.shop_num,s.sangname,s.color,cnt,c1.guipday
from cart1 c1,shop s
where c1.shop_num = s.shop_num;

--방법2
select idx,s.shop_num,sangname,color,cnt,guipday
from cart1 c1,shop s
where c1.shop_num = s.shop_num;

--시퀀스
create sequence seq_menu;

--부모테이블
create table menu(m_num number(5) primary key,
m_name varchar2(30),price varchar2(20));

--부모테이블에 음식추가
insert into menu values(seq_menu.nextval, '짜장면',5000);
insert into menu values(seq_menu.nextval, '짬뽕',6000);
insert into menu values(seq_menu.nextval, '볶음밥',7000);
insert into menu values(seq_menu.nextval, '탕수육',15000);
insert into menu values(seq_menu.nextval, '깐쇼새우',25000);
commit;

--자식테이블(자식테이블에 연결된 부모가 있어도 부모를 삭제할수있으며 부모테이블 삭제시 자동으로 자식삭제)
create table myorder(o_num number(5) primary key,
m_num number(5) REFERENCES menu(m_num) on delete CASCADE,
cnt number(5), o_date date);

--음식주문
insert into myorder values(seq_menu.nextval,1,2,sysdate);
insert into myorder values(seq_menu.nextval,2,4,sysdate);
insert into myorder values(seq_menu.nextval,3,6,sysdate);
insert into myorder values(seq_menu.nextval,4,3,sysdate);
insert into myorder values(seq_menu.nextval,5,1,sysdate);

commit;

--최종출력
--주문번호 음식명 가격 개수 주문일자
select my.m_num 주문번호, m_name 음식명, price 가격 , cnt 개수, o_date 주문일자
from menu m, myorder my
where m.m_num = my.m_num;


select * from shop;
select * from cart1;
select * from cart2;
select * from menu;
select * from myorder;

---------------------------------------------------------------------
create table board(bno number(3) constraint board_pk_bno primary key,
writer varchar2(20),
subject varchar2(100),
writeday date);

--board에 5개 insert
insert into board values(seq_sawon.nextval,'일길동','아버지',sysdate);
insert into board values(seq_sawon.nextval,'이길동','나를',sysdate);
insert into board values(seq_sawon.nextval,'삼길동','낳으시고',sysdate);
insert into board values(seq_sawon.nextval,'사길동','바지적삼',sysdate);
insert into board values(seq_sawon.nextval,'오길동','다적시셧네',sysdate);
commit;

--answer라는 댓글(자식)
--부모글지우면 자식글 자동삭제되게
create table answer (num number(5) constraint answer_pk_num primary key,
bno number(3) constraint answer_fk_bno references board(bno) on delete cascade,
nickname varchar2(20), content varchar2(30), writeday date);


--원하는 글에 댓글 추가하기
insert into answer values(seq_sawon.nextval, 66,'영지니','효지나 나오늘 못나가',sysdate);
insert into answer values(seq_sawon.nextval, 67,'가지니','가지나 나오늘 못나가',sysdate);
insert into answer values(seq_sawon.nextval, 68,'나지니','나지나 나오늘 못나가',sysdate);
insert into answer values(seq_sawon.nextval, 69,'다지니','다지나 나오늘 못나가',sysdate);
insert into answer values(seq_sawon.nextval, 70,'라지니','라지나 나오늘 못나가',sysdate);


--join으로 출력
--원글번호 작성자 작성자글 댓글단사람 댓글내용 원글날짜 댓글날짜
select b.bno 원글번호, writer 작성자, subject 작성자글, nickname 댓글단사람,content 댓글내용,b.writeday 원글날짜, a.writeday 댓글날짜
from board b, answer a
where b.bno = a. bno;

--66번 원글
delete from board where bno=66;

commit;

--board를 먼저삭제 (외래 키에 의해 참조되는 고유/기본 키가 테이블에 있습니다)
drop table board;

--자식
drop table answer;

--shop,cart 모두 삭제
--외부키로 연결이 된경우 자식테이블 먼저 삭제후 부모 테이블 삭제가능
drop table cart1;
drop table cart2;
drop table shop;

---------------------------------------------------------------------------------------------
--시퀀스 생성
create sequence seq_food;
--부모 생성
create table food(fno number(5) primary key,
foodname varchar2(20),
price varchar2(30),
shopname varchar2(40),
loc varchar2(50));
--부모값 입력
insert into food values(seq_food.nextval, '짜장면',5000,'A','서울');
insert into food values(seq_food.nextval, '짬뽕',6000,'B','경기도');
insert into food values(seq_food.nextval, '볶음밥',7000,'C','충청도');
insert into food values(seq_food.nextval, '탕수육',15000,'D','강원도');
insert into food values(seq_food.nextval, '깐쇼새우',25000,'E','전라도');
--자식생성
create table jumun(num number(5) primary key,
fno number(5) REFERENCES food(fno) on delete CASCADE,
name varchar2(20),
addr varchar2(30));
--자식값 입력
insert into jumun values(seq_food.nextval, 1,'하지니','성북구');
insert into jumun values(seq_food.nextval, 2,'가지니','종로구');
insert into jumun values(seq_food.nextval, 3,'나지니','중구');
insert into jumun values(seq_food.nextval, 4,'다지니','강남구');
insert into jumun values(seq_food.nextval, 5,'라지니','강북구');
--최종출력
select f.fno 주문번호, name 주문자, foodname 음식명, to_char(price,'999,999l') 가격, shopname 상호명, loc 가게위치, addr 주문자주소
from food f, jumun j
where f.fno = j. fno
order by name asc;

Select * from food;
select * from jumun;
commit;

--지나갑니다

--------------------------------------------------------------
--시퀀스
create sequence seq_board;
--테이블
create table snsboard(b_num number(10) primary key,
nick varchar2(20),
subject varchar2(30),
content varchar2(40),
wday date);

--부모값
insert into snsboard values(seq_board.nextval, '가','1','A',sysdate);
insert into snsboard values(seq_board.nextval, '나','2','B',sysdate);
insert into snsboard values(seq_board.nextval, '다','3','C',sysdate);
insert into snsboard values(seq_board.nextval, '라','4','D',sysdate);
insert into snsboard values(seq_board.nextval, '마','5','E',sysdate);
insert into snsboard values(seq_board.nextval, '바','6','F',sysdate);
insert into snsboard values(seq_board.nextval, '사','7','G',sysdate);
insert into snsboard values(seq_board.nextval, '아','8','H',sysdate);
insert into snsboard values(seq_board.nextval, '자','9','I',sysdate);
insert into snsboard values(seq_board.nextval, '차','10','J',sysdate);
COMMIT;

select b_num 기본키,nick 작성자닉네임,subject 제목,content 내용, wday 현재날짜
from snsboard;