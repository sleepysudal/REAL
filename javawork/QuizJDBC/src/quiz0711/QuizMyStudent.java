package quiz0711;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;



public class QuizMyStudent {	
	QUIZDB db= new QUIZDB();
	Scanner sc= new Scanner(System.in);	

	//insert
	public void insertMyStudent() {
		//connection
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("학생명은?");
		String stu_name=sc.nextLine();

		System.out.println("학년은?");		
		int stu_grade=Integer.parseInt(sc.nextLine());

		System.out.println("핸드폰번호?");		
		String hp=sc.nextLine();

		System.out.println("주소는?");
		String addr=sc.nextLine();

		System.out.println("나이는?");
		int age=Integer.parseInt(sc.nextLine());

		//SQL .. PreparedStatement는 미완의 sql문을 작성
		String sql = "insert into mystudent values (seq_stu.nextval,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_name);
			pstmt.setInt(2, stu_grade);
			pstmt.setString(3, hp);
			pstmt.setString(4, addr);
			pstmt.setInt(5, age);

			//업데이트
			int a=pstmt.executeUpdate();

			if(a==1)
				System.out.println("인서트성공!!");
			else
				System.out.println("인서트실패!!");

		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//출력
	public void selectMyStudent() {
		//connection		
		Connection conn = db.getConnection();
		//Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from mystudent order by stu_num";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("시퀀스\t학생명\t학년\t휴대폰번호\t\t주소\t\t나이\t현재날짜");
			System.out.println("===============================================");			

			while(rs.next()) {	
				System.out.println(rs.getInt("stu_num")+"\t"+rs.getString("stu_name")+
						"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("hp")+"\t"
						+rs.getString("addr")+"\t"+rs.getInt("age")+"\t"+rs.getDate("sdate"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("연결실패");
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}
	//삭제
	public void deleteMyStudent() {
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 시퀀스?");
		int stu_num = Integer.parseInt(sc.nextLine());

		String sql="delete mystudent where stu_num=?";

		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, stu_num);

			int a=pstmt.executeUpdate();

			if(a==1)
				System.out.println("**삭제 성공**");
			else
				System.out.println("**삭제 실패**");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	//수정할 데이터 확인
	public boolean isdata(String stu_num) {
		boolean b= false;

		Connection conn= db.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;

		String sql="select * from mystudent where stu_num=?";

		try {
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, stu_num);
			rs=pstmt.executeQuery();

			if(rs.next()) 
				b=true;

			else 
				b=false;


		} catch (SQLException e) {

			e.printStackTrace();
		}	finally {
			db.dbClose(rs, pstmt,conn);
		}

		return b;
	}

	//수정
	public void updateMyStudent() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		System.out.println("수정할 시퀀스 번호?");
		String stu_num=sc.nextLine();

		//여기서 시퀀스가 없다면 종료
		if(!isdata(stu_num)) {
			System.out.println("해당 번호는 존재하지 않습니다");
			return;
		}
		System.out.println("수정할 학생명은?");
		String stu_name=sc.nextLine();
		System.out.println("수정할 학년은?");
		int stu_grade=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 핸드폰번호는?");
		String hp=sc.nextLine();
		System.out.println("수정할 주소는?");
		String addr=sc.nextLine();
		System.out.println("수정할 나이는");
		int age=Integer.parseInt(sc.nextLine());

		//SQL
		String sql="update mystudent set stu_name=?,stu_grade=?,hp=?,addr=?,age=? where stu_num=?";

		try {
			pstmt=conn.prepareStatement(sql);


			pstmt.setString(1, stu_name);
			pstmt.setInt(2, stu_grade);
			pstmt.setString(3, hp);
			pstmt.setString(4,addr);
			pstmt.setInt(5,age);
			pstmt.setString(6,stu_num);

			pstmt.execute();

			System.out.println("수정성공!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//학생정보검색
	public void searchMyStudent() {
		System.out.println("검색할 학생명(일부만쳐도가능)");
		String stu_name=sc.nextLine();


		String sql="select * from mystudent where stu_name like ?";
		System.out.println(sql);

		System.out.println("시퀀스\t학생명\t학년\t휴대폰번호\t\t주소\t\t나이\t현재날짜");
		System.out.println("=======================================================");

		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+stu_name+"%");
			rs=pstmt.executeQuery();

			while(rs.next()) {
				System.out.println(rs.getInt("stu_num")+"\t"+rs.getString("stu_name")+
						"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("hp")+"\t"
						+rs.getString("addr")+"\t"+rs.getInt("age")+"\t"+rs.getDate("sdate"));
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
	}

	public static void main(String[] args) {
		QuizMyStudent quiz =new QuizMyStudent();
		Scanner sc = new Scanner(System.in);
		int n;

		while(true) {
			System.out.println("***학생정보***");
			System.out.println("1.입력\t2.출력\t3.삭제\t4.수정\t5.학생정보검색\t9.종료");
			System.out.println("=================================================");
			n=Integer.parseInt(sc.nextLine());

			if(n==1)
				quiz.insertMyStudent();
			else if(n==9) {
				System.out.println("종료합니다");
				break;
			}
			else if(n==2) {
				quiz.selectMyStudent();
			}
			else if(n==3) {
				quiz.deleteMyStudent();
			}
			else if(n==4) {
				quiz.updateMyStudent();
			}
			else if(n==5) {
				quiz.searchMyStudent();
			}
		}

	}

}
