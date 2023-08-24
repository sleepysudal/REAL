<%@page import="data.dao.MemberDao"%>
<%@page import="data.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
.loginout{
font-size:10pt;
margin-left:40px;

}

</style>
</head>
<%
//절대경로잡기 /실행 시 프로젝트명 나오면 되고, 필요한곳에 복붙해서 사용하면 됌

String root=request.getContextPath();

String myid=(String)session.getAttribute("myid");
String loginok=(String)session.getAttribute("loginok");


MemberDao dao=new MemberDao();
String name=dao.getName(myid);



%>

<body>
<a href="<%=root %>" style="text-decoration:none; color:black;margin-left:200px;"><img alt="" src="<%=root%>/image/penguin.gif" style="width:100px; height:100px;">
펭귄</a>
<span class="loginout">
<%
if(loginok!=null){%>
	<b><%=name %></b>님이 접속중입니다.<button type="button" class="btn btn-danger" onclick="location.href='login/logoutaction.jsp'">로그아웃</button>
	
<%}else{%>
	<button type="button" class="btn btn-warning" onclick="location.href='index.jsp?main=login/loginform.jsp'">로그인</button>
<%	
}
%></span>

</body>
</html>