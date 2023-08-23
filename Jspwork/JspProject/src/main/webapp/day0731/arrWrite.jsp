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
	//배열 선언
	String[] colors = { "red", "orange", "yellow", "green", "blue" };
	//제목
	String title = "배열출력";
	%>
	<b><%=title%></b>
	<table class="table table-bordered" style="width: 200px;">

		<tr>
			<th style="text-align:center">번호</th>
			<th style="text-align:center">색상</th>
		</tr>
		<%
		for (int i = 0; i < colors.length; i++) {
		%>
		<tr>
			<td align="center"><%=i + 1%></td>
			<td><b style="color: <%=colors[i]%>"><%=colors[i]%></b></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>