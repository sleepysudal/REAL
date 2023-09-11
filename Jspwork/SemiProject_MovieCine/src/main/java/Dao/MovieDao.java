package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Dto.MovieDto;
import mysql.db.DBConnect;

public class MovieDao {

	DBConnect db=new DBConnect();
	
	//insert
	public void insertMovie(MovieDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into movie_table(mv_title,mv_poster,mv_director,mv_st,mv_trailer"
				+ ",mv_opendate,mv_info,mv_regdate,mv_genre,mv_name,mv_adult,mv_teen,mv_child)"
				+ "values(?,?,?,?,?,?,?,now(),?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//바인딩
			pstmt.setString(1, dto.getMv_title());
			pstmt.setString(2, dto.getMv_poster());
			pstmt.setString(3, dto.getMv_director());
			pstmt.setString(4, dto.getMv_st());
			pstmt.setString(5, dto.getMv_trailer());
			pstmt.setString(6, dto.getMv_opendate());
			pstmt.setString(7, dto.getMv_info());
			
			pstmt.setString(8, dto.getMv_genre());
			pstmt.setString(9, dto.getMv_name());
			pstmt.setInt(10, dto.getMv_adult());
			pstmt.setInt(11, dto.getMv_teen());
			pstmt.setInt(12, dto.getMv_child());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	//select
	public List<MovieDto> getAllMovies() {
	      
	      List<MovieDto> list=new ArrayList<MovieDto>();
	      
	      Connection conn=db.getConnection();
	      PreparedStatement pstmt=null;
	      ResultSet rs=null;
	      
	      String sql="select * from movie_table order by mv_no ";
	      
	      try {
	         pstmt=conn.prepareStatement(sql);
	         rs=pstmt.executeQuery();
	         
	         while(rs.next())
	         {
	            MovieDto dto=new MovieDto();
	            
	            dto.setMv_no(rs.getString("mv_no"));
	            dto.setMv_title(rs.getString("mv_title"));
	            dto.setMv_poster(rs.getString("mv_poster"));
	            dto.setMv_director(rs.getString("mv_director"));
	            dto.setMv_st(rs.getString("mv_st"));
	            dto.setMv_trailer(rs.getString("mv_trailer"));
	            dto.setMv_opendate(rs.getString("mv_opendate"));
	            dto.setMv_info(rs.getString("mv_info"));
	            dto.setMv_regdate(rs.getTimestamp("mv_regdate"));
	            dto.setMv_genre(rs.getString("mv_genre"));
	            dto.setMv_name(rs.getString("mv_name"));
	            dto.setMv_adult(rs.getInt("mv_adult"));
	            dto.setMv_teen(rs.getInt("mv_teen"));
	            dto.setMv_child(rs.getInt("mv_child"));
	            
	            list.add(dto);
	         }
	         
	      } catch (SQLException e) {
	         // TODO Auto-generated catch block
	         e.printStackTrace();
	      }finally {
	         db.dbClose(rs, pstmt, conn);
	      }
	      
	      return list;
	   }
	
	//num에 해당하는 dto반환
	public MovieDto getData(String num)
	{
		MovieDto dto=new MovieDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		String sql="select * from movie_table where mv_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				 dto.setMv_no(rs.getString("mv_no"));
		         dto.setMv_title(rs.getString("mv_title"));
		         dto.setMv_poster(rs.getString("mv_poster"));
		         dto.setMv_director(rs.getString("mv_director"));
		         dto.setMv_st(rs.getString("mv_st"));
		         dto.setMv_trailer(rs.getString("mv_trailer"));
		         dto.setMv_opendate(rs.getString("mv_opendate"));
		         dto.setMv_info(rs.getString("mv_info"));
		         dto.setMv_regdate(rs.getTimestamp("mv_regdate"));
		         dto.setMv_genre(rs.getString("mv_genre"));
		         dto.setMv_name(rs.getString("mv_name"));
		         dto.setMv_adult(rs.getInt("mv_adult"));
		         dto.setMv_teen(rs.getInt("mv_teen"));
		         dto.setMv_child(rs.getInt("mv_child"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//delete
	public void deleteMovie(String num)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="delete from movie_table where mv_no=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//update
	public void updateMovie(MovieDto dto)
	{
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="update movie_table set mv_title=?,mv_poster=?,mv_director=?,mv_st=?,mv_trailer=?"
				+ ",mv_opendate=?,mv_info=?,mv_genre=?,mv_name=?,mv_adult=?,mv_teen=?,mv_child=? where mv_no=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//바인딩
			pstmt.setString(1, dto.getMv_title());
			pstmt.setString(2, dto.getMv_poster());
			pstmt.setString(3, dto.getMv_director());
			pstmt.setString(4, dto.getMv_st());
			pstmt.setString(5, dto.getMv_trailer());

			pstmt.setString(6, dto.getMv_opendate());
			pstmt.setString(7, dto.getMv_info());
			pstmt.setString(8, dto.getMv_genre());
			pstmt.setString(9, dto.getMv_name());
			pstmt.setInt(10, dto.getMv_adult());
			pstmt.setInt(11, dto.getMv_teen());
			pstmt.setInt(12, dto.getMv_child());
			pstmt.setString(13, dto.getMv_no());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
}