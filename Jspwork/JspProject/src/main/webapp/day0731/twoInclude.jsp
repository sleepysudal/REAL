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
<!-- two include로 본인들 이름, 주소를 전달 -->
<%
	String name=request.getParameter("name");
	String addr=request.getParameter("addr");
	%>
	
	<h3>전달받은 이름: <%=name %></h3>
	<h3>전달받은 주소: <%=addr %></h3>	
</body>
</html>