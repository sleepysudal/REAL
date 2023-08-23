<%@page import="Mysawon.model.MysawonDao"%>
<%@page import="Mysawon.model.MysawonDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<style>
div{
cursor:pointer;
}
#btn1{
position: absolute;
top:60px;
left:1000px;
}
</style>

<title>Insert title here</title>
<%
MysawonDto dto = new MysawonDto();
MysawonDao dao = new MysawonDao();

%>
</head>
<body>
	<button type="button" id="btn1" class="btn btn-warning" onclick="loaction.href=''">뒤로가기</button>
	<input type="hidden" value=<%=dto.getNum() %>>
	<div style="margin:50px 600px;"> 
		<form action="AdminAction.jsp" method="post" class="form-inline">
			<table class="table table-dark" style="width:500px;">
			<caption align="top"><h1>관리자 추가</h1></caption>
			
			
			
			<tr>
				<td style="background-color:skyblue" width="150" align="center">직위
				<td>
				<select name="grade" id="grade" style="width:100px;">
					<option value="사원">사원</option>
					<option value="대리">대리</option>
					<option value="과장">과장</option>
					<option value="부장">부장</option>
					<option value="임원">임원</option>
					<option value="사장">사장</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td style="background-color:skyblue" width="150" align="center">부서
				<td>
				<label><input type="radio" name="buseo" value="관리부">관리부</label>
				<label><input type="radio" name="buseo" value="남성부">남성부</label>
				<label><input type="radio" name="buseo" value="여성부">여성부</label>
				<label><input type="radio" name="buseo" value= "출석부">출석부</label>
				</td>
			</tr>
			
			<tr>
				<td style="background-color:skyblue" width="150" align="center">급여
				<td>
					<input type="text" name="pay" id="pay">
				</td>
			</tr>
			
			<tr>
				<td style="background-color:skyblue" width="150" align="center">입사일
				<td>
					<input type="date" name="ipsaday" id="ipsaday">
				</td>
			</tr>
			
			
			<tr>
				<td colspan="2" align="center">
			    <button type="submit" id="btn2" class="btn btn-success">등록</button>
				</td>
			</tr>
			</table>
		</form>
	</div>
	
</body>
</html>