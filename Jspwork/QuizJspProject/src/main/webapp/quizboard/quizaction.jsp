<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="db.quiz.QuizBoardDao"%>
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
request.setCharacterEncoding("utf-8");

ServletContext context=getServletContext();
String realFolder = context.getRealPath("/upload");
System.out.println(realFolder);
int filesize=1024*1024*3;
MultipartRequest multi = null;

multi = new MultipartRequest(request, realFolder, filesize, "utf-8",new DefaultFileRenamePolicy());

QuizBoardDao dao = new QuizBoardDao();
QuizBoardDto dto = new QuizBoardDto();

String writer = multi.getParameter("writer");
String title = multi.getParameter("title");
String content = multi.getParameter("content");
String imgname=multi.getFilesystemName("imgname");

dto.setWriter(writer);
dto.setTitle(title);
dto.setContent(content);

if(imgname==null)
	dto.setImgname("../image/noimage.jpg");
else
	dto.setImgname("../upload/"+imgname);

//db인서트 
dao.insertBoard(dto);
//이동
response.sendRedirect("quizlist.jsp");
	

%>

</body>
</html>