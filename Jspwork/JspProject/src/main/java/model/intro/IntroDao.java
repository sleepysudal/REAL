package model.intro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DBConnect;

public class IntroDao {
	DBConnect db = new DBConnect();
	
	//insert
	public void insertIntro(IntroDto dto)
	{
		Connection conn= db.getConnection();
		PreparedStatement pstmt=null;
		
		String sql="insert into intro values(seq_1.nextval,?,?,?,?,sysdate)";
		
		
		//바인딩
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getIntro_name());
			pstmt.setString(2, dto.getIntro_blood());
			pstmt.setString(3, dto.getIntro_hp());
			pstmt.setString(4, dto.getIntro_city());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}			
			
	}
	
	//select
	public Vector<IntroDto>getData()
	{
		Vector<IntroDto> list = new Vector<IntroDto>();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select * from intro order by intro_num";
		
		
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					IntroDto dto = new IntroDto();
					
					dto.setIntro_num(rs.getString("intro_num"));
					dto.setIntro_name(rs.getString("intro_name"));
					dto.setIntro_blood(rs.getString("intro_blood"));
					dto.setIntro_hp(rs.getString("intro_hp"));
					dto.setIntro_city(rs.getString("intro_city"));
					dto.setGaipday(rs.getTimestamp("gaipday"));
					
					list.add(dto);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(rs, pstmt,conn);
			}		
		
		return list;
	}
	//delete
	public void deleteintro(String num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql="delete from intro where intro_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//수정-업데이트 (전값불러오기)
	public IntroDto selectIntro(String num) {
		IntroDto dto = new IntroDto();
		Connection conn = db.getConnection();
		PreparedStatement pstmt= null;
		ResultSet rs= null;
		
		String sql="select * from intro where intro_num=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setIntro_num(rs.getString("intro_num"));
				dto.setIntro_name(rs.getString("intro_name"));
				dto.setIntro_blood(rs.getString("intro_blood"));
				dto.setIntro_hp(rs.getString("intro_hp"));
				dto.setIntro_city(rs.getString("intro_city"));
				dto.setGaipday(rs.getTimestamp("gaipday"));	
			}
			
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
	}
	
	//수정 ( 바꾼값넣기)
	public void updateIntro(IntroDto dto) {
		Connection conn= db.getConnection();
		PreparedStatement pstmt =null;
		
		String sql = "update intro set intro_name=?, intro_blood=?, intro_hp=?, intro_city=?, gaipday=? where intro_num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getIntro_name());
			pstmt.setString(2, dto.getIntro_blood());
			pstmt.setString(3, dto.getIntro_hp());
			pstmt.setString(4, dto.getIntro_city());
			pstmt.setTimestamp(5, dto.getGaipday());
			pstmt.setString(6, dto.getIntro_num());
			
			pstmt.execute();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	
	
}

