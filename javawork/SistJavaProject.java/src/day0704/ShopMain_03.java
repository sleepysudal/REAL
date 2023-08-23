package day0704;

import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class ShopMain_03 {

	List<Shop>list = new Vector<Shop>();
	
	//입력
	public void InputShop() {
		Scanner sc=new Scanner(System.in);
		String SangName; int su; int dan;
		
		System.out.println("상품명?");
		SangName=sc.nextLine();
		System.out.println("수량?");
		su=Integer.parseInt(sc.nextLine());
		System.out.println("가격?");
		dan=Integer.parseInt(sc.nextLine());
		
		Shop data = new Shop(SangName, su, dan);
		
		list.add(data);	
		
	}
	//출력
	public void OutputShop() {
		
		System.out.println("번호\t상품명\t수량\t가격\t총가격");
		
		for(int i=0; i<list.size(); i++) {
			Shop s=list.get(i);
			
			//총가격
			int total= s.getSu()*s.getDan();
			
			//최종출력			
			System.out.println((i+1)+"\t"+s.getSangName()+"\t"+s.getSu()+"\t"+s.getDan()+"\t"+total); //총가격 넣어줘야됨
			
		}		
		System.out.println("=====================================================================");
		
	}

	
	
	
	public static void main(String[] args) {
		ShopMain_03 sm = new ShopMain_03();
		
		Scanner sc = new Scanner(System.in);
		int n;
		
		while(true) {
			System.out.println("1.상품입고 2.상품재고 9.종료");
			n=Integer.parseInt(sc.nextLine());
			
			if(n==1)
				sm.InputShop();
			else if(n==2)
				sm.OutputShop();
			else if(n==9) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("잘못입력했어요");
				continue;
			}
		}
		

	}

}
/* 
1.상품입고 2.상품재고 9.종료
1
상품명? 바나나
수량? 10
가격? 1000
2
번호 상품명 수량 가격 총가격
1  바나나  10 1000 10000원
*/