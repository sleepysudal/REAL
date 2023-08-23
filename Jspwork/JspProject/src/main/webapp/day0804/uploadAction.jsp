<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	ServletContext context=getServletContext();
	String realFolder = context.getRealPath("/save");
	
	System.out.println(realFolder); //확인용
	
	int fileSize = 1024*1024*5; //5메가 바이트 
	
	MultipartRequest multi =null; //null로 해놓고 여기서 생성하려함
	
	try{
	multi = new MultipartRequest(request, realFolder, fileSize,"utf-8",new DefaultFileRenamePolicy());
	
	String name= multi.getParameter("name");
	String title=multi.getParameter("title");
	String uploadFileName = multi.getFilesystemName("uploadfile");
	String originalFileName = multi.getOriginalFileName("uploadfile");  // 원래 파일명이래
	
	%>
	<table class ="table table-bordered" style="width:300px;">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><%=title %></td>
		</tr>
		<tr>
			<th>업로드파일명</th>
			<td><img src="../save/<%=uploadFileName %>"></td>
		</tr>
		
		<tr>
			<th>업로드 오리지널 파일명</th>
			<td><%=originalFileName %></td>
		</tr>
		
		<tr>			
			<td>
				<input type="button" value="업로드 다시하기" onclick="location.href='uploadForm.jsp'">
			</td>	
		</tr>
	</table>
	
	<%}catch(Exception e){
		
	}
	
	
	%>
		
		 
</body>
</html>