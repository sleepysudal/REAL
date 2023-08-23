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
<style>
div {
	width: 100px;
	height: 100px;
	float:left;
}
</style>
</head>
<body>
	<%
	String sangpum = request.getParameter("sangpum");
	String size = request.getParameter("size");
	String color[] = request.getParameterValues("color");
	String[] addsangpum = request.getParameterValues("addsangpum");
	%>

	<h3>결과값 출력</h3>
	이름:
	<%=sangpum%><br> 사이즈:
	<%=size%><br>


	<%
	if (color == null) {
	%>
	<b style="color: red;">선택색상없음</b>
	<%
	} else {
	for (int i = 0; i < color.length; i++) {
	%>
	<div style="background-color: <%=color[i]%>"><%=color[i]%></div>
	<%
	}
	%>	
	<%
	}
	%>





	<%
	if (addsangpum == null) {
	%>
	<b style="color: red;">추가상품없음</b>
	<%
	} else {
	for (int i = 0; i < addsangpum.length; i++) {
	%>
	<br>[추가상품:<%=addsangpum[i]%>]&nbsp;
	<%
	}
	%>	
	<%
	}
	%>


</body>
</html>