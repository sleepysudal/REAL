<%@page import="java.text.SimpleDateFormat"%>
<%@page import="db.simpleboard.SimpleBoardDto"%>
<%@page import="java.util.List"%>
<%@page import="db.simpleboard.SimpleBoardDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=Black+And+White+Picture&family=Cute+Font&family=Diphylleia&family=Dongle:wght@300&family=Hi+Melody&family=Nanum+Brush+Script&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body *{
	font-family: 'gugi';
	}
	a:link,a:visited{
	text-decoration: none;
	color:black;
	}
	a:hover{
	text-decoration: underline;
	color:gray;
	}
</style>
</head>
<%
SimpleBoardDao dao = new SimpleBoardDao();
//List<SimpleBoardDto> list= dao.getAllBoards();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");

int totalCount=dao.getTotalCount(); // 전체 갯수
int totalPage; //총 페이지
int startPage; //각블럭에서 보여질 시작페이지
int endPage; //각블럭에서 보여질 끝페이지
int startNum; //db에서 가져올 글의 시작번호(mysql은 첫글이 0 , oracle은 첫글이 1)
int perPage=3; //한페이지당 보여질 글의 갯수?
int perBlock=5; //한블럭당 보여질 페이지 개수
int currentPage;//현재페이지
int no; //각페이지당 출력할 시작번호




//현재 페이지 읽기(단 null일 경우는 1페이지로 준다) 계산을 해야하므로 int로 형변환해줌
if(request.getParameter("currentPage")==null)
   currentPage=1;
  else
    currentPage=Integer.parseInt(request.getParameter("currentPage"));
     
    //총 페이지수 구하기
    //총 글의 갯수/한페이지당 보여질 개수로 나눔(7/5=1)
    //나머지가 1이라도 있으면 무조건 1페이지 추가(1+1=2페이지가 필요)
  	totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
    
    //각블럭당 보여야할 시작페이지
    //perBlock=5일경우  현재페이지가 1~5 시작:1 끝: 5
    //현재페이지 13 시작:11 끝:15 
  
  	startPage=(currentPage-1)/perBlock*perBlock+1;
     
  	endPage=startPage+perBlock-1;
    
     //총 페이지가 23일 경우 마지막블럭은 25가 아니라 23이다
      if(endPage>totalPage)
        endPage=totalPage;
    
     //각 페이지에서 보여질 시작번호
     //1페이지 : 0, 2페이지:5 3페이지:10....
     startNum = (currentPage-1)*perPage;
     
     //각페이지당 출력할 시작번호 구하기 no
     //총 글 갯수가 23이면 1페이지 23 , 2페이지 18 , 3페이지 13...
     no=totalCount-(currentPage-1)* perPage;
     
     //페이지에서 보여질 글만 가져오기 
     List<SimpleBoardDto>list = dao.getPagingList(startNum,perPage);

%>
<body>
	<div style="margin:30px; 30px; width:800px;">
		<button type="button" class="btn btn-outline-info"
		onclick="location.href='addform.jsp'"><i class="bi bi-pencil-fill"></i>글쓰기</button>
		
	<br><br>
	<h6><b>총 <%=totalCount%>개의 게시글이 있습니다</b></h6>
	<table class ="table table-bordered">
		<caption align="top"><b>간단 게시판 목록</b></caption>
		<tr>
			<th width="60">번호</th>
			<th width="360">제목</th>
			<th width="100">작성자</th>
			<th width="120">작성일</th>
			<th width="60">조회</th>
		</tr>
		
		<%
		if(list.size()==0)
		{%>
			<tr>
				<td colspan="5" align="center">
					<h6><b>등록된 게시글이 없습니다</b></h6>
				</td>
			</tr>
	
		<% }else{
			for(int i=0; i<list.size(); i++){
				SimpleBoardDto dto = list.get(i);
				%>
				<tr>
					<td align="center"><%=no-- %></td>
					<td><a href="detailview.jsp?num=<%=dto.getNum()%>"><%=dto.getSubject() %></a></td>
					<td><%=dto.getWriter() %></td>
					<td><%=sdf.format(dto.getWriteday()) %></td>
					<td align="center"><%=dto.getReadcount() %></td>
				</tr>
			<%}
		}
		%>
			
	</table>
	<!-- 페이지 번호 출력 -->
	<div>
	<ul class="pagination justify-content-center">
	<% 
	if(currentPage>startPage)
	{%>
	
	<li class="page-item"><a class="page-link" href="boardlist.jsp?currentPage=<%=currentPage-1%>"><</a></li>
	<%}
	
	
	
	//스타트페이지가 1보다 클
	if(startPage>1)
	{%>
		<li class="page-item"><a class="page-link" href="boardlist.jsp?currentPage=<%=startPage-perBlock%>"><<</a></li>
		
		
		
	<%}
	 for(int pp=startPage; pp<=endPage; pp++)
	 { 
		 
		 if(pp==currentPage)
		 {%>
			
			 <li class="page-item active">
			 	<a style="background-color: deeppink; border: 1px solid deeppink;"
			 	class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
			 </li>
		 <%}else
		 {%>
			<li>
				<a class="page-link" href="boardlist.jsp?currentPage=<%=pp%>"><%=pp %></a>
				
			</li> 
		 <%}
	 }
	%>
	<% 
	//endpage 가 총 페이지 보다 작을때
	if(endPage<totalPage)
	{%>
	
	<li class="page-item">
	<a class="page-link" href="boardlist.jsp?currentPage=<%=endPage+1%>">>></a>
	</li>
	<%}
	%>
	</ul>
	
	</div>
	
	
	
	
</div>

</body>
</html>