<%@page import="member.model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style>
div{
	position: absolute;
	top:200px;
	left:700px;
}
</style>
</head>
<body>
<%
//세션으로부터 idok
String id = (String)session.getAttribute("idok");

//아이디에 해당하는 이름을 dao로부터 얻는다
MemberDao dao = new MemberDao();
String name = dao.getName(id);

%>
<div>
<br><br>
<b style="color:skyblue;"><%=name %></b>님이 로그인중~~&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<input type="button" value="로그아웃" class="btn btn-danger"
onclick="location.href='logoutAction.jsp'">
<button type="button" onclick="location.href='memberList.jsp'" class="btn btn-success" id="btn1">회원목록</button>
<br><br>
<img alt="" src="../image/b2.png">
</div>
</body>
</html>