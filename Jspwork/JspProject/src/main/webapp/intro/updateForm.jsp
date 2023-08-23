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
<script>
$(function(){	
	$("#hp2").on('keyup',function() {
		if(this.value.length ==4) 
		$("#hp3").focus();
	});
});
</script>

<title>Insert title here</title>
</head>
<%

String num=request.getParameter("intro_num");
IntroDao dao=new IntroDao();
IntroDto dto=dao.selectIntro(num);

String pn=dto.getIntro_hp();  // 010 - 1234 - 5678
String result1 = pn.substring(0,3); //010
String result2 = pn.substring(4,8); //1234
String result3 = pn.substring(9,13); //5678

%>
<body>
<form action="updateAction.jsp" method="post" >
<input type="hidden" name="intro_num" value="<%=dto.getIntro_num() %>">
	<table class="table table-dark" style="width:400px;">
		<caption align="top"><h1>개인정보수정</h1></caption>
		<tr>
			<th style="text-align:center">이름</th>
			<td>
			<input type="text" name="intro_name" class="form-control"
			required="required" style="width:90px;" placeholder="이름"
			value="<%=dto.getIntro_name() %>">
			</td>
		</tr>		
			
		<tr>
			<th style="text-align:center">지역</th>
			<td>
			<label><input type="radio" name="intro_city" 
			 value="서울"
			 <%=dto.getIntro_city().equals("서울")?"checked":"" %>
			 >서울</label>
			
			<label><input type="radio" name="intro_city" 
			 value="부산"
			 <%=dto.getIntro_city().equals("부산")?"checked":"" %>>부산</label>
			
			<label><input type="radio" name="intro_city" 
			  value="경기"
			 <%=dto.getIntro_city().equals("경기")?"checked":"" %>>경기</label>
			
			<label><input type="radio" name="intro_city" 
			 value="인천"
			<%=dto.getIntro_city().equals("인천")?"checked":"" %>>인천</label>
			
			<label><input type="radio" name="intro_city" 
			  value="제주"
			  <%=dto.getIntro_city().equals("제주")?"checked":"" %>>제주</label>		
			</td>
		</tr>
		
		<tr>
			<th style="text-align:center">전화번호</th>			
			<td>
			<select name="intro_hp1" id="hp1" style="width:60px;">
				<option value="010"
				<%=result1.equals("010")?"selected":"" %>>010</option>
				<option value="011"
				<%=result1.equals("011")?"selected":"" %>>011</option>
				<option value="012"
				<%=result1.equals("012")?"selected":"" %>>012</option>
				<option value="013"
				<%=result1.equals("013")?"selected":"" %>>013</option>
				<option value="014"
				<%=result1.equals("014")?"selected":"" %>>014</option>
				<option value="015"
				<%=result1.equals("015")?"selected":"" %>>015</option>
				<option value="016"
				<%=result1.equals("016")?"selected":"" %>>016</option>
				<option value="017"
				<%=result1.equals("017")?"selected":"" %>>017</option>
				<option value="018"
				<%=result1.equals("018")?"selected":"" %>>018</option>
				<option value="019"
				<%=result1.equals("019")?"selected":""%>>019</option>
			</select>		
			<b>-</b>
			<input type="text" name="intro_hp2" maxlength="4" 
			required="required" style="width:60px;" id="hp2"
			value=<%=result2 %>
			>
			<b>-</b>
			<input type="text" name="intro_hp3" maxlength="4"  
			required="required" style="width:60px;" id="hp3"
			value=<%=result3 %>> 	
			</td>		
		</tr>
		<tr>
			<th style="text-align:center">혈액형</th>
			<td>
			<label><input type="radio" name="intro_blood" 
			 value="A"
			 <%=dto.getIntro_blood().equals("A")?"checked":"" %>>A</label>
			
			<label><input type="radio" name="intro_blood" 
			 value="B"
			 <%=dto.getIntro_blood().equals("B")?"checked":"" %>>B</label>
			
			<label><input type="radio" name="intro_blood" 
			 value="O"
			<%=dto.getIntro_blood().equals("O")?"checked":"" %>>O</label>
			
			<label><input type="radio" name="intro_blood" 
			 value="AB"
			 <%=dto.getIntro_blood().equals("AB")?"checked":"" %>>AB</label>
			</td>
		</tr>		
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-warning">수정</button>
			<button type="button" class="btn btn-success"
			onclick="location.href='list.jsp'">목록</button>
			</td>
		</tr>		
		</table>		
	</form>
</body>
</html>