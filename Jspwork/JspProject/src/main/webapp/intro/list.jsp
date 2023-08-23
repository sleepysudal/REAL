<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.intro.IntroDto"%>
<%@page import="java.util.Vector"%>
<%@page import="model.intro.IntroDao"%>
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
IntroDao dao = new IntroDao();
Vector<IntroDto>list = dao.getData();
SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
%>
<body>
<button type="button" class="btn btn-outline-warning" onclick="location.href='insertForm.jsp'">추가</button>
<br>
<table class="table table-dark" style="width:700px;">
<caption align="top"><h1>개인정보모음</h1></caption>
	<tr align="center" class="table-striped">
		<th width="100">이름</th>
		<th width="100">지역</th>
		<th width="150">전화번호</th>
		<th width="100">혈액형</th>
		<th width="150">가입일</th>
		<th width="150">수정,삭제</th>
	</tr>
	<% 
	for(int i=0; i<list.size(); i++){
		IntroDto dto=list.get(i);
	
	%>
	<tr>		
		<td style="text-align:center" valign="middle" onclick="location.href='detailPage.jsp?intro_num=<%=dto.getIntro_num()%>'"><%=dto.getIntro_name() %></td>
		<td style="text-align:center" valign="middle" onclick="location.href='detailPage.jsp?intro_num=<%=dto.getIntro_num()%>'"><%=dto.getIntro_city() %></td>
		<td style="text-align:center" valign="middle" onclick="location.href='detailPage.jsp?intro_num=<%=dto.getIntro_num()%>'"><%=dto.getIntro_hp() %></td>
		<td style="text-align:center" valign="middle" onclick="location.href='detailPage.jsp?intro_num=<%=dto.getIntro_num()%>'"><%=dto.getIntro_blood() %></td>
		<td style="text-align:center" valign="middle" onclick="location.href='detailPage.jsp?intro_num=<%=dto.getIntro_num()%>'"><%=dto.getGaipday() %></td>	
	
	
		<td>
		<button type="button" class="btn btn-info btn-sm"
		onclick="location.href='updateForm.jsp?intro_num=<%=dto.getIntro_num() %>'">수정</button>
		<button type="button" class="btn btn-danger btn-sm"
		onclick="del(<%=dto.getIntro_num() %>)">삭제</button>
		</td>
	</tr>
	<% 
	}
	%>
	</table>	
<script>
function del(intro_num){
	var a = confirm("정말 삭제?");
	if(a){
		location.href='introdelete.jsp?intro_num='+intro_num; //주소 이동 - 값넘겨줌 - 받는값은 intro_num
	}
	else{
		return;
	}
}
</script>	
</body>
</html>