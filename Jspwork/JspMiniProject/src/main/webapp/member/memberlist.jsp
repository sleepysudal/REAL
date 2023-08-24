<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="data.dto.MemberDto"%>
<%@page import="java.util.List"%>
<%@page import="data.dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<script type="text/javascript">
   function delfunc(num) {
      {
         var yes=confirm("강퇴처리 하시겠습니까?");
         
         if(yes)
            {
               location.href='member/memberdelete.jsp?num='+num;
            }
      }
   }
</script>
<title>Insert title here</title>
</head>
<%
   MemberDao dao=new MemberDao();
   List <MemberDto> list=dao.getAllMembers();
%>
<body>
<div style="margin: 30px; 30px; width: 800px;">
     <button type="button" class="btn btn-outline-success"
     onclick="location.href='../index.jsp'">메인</button>
     
  <br><br>
  <table class="table table-bordered">
     <caption align="top"><b>회원 목록</b></caption>
     <tr align="center" style="background-color: green;">
        <th width="60">번호</th>
        <th width="100">이름</th>
        <th width="100">아이디</th>
        <th width="150">핸드폰</th>
        <th width="100">주소</th>
        <th width="120">이메일</th>
        <th width="200">가입일</th>
        <th width="150">편집</th>
     </tr>
     
     <%
       if(list.size()==0)
       {%>
            <tr>
              <td colspan="8" align="center">
                <h6><b>등록된 회원정보가 없습니다</b></h6>
              </td>
            </tr>
       <%}else
        {
          
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
          
           for(int i=0;i<list.size();i++)
           {
              MemberDto dto=list.get(i);
              %>
              <tr>
                <td align="center"><%=i+1 %></td>
                <td align="center"><%=dto.getName() %></td>
                <td align="center"><%=dto.getId()%></td>
                <td align="center"><%=dto.getHp() %></td>
                <td align="center"><%=dto.getAddr() %></td>
                <td align="center"><%=dto.getEmail() %></td>
                <td align="center"><%=sdf.format(dto.getGaipday())%></td>
                <td align="center">
                <button type="button" class="btn btn-outline-danger" onclick="delfunc(<%=dto.getNum()%>)">삭제</button>
                <button type="button" class="btn btn-outline-warning" onclick="location.href='updateform.jsp'">수정</button>
                </td>
              </tr>
           <%}
        }
     %>   
  </table>
  </div>
  
</body>
</html>