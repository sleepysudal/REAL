package quiz0711;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QUIZDB {
	//URL
	static final String ORACLE_URL="jdbc:oracle:thin:@localhost:1521:XE";

	String driver="oracle.jdbc.driver.OracleDriver";

	//driver
	public QUIZDB() {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			System.out.println("����Ŭ ����̹� ����");
		}
	}
	//connection
	public Connection getConnection() {
		Connection conn =null;
		try {
			conn=DriverManager.getConnection(ORACLE_URL, "Sudal","a1234");
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("����Ŭ �������: url,����,��� Ȯ�ο��� "+e.getMessage());
		}
		return conn;
	}
	//close
	public void dbclose(ResultSet rs,Statement stmt, Connection conn)  { //�ϼ��� ����3��
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void dbClose(Statement stmt,Connection conn) { //�ϼ��� ����2�� 
		try {

			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void dbClose(ResultSet rs,PreparedStatement pstmt, Connection conn) { //�̿��� �������� 3��
		try {
			if(rs!=null)rs.close();
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public void dbClose(PreparedStatement pstmt, Connection conn) { //�̿��� �������� 2��
		try {			
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
	public static void main(String[] args) {


	}

}
