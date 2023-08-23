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
		#selphoto{
			position:absolute;
			top:100px;
			left:500px;
			width:150px;
			border-radius:20px;
		}
		</style>
		<script type="text/javascript">
		$(function(){
			//select 된 선택값 넣기
			var srcImg=$("#photo").val();
			//selphoto에 넣기
			$("#selphoto").attr("src",srcImg);
			
			$("#photo").change(function(){
				var s=$(this).val();
				$("#selphoto").attr("src",s);
			});
		});
		</script>
</head>
<body>
<form action="addAction.jsp" method="post">
	<table class="table table-dark" style="width:400px;">
	<caption align="top"><h3>상품등록</h3></caption>
		<tr>
			<th style="text-align:center">상품명</th>
			<td>
			<input type="text" name="sangpum" class="form-control"
			required="required" style="width:150px;" placeholder="상품명">
			</td>
		</tr>
		
		<tr>
			<th style="text-align:center" >상품사진</th>
			<td>
			<select name="photo" id="photo" class="form-control" style="width:150px;">
				<option value="../image/01.png">원피스</option>								
				<option value="../image/02.png">반팔티</option>
				<option value="../image/03.png">바지</option>
				<option value="../image/04.png">신발</option>
				<option value="../image/05.png">머플러</option>			
			</select>
			</td>
		</tr>
		
	
		<tr>
			<th style="text-align:center">가격</th>
			<td>
			<input type="text" name="price" class="form-control"
			required="required" style="width:150px;"placeholder="가격">	
			</td>
		</tr>
		
		<tr>
			<th style="text-align:center">입고일</th>
			<td>
			<input type="date" name="ipgoday" class="form-control"
			required="required" style="width:150px;">
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<button type="submit" class="btn btn-info">저장</button>
			<button type="button" class="btn btn-primary"
			onclick="location.href='list.jsp'">목록</button>
			</td> 
		</tr>			
	</table>
</form>
<img src="" id="selphoto">
</body>
</html>