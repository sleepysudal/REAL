package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Dto.AnswerDto;
import mysql.db.DBConnect;

	public class AnswerDao {

	   DBConnect db=new DBConnect();
	   
	   //댓글 입력
	   public void insertAnswer(AnswerDto dto)
	   {
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      
	      String sql="insert into answer(num,myid,content,star,writeday) values(?,?,?,?,now())";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         
	         pstmt.setString(1, dto.getNum());
	         pstmt.setString(2, dto.getMyid());
	         pstmt.setString(3, dto.getContent());
	         pstmt.setString(4, dto.getStar());
	        
	         pstmt.execute();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(pstmt, conn);
	      }
	   }
	   
	   //전체 댓글 갯수
	   public int getTotalCount()
	   {
	      int n=0;
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      String sql="select count(*) from answer";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         
	         if(rs.next())
	         
	            n=rs.getInt(1);
	         
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return n;
	   }
	   
	   //페이지에서 필요한 만큼만 리턴
	   public List<AnswerDto> getList(int start,int perpage)
	   {
	      List<AnswerDto> list=new Vector<AnswerDto>();
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      String sql="select * from answer order by idx desc limit ?,?";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setInt(1, start);
	         pstmt.setInt(2, perpage);
	         
	         rs=pstmt.executeQuery();
	         
	         while(rs.next())
	         {
	            AnswerDto dto=new AnswerDto();
	            
	            dto.setIdx(rs.getString("idx"));
	            dto.setNum(rs.getString("num"));
	            dto.setMyid(rs.getString("myid"));
	            dto.setContent(rs.getString("content"));
	            dto.setStar(rs.getString("star"));
	            dto.setWriteday(rs.getTimestamp("writeday"));
	            
	            list.add(dto);
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return list;
	      
	   }
	   
	   //idx에 해당 dto 반환
	   public AnswerDto getData(String idx)
	   {
	      AnswerDto dto=new AnswerDto();
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      String sql="select * from answer where idx=?";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, idx);
	         rs=pstmt.executeQuery();
	         
	         if(rs.next())
	         {
	        	 dto.setIdx(rs.getString("idx"));
		         dto.setNum(rs.getString("num"));
		         dto.setMyid(rs.getString("myid"));	
		         dto.setContent(rs.getString("content"));
		         dto.setStar(rs.getString("star"));
		         dto.setWriteday(rs.getTimestamp("writeday"));
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }
	      
	      return dto;
	   }
	   
	   
	 //수정시 모달창에서 전에작성한 내용가져옴 -dto에 리스트해서두개 받아라 ?
	   public AnswerDto getContent(String idx)
	   {
		   AnswerDto dto=new AnswerDto();
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      String sql="select content, star from answer where idx=?";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, idx);
	         rs=pstmt.executeQuery();
	         
	         if(rs.next())
	         {
	            dto.setContent(rs.getString("content"));
	            dto.setStar(rs.getString("star"));
	         }
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      return dto;
	      
	   }
	   
	   
	   //모달창의 수정버튼 누르면 수정되기
	   public void updateAnswer(AnswerDto dto)
	   {
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      
	      String sql="update answer set content=?,star=? where idx=?";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	        
	         pstmt.setString(1, dto.getContent());
	         pstmt.setString(2, dto.getStar());
	         pstmt.setString(3, dto.getIdx());
	         

	         pstmt.execute();
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(pstmt, conn);
	      }
	   }
	   
	   //삭제
	   public void deleteAnswer(String idx)
	   {
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      
	      String sql="delete from answer where idx=?";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         pstmt.setString(1, idx);
	         
	         pstmt.execute();
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      } finally {
	         db.dbClose(pstmt, conn);
	      }
	      
	   }
	   // 페이징처리 필요없는 리스트
	      public List<AnswerDto> getAllDatas(){
	         List<AnswerDto> list=new Vector<AnswerDto>();
	         
	         Connection conn=db.getConnection();
	         PreparedStatement pstmt=null;
	         ResultSet rs=null;
	         
	         String sql="select * from answer order by idx desc";
	         
	         try {
	            pstmt=conn.prepareStatement(sql);
	            
	            rs=pstmt.executeQuery();
	            
	            while(rs.next())
	            {
	               AnswerDto dto=new AnswerDto();
	               
	               dto.setIdx(rs.getString("idx"));
	               dto.setNum(rs.getString("num"));
	               dto.setMyid(rs.getString("myid"));
	               dto.setContent(rs.getString("content"));
	               dto.setStar(rs.getString("star"));
	               dto.setWriteday(rs.getTimestamp("writeday"));
	               
	               list.add(dto);
	            }
	            
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } finally {
	            db.dbClose(rs, pstmt, conn);
	         }
	         
	         return list;
	         
	      }
	    //num에 해당하는 리스트 출력
	      public List<AnswerDto> getAllAnswers(String num)
	      {
	         List<AnswerDto> list=new ArrayList<AnswerDto>();
	         
	         Connection conn=db.getConnection();
	         PreparedStatement pstmt=null;
	         ResultSet rs=null;
	         
	         String sql="select * from answer where num=? order by idx";
	         
	         try {
	            pstmt=conn.prepareStatement(sql);
	            pstmt.setString(1, num);
	            rs=pstmt.executeQuery();
	            
	            while(rs.next())
	            {
	               AnswerDto dto=new AnswerDto();
	               dto.setIdx(rs.getString("idx"));
	               dto.setNum(rs.getString("num"));
	               dto.setMyid(rs.getString("myid"));
	               dto.setContent(rs.getString("content"));
	               dto.setStar(rs.getString("star"));
	               dto.setWriteday(rs.getTimestamp("writeday"));
	               
	               list.add(dto);
	            }
	            
	         } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	         } finally {
	            db.dbClose(rs, pstmt, conn);
	         }
	         
	         return list;

	      }

	   
	   
	}
