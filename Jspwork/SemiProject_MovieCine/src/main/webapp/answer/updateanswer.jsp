<%@page import="Dto.AnswerDto"%>
<%@page import="Dao.AnswerDao"%>
<%
   request.setCharacterEncoding("utf-8");
   String idx=request.getParameter("idx");
   String content=request.getParameter("content");
   String star = request.getParameter("star");
   
   AnswerDao dao=new AnswerDao();
   AnswerDto dto =new AnswerDto();
   dao.updateAnswer(dto);
  
%>