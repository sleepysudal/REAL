<%@page import="model.sinsang.SinsangDao"%>
<%@page import="model.sinsang.SinsangDto"%>
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
	String addr=request.getParameter("addr");
	
	//입력데이터를 dto로 묶어서
	SinsangDto dto = new SinsangDto();
	
	dto.setNum(num);
	dto.setName(name);
	dto.setAddr(addr);
	
	//insert 메소드 전달
	SinsangDao dao=new SinsangDao();
	dao.updateSinsang(dto);
	
	//출력 jsp로 이동...url이 바뀜
	response.sendRedirect("list.jsp");	
%>
</body>
</html>