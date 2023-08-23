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
<body>
<form action="insertAction.jsp" method="post">
	<table class="table table-dark" style="width:400px;">
		<caption align="top"><h1>개인정보입력해주세요</h1></caption>
		<tr>
			<th style="text-align:center">이름</th>
			<td>
			<input type="text" name="intro_name" class="form-control"
			required="required" style="width:90px;" placeholder="이름">
			</td>
		</tr>
		
		<tr>
			<th style="text-align:center">지역</th>
			<td>
			<label><input type="radio" name="intro_city" 
			 value="서울" >서울</label>
			<label><input type="radio" name="intro_city" 
			 value="부산">부산</label>
			<label><input type="radio" name="intro_city" 
			  value="경기">경기</label>
			<label><input type="radio" name="intro_city" 
			 value="인천">인천</label>
			<label><input type="radio" name="intro_city" 
			  value="제주">제주</label>	
			</td>
		</tr>
		
		<tr>
			<th style="text-align:center">전화번호</th>
			<td>
			<select name="intro_hp1" id="hp1" style="width:60px;">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="012">012</option>
				<option value="013">013</option>
				<option value="014">014</option>
				<option value="015">015</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="018">018</option>
				<option value="019">019</option>
			</select>		
			<b>-</b>
			<input type="text" name="intro_hp2" maxlength="4" 
			required="required" style="width:60px;" id="hp2">
			<b>-</b>
			<input type="text" name="intro_hp3" maxlength="4"  
			required="required" style="width:60px;" id="hp3"> 	
			</td>		
		</tr>
		<tr>
			<th style="text-align:center">혈액형</th>
			<td>
			<label><input type="radio" name="intro_blood" 
			 value="A">A</label>
			<label><input type="radio" name="intro_blood" 
			 value="B">B</label>
			<label><input type="radio" name="intro_blood" 
			 value="O">O</label>
			<label><input type="radio" name="intro_blood" 
			 value="AB">AB</label>
			</td>
		</tr>
		<tr>
			<th style="text-align:center">가입일</th>
			<td>
			<input type="date" name="gaipday" class="form-control"
			required="required" style="width:150px;">			
			</td>		
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-info">저장</button>
			<button type="button" class="btn btn-success"
			onclick="location.href='list.jsp'">목록</button>
			</td>
		</tr>		
		</table>		
	</form>
</body>
</html>