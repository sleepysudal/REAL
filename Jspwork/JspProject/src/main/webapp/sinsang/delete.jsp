<%@page import="model.sinsang.SinsangDao"%>
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
	 //삭제 메소드 호출	
	String num=request.getParameter("num");
	SinsangDao dao=new SinsangDao();
	 dao.deleteSinsang(num);
	 //리스트로 이동
	response.sendRedirect("list.jsp");
	
	%>
</body>
</html>