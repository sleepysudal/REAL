<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.mymall.MallDto"%>
<%@page import="model.mymall.MallDao"%>
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

tr{
font-family:'gugi';
font-size:20px;
}

</style>
</head>
<%
String no=request.getParameter("no");
MallDao dao = new MallDao();
MallDto dto = dao.getData(no);
SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm");
NumberFormat nf=NumberFormat.getCurrencyInstance();
%>
<body>
	<div style="margin: 100px 100px;">
		<table class="table table-bordered" style="width: 700px;">
			<caption align="top">
				<h1>상품 상세보기</h1> 
			</caption>
			<tr style="width:100px;">
				<td rowspan="4">
				<img src="<%=dto.getPhoto()%>">
				</td>
			</tr>
			
			<tr>
				<th>상품명</th>
				<td><%=dto.getSangpum()%></td>
			</tr>
			
			<tr>
				<th>가격</th>
				<td><%=nf.format(Integer.parseInt(dto.getPrice())) %></td>
			</tr>
			
			<tr>
				<th>등록일</th>
				<td><%=sdf.format(dto.getWriteday()) %></td>
			</tr>
			
			<tr>
				<td colspan="3" align="center">
					<button type="button" class="btn btn-outline-dark btn-lg"
					onclick="location.href='list.jsp'">목록으로 가기</button>
				</td>
			</tr>			
		</table>			
	</div>
</body>
</html>