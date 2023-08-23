package Mysawon.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import oracle.db.DBConnect;

public class MysawonDao {
	DBConnect db=new DBConnect();
	
	
	//insert
	public void insertSawon (MysawonDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "insert into mysawon_info values(sq_mysawon.nextval,?,?,?,?,?,?,?,sysdate)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getImage());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getGender());
			pstmt.setString(4, dto.getAddr());
			pstmt.setString(5, dto.getJoomin());
			pstmt.setString(6, dto.getHp());
			pstmt.setString(7, dto.getEmail());
			
			pstmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	
	//select
	public Vector <MysawonDto>getAllMysawon(){
		Vector<MysawonDto>list = new Vector<MysawonDto>();
		Connection conn= db.getConnection();
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		
		String sql = "select * from Mysawon_info order by num";
		
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				MysawonDto dto =new MysawonDto();
				
				dto.setNum(rs.getInt("num"));
				dto.setImage(rs.getString("image"));
				dto.setName(rs.getString("name"));
				dto.setGender(rs.getString("gender"));
				dto.setAddr(rs.getString("addr"));
				dto.setJoomin(rs.getString("joomin"));
				dto.setHp(rs.getString("hp"));
				dto.setEmail(rs.getString("email"));
				dto.setPlusday(rs.getTimestamp("plusday"));
				
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
	
	//select
	public void getNum(int num){
		MysawonDto dto = new MysawonDto();
		
		Connection conn = db.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs = null;
	
		String sql="select num from mysawon_info";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum(Integer.parseInt("num"));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
		
	}
	
	//insert - admin
		public void insertadmin (MysawonDto dto) {
			Connection conn = db.getConnection();
			PreparedStatement pstmt = null;
			
			String sql = "insert into mysawon_buseo values(?,?,?,?,?)";
			
			try {
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setInt(1, dto.getNum2());
				pstmt.setString(2, dto.getGrade());
				pstmt.setString(3, dto.getBuseo());
				pstmt.setString(4, dto.getPay());
				pstmt.setString(5, dto.getIpsaday());
				
				
				pstmt.execute();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				db.dbClose(pstmt, conn);
			}
			
		}
		
		//select -admin
		public Vector <MysawonDto>getAlladmin(){
			Vector<MysawonDto>list = new Vector<MysawonDto>();
			Connection conn= db.getConnection();
			PreparedStatement pstmt=null;
			ResultSet rs = null;
			
			String sql = "select * from Mysawon_buseo order by num";
			
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					MysawonDto dto =new MysawonDto();
					
					dto.setNum(rs.getInt("num2"));
					dto.setGrade(rs.getString("grade"));
					dto.setBuseo(rs.getString("buseo"));
					dto.setPay(rs.getString("pay"));
					dto.setIpsaday(rs.getString("ipsaday"));
					
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
		//관리자 수정위해서 조회
		public MysawonDto getAdmin(int num2) {
		MysawonDto dto = new MysawonDto();
		
		Connection conn =  db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from mysawon_buseo where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num2);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				dto.setNum2(Integer.parseInt("num2"));
				dto.setGrade("grade");
				dto.setBuseo("buseo");
				dto.setPay("pay");
				dto.setIpsaday(rs.getString("ipsaday"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dto;
	}
	//수정-어드민
		public void updateAdmin(MysawonDto dto) {
		Connection conn = db.getConnection();
		PreparedStatement pstmt = null;
		
		String sql = "update mysawon_buseo set grade=?, buseo=?, pay=? where num=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getGrade());
			pstmt.setString(2, dto.getBuseo());
			pstmt.setString(3, dto.getPay());
			pstmt.setInt(4, dto.getNum2());
			
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}

	
}
