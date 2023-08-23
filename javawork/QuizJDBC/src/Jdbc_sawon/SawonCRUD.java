package Jdbc_sawon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SawonCRUD {

	DBConnect db= new DBConnect();
	Scanner sc= new Scanner(System.in);
	
	public void addSawon() {
		System.out.println("***����߰��ϱ�***");
		
		System.out.println("�����?");
		String name=sc.nextLine();
		
		System.out.println("����(���� or ����)?");
		String gender=sc.nextLine();
		
		System.out.println("�μ���?");
		String buseo=sc.nextLine();		
		
		System.out.println("�޿�?");
		int pay=Integer.parseInt(sc.nextLine());
		
		String sql = "insert into sawon values(seq_sawon.nextval,'"+name+"','"+gender+"','"+buseo+"',"+pay+")";
		System.out.println(sql);
		
		
		//����Ŭ�� ����
		Connection conn = db.getConnection();
		Statement stmt= null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql); //sql�� ����
			
			System.out.println("DB�� �߰��Ǿ����ϴ�");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}		
	}
	public void writeSawon() {
		String sql = "select num,name,gender,buseo,to_char(pay,'L999,999,999')pay from sawon";
		
		System.out.println("\t\t[��ü������]");
		System.out.println();
		
		System.out.println("������\t�����\t����\t�μ���\t���޿�");
		System.out.println("------------------------------------------");
		
		//db����
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("num")+"\t"+rs.getString("name")+"\t"+rs.getString("gender")+"\t"
						+rs.getString("buseo")+"\t"+rs.getString("pay"));
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbclose(rs, stmt, conn);
		}
		
	}
	//����
	public void deleteSawon() {		
		
		Scanner sc = new Scanner(System.in);		
		System.out.println("������ ������� �Է����ּ���");
		String name = sc.nextLine();
		String sql= "delete sawon where name='"+name+"'";
		
		//db����
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs= null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);	
			
			System.out.println(name+"�� ������");
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbclose(rs, stmt, conn);
		}
		
	}
	//���� ������ �Է��� �μ� ,�޿��� ����
	public void updateSawon() {		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("������ �������� �Է����ּ���");
		int num= Integer.parseInt(sc.nextLine());		
		
		System.out.println("������ �μ�����?");
		String buseo=sc.nextLine();
		System.out.println("������ �޿���?");
		int pay=Integer.parseInt(sc.nextLine());
		
		String sql="update sawon set buseo='"+buseo+"',pay="+pay+" where num="+num;		
		System.out.println(sql);
		
		Connection conn=db.getConnection();
		Statement stmt=null;
		
		try {
			stmt=conn.createStatement();
			stmt.execute(sql);			
			System.out.println("��������!!!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(stmt, conn);
		}	
			
	}
	public void searchSawon() {
		System.out.println("�˻��� ������� �Է����ּ���(�Ϻΰ˻��� ��)");
		String name = sc.nextLine();
		 
		String sql = "select num,name,gender,buseo,to_char(pay,'L999,999,999')pay from sawon where name like '%"+name+"%'";

		System.out.println("\t\t[�˻�������]");
		System.out.println();

		System.out.println("������\t�����\t����\t�μ���\t���޿�");
		System.out.println("------------------------------------------");

		//db����
		Connection conn = db.getConnection();
		Statement stmt = null;
		ResultSet rs=null;
		
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("num")+"\t"
						+rs.getString("name")+"\t"
						+rs.getString("gender")+"\t"
						+rs.getString("buseo")+"\t"
						+rs.getString("pay"));
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			db.dbclose(rs, stmt, conn);
		}
		
		
	}

	
	public static void main(String[] args) {
		//Ŭ���� ����
		SawonCRUD sa=new SawonCRUD();
		
		
		//scanner ����
		Scanner sc= new Scanner(System.in);
		int n;
		
		
		while(true) {
			System.out.println("Oracle Db_sawon ����");
			System.out.println("1.insert 2.select 3.update 4.delete 5.����˻� 9.����");
			
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1) 
				sa.addSawon();			
			else if(n==9) {
				System.out.println("�����մϴ�");
				break;
			}
			else if(n==2) {
				sa.writeSawon();
			}
			else if(n==3) {
				sa.updateSawon();
			}
			else if(n==4) {
				sa.deleteSawon();
			}
			else if(n==5) {
				sa.searchSawon();
			}
		}
		

	}

}
