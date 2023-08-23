--emp테이블에서 ename만 조회하시오
Select ename from emp;
--emp테이블에서 이름과 직업만 조회하시오
Select ename, job from emp;
--emp테이블 전체 조회하시오
select * from emp;
--student테이블 전체 조회
select * from student;
--표현식
select name, '지금실습중' from student;
--컬럼 별칭 allias출력
select name "이름",grade as "학년",birthday 생일 from student;
--emp에서 사원명, 직업, 입사일자를 조회하시오 
select ename 사원명, job as "직업", hiredate 입사일자 from emp;
--DISTINCT: 중복된 값을 제거하고 출력하기
select DISTINCT job "직 업 군" from emp;
--emp에서 부서번호를 중복없이 출력하기
select DISTINCT DEPTNO "부서번호" from emp;
--합성 연산자: 컬럼을 붙혀서 출력
select name || grade "학년별 학생명" from student;
--professor 조회
select * from professor;
--하나의 컬럼으로 출력_조인형 님은 정교수입니다
select name||'님은' ||position||'입니다'from professor;
--emp에서 smith님의 job은 clerk 입니다 
select ename ||'님의 job은'|| job||'입니다' from emp;
--student에서 서진수님의 키는 180cm, 몸무게는 72kg입니다
select name ||'님의 키는'||height||'cm, 몸무게는'||weight||'kg입니다' from student;
--emp에서 내직업은 salesman이고 연봉은 ***입니다
select '내직업은'||job||'이고 연봉은'||sal||'입니다' from emp; 
--정렬
--student에서 학생명 학년 생일을 학생명의 오름차순으로 조회하시오
select name 학생명, grade 학년, birthday 생일 from student order by name asc;--생략가능
select name 학생명, grade 학년, birthday 생일 from student order by birthday;

--emp에서 사원명,직업,급여를 급여가 낮은사람 순으로 조회하세요
select ename 사원명, job 직업, sal 급여 from emp order by 3 desc;--컬럼번호로도 정렬가능

--emp에서 직업군을 중복없이 출력하고 직업군의 오름차순으로 출력하시오
select DISTINCT job 직업군 from emp order by job;

--산술연산자
--emp에서 sal에 특별보너스 100을 더하여 출력하시오
select ename 사원명, sal 기본급, sal+100 특별보너스 from emp;

--where절 : 조건
--emp에서 10번 부서에 근무하는 사람의 사원명, 급여와 부서번호를 출력하세요
select ename 사원명, sal 급여, deptno 부서번호 from emp where deptno=10;
--emp에서 이름이 king인 사람의 사원명,직업을 조회하시오
select ename 사원명, job 직업 from emp where ename='KING';
--emp에서 급여가 3000이상인 사람의 사원명 급여를 조회하시오
select ename 사원명, sal 급여 from emp where sal>=3000; 
--학생테이블에서 키가 180cm이상인 학생명과 키를 출력하시오
select name 학생명, height 키 from student where height>=180;
--학생테이블에서 키가 160부터 180사이인 학생명과 키를 출력 : between a and b(작은숫자부터)
select name 학생명, height 키 from student where height between 160 and 180 order by height;
--in(a,b) : a,b만 조회
--emp에서 deptno가 20,30인 사람들의 사원명과 부서번호를 조회하시오
select ename 사원명, deptno 부서번호 from emp where deptno in(20,30);
--null 값만 출력
--emp에서 comm이 null인 사람의 이름과 보너스를 출력하시오
select ename 사원명, comm 보너스 from emp where comm is null;
--emp에서 comm이 null이 아닌사람의 이름과 보너스를 출력하시오
select ename 사원명, comm 보너스 from emp where comm is not null;

--NVL : null 값 0으로 바꾸기 _연산이 목적
select ename 사원명, nvl(comm,0) 보너스 from emp;

