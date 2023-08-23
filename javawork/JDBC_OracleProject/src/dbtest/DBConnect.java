package dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	//driver, URL, 계정,비밀번호
	
	//URL
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	//DRIVER
	String driver="oracle.jdbc.driver.OracleDriver";
	public DBConnect() {
		try {
			Class.forName(driver);
			System.out.println("오라클 드라이버 성공");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("오라클 드라이버 실패");
		}
	}
	//Connection
	public Connection getConnection() {
		
		Connection conn =null;
		
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "Sudal","a1234");
		} catch (SQLException e) {
			
			e.printStackTrace();
			System.out.println("오라클 연결실패: url,계정,비번 확인요함 "+e.getMessage());
		}
	
		return conn;
	}
	//close 메서드..총 4개 
	public void dbClose(ResultSet rs,Statement stmt, Connection conn) { //완성된 구문 3개
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void dbClose(Statement stmt,Connection conn) { //완성된 구문2개 
		try {
			
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void dbClose(ResultSet rs,PreparedStatement pstmt, Connection conn) { //미완의 구문으로 3개
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	public void dbClose(PreparedStatement pstmt, Connection conn) { //미완의 구분으로 2개
		try {			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
