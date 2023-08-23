<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="member.model.MemberDto"%>
<%@page import="member.model.MemberDao"%>
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
String realPath=getServletContext().getRealPath("/upload");
int uploadSize = 1024*1024*3; //3mb

MultipartRequest multi = null;

multi = new MultipartRequest(request, realPath, uploadSize, "utf-8",new DefaultFileRenamePolicy());

//dao선언
MemberDao dao = new MemberDao();
//dto 선언
MemberDto dto = new MemberDto();
dto.setId(multi.getParameter("id")); //아이디 
dto.setPass(multi.getParameter("pass")); //비밀번호
dto.setName(multi.getParameter("name")); //이름
dto.setHp(multi.getParameter("hp")); //전화번호

//dto.setPhoto(multi.getFilesystemName("uploadImage"));
String photo = multi.getFilesystemName("uploadImage"); //사진

if(photo==null)
	dto.setPhoto("../image/noimage.png");//사진선택안한경우
	else
		dto.setPhoto("../upload/"+photo);//사진선택한경로 가상의 폴더에 지정을 해주면 실제경로엔 다른게 들어감 system.out.println 경로에가면 또잇음 끝에 업로드라 되잇음
									//실제 경로에는 지정된위치가 있고 그게 업로드로 끝나는폴더 거기에 사진을넣어준다
//db에 insert
dao.insertMember(dto);

//성공후 이동
response.sendRedirect("loginForm.jsp");




%>
</body>
</html>