--LIKE 연산자
--학생테이블에서 김씨만 조회하여 모든열을 출력하시오
select *from student where name like '김%';
--학생테이블 총 몇명? 괄호안에는 컬럼 넣어주는데 대부분 * 넣어줌
select count(*)cnt from student;
--emp에서 job이 salesman, manager인 사원명, 직업군만 출력하시오(or in 연산자)
select ename 사원명,job 직업군 from emp where job = 'SALESMAN' or job='MANAGER';
select ename 사원명, job 직업군 from emp  where job in ('SALESMAN' , 'MANAGER');
--emp에서 급여가 2000~3000인 사원명, 직업군, 급여를 출력하세요(and between연산자)
select ename 사원명, job 직업군 , sal 급여 from emp where sal >=2000 and sal <=3000;
select ename 사원명, job 직업군 , sal 급여 from emp where sal between 2000 and 3000;

--퀴즈 : student 테이블에서 1학년 학생의 학생명,키를 출력하시오 (단 키가 작은순)
select name 학생명, height 키 from student where grade=1 order by height desc;
--퀴즈 : student 테이블에서 2학년 학생의 학생명 생일 키 몸무게를 출력하시오(단 생일이 빠른 사람 순서)
select name 학생명, birthday 생일, height 키, weight 몸무게 from student where grade=2 order by birthday;
--퀴즈 : professor에서 교수들의 이름중 조 씨성을 가진 교수의 교수명 직위 입사일자를 출력하시오
select name 교수명, position 직위, hiredate 입사일자 from professor where name LIKE '조%';
--퀴즈 emp에서 사원명, 급여 , 급여*12 , 보너스, 급여총계를 구하시오
select ename 사원명, sal 급여, sal*12 "급여*12", NVL(comm,0) 보너스, (sal*12)+NVL(comm,0) 급여총계 from emp;
--퀴즈 emp에서 입사일자가 1982/01/01이후에 들어온사람의 사원명과 입사일자를 조회하시오(입사일자순)
select ename 사원명, hiredate 입사일자 from emp where hiredate>='82/01/01' order by hiredate;

--LIKE % , _ 언더바 이용해서 특정 순번에 있는 글을 출력
--EMP에서 사원명이 두번째 글자가 a인 사람의 사원명 출력
select ename 사원명 from emp where ename Like '_A%';
--EMP에서 사원명이 2번째 글자가 A인사람 또는 3번째 글자가 A인 사람 사원명 출력
select ename 사원명 from emp where ename Like '_A%' or ename LIke '__A%';

--날짜 리터럴 ' ' 반드시 사용
--emp에서 직급이 CLERK이고 입사일이 87/05/23인사람의 사원명 입사일 구하기
select ename 사원명, hiredate 입사일 from emp where job= 'CLERK' and hiredate = '87/05/23';
--emp에서 매니저이거나 82년이후 입사자의 사원명 직업군 입사일 출력
select ename 사원명, job 직업군, hiredate 입사일 from emp where job = 'MANAGER' OR hiredate >='82/01/01' order by hiredate asc;

--다중정렬
--student 에서 1학년 학생의 이름과 키와 몸무게 출력(키는 작은사람부터, 몸무게는 많은사람 부터)
select name 학생명, height 키, weight 몸무게 from student where grade =1 order by height asc, weight desc;

--emp에서 급여 내림차순 후 다시 이름으로 오름차순_사원번호 사원명 급여 조회
select empno 사원번호, ename 사원명, sal 급여 from emp order by sal desc, ename;

--union
--unionall
select name,deptno1,deptno2 from student where deptno1 =101 union all
select name, deptno1,deptno2 from student where deptno2=201;

--gogak point 가 30~50만 고객명과 포인트를출력하시오 (포인트많은순)
select gname 고객명, point 포인트 from gogak where point between 300000 and 500000 order by point asc;
--emp의 comm의 널을 0으로 바꿔서 직업이 manager인 사람의 이름과 보너스 출력하시오
select ename 이름 , NVL(comm ,0) 보너스 from emp where job ='MANAGER';
--professor 103번 학과 교수들의 이름과 급여, 보너스, 연봉(급여*12+보너스)을 출력하시오
select name 이름, pay 급여, NVL(bonus,0) 보너스, (pay*12)+NVL(bonus,0) 연봉 from professor where deptno=103;

