<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="db.quiz.QuizBoardDao"%>
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
QuizBoardDao dao = new QuizBoardDao();
List <QuizBoardDto> list= dao.getAllBoards();
%>
<button type="button" onclick="location.href='quizlist.jsp'">목록</button>
<table>
<tr>

	<%
	for(int i=1; i<=list.size(); i++)
	{ 
	QuizBoardDto dto = list.get(i-1);
	%>
		
			<td>
		
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="<%=dto.getImgname() %>" style="width:100px;"><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;작성자:<%=dto.getWriter() %><br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;내용:<%=dto.getContent() %>
			</td>
		
		<%if(i%3==0){%>
		</tr>
		<tr>
	<%}}
	
	%>
	</tr>
</table>
</body>
</html>