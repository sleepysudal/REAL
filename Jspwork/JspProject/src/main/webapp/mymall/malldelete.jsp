<%@page import="model.mymall.MallDao"%>
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
	//삭제 메서드 호출
	String no = request.getParameter("no"); //인자값 이름쓰면 그걸 가져온다
	MallDao dao=new MallDao(); //메서드 불러오기 위한 생성자
	dao.deleteMyMall(no);
	
	//리스트로 이동
	response.sendRedirect("list.jsp");
	%>
</body>
</html>