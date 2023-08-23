<%@page import="model.mymall.MallDao"%>
<%@page import="model.mymall.MallDto"%>
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
	String no = request.getParameter("no");
	String sangpum=request.getParameter("sangpum");
	String photo=request.getParameter("photo");
	String price=request.getParameter("price");
	String ipgoday=request.getParameter("ipgoday");
	
	//dto 선언 및 설정
	MallDto dto=new MallDto();
	dto.setNo(no);
	dto.setSangpum(sangpum);
	dto.setPhoto(photo);
	dto.setPrice(price);
	dto.setIpgoday(ipgoday);
	
	//insert dao 메소드
	MallDao dao=new MallDao();
	dao.updateMall(dto);
	
	//출력jsp ..url 변경
	response.sendRedirect("list.jsp");
	
	%>
</body>
</html>