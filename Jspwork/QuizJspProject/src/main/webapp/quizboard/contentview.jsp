<%@page import="db.quiz.QuizBoardDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	 span.day{
	 	font-size: 25px;
	 	color: red;
	 	font-family: 'gugi';
	 }
</style>
</head>
<body>
<jsp:useBean id="dao" class="db.quiz.QuizBoardDao"/>
<%
//num을 읽는다
String q_num = request.getParameter("num");

//dao 선언
//조회수 1증가
dao.updateReadCount(q_num);

//dto 
QuizBoardDto dto = dao.getBoard(q_num);

//날짜형식
SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd"); 
%>
<div style="margin:30px 30px;">
	<table class="table table-dark">
	
		<tr>
			<td>
				<b>작성자: <%=dto.getWriter() %></b><br>
				<span class="day"><%=sdf.format(dto.getWriteday()) %>
				&nbsp;&nbsp;&nbsp;조회: <%=dto.getReadcount() %>
				</span>
			</td>
		</tr>
		
		<tr height="150">
			<td>
				<!-- pre태그 안에 쓰거나 replace()이용한다: db 저장시 br태그가 \n으로 저장된다.. 그러므로 출력시 다시 br 로 변환한다 -->
				<%=dto.getContent().replace("\n", "<br>") %> <%-- / 를 자바의 br 로 바꿔줌 --%>
			</td>
		</tr>
		
		<tr>
			<td>
				<button type="button" class="btn btn-outline-danger" 
				onclick="location.href='quizform.jsp'"><i class="bi bi-piggy-bank"></i>글쓰기<i class="bi bi-piggy-bank"></i></button>
				<button type="button" class="btn btn-outline-danger" 
				onclick="location.href='quizlist.jsp'"><i class="bi bi-piggy-bank"></i>목록<i class="bi bi-piggy-bank"></i></button>
				<button type="button" class="btn btn-outline-danger" 
				onclick="location.href='updatepassform.jsp?num=<%=dto.getQ_num()%>'"><i class="bi bi-piggy-bank"></i>수정<i class="bi bi-piggy-bank"></i></button>
				<button type="button" class="btn btn-outline-danger" 
				onclick="location.href='deletepassform.jsp?num=<%=dto.getQ_num()%>'"><i class="bi bi-piggy-bank"></i>삭제<i class="bi bi-piggy-bank"></i></button>
			</td>
		</tr>
		
	</table>
</div>
</body>
</html>