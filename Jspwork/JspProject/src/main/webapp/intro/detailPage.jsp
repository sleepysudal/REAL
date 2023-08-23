<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.intro.IntroDao"%>
<%@page import="model.intro.IntroDto"%>
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
<style>
a {
	text-decoration: none;
}

tr {
	font-family: 'gugi';
	font-size: 20px;
}
</style>
</head>
<body>
<%
String num=request.getParameter("intro_num");
IntroDao dao = new IntroDao();
IntroDto dto =dao.selectIntro(num);
SimpleDateFormat sdf =new SimpleDateFormat("yyyy년-MM월-dd일");

%>
 <div style="margin:100px 100px;">
 <table class="table table-dark" style="width:700px;">
 <caption align="top"><h1><%=dto.getIntro_name() %>님의 정보입니다</h1></caption>
 	<tr> 		
 		<td rowspan="6">
 		<img src="../image/01.png" style="width:300px" border="solid 3px red"> 		
 		</td> 		
 	</tr>
 	<tr>
 		<th>이름</th>
 		<td><%=dto.getIntro_name() %></td>
 	</tr>
 	<tr>
 		<th>혈액형</th>
 		<td><%=dto.getIntro_blood() %>형</td>
 	</tr>
 	<tr>
 		<th>전화번호</th>
 		<td><%=dto.getIntro_hp() %></td>
 	</tr>
 	<tr>
 		<th>주거지</th>
 		<td><%=dto.getIntro_city() %></td>
 	</tr>
 	<tr>
 		<th>가입날짜</th>
 		<td><%=sdf.format(dto.getGaipday()) %></td>
 	</tr>
 	</table>
</div>
</body>

</html>