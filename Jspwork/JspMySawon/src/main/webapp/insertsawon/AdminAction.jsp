<%@page import="java.text.DateFormat"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@page import="java.sql.Timestamp"%>
<%@page import="Mysawon.model.MysawonDto"%>
<%@page import="Mysawon.model.MysawonDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<% 

	//한글인코딩
	request.setCharacterEncoding("utf-8");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	MysawonDao dao =new MysawonDao();
	MysawonDto dto=new MysawonDto();	
	

	String grade = request.getParameter("grade");
	String buseo=request.getParameter("buseo");
	String pay=request.getParameter("pay");
	String ipsaday=request.getParameter("ipsaday");
	
	dto.setGrade(grade);
	dto.setBuseo(buseo);
	dto.setPay(pay);
	dto.setIpsaday(ipsaday);


	//db insert
	dao.insertadmin(dto);
	//이동
	response.sendRedirect("");
%>
</body>
</html>