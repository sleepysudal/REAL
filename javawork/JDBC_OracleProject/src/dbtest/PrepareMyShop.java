package dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PrepareMyShop {
	DBConnect db= new DBConnect();
	Scanner sc= new Scanner(System.in);

	//insert
	public void insertMyshop() {
		//connection
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("��ǰ����?");
		String sang=sc.nextLine();
		System.out.println("����?");		
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("����?");
		int dan = Integer.parseInt(sc.nextLine());

		//SQL .. PreparedStatement�� �̿��� sql���� �ۼ�
		String sql = "insert into myshop values (seq1.nextval,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);

			//?�� ������� ���ε�
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3, dan);

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
	//select
	public void selectMyshop() {

		//connection		
		Connection conn = db.getConnection();
		//Statement stmt=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;

		String sql="select * from myshop order by shopnum";

		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			System.out.println("������\t��ǰ��\t��\t����\t��¥");
			System.out.println("---------------------------------------------------------");
			//System.out.println(sql); �������� sql �޽��� ���ؼ� ���

			while(rs.next()) {	
				System.out.println(rs.getInt("shopnum")+"\t"+rs.getString("sangpum")+
						"\t"+rs.getInt("su")+"\t"+rs.getInt("price")+"\t"+rs.getDate("ipgo"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("�������");
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}

	//delete
	public void deleteMyshop() {
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("������ ������?");
		int shopnum = Integer.parseInt(sc.nextLine());

		String sql="delete myshop where shopnum=?";
		//prepare �� ? 
		try {
			pstmt = conn.prepareStatement(sql);
			//?���ε�
			pstmt.setInt(1, shopnum);

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
	//������ �������� ����?
	public boolean isData(String shopnum) {
		boolean b= false;

		Connection conn= db.getConnection();
		PreparedStatement pstmt =null;
		ResultSet rs=null;

		String sql="select * from myshop where shopnum=?";

		try {
			pstmt=conn.prepareStatement(sql);
			//?
			pstmt.setString(1, shopnum);
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
	//����..������ �Է���
	public void updateMyshop() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("������ ������ ��ȣ?");
		String shopnum=sc.nextLine();
		
		//���⼭ �������� ���ٸ� ����
		if(!isData(shopnum)) {
			System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�");
			return;
		}
		System.out.println("������ ��ǰ����?");
		String sangpum=sc.nextLine();
		System.out.println("������ ������?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("������ ������");
		int price=Integer.parseInt(sc.nextLine());
		
		//SQL
		String sql="update myshop set sangpum=?,su=?,price=? where shopnum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//4�� ������� ���ε�
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, price);
			pstmt.setString(4,shopnum);
			
			//������Ʈ
			pstmt.execute();
			
			System.out.println("��������!!!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//�˻�
	public void searchSangpum() {
		
		System.out.println("�˻��� ��ǰ��(�Ϻ�)");
		String sangpum=sc.nextLine();
		
		
		String sql="select * from myshop where sangpum like ?";
		System.out.println(sql);
		
		System.out.println("������\t��ǰ��\t����\t����\t��¥");
		System.out.println("-------------------------------------");
		
		Connection conn=db.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+sangpum+"%");
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				System.out.println(rs.getInt("shopnum")+"\t"+rs.getString("sangpum")+
						"\t"+rs.getInt("su")+"\t"+rs.getInt("price")+"\t"+rs.getDate("ipgo"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(rs, pstmt, conn);
		}
		
	}

	public static void main(String[] args) {

		PrepareMyShop shop = new PrepareMyShop();
		Scanner sc = new Scanner(System.in);
		int n;

		while(true) {
			System.out.println("-----------------------------------------");
			System.out.println("***��ǰ�԰�***");
			System.out.println("1.��ǰ�߰� 2.��ǰ���� 3.��ǰ���� 4.��ǰ��ü��� 5.��ǰ�˻� 9.����");
			n=Integer.parseInt(sc.nextLine());

			if(n==1)
				shop.insertMyshop();
			else if(n==9) {

				System.out.println("�����մϴ�");
				break;
			}
			else if(n==4) {
				shop.selectMyshop();
			}
			else if(n==2) {
				shop.deleteMyshop();
			}
			else if(n==3) {
				shop.updateMyshop();
			}
			else if(n==5) {
				shop.searchSangpum();
			}

		}
	}

}
