<%@page import="java.util.List"%>
<%@page import="Dto.MemberDto"%>
<%@page import="Dao.MemberDao"%>
<%@page import="Dto.AnswerDto"%>
<%@page import="Dao.AnswerDao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dto.MovieDto"%>
<%@page import="Dao.MovieDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://fonts.googleapis.com/css2?family=East+Sea+Dokdo&family=Moirai+One&family=Nanum+Pen+Script&family=Orbit&display=swap" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.18/dist/sweetalert2.all.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.7.0.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
<title>detail</title>
<style>
/* 스타일은 위에서 내려오는 순으로 적음 추가시 같은 위치쪽 삽입 */
b{
   color: white; <!-- b태그 글씨 색깔 -->
}

/* 디테일 큰 div */
.detailblock{
   width: 100%;
   height: 2035px;
   border: 10px solid white;
}

/* 디테일 내부 라인 div */
.detailall{
   position: absolute;
   right: 13.2%;
   left: 13.2%;
   width: 73.6%;
   height: 1950px;
   border: 10px solid white;
   margin-top: 50px;
}

/* 영화 포스터 div */
.detailposter{
   position: relative;
   left: 270px;
   width: 300px;
   height: 400px;
}

.detailposter img{
   width: 290px;
   height: 400px;
}

/* 영화 이름 div */
.detailtitle{
   position:absolute;
   top: 0px;
   left: 600px;
   width: 500px;
   height: 50px;
   border: 2px solid white;
   font-size: 1.5em;
}

/* 영화 예매율 div border-bottom: 1px white; 추가 */
.detailreserve{
   color: white;
   position:absolute;
   top: 50px;
   left: 600px;
   width: 500px;
   height: 50px;
   border: 2px solid white;
}

/* 장르, 개봉 div */
.detailinfo{
   color: white;
   position: absolute;
   top: 100px;
   left: 600px;
   width: 500px;
   height: 50px;
   border: 2px solid white;
}
/*평점*/
.averageRating{
 color: white;
   position: absolute;
   top: 150px;
   left: 600px;
   width: 500px;
   height: 50px;
   border: 2px solid white;
}
/* 스토리 */
.detailstory{
   color: white;
   position: absolute;
   top: 500px;
   left: 270px;
   width: 830px;
   height: 500px;
   border: 2px solid white;
}

/* 예매하기 버튼 */
#detailbtn1{
   position: absolute;
   top: 355px;
   left: 600px;
   color: white;
   background-color: #DF3E49;
   width: 100px;
   height: 45px;
   border: none;
   border-radius: 20px;
   font-weight: 500;
}
/* 이전으로 버튼 */
#detailbtn2{
   position: absolute;
   top: 355px;
   left: 710px;
   color: black;
   background-color: white;
   width: 100px;
   height: 45px;
   border: none;
   border-radius: 20px;
   font-weight: 500;
}

.detailcomment{
   position: absolute;
   top: 970px;
   left: 270px;
}

.detailresult{
   position: absolute;
   top: 1400px;
   left: 170px;
   width: 1030px;
   height: 500px;
   border: 2px solid white;
}
i.penguin{
font-size: 23pt;
}
#writer{
color: magenta;
font-size: 18pt;
}
#starimage{
width: 70px;
height: 70px;
}
.starscore{
width: 18px;
height: 18px;
}

</style>
<%
   //절대경로잡기
   String root = request.getContextPath();
   
   
//쿼리 파라미터에서 포스터 ID를 가져옵니다.
String mv_no = request.getParameter("mv_no");
String mv_title = request.getParameter("mv_title");
String mv_poster = request.getParameter("mv_poster");
String mv_st = request.getParameter("mv_st");
String mv_genre = request.getParameter("mv_genre");
String mv_opendate = request.getParameter("mv_opendate");

//String num = (String)session.getAttribute("num");// num-answer 
String idx = request.getParameter("idx");
String num = request.getParameter("mv_no"); //member-mvno
String content = request.getParameter("content");//댓글 내용
String star = request.getParameter("star"); //별점
String writeday = request.getParameter("writeday"); //작성일 가져옴
String myid = (String)session.getAttribute("myid");
   
   //무비테이블
   MovieDao dao = new MovieDao();
   MovieDto dto = dao.getData(mv_no); //영화번호 가져온다
   
   //임의의 아이디사용, ref)회원탈퇴시 회원이 작성한 댓글이 자동으로 삭제될려면 member의 sequence번호가 필요함 but 선택사항
   /* String myid = (String)session.getAttribute("myid"); */
   
