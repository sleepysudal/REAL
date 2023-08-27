<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
.header_content li {
	list-style: none;
	float: left;
	/* border: 1px solid black; */
}

.header_content span {
	font-size: 10pt;
	color: black;
}

a:link {
	color: black;
	text-decoration: none;
}

a:visited {
	color: black;
	text-decoration: none;
}

a:hover {
	color: blsack;
	text-decoration: underline;
}
</style>
</head>
<%
//절대경로잡기
String root = request.getContextPath();
%>
<body>
	<!-- 메인 헤더 -->
	<div class="header_content">
    	<div class="contents" align="center">
        	<ul class="memberInfo_wrap">
       			<li style="margin: 15px 530px 0px 60px;"><a href="<%=root %>index.jsp"><img alt="" src="<%=root%>/logoimg/logo.png" style="width: 220px; height: 75px;"></a></li>
            	<li style="margin: 35px 30px 0px 0px;"><a href="<%=root%>/index.jsp?main=member/memberloginform.jsp"><img src="<%=root%>/logoimg/header1.png" alt="" style="width: 40px; height: 40px; "/><br><span>로그인</span></a></li>
            	<li style="margin: 35px 30px 0px 0px;"><a href="<%=root%>/index.jsp?main=member/memberaddform.jsp"><img src="<%=root%>/logoimg/header2.png" alt="" style="width: 40px; height: 40px;  "/><br><span>회원가입</span></a></li>       
            	<li style="margin: 35px 25px 0px 0px;"><a href="<%=root%>/index.jsp?main=member/memebermypage.jsp"><img src="<%=root%>/logoimg/header3.png" alt="" style="width: 40px; height: 40px; "/><br><span>MY INFO</span></a></li>
           	 	<li style="margin: 35px 30px 0px 0px;"><a href=""><img src="<%=root%>/logoimg/header4.png" alt="" style="width: 40px; height: 40px; "/><br><span>고객센터</span></a></li>
        	</ul>
    	</div>
	</div>

	<nav id="menu">
		<ul>
			<li><a href="#">영화</a></li>
			<li><a href="#">극장</a></li>
			<li><a href="#">예매</a></li>
			<li><a href="#">스토어</a></li>
			<li><a href="#">이벤트</a></li>
			<li><a href="#">혜택</a></li>
		</ul>
	</nav>


</body>
</html>