--sql 그룹함수 (count , sum, avg)
--count(*) null값 포함, count(컬럼):null값 제외
select count(*),count(hpage) from professor;
--sum(컬럼명)
select count(bonus), sum(bonus) from professor;
--avg(컬럼명)
select count(bonus), sum(bonus), avg(bonus) from professor;

--max,min
select max(sal), min(sal) from emp;
select max(hiredate),min(hiredate) from emp;

--소수점
--emp에서 sal 평균
select round (avg(sal),1) from emp;--소수점 1자리
select round (avg(sal),2) from emp;--소수점 2자리
select round (avg(sal),3) from emp;--소수점 3자리
select round (avg(sal),0) from emp;--반올림
select round (avg(sal),-1) from emp;--10단위 
select round (avg(sal),-2) from emp;--100단위 

--콘솔에 출력
--현재날짜를 콘솔에 출력
select sysdate from dual;

--내일날짜를 콘솔에 출력
select sysdate+1 from dual;

--to_char : 날짜 및 수치데이터를 문자로 변환하기 위한 함수
--날짜에서 년도만 추출
select to_char(sysdate,'year')from dual; --영어로 나옴
select to_char(sysdate,'yyyy')from dual; --2023

select to_char(sysdate,'mm')from dual; --07
select to_char(sysdate,'month')from dual; --7월

select to_char(sysdate,'dd')from dual; --06
select to_char(sysdate,'day')from dual;--목요일

select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss')from dual;--2023-07-06 15-13-28

--to_char 숫자에도 적용가능하다
select to_char(234589770,'999,999,999')from dual;

--emp
select empno 사원번호, ename 사원명 , to_char(hiredate, 'yyyy')년도 from emp;
--emp에서 사원번호,사원명,급여 출력(급여는 천단위 구분기호)
select empno 사원번호, ename 사원명 , to_char(sal,'U999,999')급여 from emp;

--서브쿼리
--쿼리 안에 또다른 쿼리 담김(king 보다 급여를 많이받는사람은?) 2가지 질문
--서브쿼리가 먼저 수행되어 그 결과를 메인쿼리에 전해주고 그 값을 받아 메인쿼리가 실행
--서브쿼리안에는 order by절 못옴
--EMP에서 JAMES보다 급여 많이 받는 사람의 사원명 급여를 구해봅시다
SELECT ename 사원명, sal 급여 from emp where sal>(select sal 급여 from emp where ename ='JAMES');

--EMP에서 평균급여보다 많이받는 사람의 사원번호, 사원명, 급여를 나타내시오
SELECT empno 사원번호, ename 사원명, sal 급여 from emp where sal>(select avg(sal)from emp);

--emp에서 이름이 WARD 인 사람의 MGR 과 같은 값을 가진 사람의 목록 출력
select *from emp where MGR=(select MGR from emp where ename='WARD');

--emp에서 평균급여보다 많이 받는 사람수? 
select count(*) from emp where sal>(select avg(sal) from emp);

--서브쿼리 문제 
--1emp에서 adams와 같은 직업군을 가진 사람의 이름 연봉 직업군 출력
select ename 이름, sal*12+NVL(comm,0) 연봉,job 직업군 from emp where job=(select job  from emp where ename='ADAMS'); 
--2emp에서 SCOTT와 같은 연봉을 받는 사람의 이름과 연봉출력
select ename 이름, sal*12+NVL(comm,0) from emp where sal=(select sal  from emp where ename = 'SCOTT');
--3student에서 제1전공이 일지매 학생과 동일한 학생들의 학생명 제1전공 출력
SELECT name 학생명, deptno1 제1전공 from student where deptno1=(select deptno1 from student where name='일지매');
--4student에서 제1전공이 101인 학과의 평균몸무게보다 몸무게가 많은 학생들의 이름과 몸무게 출력
select name 이름, weight 몸무게 from student where weight>(select avg(weight) from student where deptno1=101); 
--5professor에서 입사일이 김영조 교수보다 나중에 입사한 사람의 이름과 입사일 학과번호를 출력하시오
select name 이름, hiredate 입사일, profno 학과번호 from professor where hiredate >(select hiredate from professor where name='김영조');

