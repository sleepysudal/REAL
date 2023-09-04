<%@page import="data.dto.ShopDto"%>
<%@page import="data.dao.ShopDao"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	//업로드 경로
	String uploadPath=getServletContext().getRealPath("/shopsave");
	System.out.println(uploadPath);
	//업로드 이미지 사이즈
	int uploadSize = 1024* 1024 * 5;
	
	MultipartRequest multi = null;
	
	try{
	multi= new MultipartRequest(request,uploadPath,uploadSize,"utf-8",new DefaultFileRenamePolicy());
	
	String sangpum = multi.getParameter("sangpum");
	String category = multi.getParameter("category");
	String ipgoday = multi.getParameter("ipgoday");
	int price = Integer.parseInt(multi.getParameter("price"));
	String photo= multi.getFilesystemName("photo");
	
	//dao 
	ShopDao dao = new ShopDao();
	
	//dto 에 데이터 넣기
	ShopDto dto = new ShopDto();
	dto.setSangpum(sangpum);
	dto.setCategory(category);
	dto.setIpgoday(ipgoday);
	dto.setPhoto(photo);
	dto.setPrice(price);
	
	//db에 추가
	dao.insertshop(dto);
	
	//상품등록으로 이동
	response.sendRedirect("../index.jsp?main=shop/addform.jsp");
	
	}catch(Exception e){
		System.out.println("업로드오류 : "+e.getMessage());
		
	}
%>
</body>
</html>