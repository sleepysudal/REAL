<%@page import="db.simpleguest.SimpleGuestDto"%>
<%@page import="db.simpleguest.SimpleGuestDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Vector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
</head>
<%
   SimpleGuestDao dao=new SimpleGuestDao();
   Vector<SimpleGuestDto> list=dao.getAllGuests();
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy년 MM월 dd일");
%>
<body>
<div style="margin: 50px; 100px; "></div>
<button type="button" class="btn btn-outline-success"
onclick="location.href='insertForm.jsp'">글쓰기</button>


<%
   for(int i=0;i<list.size();i++)
   {
      SimpleGuestDto dto=list.get(i);
      int no=list.size()-i;
      %>   
      
      <table class="table" style="width: 500px">
      <tr>
         <td>
            <b>No.<%=no %></b>
            <b><%=dto.getNick() %></b>
         </td>
         <td align="right">
         <b style="color: gray;"><%=sdf.format(dto.getWriteday())%></b>
         </td>

      </tr>
      
      <tr height="100">
        <td colspan="2" valign="top">
        <div>
           <img src="../avata/b<%=dto.getImage()%>.png"
           align="left" hspace="20">
        </div>
           <pre>
             <%=dto.getStory() %>
           </pre>
        </td>
      </tr>
      <tr>
      
      
      
      <br><br>
      </tr>
      </table>
      <div style="left: 400px; position:absolute;">
         <input type="button" value="수정" onclick="location.href='updateForm.jsp?num=<%=dto.getNum() %>'"
         class="btn btn-success btn-sm">
         <input type="button" value="삭제" onclick="location.href='deleteForm.jsp?num=<%=dto.getNum() %>'"
         class="btn btn-waring btn-sm">
      </div>
   <%} 
%>

</table>

</body>
</html>