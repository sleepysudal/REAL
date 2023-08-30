<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css" />
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>찐 테스트 </title>
<style>

.swiper {
	width: 100%;
	height: 100%;
}

.swiper-slide {
	text-align: center;
	font-size: 18px;
	background: #fff;

	
	/* 요소 내부의 내용을 수직 중앙 정렬하는 스타일 설정 */
	display: flex; /* 표준 방식 */
	
	/* 요소 내용을 수직으로 중앙 정렬 */
	justify-content: center; /* 수평 가운데 정렬 */
	
	/* 요소 내용을 수직으로 중앙 정렬 */
	align-items: center; /* 수직 가운데 정렬 */
}

.swiper-slide img {
	display: block;
	width: 60%;
	height: 60%;
	object-fit: cover;
	
}




.swiper-button-next {
	opacity: 0.1; /*투명도 조절 */
}

.swiper-button-prev {
	opacity: 0.1; /*투명도 조절 */
}

.video-wrap {
  position: relative;
}

.video-overlay {
 position: absolute; /* 영상 위에 겹쳐지도록 절대 위치 설정 */
  top: 300px; /* 위에서부터 0px만큼 떨어진 위치에 배치 */
  left: 300px; /* 왼쪽에서부터 0px만큼 떨어진 위치에 배치 */
  width: 100%; /* 요소의 너비를 부모 요소의 100%로 설정 */
  height: 100%; /* 요소의 높이를 부모 요소의 100%로 설정 */
  display: flex; /* 내부 요소들을 플렉스 박스로 배치 */
  flex-direction: column; /* 내부 요소들을 세로 방향으로 배치 */
  text-align: left; /* 내부 텍스트를 가운데 정렬 */
  color: white; /* 텍스트 색상을 흰색으로 설정 */
  padding: 20px; /* 내부 요소와 테두리 사이의 간격 설정 */
  
}
#videoname1{
font-size: 25pt;
}
#videoname2{
font-size:13pt;
}
#moviechart1{
text-decoration: none;
color:black;
position: absolute;
left:70px;

}
#futuremovie1{
text-decoration: none;
color:black;
position: absolute;
left:350px;

}
#btnall1{
position: absolute;
right: 200px;
}

.btnwrap{
	background-color: white; /* 배경 하얀색으로 변경 */
 	display: flex; /* 내부 요소들을 플렉스 박스로 배치 */
  	align-items: center; /* 요소들을 세로 축에서 가운데로 정렬 */
 	height:150px; /* div높이 정리*/
}





</style>
</head>
<body>
	<!-- 비디오  -->
	<div class="video-wrap">
  		<div class="video-overlay">
   		 <strong class="videoname1" id="videoname1">오펜하이머</strong>
    	<span class="videoname2" id="videoname2">
      	THE WORLD FOREVER CHANGES
     	 <br>
      	세상을 영원히 바꾸다 8월 15일 대개봉!
    	</span>
  	</div>
 <!-- <video autoplay muted>
    <source src="../image/opvideo.mp4" type="video/mp4">
    </video> -->
    <iframe width="100%" height="500" src="https://www.youtube.com/embed/oSqK_v6zPoM?mute=1&autoplay=1" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share" allowfullscreen></iframe>
  
</div>
	
	<div class="movie chart wrap">
	<div class="content">
	<div class="btnwrap">
	<h3><a href="#" id="moviechart1"><i class="bi bi-bar-chart-line-fill"></i>영화 순위</a></h3>
	
	<h3><a href="#" id="futuremovie1"><i class="bi bi-film"></i>상영 예정작</a></h3>
	<button type="button" id="btnall1" class="btn btn-outline-danger" name="btnall" onclick="location.href=''">전체보기</button>
	</div>
	
	<!-- Swiper -->
	<div class="swiper mySwiper">
		<div class="swiper-wrapper">

			<div class="swiper-slide" >
			<%
			 for(int i=1; i<=10; i++){
				 %>
				 <div class="1page container" align="center">
					<img src="../image/movie<%=i %>.jpeg"><br>
					<h3 class="block"><%=i %>.영화제목</h3>
					<h6>좋아요 99%&nbsp;예매율56%</h6>
				</div>
				 <%
				 if(i%5==0){
					 %>
					 </div>
					 <div class="swiper-slide" >
					 <%
				 }
			 }
			%>
				
			</div>
			<div class="swiper-button-next">
				 <img src="../image/rightarrow.png" style="width: 100px; height: 100px;"> 
			</div>
			<div class="swiper-button-prev" >
				  <img src="../image/leftarrow.png" style="width: 100px; height: 100px;">
			</div>
			
		</div>
	</div>
	
</div>
</div>

<!-- 이벤트 -->
<div class="event">
	<h1>이벤트</h1>
	<button type="button" id="btnall2" class="btn btn-outline-danger">전체보기</button>	
	<div class="eventimage">
	<img src="../image/movie3.jpeg" id="eventimage1" style="width: 200px; height: 300px;">
	<h3>오펜하이머 상영회</h3>
<h6 style="color: gray">2023-08-26</h6>
<img src="../image/movie3.jpeg" id="eventimage2" style="width: 200px; height: 300px;">
<h3>오펜하이머 n차 관람</h3>
<h6 style="color: gray">2023-08-01~2023-10-31</h6>
</div>
</div>

	<script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

	<!-- Initialize Swiper -->
	<script>
		var swiper = new Swiper(".mySwiper", {
			spaceBetween : 30,
			centeredSlides : true,

			pagination : {
				el : ".swiper-pagination",
				clickable : true,
			},
			navigation : {
				nextEl : ".swiper-button-next",
				prevEl : ".swiper-button-prev",
			},
		});
	</script>
</body>
</html>