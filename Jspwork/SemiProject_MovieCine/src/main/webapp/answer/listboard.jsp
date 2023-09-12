<%@page import="Dao.MovieDao"%>
<%@page import="Dto.MovieDto"%>
<%@page import="Dto.AnswerDto"%>
<%@page import="java.util.List"%>
<%@page import="Dao.AnswerDao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.json.simple.JSONObject"%>
<%@page import="org.json.simple.JSONArray"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

   MovieDto mdto=new MovieDto();
   AnswerDao dao=new AnswerDao();
   String num=request.getParameter("num");
   
   List<AnswerDto> list=dao.getAllAnswers(num);
   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
   JSONArray arr=new JSONArray();
   for(AnswerDto dto:list)
   {
      JSONObject ob=new JSONObject();
      ob.put("idx", dto.getIdx());
      ob.put("num", dto.getNum());
      ob.put("myid", dto.getMyid());
      ob.put("content", dto.getContent());
      ob.put("star", dto.getStar());
      ob.put("writeday", sdf.format(dto.getWriteday()));
      
      arr.add(ob);
   }
%>
<%=arr.toString()%>