<%@page import="model.myteam.TeamDto"%>
<%@page import="model.myteam.TeamDao"%>
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
<%
	String num=request.getParameter("num");
	TeamDao dao=new TeamDao();
	TeamDto dto=dao.getData(num);
%>
<body>
	<form action="updateAction.jsp" method="post">
	<input type="hidden" name="num" value="<%=dto.getNum() %>">
		<table class="table table-bordered" style="width: 300px;">
			<tr>
				<th>이름</th>
				<td>
				<input type="text" name="name" class="form-control"
				 required="required" style="width: 120px;" placeholder="이름"
				  value="<%=dto.getName() %>"> <!-- required 는 값 입력무조건받게하기 알림띄워줌 -->
				</td>
			</tr>
			<tr>
				<th>운전면허</th>
				<td>
				<input type="checkbox" name="driver" <%=dto.getDriver().equals("있음")?"checked":"" %>>있음				
				</td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
				<input type="text" name="addr" class="form-control" value="<%=dto.getAddr() %>"
				required="required" style="width: 180px;" placeholder="주소"> <!-- required 는 값 입력무조건받게하기 알림띄워줌 -->
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<button type="submit" class="btn btn-warning">수정</button>
				<button type="button" class="btn btn-info"
				onclick="location.href='list.jsp'">목록으로이동</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>