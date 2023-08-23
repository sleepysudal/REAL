<%@page import="java.util.Enumeration"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://fonts.googleapis.com/css2?family=Bagel+Fat+One&family=Dongle:wght@300;400&family=Gugi&family=Pangolin&display=swap"
	rel="stylesheet">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>

<title>Insert title here</title>
</head>
<body>
<%
//톰캣에 업로드된 프로젝트 경로구하기
ServletContext context =getServletContext();
//프로젝트의 upload 실제 경로구하기
String realFolder =context.getRealPath("/upload");

System.out.println(realFolder);

//업로드시 허용 되는 크기 지정
int uploadsize = 1024*1024*3; //3mb 숫자가 뒤에 5면 5메가

MultipartRequest multi = null;

try{
	multi=new MultipartRequest(request,realFolder,uploadsize,"utf-8",
			new DefaultFileRenamePolicy());
	
	//입력된 값들 읽어오기
	String nick = multi.getParameter("nick");
	%>
	
	<h2>작성자명: <%=nick %></h2>
	
	<%
	//파일타입이 여러개인 경우 Enumeration은 자료형이라기 보다 인터페이스임 덩어리자체인데 enumeration 이라는api를 가져온다 자료형이라 볼수도있음
	Enumeration forNames=multi.getFileNames(); //file타입만 얻어옴 , 복수형 얻어올려면 while 문 통해서 다음값얻어오는 메서드 활용
	
	while(forNames.hasMoreElements()){
		String fileName=(String)forNames.nextElement(); //오브젝트값 받아올땐 항상 좌우 맞춰준다 스트링-스트링
		System.out.println("file type의 name: "+fileName);
		
		//실제 업로드 된 파일명얻기
		String uploadName = multi.getFilesystemName(fileName); //각각에서 얻어온 파일네임을 넣어줌
		
		//파일선택안하면 null
		if(uploadName!=null){%>
			
			<figure>
			<img src="../upload/<%=uploadName %>" style="max-width:200px;" border="1px solid red;">
			<figcaption><b><%=uploadName %></b></figcaption>
			</figure>	
		<%}
		
	}
	
	%>
<%}catch(Exception e){
	
}




%>
</body>
</html>