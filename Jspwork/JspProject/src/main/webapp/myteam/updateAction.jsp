<%@page import="model.myteam.TeamDao"%>
<%@page import="model.myteam.TeamDto"%>
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
	//데이터를 읽기 
	String num=request.getParameter("num");
	String name=request.getParameter("name");
	String driver=request.getParameter("driver");
	String addr=request.getParameter("addr");
	
	//system.out.println(driver) 확인체크안할경우 null, 체크할경우 on
	
	//dto 선언
	TeamDto dto= new TeamDto();	
	dto.setNum(num);
	dto.setName(name);
	dto.setDriver(driver==null?"없음":"있음");
	dto.setAddr(addr);
	
	//insert dao 메소드 전달
	TeamDao dao=new TeamDao();
	dao.updateTeam(dto);
	
	//출력 jsp로 이동 ...url이 바뀜
	response.sendRedirect("list.jsp");	
%>
</body>
</html>