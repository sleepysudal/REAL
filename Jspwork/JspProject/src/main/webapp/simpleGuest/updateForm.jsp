<%@page import="db.simpleguest.SimpleGuestDao"%>
<%@page import="db.simpleguest.SimpleGuestDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Dongle:wght@300;400;700&family=Gaegu:wght@300&family=Noto+Serif+KR:wght@200&family=Single+Day&display=swap"rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
//dto 받아오는 메서드 호출
String num = request.getParameter("num");
SimpleGuestDao dao = new SimpleGuestDao();
SimpleGuestDto dto= dao.getData(num);



%>
<body>
<div style="margin: 50px; 100px; ">
   <form action="updateAction.jsp" method="post">
      <!-- num hidden 으로 넘김 -->
      <input type="hidden" name="num" value="<%=num %>">
      <table class="table table-bordered" style="width: 500px;">
         <caption align="top"><b>간단 방명록 수정</b></caption>
            <tr>
               <th width="80" style="background-color: green">닉네임</th>
               <td>
                  <input type="text" name="nick" style="width: 120px;"
                  value="<%=dto.getNick() %>">
               </td>
               <th width="100" style="background-color: green">비밀번호</th>
               <td>
                  <input type="password" name="pass" required="required" style="width: 120px;">
               </td>
            </tr>
            
            <tr>
              <td colspan="4">
              <%
              for(int i=1;i<=10;i++)
              { 
            	  int n=Integer.parseInt(dto.getImage());
              %>
                 <input type="radio" value="<%=i%>"
                 style="width:30px;" name="image"
                 <%=i==n?"checked":"" %>>&nbsp;
              <%}
              %>
              
              <br>
              <%
                 for(int i=1;i<=10;i++)
                 {%>
                    <img alt="" src="../avata/b<%=i%>.png" style="width:40px;">
                 <%}
              %>
           
              </td>
            </tr>
            
            <tr>
              <td colspan="4">
                 <textarea style="width: 480px; height: 150px" name="story"></textarea>
              </td>
            </tr>
            <tr>
              <td colspan="4" align="center">
                 <input type="submit" value="수정" class="btn btn-outline-info">                  
                 <input type="button" value="목록" class="btn btn-outline-success"
                 onclick="location.href='guestlist.jsp'">              
              </td>
            </tr>
      </table>  
   </form>
   </div>
</body>
</html>