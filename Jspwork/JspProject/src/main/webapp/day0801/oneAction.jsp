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
	String name=request.getParameter("name");
	String birth=request.getParameter("birth");
	String[] hobby=request.getParameterValues("hobby");
%>
	<h3 class="alert alert-info">폼태그로부터 읽은값</h3>

이름:
<%=name %><br> 
생년월일
<%=birth %><br> 
취미:
<%
	if(hobby==null){%>
		<b style="color:red;">취미없음</b>
	<%}else{
		
	 for(String h:hobby){ 
	 %> 
	 [<%=h %>]&nbsp;
	<%}
	}
%>
	
</body>
</html>