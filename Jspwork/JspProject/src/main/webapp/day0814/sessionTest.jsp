<%@page import="java.util.Date"%>
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
</head>
<body>
<%
//세션을 저장하는 방법
session.setAttribute("msg", "happy monday!!!");
session.setMaxInactiveInterval(60); //60초동안 유지시간 지속
%>
<h3>세션값 얻기</h3>
세션값: <%=session.getAttribute("msg") %><br>
세션유지시간:<%=session.getMaxInactiveInterval() %> 초<br>
세션 생성시간: <%=session.getCreationTime() %><br>
세션 생성시간: <%=new Date(session.getCreationTime()) %>
</body>
</html>