# REAL
### 0705 JAVA
### 1. 스윙 라디오버튼 체크박스 버튼 
### 2. 배열을 이용해서 테이블을 마우스로 클릭시 발생하는 이벤트구현
### 3. 기존에 작성된 파일을 불러온 후 새로운 내용 작성해서 테이블에 추가하기
* * *
### 0705 SQL 초기설치 및 설정
##### 구글에 오라클 익스프레스 검색해서 오라클 데이터베이스 익스프레스 에디션 다운로드링크 따라 들어가거나 하단의 링크를 타고 들어가서 설치한다.
<https://www.oracle.com/kr/database/technologies/xe-downloads.html>
##### 1.다운로드가 끝나면 압축을 풀고 setup 응용프로그램을 실행한다.
##### 2.디폴트 설정으로 설치가 끝나면 비밀번호 지정하는 창이 뜨는데 본인이 원하는것으로 지정하고 기억해야된다.
##### 2-1 ![캡처1](https://github.com/sleepysudal/REAL/assets/42789882/f5057607-ee9a-424b-9019-ff076d77641c)
##### 3.CMD 를 실행하고 sqlplus 치면 뜨는 코드에서 사용자명 system 비밀번호는 2-1 상황에서 지정했던 비밀번호로 입력한다
 ![캡처2](https://github.com/sleepysudal/REAL/assets/42789882/02bfa608-0fbe-4b2a-9852-9be2022092e6)
##### 4.구글 오라클 디벨로퍼 검색 해서 다운로드하거나 하단의 링크를 타고 들어가서 설치한다.
<https://www.oracle.com/database/sqldeveloper/technologies/download/>
##### 5. 압축풀고 sqldeveloper 응용프로그램 실행한다.
##### 6. sqldevloper 실행후 환경설정 관련해서 이전설정 물어보는것은 기존설정 가져오냐 질문임으로 아니오를 눌러 초기 설정으로 시작한다
![캡처3](https://github.com/sleepysudal/REAL/assets/42789882/3328bd90-9e42-419d-9d40-fc14a27072ac)
##### 7-2 사진 속에서 좌측 상단의 초록색 플러스 모양을 누른다 
![캡처4](https://github.com/sleepysudal/REAL/assets/42789882/559a4920-dbc4-4d35-abef-a6e5c7196c6b)
##### 7-4 상단에 사진에서 사용자이름 칸에 system  비밀번호에는 기존에 설정한 번호 입력후 하단에 테스트 눌럿을때 상태 : 성공 뜨면 접속버튼을 누른다(상단 name은 사용자이름이 아니므로 ex)test01 이렇게작성해도됨)
* * *
# 0706 오라클 SQL 
### 오라클 계정생성과 삭제 및 권한부여
##### 1. CMD 실행후 기존사용자명, 비밀번호 로그인 
##### 2. alter session set "_ORACLE_SCRIPT"=true;
##### 3. CREATE USER TEST IDENTIFIED BY A0000A; <<해당 문구에서 TEST와 A0000A 는 아이디와 비밀번호 설정이다
##### 4. grant connect,resource,dba to TEST;  << TSET 계정에 권한 부여 
##### 5. desc dba_users; << 오라클 사용자 정보확인
##### 6. select username,account_status from dba_users; << 계정상태 락 풀렷는지 확인하는용도
##### 7. 락풀린거 확인되면 다시 cmd 창 켜서 sqlplus 사용자명 TEST 비밀번호 A0000A 로그인한다.
##### 8. 연습으로 쓸 자료가 있으면 그대로 복사 해서 CMD 창에 붙여넣기한다
![캡처1](https://github.com/sleepysudal/REAL/assets/42789882/7d21ca47-c2a6-47d5-a380-7ae5daccf703)
![캡처2](https://github.com/sleepysudal/REAL/assets/42789882/efb8e470-07ea-4389-897b-68d34c4cd418)
##### 9. 작업하기 쉽게 글꼴설정한다
![캡처4](https://github.com/sleepysudal/REAL/assets/42789882/6c8fed12-64ad-4345-9078-8c78b4153307)
##### 10. 전에 등록햇던 system 계정말고 새로만든 TEST 를 이용해서 A0000A 로그인 하고 테스트 성공시 접속한다. 
![캡처3](https://github.com/sleepysudal/REAL/assets/42789882/9865db43-a7ad-40d4-801d-d6196875aac4)
* * *
### SQL DEVELOPER 활용한 SQL 작성
##### 1. 컨트롤a  전체 선택 // 컨트롤 엔터 그 줄 실행 // -- 주석처리
<<<<<<< HEAD
##### 1-1 select ename from emp;  << --emp테이블에서 이름만 조회
=======
##### 1-1 select ename from emp; 작성 << --emp테이블에서 이름만 조회
>>>>>>> 154308cc261c28c5abe99e8d691543f56e1645a1
##### 1-2 Select ename, job from emp;   << emp테이블에서 이름과 직업만 조회        
##### 1-3 select * from emp << emp테이블 전체 조회
##### 1-4 select * from student; << student테이블  전체조회
##### 1-5 select * from professor; << professor 조회
##### 1-6 (')홑따옴표 : 문자열을 감싸주는 기호
##### 1-7 (")쌍따옴표 : 컬럼명 등을 감싸주는 기호

### 표현식 collum 이외에 원하는 구문을 select로 쓰기 
##### select name "이름",grade as "학년",birthday 생일 from student; << 컬럼 별칭 allias 출력
##### select ename 사원명, job as "직업", hiredate 입사일자 from emp; << emp에서 사원명, 직업, 입사일자를 조회하시오
##### select DISTINCT job "직 업 군" from emp; << DISTINCT: 중복된 값을 제거하고 출력하기
##### select DISTINCT DEPTNO "부서번호" from emp; << emp에서 부서번호를 중복없이 출력하기

### 합성연산자 : 컬럼을 붙혀서 출력 
##### select name || grade "학년별 학생명" from student;
##### select name||'님은' ||position||'입니다'from professor; << professor 테이블에서 포지션컬럼 관련 출력
##### select ename ||'님의 job은'|| job||'입니다' from emp; << emp 테이블에서  잡관련 컬럼 출력
##### select name || '님의 키는' ||height|| 'cm, 몸무게는' ||weight|| 'kg입니다' from student; << student 테이블에서 님의 키는 cm, 몸무게는 kg입니다 출력
##### select '내직업은'||job||'이고 연봉은'||sal||'입니다' from emp; << emp에서 내직업은 이고 연봉은 ***입니다
##### select name 학생명, grade 학년, birthday 생일 from student order by name asc; << asc는 오름차순으로 생략 가능하다
##### select ename 사원명, job 직업, sal 급여 from emp order by 3 desc;--컬럼번호로도 정렬가능 << desc는 내림차순 정렬로 사원명,직업,급여를 급여가 낮은사람 순으로 조회한다
##### select DISTINCT job 직업군 from emp order by job; << emp에서 직업군을 중복없이 출력하고 직업군의 오름차순으로 출력한다.

 * * *
<<<<<<< HEAD
### 산술연산자
##### select ename 사원명, sal 기본급, sal+100 특별보너스 from emp; <<  sal에 특별보너스 100을 더하여 출력

### where절 : 조건
##### select ename 사원명, sal 급여, deptno 부서번호 from emp where deptno=10; <<번호 조회는 숫자만 입력
##### select ename 사원명, job 직업 from emp where ename='KING'; << 문자열인 KING 은 홀따옴표 사용
##### select ename 사원명, sal 급여 from emp where sal>=3000;  << 범위 조회도 비교연산자를 통해가능하다

##### select name 학생명, height 키 from student where height between 160 and 180; << between a and b(작은숫자부터 작성필요) 뒤에 order by height 붙이면 160부터 오름차순으로 뜸 ( asc는 생략이가능)

##### select ename 사원명, deptno 부서번호 from emp where deptno in(20,30); << 부서번호 20,30만 조회함 in(a,b) : a,b만 조회

##### select ename 사원명, comm 보너스 from emp where comm is null; << null 값만 출력

##### select ename 사원명, comm 보너스 from emp where comm is not null; << null이 아닌사람의 이름과 보너스를 출력


##### select ename 사원명, nvl(comm,0) 보너스 from emp; << nvl : null 값 0으로 바꾸기 _연산이 목적

### LIKE 연산자
##### select *from student where name like '김%'; << 학생테이블에서 김씨만 조회해서 모든열 출력

### (or in 연산자)
##### select ename 사원명,job 직업군 from emp where job = 'SALESMAN' or job='MANAGER'; << or 연산자 활용해서 출력
##### select ename 사원명, job 직업군 from emp  where job in ('SALESMAN' , 'MANAGER'); << in 연산자 활용해서 출력

### (and between연산자)
##### select ename 사원명, job 직업군 , sal 급여 from emp where sal >=2000 and sal <=3000;
##### select ename 사원명, job 직업군 , sal 급여 from emp where sal between 2000 and 3000;


### LIKE % , _ 언더바 이용해서 특정 순번에 있는 글을 출력
##### select ename 사원명 from emp where ename Like '_A%';

### 날짜 리터럴 ' ' 반드시 사용
##### select ename 사원명, hiredate 입사일 from emp where job= 'CLERK' and hiredate = '87/05/23';

### 다중정렬
##### select name 학생명, height 키, weight 몸무게 from student where grade =1 order by height asc, weight desc;

### UNION : 각 쿼리의 결과 합을 반환하는 합집합 (중복제거)
### UNION ALL : 각 쿼리의 모든 결과를 포함한 합집합 (중복제거 안함)

### emp의 comm의 널을 0으로 바꿔서 직업이 manager인 사람의 이름과 보너스 출력
### select ename 이름 , NVL(comm ,0) 보너스 from emp where job ='MANAGER'; <<null 값 안바꾸면 출력시 오류 위험 있어서 0으로 변경

### sql 그룹함수 (count , sum, avg)
### count(*) null값 포함, count(컬럼):null값 제외
### select count(*),count(hpage) from professor;

### max,min
##### select max(sal), min(sal) from emp;

### 소수점
##### select round (avg(sal),1) from emp;--소수점 1자리
##### select round (avg(sal),2) from emp;--소수점 2자리
##### select round (avg(sal),3) from emp;--소수점 3자리
##### select round (avg(sal),0) from emp;--반올림
##### select round (avg(sal),-1) from emp;--10단위 
##### select round (avg(sal),-2) from emp;--100단위 

### 콘솔에 출력
##### 현재날짜를 콘솔에 출력
##### select sysdate from dual;

### 내일날짜를 콘솔에 출력
##### select sysdate+1 from dual;

### to_char : 날짜 및 수치데이터를 문자로 변환하기 위한 함수
##### 날짜에서 년도만 추출
##### select to_char(sysdate,'year')from dual; --영어로 나옴
##### select to_char(sysdate,'yyyy')from dual; --2023

##### select to_char(sysdate,'mm')from dual; --07
##### select to_char(sysdate,'month')from dual; --7월

##### select to_char(sysdate,'dd')from dual; --06
##### select to_char(sysdate,'day')from dual;--목요일

##### select to_char(sysdate,'yyyy-mm-dd hh24-mi-ss')from dual;--2023-07-06 15-13-28

### to_char 숫자에도 적용가능하다
##### select to_char(234589770,'999,999,999')from dual;

### 서브쿼리
##### 쿼리 안에 또다른 쿼리 담김(king 보다 급여를 많이받는사람은?) 2가지 질문
##### 서브쿼리가 먼저 수행되어 그 결과를 메인쿼리에 전해주고 그 값을 받아 메인쿼리가 실행
##### 서브쿼리안에는 order by절 못옴

##### EMP에서 JAMES보다 급여 많이 받는 사람의 사원명 급여를 구해봅시다
##### SELECT ename 사원명, sal 급여 from emp where sal>(select sal 급여 from emp where ename ='JAMES');

##### EMP에서 평균급여보다 많이받는 사람의 사원번호, 사원명, 급여를 나타내시오
##### SELECT empno 사원번호, ename 사원명, sal 급여 from emp where sal>(select avg(sal)from emp);

##### emp에서 이름이 WARD 인 사람의 MGR 과 같은 값을 가진 사람의 목록 출력
##### select *from emp where MGR=(select MGR from emp where ename='WARD');

=======
>>>>>>> 154308cc261c28c5abe99e8d691543f56e1645a1










