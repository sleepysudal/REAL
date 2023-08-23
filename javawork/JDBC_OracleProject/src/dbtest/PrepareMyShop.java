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

		System.out.println("상품명은?");
		String sang=sc.nextLine();
		System.out.println("수량?");		
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("가격?");
		int dan = Integer.parseInt(sc.nextLine());

		//SQL .. PreparedStatement는 미완의 sql문을 작성
		String sql = "insert into myshop values (seq1.nextval,?,?,?,sysdate)";

		try {
			pstmt = conn.prepareStatement(sql);

			//?를 순서대로 바인딩
			pstmt.setString(1, sang);
			pstmt.setInt(2, su);
			pstmt.setInt(3, dan);

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
			System.out.println("시퀀스\t상품명\t수\t가격\t날짜");
			System.out.println("---------------------------------------------------------");
			//System.out.println(sql); 오류날시 sql 메시지 통해서 출력

			while(rs.next()) {	
				System.out.println(rs.getInt("shopnum")+"\t"+rs.getString("sangpum")+
						"\t"+rs.getInt("su")+"\t"+rs.getInt("price")+"\t"+rs.getDate("ipgo"));
			}
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("연결실패");
		}finally {
			db.dbClose(rs, pstmt,conn);
		}
	}

	//delete
	public void deleteMyshop() {
		Connection conn= db.getConnection();
		PreparedStatement pstmt = null;

		System.out.println("삭제할 시퀀스?");
		int shopnum = Integer.parseInt(sc.nextLine());

		String sql="delete myshop where shopnum=?";
		//prepare 라서 ? 
		try {
			pstmt = conn.prepareStatement(sql);
			//?바인딩
			pstmt.setInt(1, shopnum);

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
	//수정할 시퀀스가 존재?
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
	//수정..시퀀스 입력후
	public void updateMyshop() {
		Connection conn=db.getConnection();
		PreparedStatement pstmt=null;
		
		System.out.println("수정할 시퀀스 번호?");
		String shopnum=sc.nextLine();
		
		//여기서 시퀀스가 없다면 종료
		if(!isData(shopnum)) {
			System.out.println("해당 번호는 존재하지 않습니다");
			return;
		}
		System.out.println("수정할 상품명은?");
		String sangpum=sc.nextLine();
		System.out.println("수정할 수량은?");
		int su=Integer.parseInt(sc.nextLine());
		System.out.println("수정할 가격은");
		int price=Integer.parseInt(sc.nextLine());
		
		//SQL
		String sql="update myshop set sangpum=?,su=?,price=? where shopnum=?";
		
		try {
			pstmt=conn.prepareStatement(sql);
			
			//4개 순서대로 바인딩
			pstmt.setString(1, sangpum);
			pstmt.setInt(2, su);
			pstmt.setInt(3, price);
			pstmt.setString(4,shopnum);
			
			//업데이트
			pstmt.execute();
			
			System.out.println("수정성공!!!");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			db.dbClose(pstmt, conn);
		}
		
	}
	//검색
	public void searchSangpum() {
		
		System.out.println("검색할 상품명(일부)");
		String sangpum=sc.nextLine();
		
		
		String sql="select * from myshop where sangpum like ?";
		System.out.println(sql);
		
		System.out.println("시퀀스\t상품명\t수량\t가격\t날짜");
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
			System.out.println("***상품입고***");
			System.out.println("1.상품추가 2.상품삭제 3.상품수정 4.상품전체출력 5.상품검색 9.종료");
			n=Integer.parseInt(sc.nextLine());

			if(n==1)
				shop.insertMyshop();
			else if(n==9) {

				System.out.println("종료합니다");
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
