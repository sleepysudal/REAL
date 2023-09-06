<%@page import="data.dao.ShopDao"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&family=Dongle&family=Gugi&family=Orbit&display=swap"
        rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
<style type="text/css">
   div.cart{
      float: right;
      cursor: pointer;
      z-index: 10;
      position: relative;
      left: -20px;
      top: -50px;
   }
   .count{
      width: 30px;
      height: 30px;
      float: right;
      background-color: red;
      border-radius: 100px;
      text-align: center;
      z-index: 10;
      position: relative;
      left: -23px;
      color: white;
      font-size: 0.8em;
      
   }
   #img1{
      z-index: 0;
   }
   #btn1 {
   position: absolute;
   top: 220px;
   left: 1280px;
   z-index: 1;
   }
   #btn2 {
   position: absolute;
   top: 220px;
   left: 1280px;
   z-index: 1;
   }
</style>

<script type="text/javascript">
   $(function(){
      $("div.cart").click(function(){
         location.href="index.jsp?main=shop/mycart.jsp";
      });
   });
</script>
</head>
<%
   //절대경로잡기
   String root=request.getContextPath();
   //로그인 세션
   String loginok=(String)session.getAttribute("loginok");
   //아이디 얻기
   String myid=(String)session.getAttribute("myid");
   //dao에서 이름얻기
   MemberDao dao=new MemberDao();
   String name=dao.getName(myid);
%>
<body>
<a href="<%=root%>" style="color: black;"><img alt="" src="<%=root%>/image/penguin.gif" width="1520" height="200" id="img1"></a>

<%
if(loginok==null){%>
   <button type="button" class="btn btn-success" id="btn1" style="width: 100px;" 
   onclick="location.href='index.jsp?main=login/loginform.jsp'">Login</button>
<%}
else{%>
   <b><%=name %>님 로그인중...</b>
   <button type="button" class="btn btn-danger" id="btn2" style="width: 100px;" 
   onclick="location.href='login/logoutaction.jsp'">Logout</button>
<%}
%>

<div class="cart">
   <%
   ShopDao sdao=new ShopDao();
   //카트개수
   int carSize=sdao.getCartList(myid).size();
   %>
   <i class="bi bi-cart4" style="font-size: 1.4em"></i>
   <div class="count"><%=carSize %></div>
</div>
</body>
</html>