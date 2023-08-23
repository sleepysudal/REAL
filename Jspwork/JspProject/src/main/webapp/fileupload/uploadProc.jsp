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
	ServletContext context = getServletContext();
	String realFolder = context.getRealPath("/upload"); //upload 폴더 무조건 만들어라 - 그폴더이름 쓰는거임
	
	System.out.println(realFolder);
	
	int filesize=1024*1024*3; //3mb
	
	MultipartRequest multi = null; 
	//여기서는 우리가 try 캐치 직접해야함
	
	try{
	multi=new MultipartRequest(request, realFolder,filesize,"utf-8",
		new DefaultFileRenamePolicy());
	
		String writer= multi.getParameter("writer");
		String subject = multi. getParameter("subject");
		String uploadName=multi.getFilesystemName("uFile");
		String orignalFileName = multi.getOriginalFileName("uFile");
		%>
		
		<table class="table" style="width:300px";>
		<tr>
			<th>글쓴이</th>
				<td><%=writer %></td>
		</tr>
		<tr>
			<th>제목</th>
				<td><%=subject %></td>
		</tr>
		<tr>
			<th>업로드파일명</th>
				<td><img src="../upload/<%=uploadName%>"></td>
		</tr>
		<tr>
			<th>원래 파일명</th>
			<td><%=orignalFileName %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<input type="button" value="다시업로드"
			onclick="location.href='uploadForm.jsp'">
			</td>
		</tr>
		</table>
	<%}catch(Exception e){
		System.out.println("업로드 오류: "+e.getMessage());
	}
%>
</body>
</html>