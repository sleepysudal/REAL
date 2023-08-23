package day0710;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QuizConnectNewBoard {
	static final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	public void snsboard() {
		Connection conn = null;
		Statement stmt= null;
		ResultSet rs = null;
		
		String sql = "select b_num, nick,subject,content,wday from snsboard";
		
		try {
			conn=DriverManager.getConnection(URL, "Sudal","a1234");
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);			
		
			System.out.println("번호\t닉네임\t제목\t내용\t현재날짜");
			System.out.println("---------------------------------------------------------");
			
			while(rs.next()) {
				int b_num=rs.getInt("b_num");
				String nick = rs.getString("nick");
				String subject = rs.getString("subject");
				String content = rs.getString("content");
				String wday= rs.getString("wday");
				
				
				System.out.println(b_num+"\t"+nick+"\t"+subject+"\t"+content+"\t"+wday);
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
	}
		
		
		
		
	
	public static void main(String[] args) {
		QuizConnectNewBoard q1= new QuizConnectNewBoard();
		q1.snsboard();

	}

}
//테이블명: snsboard
//b_num 기본키
//nick 작성자 닉네임(문자열)
//subject 제목
//content 내용
//wday 현재날짜

//최소 10개 인서트
//자바 QuizConnectNewBoard
//메서드 Connection ,Statement , Resultset 객체 이용해서 새로만든 board를 불러오세요