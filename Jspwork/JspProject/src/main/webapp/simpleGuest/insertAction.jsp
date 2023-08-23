<%@page import="db.simpleguest.SimpleGuestDto"%>
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
	<%-- 
	<%
	request.setCharacterEncoding("utf-8");
	
	String nick = request.getParameter("nick");
	String pass = request.getParameter("pass");
	String image = request.getParameter("image");
	String story = request.getParameter("story");
	
	SimpleGuestDto dto = new SimpleGuestDto();
	dto.setNick(nick);
	dto.setPass(pass);
	dto.setImage(image);
	dto.setStory(story);
	
	//메소드 호출하기위해 생성
	SimpleGuestDao dao = new SimpleGuestDao();
	dao.insertGuest(dto);
	
	//목록으로 이동
	response.sendRedirect("guestlist.jsp");
	%> --%>
	
	<!-- 자바빈즈로 변경하려면 -->
	<%
		request.setCharacterEncoding("utf-8");
	%>
	<!-- 생성하는역할 -->
	<jsp:useBean id="dao" class="db.simpleguest.SimpleGuestDao"/>
	<jsp:useBean id="dto" class="db.simpleguest.SimpleGuestDto"/>
	
	<!-- name으로 부르는데 -->
	<jsp:setProperty property="*" name="dto"/>
	<%
	//insert 호출
	dao.insertGuest(dto);
	
	//목록으로 이동
	response.sendRedirect("guestlist.jsp");
	%>
</body>
</html>