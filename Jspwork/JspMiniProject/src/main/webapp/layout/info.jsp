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
</head>
<% 
//절대경로 잡기 
String root = request.getContextPath();
%>
<body>
	<div style="font-size:16pt; line-height:25px;">
	<i class="bi bi-piggy-bank"></i>Air canada<br>
	<i class="bi bi-telephone-inbound-fill"></i>02-1111-4444<br>
	<i class="bi bi-shop"></i>캐나다 &nbsp;&nbsp;퀘벡<br>
	<i class="bi bi-envelope"></i>canada@gmail.com<br>
	
	<br><br>
	<img alt="" src="<%=root %>/image/banner0.jpeg" width="100px" height="75px">
</div>
</body>
</html>