/*
0707 /////////////////////////////////
*/
--emp에서 job 종류별로 직업군을 한번씩 출력 
select DISTINCT job 직업군 from emp; 
--emp테이블에서 사원명이 A나 S로 시작하는 사람만 출력(사원번호 사원명)
select empno 사원번호, ename 사원명 from emp where ename LIKE 'A%' or ename LIKE 'S%';
--emp에서 deptno가 10인 부서만 출력하시오(사원명 부서번호)
select ename 사원명, deptno 부서번호 from emp where deptno=10;
--emp에서 급여(sal)가 평균보다 더 높은사람만 사원명 급여를 출력하시오
select ename 사원명, sal 급여 from emp where sal > (select avg(sal) from emp);
--scott의 급여와 동일하거나 더많이 받는사람의 사원명과 급여를 출력하시오
select ename 사원명, sal 급여 from emp where sal >=(select sal from emp where ename = 'SCOTT');
--emp에서 hiredate에서 월이 5월인 사람만 사원명 입사일자출력하시오(to_char사용)
select ename 사원명, hiredate 입사일자 from emp where to_char(hiredate,'mm')='05';

--1 테이블생성
--primary key 는 기본키를 의미 not null+unique 를 의미한다

--test1테이블
create table test(num number(5) primary key,
name varchar2(20),score number(6,2), birth date); 

desc test; --구조보기

select * from test; --테스트 테이블 조회

--test1에 전체데이터 insert
insert into test values(1, '손석구',67.2,'1996-02-26');
--test에 일부데이터 insert
insert into test(num,name) values (2,'강호동');

--insert 에러
--무결성 제약 조건 ( Sudal.SYS_C008392)에 위배
--insert into test values(4, '이영애',68.78, '1989-11-12',22,'대한민국 서울특별시 ㄱㄴㄷㄹㅁㅂㅅㅇㅈㅊㅋㅌㅍㅎ131221516611224221414214214');
--주소 저장컬럼 30=>50
--ALTER TABLE 테이블명 MODIFY 컬럼명 데이터타입;
alter table test modify addr varchar2(50);

--age 타입을 문자열(10)으로 변경하고 초기값을 20으로 설정하기
alter table test modify age varchar2(10) default '20';

insert into test (num,name) values(10, '강호동');

--num 의 오름차순 출력
select * from test order by num;

--name의 내림차순 출력
select * from test order by name desc;

--drop
--ALTER TABLE 테이블명 DROP COLUMN 삭제할 컬럼명

--AGE라는 컬럼을 삭제
alter table test drop column age;

--addr 삭제
alter table test drop column addr;

--컬럼명 변경
--ALTER TABLE 테이블명 RENAME COLUMN OLD컬럼명 TO NEW컬럼명;
--SCORE 를 ==> JUMSU
alter table test rename column  score to jumsu;

--birth ==> birthday
alter table test rename column birth to birthday;

--테이블삭제 test 
drop table test;

--sysdate 현재날짜 의미
insert into test values(5, '이효리',88.96,sysdate);

--alter
--나이를 저장할 컬럼 추가, 무조건 null로 추가
--alter table 테이블명 add 추가할 컬럼명 데이터타입;
alter table test add age number(5);

--주소를 저장할 컬럼을 추가
alter table test add addr varchar2(30) default '강남구';


--시퀀스생성 
--시퀀스 기본으로 생성,1부터 1씩 증가하는 시퀀스 생성됨
create sequence seq1;

--전체 시퀀스 확인
select * from seq;

--다음 시퀀스 값을 발생 콘솔에 출력
select seq1.nextval from dual;

--현재 마지막 발생한 시퀀스값 콘솔에 출력
select seq1.currval from dual;

--seq1 삭제 
drop sequence seq1;

--10부터 5씩 증가하는 시퀀스생성 -cache값 없애기
create sequence seq2 start with 10 increment by 5 nocache;

