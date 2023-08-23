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
<body>
<%
session.setAttribute("msg", "happy");
session.setMaxInactiveInterval(10); //10초동안 유지시간 지속
%>
<h2>10초안에 눌러주세요!!!!</h2>
<form action="sessionAction.jsp" method="post">
<h2>가고싶은 여행지</h2>
<input type="radio" value="베트남 3박 4일" name="travel">베트남 3박 4일&nbsp;
<input type="radio" value="프랑스 4박 5일" name="travel">프랑스 4박 5일&nbsp;
<input type="radio" value="영국 5박 6일" name="travel">영국 5박 6일&nbsp;
<input type="radio" value="독일 6박 7일" name="travel" checked="checked">독일 6박 7일&nbsp;
<input value="여행당첨" type="submit">
</form>
</body>
</html>