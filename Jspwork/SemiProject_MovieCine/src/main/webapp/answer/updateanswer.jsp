<%@page import="Dto.AnswerDto"%>
<%@page import="Dao.AnswerDao"%>
<%
   request.setCharacterEncoding("utf-8");

   String idx=request.getParameter("idx");
   String content=request.getParameter("content");
   String star = request.getParameter("star");
   
   
   AnswerDto dto =new AnswerDto();
   
   dto.setIdx(idx);
   dto.setContent(content);
   dto.setStar(star);
   
   AnswerDao dao=new AnswerDao();
   dao.updateAnswer(dto);
  
%>