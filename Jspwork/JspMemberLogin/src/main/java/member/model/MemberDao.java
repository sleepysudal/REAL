package member.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import mysql.db.DBConnect;

public class MemberDao {
	DBConnect db = new DBConnect();
	//아이디 중복체크
	public boolean isIdcheck(String id)
	{
		boolean flag =false;
		
		Connection conn =db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from spmember where id=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return flag;
		
	}
	//로그인시 아이디 비번 비교 
	public boolean isEqualPass(String id,String pass) {
		boolean flag =false;
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from spmember where id=? and pass=?";
		
		try {
			pstmt=conn.prepareStatement(sql);			
			
			pstmt.setString(1, id);
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
	
	// insert
	public void insertMember (MemberDto dto) {
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into spmember values(null, ?, ?, ?, ?, ?, now())";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPass());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getHp());
			pstmt.setString(5, dto.getPhoto());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//select
	public Vector <MemberDto> getAllMembers(){
		Vector<MemberDto>list = new Vector<MemberDto>();
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		String sql="select * from spmember order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MemberDto dto = new MemberDto();
				
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));				
				dto.setName(rs.getString("name"));
				dto.setPhoto(rs.getString("photo"));
				dto.setHp(rs.getString("hp"));
				dto.setGaip(rs.getTimestamp("gaip"));
				
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
	//수정 num의 dto
	public MemberDto getData(String num) {
		MemberDto dto = new MemberDto();
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from spmember where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(rs.getString("num"));
				dto.setId(rs.getString("id"));
				dto.setPass(rs.getString("pass"));
				dto.setName(rs.getString("name"));
				dto.setHp(rs.getString("hp"));
				dto.setPhoto(rs.getString("photo"));
				dto.setGaip(rs.getTimestamp("gaip"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		return dto;
		
	}
	//수정 pass name hp photo
	public void updateMembers(MemberDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update spmember set pass=?, name=?, hp=?, photo=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			
			pstmt.setString(2, dto.getName());
			pstmt.setString(1, dto.getPass());
			pstmt.setString(3, dto.getHp());
			pstmt.setString(4, dto.getPhoto());
			pstmt.setString(5, dto.getNum());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//삭제 
	public void deleteMember(String num) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "delete from spmember where num=?";
		
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
	//아이디 통해서 이름얻기
    public String getName(String id) {

        String name="";
        Connection conn=db.getConnection();
        PreparedStatement pstmt=null;
        ResultSet rs=null;

        String sql="select * from spmember where id=?";

        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, id);

            rs=pstmt.executeQuery();

            if(rs.next()) {
                name=rs.getString("name");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            db.dbClose(rs,pstmt, conn);
        }


        return name;
    }

   
}
