<%@page import="java.util.List"%>
<%@page import="Dto.MemberDto"%>
<%@page import="Dao.MemberDao"%>
<%@page import="Dto.AnswerDto"%>
<%@page import="Dao.AnswerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dto.MovieDto"%>
<%@page import="Dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=VT323&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>detail</title>
<%
//절대경로잡기
String root = request.getContextPath();
%>	
<style>
/* 스타일은 위에서 내려오는 순으로 적음 추가시 같은 위치쪽 삽입 */

b{
	color: white; <!-- b태그 글씨 색깔 -->
}

/* 디테일 큰 div */
.detailblock{
	width: 100%;
	height: 2035px;
	border: 10px solid white;
}

/* 디테일 내부 라인 div */
.detailall{
	position: absolute;
	right: 13.2%;
	left: 13.2%;
	width: 73.6%;
	height: 1950px;
	border: 10px solid white;
	margin-top: 50px;
}

/* 영화 포스터 div */
.detailposter{
	position: relative;
	left: 270px;
	width: 300px;
	height: 400px;
}

.detailposter img{
	width: 290px;
	height: 400px;
}

/* 영화 이름 div */
.detailtitle{
	position:absolute;
	top: 0px;
	left: 600px;
	width: 500px;
	height: 50px;
	border: 2px solid white;
	font-size: 1.5em;
}

/* 영화 예매율 div border-bottom: 1px white; 추가 */
.detailreserve{
	color: white;
	position:absolute;
	top: 50px;
	left: 600px;
	width: 500px;
	height: 50px;
	border: 2px solid white;
}

/* 장르, 개봉 div */
.detailinfo{
	color: white;
	position: absolute;
	top: 100px;
	left: 600px;
	width: 500px;
	height: 50px;
	border: 2px solid white;
}

/* 스토리 */
.detailstory{
	color: white;
	position: absolute;
	top: 500px;
	left: 270px;
	width: 830px;
	height: 500px;
	border: 2px solid white;
}

/* 예매하기 버튼 */
#detailbtn1{
	position: absolute;
	top: 355px;
	left: 600px;
	color: white;
	background-color: #DF3E49;
	width: 100px;
	height: 45px;
	border: none;
	border-radius: 20px;
	font-weight: 500;
}
/* 이전으로 버튼 */
#detailbtn2{
	position: absolute;
	top: 355px;
	left: 710px;
	color: black;;
	background-color: white;
	width: 100px;
	height: 45px;
	border: none;
	border-radius: 20px;
	font-weight: 500;
}

.detailcomment{
	position: absolute;
	top: 1100px;
	left: 270px;
	
}

.detailresult{
	position: absolute;
	top: 1650px;
	left: 170px;
	width: 1030px;
	height: 500px;
	border: 2px solid white;
}
i.penguin{
font-size: 23pt;
}


</style>
<%
// 쿼리 파라미터에서 포스터 ID를 가져옵니다.
String mv_no = request.getParameter("mv_no");
String mv_title = request.getParameter("mv_title");
String mv_poster = request.getParameter("mv_poster");
String mv_st = request.getParameter("mv_st");
String mv_genre = request.getParameter("mv_genre");
String mv_opendate = request.getParameter("mv_opendate");


//answer 테이블 
String idx = request.getParameter("idx"); //시퀀스
//String num = (String)session.getAttribute("num");// num-answer 
String num = request.getParameter("mv_no"); //member-mvno
String content = request.getParameter("content");//댓글 내용
String star = request.getParameter("star"); //별점
String writeday = request.getParameter("writeday"); //작성일 가져옴
String myid = (String)session.getAttribute("myid");


//무비테이블
MovieDao dao = new MovieDao();
MovieDto dto = dao.getData(mv_no); //영화번호 가져온다

//댓글테이블
AnswerDao adao = new AnswerDao();
AnswerDto adto = adao.getData(idx); //댓글 별점 작성일 다 가져오고싶다
List<AnswerDto> alist=adao.getAllAnswers(dto.getMv_no());

//멤버테이블
MemberDao mdao = new MemberDao();
MemberDto mdto = mdao.getData(num); //mem_id 가져오기

%>

