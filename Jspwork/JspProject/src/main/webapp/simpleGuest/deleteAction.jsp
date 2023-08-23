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
</head>
<body>
<%
String num =request.getParameter("num");
String pass= request.getParameter("pass");

SimpleGuestDao dao = new SimpleGuestDao();

boolean b=dao.isEqualPass(num, pass);


if(b){
	dao.deleteGuest(num);
	response.sendRedirect("guestlist.jsp");
	
}else{ %>
	<script type="text/javascript">
	alert("비밀번호 틀렸습니다");
	history.back();
	</script>
	
<%}
%>
</body>
</html>