<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.myteam.TeamDto"%>
<%@page import="java.util.ArrayList"%>
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
TeamDao dao = new TeamDao();
ArrayList<TeamDto> list = dao.getAllMyTeams();
//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd HH:mm");
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM--dd");
%>
<body>
	<a href="addForm.jsp">팀원추가</a>
	<br>
	<table class="table table-dark" style="width: 800px;">
		<tr align="center" class="table-dark">
			<th width="60">번호</th>
			<th width="60">이름</th>
			<th width="60">운전면허</th>
			<th width="150">주소</th>
			<th width="150">작성일</th>
			<th width="60">수정 삭제</th>
		</tr>
		<%
		for (int i = 0; i < list.size(); i++) {
			TeamDto dto = list.get(i); //i번지의 dto를 꺼낸다
		%>
		<tr>
			<td align="center"><%=i + 1%></td>
			<td align="center"><%=dto.getName()%></td>
			<td align="center"><%=dto.getDriver()%></td>
			<td align="center"><%=dto.getAddr()%></td>
			<td align="center"><%=dto.getWriteday()%></td>
		
			<td>
            <button type="button" class="btn btn-info btn-lg"
            onclick="location.href='updateForm.jsp?num=<%=dto.getNum()%>'">수정</button>
            <button type="button" class="btn btn-danger btn-sm"
            onclick="delete1(<%=dto.getNum()%>)">삭제</button>       
           </td>		
		</tr>
			<%
			}
			%>
		
	</table>
	<script>
      function delete1(num){
         var a = confirm("정말 삭제 하시겠습니까?");
         if(a){
            location.href='teamdelete.jsp?num=' + num;
         }
         else{
            return;
         }
      }
   </script>
</body>
</html>