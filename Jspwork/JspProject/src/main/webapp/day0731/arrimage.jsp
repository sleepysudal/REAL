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
	String[] str = { "01.png", "02.png", "03.png", "04.png", "05.png", "06.png", "07.png", "08.png", "09.png" };
	int n = 0;
	%>
	<table class="table table-bordered" style="width: 450px;">
		<%
		for (int i = 0; i < 3; i++) {
		%>
			<tr>
			<% 
				for(int j=0; j<3; j++){
					%>
					<td>
					<img src="../image/<%=str[n]%>" width="150" height="150">
					</td>
				<%
				n++;
				}
			%>
			</tr>
		<%
		}
		%>
	</table>
</body>
</html>