<%@page import="member.model.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300;400&family=Gugi&family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<%
String id = request.getParameter("id");
String pass= request.getParameter("pass");
String save= request.getParameter("savecheck");

MemberDao dao= new MemberDao();
boolean flag= dao.isEqualPass(id, pass);

if(flag)
{
//로그인인지 알수있는 세션저장
session.setAttribute("loginok", "yes");
//아이디 값 저장
session.setAttribute("idok", id);
//비번 값 저장
session.setAttribute("passok", pass);
//체크값 세션 저장
session.setAttribute("saveok", save);

//로그인메인으로 이동
response.sendRedirect("loginMain.jsp");
}else{%>
<script type="text/javascript">
alert("아이디,비번 틀림");
history.back();
</script>
<%}



%>
</body>
</html>