--시퀀스 발생
select seq2.nextval from dual;

--seq2 삭제
drop sequence seq2;

--seq1 :시작값5 증가값:2, 끝값 30 캐시 no, cycle:y
create sequence seq1 start with 5 increment by 2 maxvalue 30 nocache cycle;
--seq2 시작값1 증가값1 cache:n
create sequence seq2 nocache;
--seq3 시작값은 1 증가값 2 cache:n
create sequence seq3 start with 1 increment by 2 nocache;

--출력
select seq1.nextval, seq2.nextval, seq3.nextval from dual;

--전체삭제 
drop sequence seq1;
drop sequence seq2;
drop sequence seq3;

-----------------------시퀀스 1개 생성, 테이블 생성
create sequence seq_start nocache;

create table personinfo (num number(5) primary key, 
name varchar2(20), 
job varchar2(30),
gender varchar2(20),
age number(5),
hp varchar2(20),
birthday date);

--구조 확인
desc personinfo; 

select * from personinfo;

--birthday를 ipsaday 로 변경
alter table personinfo rename column birthday to ipsaday;

--insert 
insert into personinfo values (seq_start.nextval, '박병주','엔지니어','남자',22,'010-1234-5678','2023-01-01');
insert into personinfo values (seq_start.nextval, '하병일','엔지니어','남자',22,'010-1234-5678','2023-01-01');
insert into personinfo values (seq_start.nextval, '가병이','대통령','여자',12,'010-3234-5678','2022-02-01');
insert into personinfo values (seq_start.nextval, '나병삼','가수','남자',32,'010-5634-5678','2021-03-01');
insert into personinfo values (seq_start.nextval, '다병사','개그맨','여자',27,'010-7834-5788','2020-01-01');
insert into personinfo values (seq_start.nextval, '라병오','제빵사','남자',29,'010-8334-1278','2023-05-01');
insert into personinfo values (seq_start.nextval, '마병육','제빵사','여자',42,'010-6536-5278','2023-07-06');
insert into personinfo values (seq_start.nextval, '사병칠','개그맨','남자',52,'010-1134-8958','2023-04-04');
insert into personinfo values (seq_start.nextval, '아병팔','가수','여자',62,'010-8924-5678','2023-02-09');
insert into personinfo values (seq_start.nextval, '자병구','대통령','남자',19,'010-1124-9468','2020-02-07');
insert into personinfo values (seq_start.nextval, '차병십','엔지니어','여자',44,'010-1274-3478','2019-03-01');
commit; --안하면 실질적완료상태아님

--최종 인원 확인
select count(*)from personinfo;
--조회연습
select * from personinfo order by name asc;
select * from personinfo order by age desc;
select * from personinfo order by 5 asc; --컬럼번호로도 가능

select * from personinfo order by gender, age desc;
select * from personinfo order by gender, name;

select job from personinfo; --직업만 출력
select distinct job from personinfo; --중복빼고 출력

--성이 가씨만 출력
select * from personinfo where name like  '가%';

--이름이 2번째 글자가 병인사람
select * from personinfo where name like '_병%';

--핸드폰 마지막 자리가 3333인 사람
select * from personinfo where hp like '%5678';

--입사날짜가 3월인 사람
select * from personinfo where to_char(ipsaday,'mm')='03';

--입사일자가 2023년인 사람을 출력
select * from personinfo where to_char(ipsaday, 'yyyy') ='2023';

--나이가 20~30사이 
select * from personinfo where age between 20 and 30;

--직업이 연예인이거나 프로그래머인사람
select * from personinfo where job in('연예인','프로그래머');

--직업이 연예인이거나 프로그래머가 아닌사람
select * from personinfo where job not in('연예인','프로그래머');

--평균나이, 소수점 한자리로 구하기
select round(avg(age),1) from personinfo;

--내용 수정(update)
--update 테이블명 set 컬럼 = '변경할데이터' where 컬럼2='데이터값';