%>
<script>
function back(){
   history.back();
}
$(function(){
   var currentPage=1;
   list(currentPage);
   
    // 댓글 추가 
    
    $("#btnadd").click(function(){
        var content = $("#content").val();
        var star = $("#star").val();
        var num =  $("#num").val();
        
        $.ajax({
            type: "post",
            dataType: "html",
            url: "answer/addanswer.jsp",
            data: {"content": content, "star": star, "num": <%=num%>},
            success: function(res){
                //인서트 후 초기화
                $("#content").val("");
                $("#star").val("");
                //다시 리스트 호출
                list(currentPage);
                location.reload();
            }
        });
    });

    // 댓글 삭제 - sweetalert 쓸거
    $(document).on("click", ".btndel", function() {
        var idx = $(this).data("idx");
        
        Swal.fire({
            title: "댓글 삭제",  
            text: "이 댓글을 삭제하시겠습니까?",  
            icon: "question",  
            showCancelButton: true,  
            confirmButtonColor: "#3085d6",  
            cancelButtonColor: "#d33",  
            confirmButtonText: "삭제",  
            cancelButtonText: "취소"  
        }).then((result) => {  
            if (result.isConfirmed) {  
                $.ajax({
                    type: "get",
                    dataType: "html",
                    url: "answer/deleteanswer.jsp",
                    data: { "idx": idx },  
                    success: function() {
                       list(currentPage);
                        location.reload();
                    }
                });
            }
        });
    });

    // 댓글 수정 - modal 쓸거
    $(document).on("click", ".btnup", function() {
        var idx = $(this).data("idx");  
        var content = $(this).data("content");
        var star = $(this).data("star");
        
        $("#updatecontent").val(content);
        $("#updatestar").val(star);
        
        $("#updatemodal").modal("show");
        
        //modal창의 수정버튼 누르면 
        $("#updatebtn").click(function() {
            // 수정한 내용을 가져옵니다.
            var updatecontent = $("#updatecontent").val();
            var updatestar = $("#updatestar").val();
            
            // 서버로 수정 내용을 전송합니다.
            $.ajax({
                type: "post",
                dataType: "html",
                url: "answer/updateanswer.jsp",
                data: { "idx": idx, "content": updatecontent, "star": updatestar },
                success: function() {
                    // 수정 후 모달을 닫고 댓글 목록을 업데이트합니다.
                    $("#updatemodal").modal("hide");
                    list(currentPage);
                    location.reload();
                }
            });
        });

        // 모달이 닫힐 때 입력 내용 초기화
        $('#updatemodal').on('hidden.bs.modal', function() {
            $("#updatecontent").val('');
            $("#updatestar").val('');
        });
    });
});

    // list 함수에서 pagination 컨트롤을 그리고 데이터를 가져오도록 수정
    function list(currentPage) {
       
        $.ajax({
            type: "get",
            url: "answer/listboard.jsp",
            data: {"num": <%=num%>, "currentPage": currentPage},
            dataType: "json",
            success: function(data){
               calculateAverageRating();
                var startPage = "";
                var endPage = "";
                var totalPage = "";
                var perPage="";
                var commentNumber="";
                
                var s="<div style='text-align: center;'>";
                s += "<table class='table' style='width:1030px'>";
                s += "<caption align='top'><b>댓글목록</b></caption>";
                
                /* s += "<tr class='table-info'>";
                s += "<th>번호</th>";
                s += "<th>아이디</th>";
                s += "<th>별점</th>";
                s += "<th>내용</th>";
            
                s += "<th width='160'>작성일</th>";
                s += "<th width='160'>수정 | 삭제</th>";
                s += "</tr>"; */
                
                
                if (data.length == 0) {
                    s += "<tr>";
                    s += "<td colspan='4' align='center'>";
                    s += "<b>댓글이 없습니다</b>";
                    s += "</td></tr>";
                } else {
                    $.each(data, function(i, item){
                        startPage = item.startPage;
                        endPage = item.endPage;
                        totalPage = item.totalPage;
                        perPage=item.perPage;
                        commentNumber = (currentPage - 1) * perPage + i + 1;
                        
                        var starimage = "";
                        
                        if (item.star == "1") {
                            starimage = "<img src='image/angry.png' id='starimage' alt='1 Star'>";
                        } else if (item.star == "2") {
                            starimage = "<img src='image/sad.png' id='starimage'alt='2 Star'>";
                        } else if (item.star == "3") {
                            starimage = "<img src='image/laughing.png'id='starimage' alt='3 Star'>";
                        } else if (item.star == "4") {
                            starimage = "<img src='image/smile.png' id='starimage' alt='4 Star'>";
                        } else if (item.star == "5") {
                            starimage = "<img src='image/love.png' id='starimage' alt='5 Star'>";
                        }
                        
                      
                        
                        s += "<tr>";
                        s += "<td align='center' rowspan='2' valign='middle'>" + starimage + "</td>";
                        s += "<td>" + (item.myid ? item.myid : "비회원") + "</td>"; 
                        s += "<td>"
                        s +="<button type='button' class='btn btn-outline-success btnup' data-idx='" + item.idx + "' data-content='" + item.content + "' data-star='" + item.star + "'>수정</button>";
                        s += "</td>";
                        s += "</tr>";
                        s += "<tr>";
                        s += "<td colspan='2'><textarea readonly style='width:400px;'>" + item.content + "</textarea></td>";
                        s +="</tr>";
                        s +="<tr>";
                        s += "<td colspan='2'>" + item.writeday + "</td>"; 
                        s += "<td>"
                        s +="<button type='button' class='btn btn-outline-danger btndel' data-idx='"+  item.idx+"'>삭제</button>";
                        s +="</td>"
                        s += "</tr>";
                    })
                }
                s += "</table>";
                s += "</div>";
                
                    // pagination 컨트롤을 그리는 코드
                    s += "<div style='width: 600px; text-align: center;'>";
                    s += "<ul class='pagination justify-content-center'>";

                    // 이전 버튼
                    if (startPage>=1 && currentPage > 1) {
                        s += "<li class='page-item active'>";
                        s += "<a class='page-link'><i class='bi bi-arrow-left prev' style='cursor:pointer;'></i></a>";
                        s += "</li>";
                        
                     // 이전 버튼 클릭 이벤트 핸들러
                        $('.detailresult').on('click', '.prev', function(){
                            if (currentPage > 1) {
                                currentPage -= 1; // 현재 페이지를 감소시킴
                                list(currentPage); // 페이지를 다시 불러옴
                            }
                        });
                    }

                    //숫자페이지
                    for (var pp = startPage; pp <= endPage; pp++) {
                        if (pp == currentPage) {
                            s += "<li class='page-item active'>";
                            s += "<a class='page-link paging' style='cursor:pointer;'>"+pp+"</a>";
                            s += "</li>";
                        } else {
                            s += "<li class='page-item'>";
                            s += "<a class='page-link paging' style='cursor:pointer;'>"+pp+"</a>";
                            s += "</li>";
                        }
                        
                     // 페이지번호 클릭 이벤트 핸들러
                        $('.detailresult').on('click', '.paging', function(){
                            currentPage = $(this).text().trim();
                            list(currentPage); // 페이지를 다시 불러옴
                        });
                    }

                    // 다음 버튼
                    if (endPage<=totalPage && currentPage<totalPage) {
                        s += "<li class='page-item active'>";
                        s += "<a class='page-link'><i class='bi bi-arrow-right next' style='cursor:pointer;'></i></a>";
                        s += "</li>";
                        
                     // 다음 버튼 클릭 이벤트 핸들러
                        $('.detailresult').on('click', '.next', function(){
                            if (currentPage < totalPage) {
                                currentPage += 1; // 현재 페이지를 증가시킴
                                list(currentPage); // 페이지를 다시 불러옴
                            }
                        });
                    }

                    s += "</ul>";
                    s += "</div>";
                    
                    //alert("hi");
                    $(".detailresult").html(s);
                }
               
        });
    }
    
    function calculateAverageRating() {
       <%
          AnswerDao adao=new AnswerDao();
          List<AnswerDto>list=adao.getAllAnswers(num);
          int totalrate=0;
          double avgrate=0;
          
          
          for(AnswerDto adto:list)
          {
             //총 평점
             totalrate+=Integer.parseInt(adto.getStar());
             
             
          }
          
          //평균 평점
          avgrate=(double)totalrate/(list.size());
          System.out.printf("%.1f",avgrate);
          
       %>
        //평균평점
      var avgrate=<%=avgrate%>.toFixed(1);
      
      //총댓글수
      var totalcomment=<%=list.size()%>;
      
        if (totalcomment > 0) {
            
            var ratingText = "관람객 평점: " + avgrate + "\t(총\t" + totalcomment + "명이 평가해주셨습니다.)";

            // 별 이미지 출력을 위한 변수 
            var starImages = "";

            // 별 이미지를 조건에 따라 설정
            if (avgrate == 5) {
                for (var i = 1; i <= 5; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
            } else if (avgrate >= 4.5) {
                for (var i = 1; i <= 4; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
                starImages += "<img src='image/halfstar.png' class='starscore'>";
            } else if (avgrate >= 4) {
                for (var i = 1; i <= 4; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
            } else if (avgrate >= 3.5) {
                for (var i = 1; i <= 3; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
                starImages += "<img src='image/halfstar.png' class='starscore'>";
            } else if (avgrate >= 3) {
                for (var i = 1; i <= 3; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
            } else if (avgrate >= 2.5) {
                for (var i = 1; i <= 2; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
                starImages += "<img src='image/halfstar.png' class='starscore'>";
            } else if (avgrate >= 2) {
                for (var i = 1; i <= 2; i++) {
                    starImages += "<img src='image/onestar.png' class='starscore'>";
                }
            } else if (avgrate >= 1.5) {
                starImages += "<img src='image/onestar.png' class='starscore'>";
                starImages += "<img src='image/halfstar.png' class='starscore'>";
            } else if (avgrate >= 1) {
                starImages += "<img src='image/onestar.png' class='starscore'>";
            }

            $(".averageRating").html(ratingText + "<br>" + starImages);
        } else {
            $(".averageRating").text("관람객 평점: 아직 평가 없음");
        }
    }


</script>

</head>
<body>
<!-- 큰 div 영역 -->
<div class="detailblock">
   <!-- 출력할 컨텐츠 영역 -->
   <div class="detailall">
      <div class="detailposter"><b><img src="<%=dto.getMv_poster()%>"></b></div>
      <div class="detailtitle"><b>영화제목 : <%=dto.getMv_title() %></b></div>
      <div class="detailreserve">예매율 (border-bottom 1px white 추가)</div>
      <div class="detailinfo">장르 : <%=dto.getMv_genre() %><br>개봉 : <%=dto.getMv_opendate() %></div>
      <div class="averageRating" class="text-white"></div>
      
      <div class="detailstory"><%=dto.getMv_st() %></div>
      <button type="button" id="detailbtn1" onclick="location='<%=root%>/index.jsp?main=Movie_reserve/movielist.jsp'">예매하기</button>
      <button type="button" id="detailbtn2" onclick="back()">이전으로</button>
      
   
      <!-- 댓글 입력 -->
      <div class="detailcomment">   
      <form>
         <input type="hidden" id="num" value="<%=num %>">
         <input type="hidden" id="idx" value="<%=idx %>">
         
         
         <table class="table table-bordered" style="width:600px; height: 250px;">
         <caption align="top"><b>댓글 입력</b></caption>
            <tr>
               <th align="center" valign="middle" style="width: 150px;">작성자</th>
               <td><b style="color: blue;">
                  <%
            if (myid == null || myid == "") {
             myid = "비회원";
            }
            %>
            
           <%= myid %>
           
               </b></td>
            </tr>
            
            <tr>
               <th align="center" valign="middle" style="width: 100px;">댓글작성</th>
               <td>
               <textarea id="content" class="form-control"
               placeholder="댓글을 입력해주세요"></textarea>
               </td>
            </tr>
            
            <tr>
               <th align="center" valign="middle" style="width: 100px;">별점</th>
               <td>
               <select name="star" id="star" style="width:100px;">
                  <option value="1">★</option>
                  <option value="2">★★</option>
                  <option value="3">★★★</option>
                  <option value="4">★★★★</option>
                  <option value="5" selected>★★★★★</option>
               </select>
               </td>
            </tr>
            
            <tr>
               <th align="center" valign="middle">댓글등록</th>
               <td colspan="2">
                  <button type="button" class="btn btn-outline-danger" id="btnadd"><i class="bi bi-tencent-qq penguin"></i></button>
               </td>
            </tr>
         </table>
      </form>
      </div>
      
      <div class="detailresult">
         <b>댓글출력</b>
         <div style="overflow: auto; height: 400px;">
         
         
         
         </div>
         </div>
   </div>
</div>

<!-- 모달 창 -->
<div class="modal fade" id="updatemodal" tabindex="-1" aria-labelledby="updateModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="updateModalLabel">댓글 수정</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <!-- 수정할 내용을 입력할 폼 -->
                <form>
                    <div class="mb-3">
                        <label for="updatecontent" class="form-label">댓글 내용</label>
                        <textarea class="form-control" id="updatecontent" rows="3"></textarea>
                    </div>
                    <div class="mb-3">
                        <label for="updatestar" class="form-label">별점</label>
                        <select class="form-select" id="updatestar">
                            <option value="1">★</option>
                            <option value="2">★★</option>
                            <option value="3">★★★</option>
                            <option value="4">★★★★</option>
                            <option value="5">★★★★★</option>
                        </select>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-bs-dismiss="modal">닫기</button>
                <button type="button" class="btn btn-info" id="updatebtn">수정</button>
            </div>
        </div>
    </div>
</div>

</body>
</html>