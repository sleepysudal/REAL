<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<body>
<div style="margin:100px 600px; width:400px">
	<form action="quizaction.jsp" method="post" enctype="multipart/form-data" class="form-inline">
		<table class="table table-bordered">
			<caption align="top"><i class="bi bi-piggy-bank"></i>글쓰기</caption>
			
			<tr>
				<th style="background-color:skyblue">작성자</th>
					<td>
						<input type="text" name="writer" class="form-control"
						required="required" autofocus="autofocus" style="width:150px">
					</td>
			</tr>
			
			<tr>
				<th style="background-color:skyblue">제목</th>
					<td>
						<input type="text" name="title" class="form-control"
						required="required"  style="width:270px">
					</td>
			</tr>
			
			<tr>
					<th style="background-color:skyblue">내용</th>
					<td>
					<textarea name="content" class="form-control" required="required"></textarea>
					</td>
				
			</tr>
			
			<tr>
				<th style="background-color:skyblue">이미지업로드</th>
				<td>
					<input type="file" name="imgname" class="form-control">
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center">
				<!-- type이 image거나 submit이면 기본이 submit이다 -->
					<input type="image" src="../image/button.png" style="width:70px;">
					
					 <input type="image" src="../image/list.png" style="width:70px;"
					onclick="location.href='quizlist.jsp'; return false;">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>