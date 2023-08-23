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
div.loginform{
width:500px;
margin-top:200px;
margin-left:700px;
}
h1{
font-family:'gugi';

}

</style>
</head>
<body>
<%
//세션으로부터 아이디,비밀번호,저장 값 얻기
String myid=(String)session.getAttribute("idok");
String saveid=(String)session.getAttribute("saveok");

boolean save = true;

if(saveid==null)
{
	myid="";
	save=false;
}
%>
 <div class="loginform">
 	<form action="loginAction.jsp" method="post"> 		
 			<table class="table table-dark" style="width:400px;">
 			<caption align="top"><h1>&nbsp;&nbsp;&nbsp;&nbsp;
 			&nbsp;&nbsp;&nbsp;로그인화면</h1></caption>
 				<tr>
 					<th>아이디</th>
 					<td>
 					<input type="text" id="id" name="id" class="form-control" 
 					required="required" style="width:200px;" value="<%=myid %>"
 					placeholder="아이디입력">
 					</td>
 				</tr>
 				<tr>
 					<th>비밀번호</th>
 					<td>
 					<input type="password" id="pass" name="pass" class="form-control" 
 					required="required" style="width:200px;"
 					placeholder="비밀번호입력">
 					</td>
 				</tr>
 				<tr>
 					<td colspan="2" align="center">
 					<button type="submit" id="btn1" class="btn btn-outline-info">로그인</button>
 					<button type="button" id="btn2" class="btn btn-outline-success" 
 					onclick="location.href='addForm.jsp'">회원가입</button>
 					<br><br>
 					<input type="checkbox" name="savecheck" id="savecheck"
 					<%=save?"checked":"" %>>&nbsp;&nbsp;아이디저장
 					</td>
 				</tr>				
 			
 				
 			</table> 		
 	</form>
 </div>
</body>


</html>