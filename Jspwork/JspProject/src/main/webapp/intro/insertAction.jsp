<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
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
	//한글인코딩
	request.setCharacterEncoding("utf-8");

	String intro_name=request.getParameter("intro_name");
	String intro_blood=request.getParameter("intro_blood");
	String intro_hp=request.getParameter("intro_hp1")+"-"+request.getParameter("intro_hp2")+"-"+request.getParameter("intro_hp3");	
	String intro_city=request.getParameter("intro_city");	
	
	IntroDto dto=new IntroDto();
	
	dto.setIntro_name(intro_name);
	dto.setIntro_blood(intro_blood);
	dto.setIntro_hp(intro_hp);
	dto.setIntro_city(intro_city);
	
	IntroDao dao =new IntroDao();
	dao.insertIntro(dto);
	
	response.sendRedirect("list.jsp");
%>
</body>
</html>