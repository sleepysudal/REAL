<%@page import="model.mymall.MallDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
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
td{
font-family:'gugi';
font-size:20px;


}
</style>
</head>
<%
	MallDao dao= new MallDao();
	ArrayList<MallDto>list = dao.getAllMyMalls();
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
	<button type="button" class="btn btn-outline-warning" onclick="location.href='addForm.jsp'">추가</button>
	<br>
	<table class = "table table-dark" style="width:1000px;">
		<tr align="center" class="table-striped">
			<th width="100">번호</th>
			<th width="100">상품명</th>
			<th width="100">상품사진</th>
			<th width="100">가격</th>
			<th width="100">입고일</th>
			<th width="100">작성일</th>
			<th width="100">수정 삭제</th>
		</tr>
		<% 
		for(int i=0; i<list.size(); i++){
			MallDto dto = list.get(i); 
		
		%>
		<tr>
			<td style="text-align:center" valign="middle"><%=i+1 %>번</td>
			<td style="text-align:center" valign="middle"><%=dto.getSangpum() %></td>
			<td style="text-align:center" valign="middle"><img src='<%=dto.getPhoto() %>' 
			onclick="location.href='detailPage.jsp?no=<%=dto.getNo() %>'"></td>
			<td style="text-align:center" valign="middle"><%=dto.getPrice() %>원</td>
			<td style="text-align:center" valign="middle"><%=dto.getIpgoday() %></td>
			<td style="text-align:center" valign="middle"><%=dto.getWriteday() %></td>
			
			<td>
			<button type="button" class="btn btn-danger btn-sm"
			onclick="location.href='updateForm.jsp?no=<%=dto.getNo() %>'">수정</button>
			<button type="button" class="btn btn-warning btn-lg"
			onclick="delete1(<%=dto.getNo()%>)">삭제</button>
			</td>
		</tr>
		<%
		}
		%>
		</table>
		<script>
		function delete1(no){
	         var a = confirm("정말 삭제 하시겠습니까?");
	         if(a){
	            location.href='malldelete.jsp?no=' + no;
	         }
	         else{
	            return;
	         }
	      }
		</script>			
</body>
</html>