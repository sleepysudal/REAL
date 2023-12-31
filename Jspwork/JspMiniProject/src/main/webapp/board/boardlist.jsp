<%@page import="data.dto.SmartAnswerDto"%>
<%@page import="data.dao.SmartAnswerDao"%>
<%@page import="data.dao.SmartDao"%>
<%@page import="data.dto.SmartDto"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
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
<style type="text/css">
a:link,a:visited{
   text-decoration: none;
   color: black;
}
a:hover{
   text-decoration: underline;
}
</style>
<script type="text/javascript">
$(function() {
   
   //전체선택클릭시 체크값 얻어서 모든체크값 전달하기
   $(".alldelcheck").click(function(){
      
      //전체체크값 얻기
      var chk=$(this).is(":checked");
      console.log(chk);
      
      //전체체크값을 글앞의 체크에 일괄 전달하기
      $(".delcheck").prop("checked",chk);
   });
   
   $("#btndel").click(function() {
      
      //체크된 길이
      var len=$(".delcheck:checked").length;
      //alert(len);
      
      if(len==0){
         alert("최소 1개이상 체크해주세요");         
      }else{
         var a=confirm(len+"개의 글을 삭제하려면 [확인]을 눌러주세요");
         
         //체크된 곳의 value값 얻기(num)
         var n="";
         
         $(".delcheck:checked").each(function(idx) {
            
            n+=$(this).val()+",";
         })
         
         //마지막 컴마 제거하기
         n=n.substring(0,n.length-1);
         
         console.log(n);
         
         //삭제파일로 전송
         location.href="board/alldelete.jsp?nums="+n;
      }
         
      
   })
   
})
</script>
</head>
<%
   String num=request.getParameter("num");
   //페이징처리
   SmartDao dao = new SmartDao();
   //SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
   
   
   int totalCount=dao.getTotalCount();//전체 게시글의 수
   int totalPage;//총 페이지 수
   int startPage;//각 블럭에서 보여질 시작페이지
   int endPage;//각 블럭에서 보여질 마지막페이지
   int startNum;//db에서 가져올 글의 시작 번호(mysql은 첫 글이 0, oracle은 1)
   int perPage=3;//한 페이지당 몇 개의 글을 보여줄지
   int perBlock=5;//한 페이지에서 보여즐 블럭의 개수
   int currentPage;//현재 페이지
   int no;

   //현재페이지 읽기(단 null일경우는 1페이지를 준다)계산을 해야하므로 int로 형변환
   if(request.getParameter("currentPage")==null || request.getParameter("currentPage").equals("null"))
              currentPage=1;
     else
       currentPage=Integer.parseInt(request.getParameter("currentPage"));
        
       //총 페이지 수 구하기
       //총 게시글의 개수/한 페이지당 보여질 개수로 나누기
       //나머지가 하나라도 있으면 무조건 페이지를 하나 더 추가(1+1=2페이지가 필요)
        totalPage=totalCount/perPage+(totalCount%perPage==0?0:1);
     
       //각 블럭당 보여야할 시작페이지
       //perBlock=5일경우는 현재페이지 1~5 시작:1, 끝:5
       //perBlock=13일 경우는 시작:11, 끝:15
        startPage=(currentPage-1)/perBlock*perBlock+1;
        
        endPage=startPage+perBlock-1;
       
        //총 페이지가 23일경우 마지막블럭은 25가 아니라 23이다.
         if(endPage>totalPage)
              endPage=totalPage;
        
        //각 페이지에서 보여질 시작번호
        //1페이지: 0, 2페이지:5, 3페이지:10
        startNum=(currentPage-1)*perPage;
        
        //각페이지당 출력할 시작번호 구하기 no
       //총글개수가 23이면 1페이지 23,2페이지는 18,3페이지는 13...
        no=totalCount-(currentPage-1)*perPage;
        
        //각 페이지 필요한 게시글 가져오기
        List<SmartDto> list = dao.getPaingList(startNum, perPage);
        
        //댓글에 관한 dao
        SmartAnswerDao adao = new SmartAnswerDao(); 
        for(SmartDto dto:list)
        {
        	//댓글변수에 댓글 총 갯수 넣기
        	int acount = adao.getAllSmartAnswers(dto.getNum()).size();
        	dto.setAnswercount(acount);
        }
        %>   
  
<body>
 <div style="margin: 30px 30px; width: 800px;" >
   <br>
   <button type="button" class="btn btn-info" onclick="location.href='index.jsp?main=board/smartform.jsp'">글쓰기</button>
   <h5><b>총 <%=totalCount %>개의 게시글이 있습니다</b></h5>
     <table class="table table-bordered">
        <caption align="top"><b>스마트 게시판 목록</b></caption>
        <tr class="table-light">
          <th width="60">번호</th>
          <th width="450">제목</th>
          <th width="130">작성자</th>
          <th width="160">작성일</th>
          <th width="60">조회</th>
        </tr>
        
        <%
         if(totalCount==0)       
         {%>
            <tr>
               <td colspan="5" align="center">
                 <h6>등록된 게시글이 없습니다</h6>
               </td>
            </tr>
         <%}else{
            
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy.MM.dd");
            for(SmartDto dto:list)
            {%>
               <tr>
                  <td align="center">
                    <input type="checkbox" value="<%=dto.getNum()%>" class="delcheck">
                    <%=no-- %>
                  </td>
                  <td>
                   <a href="index.jsp?main=board/contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>"><%=dto.getSubject() %></a>
                  
                  <!-- 댓글 갯수 출력 -->
                   
                <%
					if(dto.getAnswercount()>0)
					{%>
				<a href="index.jsp?main=board/contentview.jsp?num=<%=dto.getNum()%>&currentPage=<%=currentPage%>#alist" 
                  style="color:red;">[<%=dto.getAnswercount() %>]</a>
					<%}
                %>
                  
                  
                  </td>
                  <td align="center"><%=dto.getWriter()%></td>
                  <td align="center"><%=sdf.format(dto.getWriteday()) %></td>
                  <td align="center"><%=dto.getReadcount() %></td>
               </tr>
         <% }
         }
         %>
         <tr>
           <td colspan="5">
             <input type="checkbox" class="alldelcheck">전체선택
             <span style="float: right;">
                <button type="button" class="btn btn-danger" onclick="" style="width: 100px;" id="btndel">삭제</button>
            <button type="button" class="btn btn-info" onclick="location.href='index.jsp?main=board/smartform.jsp'">글쓰기</button>             
             </span>
           </td>
         </tr>
     </table>
 </div>
 <!-- 페이지번호 출력 -->

   <div align="center">
      <ul class="pagination justify-content-center">
        <%
        //이전
        if(startPage>1){
           %>
                <li>
                    <a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=startPage-1 %>">이전</a>
                 </li>
          
        <%}
           for(int pp=startPage;pp<=endPage;pp++){
              if(pp==currentPage){
                 %>
                 <li class="page-item active">
                    <a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
                 </li>
                 
              <%}else
              {%>
                 <li>
                    <a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=pp %>"><%=pp %></a>
                 </li>
              <%}
           }
           //다음
           if(endPage<totalPage){%>
              <li>
               <a class="page-link" href="index.jsp?main=board/boardlist.jsp?currentPage=<%=endPage+1 %>">다음</a>
            </li>
           <%}
           
           %>
             
      </ul>
   </div>
 
</body>
</html>