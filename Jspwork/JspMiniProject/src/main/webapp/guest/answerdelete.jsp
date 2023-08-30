<%@page import="data.dao.AnswerDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
AnswerDao dao=new AnswerDao();
String idx = request.getParameter("idx");


dao.deleteAnswer(idx);
%>