--2번 직업 나이 수정하기, 조건이 없으면 모든 데이터가 수정된다 조건필수
update personinfo set job ='대통령', age=55 where num=2;

--잘못 수정한 데이터 원래대로 돌리기 
rollback;

--하씨이면서 대통령인사람의 젠더를 여자로 수정하기
update personinfo set gender = '여자' where name like '하%' and  job like '대통령';

--num이 8번인 사람의 직업을 교사로 입사일을 2000-12월 25일로 수정
update personinfo set job = '교사' ,ipsaday ='2000-12-25' where num=8;

commit;

--삭제
--delete from 테이블명;
--5번만 삭제
delete from personinfo where num=5;

--여자중에서 나이가 25세 이상만 모두 삭제
delete from personinfo where age>=25 and gender='여자';

--핸드폰을 ***-***-**** 수정
update personinfo set hp = '***-***-****'; 

--잘못을때 되돌리기 커밋 하면 못되돌림
rollback; 

--테이블 삭제
--시퀀스 삭제
drop table personinfo;
drop sequence seq_start;

--DEPT 에서 30번 부서를 시애틀로 변경해주세요
update dept set loc = '시애틀' where deptno=30;

--EMP테이블 TOTALSAL 열을 하나 추가(number(20))
alter table emp add TOTALSAL number(20);

--emp테이블 TOTALSAL에 SAL과 COMM을 더한가격을 수정하시오
update emp set TOTALSAL = sal+nvl(comm,0);

--emp에서 WARD 삭제하시오 
delete from emp where ename='WARD';

--product 테이블에서 100번을 쵸코파이로 수정
update product set p_name = '쵸코파이' where p_code = 100;

--group by
--professor에서 학과별로 교수들의 평균 급여를 출력하시오
select deptno, avg(pay) "평균 급여"
from professor
group by deptno;

--select 절에 사용된 그룹함수 이외의 컬럼이나 표현식은 반드시 group by에 사용되어야함
--professor에서 직급별 평균 보너스
select position ,avg(nvl(bonus,0)) "평균 보너스"
from professor 
group by position;

--학과별 직급별로 교수들의 평균급여
select deptno, position, avg(pay) "평균급여"
from professor
group by deptno,position;

--student 에서 학년별 최고키와 최고몸무게 출력
select grade , max(height) 최고키, max(weight) 최고몸무게
from student
group by grade;

--교수의 직급별 총급여와 최고보너스를 구하시오
select position 직급, sum(pay)"총급여", max(nvl(bonus,0)) "최고보너스"
from professor
group by position;

--emp에서 동일한 직업끼리의 사원수 구하시오
--직무  사원수 
select job 직무,count(job) 사원수 from emp group by job; --count 안에는 아무거나넣어도상관없음

--HAVING 절_ 조건주고 검색하기_반드시 group by뒤에....
--having 은 그룹조건 where 은 일반조건에 쓴다
--emp에서 평균급여가 2000이상인 부서의 부서번호와 평균급여를 구하시오
--where절은 그룹함수의 비교조건으로 쓸수없다
select deptno , avg(sal) 
from emp
group by deptno
having avg(sal)>2000;

--professor 에서 평균급여가 300이상인 학과의 학과번호와 평균급여를 구하시오
select  deptno 학과, avg(pay) 평균급여  
from professor
where deptno not in(101)
group by deptno
having avg(pay)>300
order by deptno desc;

--emp에서 job 별로 sal 의 평균급여를 구하시오
select job 직업 , avg(sal) 평균급여
from emp
group by job;

--emp 에서 직업별 인원수 최대급여 최소급여 출력하세요 (job의 오름차순)
select job 직업, count(job), max(sal) 최대급여, min(sal)최소급여
from emp
group by job
order by job;

