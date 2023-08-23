package db.simpleguest;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import mysql.db.DBConnect;



public class SimpleGuestDao {
	DBConnect db = new DBConnect();
	
	//INSERT
	public void insertGuest(SimpleGuestDto dto) 
	{
		Connection conn = db.getConnection();
		PreparedStatement pstmt =null;
		
		String sql="insert into simpleGuest (image,nick,pass,story,writeday) values(?,?,?,?,now())";
		
		//바인딩
				try {
					pstmt=conn.prepareStatement(sql);
					
					pstmt.setString(2, dto.getNick());
					pstmt.setString(3, dto.getPass());
					pstmt.setString(1, dto.getImage());
					pstmt.setString(4, dto.getStory());
					
					pstmt.execute();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					db.dbClose(pstmt, conn);
				}			
					
			}
	
	//select 
	public Vector<SimpleGuestDto> getAllGuests(){
		
		Vector<SimpleGuestDto>list = new Vector<SimpleGuestDto>();
		
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql ="select * from simpleGuest order by num desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				SimpleGuestDto dto = new SimpleGuestDto();
				
				dto.setNum(rs.getString("num"));
				dto.setNick(rs.getString("nick"));
				dto.setPass(rs.getString("pass"));
				dto.setStory(rs.getString("story"));
				dto.setImage(rs.getString("image"));
				dto.setWriteday(rs.getTimestamp("writeday"));
				
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
	//비밀번호 비교
	//비밀번호가 맞으면 true, 틀리면 false
	public boolean isEqualPass(String num,String pass) {
		boolean flag =false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from simpleGuest where num=? and pass=?";
		
		try {
			pstmt=conn.prepareStatement(sql);			
			
			pstmt.setString(1, num);
			pstmt.setString(2, pass);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				flag=true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}	
		
		return flag;		
	}
	
	//수정폼...하나의 dto
	public SimpleGuestDto getData(String num) {
		SimpleGuestDto dto = new SimpleGuestDto();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		String sql="select * from simpleGuest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setNum(rs.getString("num"));
				dto.setNick(rs.getString("nick"));
				dto.setImage(rs.getString("image"));
				dto.setStory(rs.getString("story"));
				dto.setPass(rs.getString("pass"));
				dto.setWriteday(rs.getTimestamp("writeday"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
		return dto;
		
	}
	//수정..비번이 맞을 경우에만 호출할 것이므로 
	//비번은 조건에 안넣을예정
	//수정 : 닉네임 , 이미지 ,스토리
	public void updateGuests(SimpleGuestDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt =null;
		
		String sql = "update simpleGuest set nick=?, image=?,story=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getNick());
			pstmt.setString(2, dto.getImage());
			pstmt.setString(3, dto.getStory());
			pstmt.setString(4, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	public void deleteGuest(String num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from simpleGuest where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, num);
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
			
			
			
			
}