<script type="text/javascript">

	/* 이전 화면으로 돌아가는 이벤트*/
	function back() {
		history.back();
	}
	//댓글 추가 버튼
	$(function(){
		
		list();
		
		$("#btnadd").click(function(){
		var content=$("#content").val();
		var star=$("#star").val();
		
		var num =  $("#num").val();
		
		
		$.ajax({
			type:"post",
			datatype:"html",
			url:"answer/addanswer.jsp",
			data: {"content":content, "star":star, "num":<%=num%>},
			success: function(res){
				//인서트 후 초기화
				$("#content").val(" ");
				$("#star").val(" ");
				
				list();

			}
		})
	})
})
//댓글리스트
function list(){
		$.ajax({
			type:"get",
			url:"answer/listboard.jsp",
			data: {"num":<%=num%>}, // num을 서버로 전송
			dataType:"json",
			success: function(data){
				//alert(data.length);
				var s = "<table class='table table-bordered' style='width:1030px;'>";
				s+="<caption align='top'><b>댓글목록</b></caption>";
				s+="<tr>";
				s+="<th>번호</th>"
				s+="<th>작성자</th>";
				s+="<th>별점</th>";
				s+="<th>내용</th>";
				s+="<th>작성일</th>";
				s+="</tr>";
				
				if(data.length==0){
					s+="<tr>";
					s+="<td colspan='4' align='center'>";
					s+="<b>저장된 글이 없습니다</b>";
					s+="</td></tr>";
				}else{
					$.each(data, function(i,item){
						s+="<tr>";
						s+="<td align='center'>" + (i+1)+"</td>";
						s+="<td>" + item.myid+ "</td>";
						s+="<td>"+item.star+ "</td>";
						s+="<td>"+item.content+"</td>";
						s+="<td>"+item.writeday+"</td>";
						s+="</tr>";
					})
				}
				s+="</table>";
				$(".detailresult").html(s);
				
			}
		})
	}

</script>
</head>

<body>
<!-- 큰 div 영역 -->
<div class="detailblock">
	<!-- 출력할 컨텐츠 영역 -->
	<div class="detailall">
		<div class="detailposter"><b><img src="<%=dto.getMv_poster()%>"></b></div>
		<div class="detailtitle"><b>영화제목 : <%=dto.getMv_title() %></b></div>
		<div class="detailreserve">예매율 (border-bottom 1px white 추가)</div>
		<div class="detailinfo">장르 : <%=dto.getMv_genre() %><br>개봉 : <%=dto.getMv_opendate() %></div>
		<div class="detailstory"><%=dto.getMv_st() %></div>
		<button type="button" id="detailbtn1" onclick="location='<%=root%>/index.jsp?main=Movie_reserve/movielist.jsp'">예매하기</button>
		<button type="button" id="detailbtn2" onclick="back()">이전으로</button>
		
	
		<!-- 댓글 입력 -->
		<div class="detailcomment">	
		<form>
			<input type="hidden" id="num" value="<%=num %>">
			<table class="table table-bordered" style="width:600px; height: 250px;">
			<caption align="top"><b>댓글 입력</b></caption>
				<tr>
					<th align="center" valign="middle" style="width: 150px;">작성자</th>
					<td>
					<%=myid%>
					
					</td>
				</tr>
				
				<tr>
					<th align="center" valign="middle" style="width: 100px;">댓글작성</th>
					<td>
					<input type="text" id="content" style="width:500px; height: 200px;"  class="form-control"
					placeholder="댓글을 입력해주세요">  
					</td>
				</tr>
				
				<tr>
					<th align="center" valign="middle" style="width: 100px;">별점</th>
					<td>
					<select name="star" id="star" style="width:100px;">
						<option value="1">★</option>
						<option value="2">★★</option>
						<option value="3">★★★</option>
						<option value="4">★★★★</option>
						<option value="5" selected>★★★★★</option>
					</select>
					</td>
				</tr>
				
				<tr>
					<th align="center" valign="middle">댓글등록</th>
					<td colspan="2">
						<button type="button" class="btn btn-outline-danger" id="btnadd"><i class="bi bi-tencent-qq penguin"></i></button>
					</td>
				</tr>
			</table>
		</form>
		</div>
		<div class="detailresult"><b>댓글출력</b></div>
			<table class="table table-bordered" style="width:1000px;">
			<caption align="top"></caption>
			</table>
	</div>
</div>

</body>
</html>