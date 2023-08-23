<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300&family=Gamja+Flower&family=Nanum+Pen+Script&family=Noto+Serif+KR:wght@200&display=swap" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	div.layout{
	border:0px solid gray;
	position: absolute;
	}
	div.title{
	width:100%;
	height:80px;
	line-height:80px;
	font-size:30px;
	font-family:'gugi';
	text-align:left;
	}
	div.menu{
	width:100%;
	height:80px;
	line-height:80px;
	font-family:'gugi';
	text-align:center;
	top:80px;
	}
	div.info{
	width:200px;
	height:500px;
	line-height:10px;
	font-family:'gugi';
	left:30px;
	top:300px;
	padding: 20px 10px;
	border:5px groove skyblue;
	border-radius:30px;
	}
	div.main{
	width:1200px;
	height:1000px;
	font-size:13pt;
	font-family:'gugi';
	left:300px;
	top:200px;
	
	}
	
	
	
</style>
</head>
<%
//절대경로잡기 /실행 시 프로젝트명 나오면 되고, 필요한곳에 복붙해서 사용하면 됌

String root=request.getContextPath();
String mainPage="layout/main.jsp"; //기본페이지

//url을 통해서 main값을 얻어서 메인 웹페이지에 출력
if(request.getParameter("main")!=null)
{
   mainPage=request.getParameter("main");
}
%>
<body>
<div class="layout title">
   <jsp:include page="layout/title.jsp"/>
</div>
<div class="layout menu">
   <jsp:include page="layout/menu.jsp"/>
</div>
<div class="layout info">
   <jsp:include page="layout/info.jsp"/>
</div>
<div class="layout main">
   <jsp:include page="<%= mainPage%>"/>
</div>
</body>
</html>