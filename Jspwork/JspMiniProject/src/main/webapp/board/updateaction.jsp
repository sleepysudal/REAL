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
   //엔코딩
   request.setCharacterEncoding("utf-8");
   String num=request.getParameter("num");
   String currentPage=request.getParameter("currentPage");
   System.out.println(currentPage);
%>
<jsp:useBean id="dao" class="data.dao.SmartDao"/>
<jsp:useBean id="dto" class="data.dto.SmartDto"/>
<jsp:setProperty property="*" name="dto"/>
<%
  dao.updateSmart(dto);

  //목록으로 이동
  //response.sendRedirect("../index.jsp?main=board/boardlist.jsp");
  
  //디테일페이지로 이동하려면 방금 insert된 num값을 알아야한다
  
  response.sendRedirect("../index.jsp?main=board/contentview.jsp?num="+num+"&currentPage="+currentPage);
   
%>
</body>
</html>