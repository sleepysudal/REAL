<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
body{
background-color: black;
}
div>a{
text-decoration: none;
color: white;
font-size: 14pt;
}
div>h6{
color: white;
}
div>h6>a{
color:white;
}
#mack{
cursor: pointer;
width: 100%;
}
</style>
</head>
<%
String root=request.getContextPath();
%>
<body>


<!-- 푸터 -->
	<div class="footer_content">
		<div class="gwang-go content">
		<img src="../image/mack.jpeg" name="mack" id="mack" 
		onclick="location.href='https://www.mcdonalds.co.kr/kor/main.do'">
		</div>
		<div class="contents" align="center">
		<a href="#">회사소개</a>&nbsp;
		<a href="#">지속가능경영</a>&nbsp;
		<a href="#">IR</a>&nbsp;
		<a href="#">채용정보</a>&nbsp;
		<a href="#">광고/제휴/출점문의</a>&nbsp;
		<a href="#">이용약관</a>&nbsp;
		<a href="#">편성기준</a>&nbsp;
		<a href="#" style="text-decoration: underline;"><b style=color:yellow>개인정보처리방침</b></a>&nbsp;
		<a href="#">법적고지</a>&nbsp;
		<a href="#">이메일주소무단수집거부</a>&nbsp;
		<a href="#">윤리경영</a>&nbsp;
		<a href="#">사이버감사실</a>
		
		<br>
		<hr>
		
		<h6>(04323)서울특별시 부산구 두강대로 15길 57, sist몰 7층 (가로동)</h6>
		<h6>대표이사 : 장순녕&nbsp;사업자등록번호 : 114-02-34678&nbsp;통신판매업신고번호 : 2023-서울부산-1955&nbsp;
		<a href="https://www.youtube.com/@goyoungii"><b style=color:yellow>사업자정보확인</b></a></h6>
		<h6>호스팅사업자: SY네트워크&nbsp; 개인정보보호 책임자 : 쌍용구&nbsp;대표이메일 : gitmasterx@sy.net</h6>
		<h6><i class="bi bi-award-fill"></i> 3 SINE. All Rights Reserved</h6>
		</div>
		
	</div>
</body>
</html>