--입사년도 그룹 별로 (입사년도, 인원수, 급여평균(소수점djqtdl)_입사년도의 오름차순
select to_char(hiredate,'yyyy')입사년도 , count(*)인원수,round(avg(sal),0)평균급여
from emp
group by to_char(hiredate,'yyyy')
order by to_char(hiredate,'yyyy');

--Rollup함수 
--자동으로 소계/합계 구해주는 함수 
--group by 절에 주어진 조건으로 소계값을 구해준다
select deptno 학과번호 , position 직위, sum(pay)총급여
from professor
group by position,rollup(deptno); --정교수 끼리의 합 조교수끼리의 합 추가로 구해주는 롤업

select deptno 학과번호 , position 직위, sum(pay)총급여
from professor
group by deptno,rollup(position);

--count 
select position ,count(*) , sum(pay)
from professor
group by rollup(position);

--cube 함수
--rollup처럼 각소계에 전체총계까지 구해준다
select deptno , position, count(*), sum(pay)총급여
from professor
group by cube(deptno,position);

--오늘의 총복습
--emp에서 평균연봉이 2000이상인 부서의 부서번호와 평균급여를 구하시오
select deptno, avg(sal)
from emp
group by deptno
having avg(sal)>=2000;

--emp에서 deptno별 인원수는?
select deptno 부서번호 , count(*) 인원수
from emp
group by deptno;

--emp에서 job별 인원수를 구하시오(단 인원이 2명이상인곳만 구할것)
select job 직군, count(*) 인원수
from emp
group by job
having count(*)>=2;

--emp에서 job별 급여합계를 구하는데 (president 는 제외할것)급여합계가 5000이상만 구하시고 급여합계가 높은것부터 출력하시오
--job급여총계
select job 직군, sum(sal)총급여
from emp
where job not in('PRESIDENT') --president 제외
group by job --job 그룹별로
having sum(sal)>=5000 --sal 5000이상
order by sum(sal) desc; --높은것부터 출력




---------------제약조건
--테이블생성
create table sawon(num number(5) CONSTRAINT sawon_pk_num primary key,
name varchar2(20),
gender varchar2(10),
buseo varchar2(20) CONSTRAINT sawon_ck_buseo check(buseo in('홍보부','인사부','교육부')),
pay number(10) default 2000000);

select * from sawon;

--시퀀스 생성
create sequence seq_sawon nocache;

--데이터 10개정도 insert 
--insert into sawon values(seq_sawon.nextval,'이영미','여자','게임개발부',3500000);
insert into sawon values(seq_sawon.nextval,'가일도','여자','교육부',3500000);
insert into sawon values(seq_sawon.nextval,'나이레','남자','인사부',2500000);
insert into sawon values(seq_sawon.nextval,'다삼미','여자','홍보부',3500000);
insert into sawon values(seq_sawon.nextval,'라사파','남자','인사부',4500000);
insert into sawon values(seq_sawon.nextval,'마오솔','여자','교육부',5500000);
insert into sawon values(seq_sawon.nextval,'바육라','남자','인사부',6500000);
insert into sawon values(seq_sawon.nextval,'사칠시','여자','홍보부',7500000);
insert into sawon values(seq_sawon.nextval,'아팔도','남자','인사부',8500000);
insert into sawon values(seq_sawon.nextval,'자구레','여자','교육부',9500000);
commit;

--부서별 인원수와 최고급여, 최저 급여 조회
select buseo 부서,count(*) 인원수, max(pay)최고급여, min(pay)최저급여
from sawon
group by buseo;
--위의 쿼리문에서 최고급여, 최저급여에 화폐단위 붙히고 3자리 컴마도 나오게해주세요
select buseo 부서,count(*) 인원수, to_char(max(pay),'U999,999,999')최고급여, to_char(min(pay),'U999,999,999')최저급여
from sawon
group by buseo;

--성별 인원수와 평균급여를 출력하시오(인원수 뒤에 명 이라고 나오도록...)
select gender 성별, count(*)||'명' 인원수, avg(pay) 평균급여
from sawon
group by gender;

--부서별 인원수와 평균급여를 구하되 인원이 4명 이상인 경우에만 출력하도록 하세요
select buseo 부서별 , count(*) 인원수 ,avg(pay) 평균급여
from sawon
group by buseo
having count(*)>=4; 

select * from mymall where no=88;
create sequence test;