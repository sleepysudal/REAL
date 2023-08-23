<%@page import="db.ajaxboard.AjaxBoardDao"%>
<%@page import="db.ajaxboard.AjaxBoardDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//post방식
request.setCharacterEncoding("utf-8");
String num=request.getParameter("unum");
String writer=request.getParameter("uwriter");
String subject=request.getParameter("usubject");
String story=request.getParameter("ustory");
String avata=request.getParameter("uavata");

//dto 선언
AjaxBoardDto dto =new AjaxBoardDto();

dto.setNum(num);
dto.setWriter(writer);
dto.setSubject(subject);
dto.setStory(story);
dto.setAvata(avata);

//dao선언
AjaxBoardDao dao =new AjaxBoardDao(); //만든 update 메서드 가져오기 위해 생성
dao.updateBoard(dto);

%>
