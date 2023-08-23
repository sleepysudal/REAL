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

		System.out.println("�л�����?");
		String stu_name=sc.nextLine();

		System.out.println("�г���?");		
		int stu_grade=Integer.parseInt(sc.nextLine());

		System.out.println("�ڵ�����ȣ?");		
		String hp=sc.nextLine();

		System.out.println("�ּҴ�?");
		String addr=sc.nextLine();

		System.out.println("���̴�?");
		int age=Integer.parseInt(sc.nextLine());

		//SQL .. PreparedStatement�� �̿��� sql���� �ۼ�
		String sql = "insert into mystudent values (seq_stu.nextval,?,?,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stu_name);
			pstmt.setInt(2, stu_grade);
			pstmt.setString(3, hp);
			pstmt.setString(4, addr);
			pstmt.setInt(5, age);

			//������Ʈ
			int a=pstmt.executeUpdate();

			if(a==1)
				System.out.println("�μ�Ʈ����!!");
			else
				System.out.println("�μ�Ʈ����!!");

		} catch (SQLException e) {			
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//���
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
			System.out.println("������\t�л���\t�г�\t�޴�����ȣ\t\t�ּ�\t\t����\t���糯¥");
			System.out.println("===============================================");			

			while(rs.next()) {	
				System.out.println(rs.getInt("stu_num")+"\t"+rs.getString("stu_name")+
						"\t"+rs.getInt("stu_grade")+"\t"+rs.getString("hp")+"\t"
						+rs.getString("addr")+"\t"+rs.getInt("age")+"\t"+rs.getDate("sdate"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("�������");
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}
	//����
	public void deleteMyStudent() {
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("������ ������?");
		int stu_num = Integer.parseInt(sc.nextLine());

		String sql="delete mystudent where stu_num=?";

		try {
			pstmt = conn.prepareStatement(sql);			
			pstmt.setInt(1, stu_num);

			int a=pstmt.executeUpdate();

			if(a==1)
				System.out.println("**���� ����**");
			else
				System.out.println("**���� ����**");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}		
	}
	//������ ������ Ȯ��
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

	//����
	public void updateMyStudent() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;

		System.out.println("������ ������ ��ȣ?");
		String stu_num=sc.nextLine();

		//���⼭ �������� ���ٸ� ����
		if(!isdata(stu_num)) {
			System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�");
			return;
		}
		System.out.println("������ �л�����?");
		String stu_name=sc.nextLine();
		System.out.println("������ �г���?");
		int stu_grade=Integer.parseInt(sc.nextLine());
		System.out.println("������ �ڵ�����ȣ��?");
		String hp=sc.nextLine();
		System.out.println("������ �ּҴ�?");
		String addr=sc.nextLine();
		System.out.println("������ ���̴�");
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

			System.out.println("��������!!!");

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
	}
	//�л������˻�
	public void searchMyStudent() {
		System.out.println("�˻��� �л���(�Ϻθ��ĵ�����)");
		String stu_name=sc.nextLine();


		String sql="select * from mystudent where stu_name like ?";
		System.out.println(sql);

		System.out.println("������\t�л���\t�г�\t�޴�����ȣ\t\t�ּ�\t\t����\t���糯¥");
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
			System.out.println("***�л�����***");
			System.out.println("1.�Է�\t2.���\t3.����\t4.����\t5.�л������˻�\t9.����");
			System.out.println("=================================================");
			n=Integer.parseInt(sc.nextLine());

			if(n==1)
				quiz.insertMyStudent();
			else if(n==9) {
				System.out.println("�����մϴ�");
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
