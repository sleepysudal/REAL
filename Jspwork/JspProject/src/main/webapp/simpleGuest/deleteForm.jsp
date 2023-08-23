<%@page import="db.simpleguest.SimpleGuestDao"%>
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
th{
font-family: 'gugi';
}
</style>
</head>
<body>
<%
String num = request.getParameter("num");
//String pass =request.getParameter("pass");


%>
<div style="margin:100px; 100px; border: 3px dashed green;" >
<form action="deleteAction.jsp" method="post">
<input type="hidden" name="num" value="<%=num %>">
<table>
	<tr>
		<th>비밀번호</th>
			<td>
			<input type="password" name="pass">
			</td>
	</tr>
	<tr>
	<td>
	<button type="submit" class="btn btn-outline-dark" style="width:100px; font-size: 1.3em">삭제</button>
	<button type="button" class="btn btn-dark" style="width:100px; font-size: 2.3em">취소</button>
	</td>
	</tr>				
</table>
</form>
</div>
</body>
</html>