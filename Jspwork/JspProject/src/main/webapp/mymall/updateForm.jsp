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
<%
String no = request.getParameter("no");
MallDao dao = new MallDao();
MallDto dto = dao.getData(no);
%>
<body>
	<form action="updateAction.jsp" method="post">  <!-- 주소창에 인자값들 뜨는것 post 활용해서 숨김 -->
		<input type="hidden" name="no" value="<%=dto.getNo()%>"> <!-- no 시퀀스값은 hidden 사용해서 숨김 -->
		<table class="table table-dark" style="width: 400px;"> <!-- 부트스트랩활용해서 테이블 스타일적용 -->
		<caption align="top"><h3>등록상품수정</h3></caption>    <!-- 테이블 상단에 등록상품수정이라고 텍스트 추가 -->
			<tr>
				<th style="text-align: center">상품명</th>
				<td>
				<input type="text" name="sangpum" class="form-control"
					required="required" style="width: 150px;" placeholder="상품명"
					value="<%=dto.getSangpum() %>">
				</td>
			</tr>
			<tr>
				<th style="text-align: center">상품사진</th>
				<td>
				<select name="photo" id="photo" class="form-control"
				style="width:150px;">
						<option value="../image/01.png"
						<%=dto.getPhoto().equals("../image/01.png")?"selected":"" %>>원피스</option>
						<option value="../image/02.png"
						<%=dto.getPhoto().equals("../image/02.png")?"selected":"" %>>반팔티</option>
						<option value="../image/03.png"
						<%=dto.getPhoto().equals("../image/03.png")?"selected":"" %>>바지</option>
						<option value="../image/04.png"
						<%=dto.getPhoto().equals("../image/04.png")?"selected":"" %>>신발</option>
						<option value="../image/05.png"
						<%=dto.getPhoto().equals("../image/05.png")?"selected":"" %>>머플러</option>
				</select>
				</td>
			</tr>


			<tr>
				<th style="text-align: center">가격</th>
				<td>
				<input type="text" name="price" class="form-control"
					required="required" style="width: 150px;" placeholder="가격"
					value="<%=dto.getPrice() %>">
				</td>
			</tr>

			<tr>
				<th style="text-align: center">입고일</th>
				<td>
				<input type="date" name="ipgoday" class="form-control"
					required="required" style="width: 150px;" 
					value="<%=dto.getIpgoday() %>"></td>
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
	<img src="" id="selphoto">
</body>
</html>