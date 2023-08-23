package day0620;

import java.util.Scanner;

public class QuizIfOper_05 {

	public static void main(String[] args) {
		/*
		 * 상품명? 아이패드
		 * 수량? 3
		 * 가격? 500000
		 * =================================
		 * 아이패드 3개는 총 1500000원입니다
		 * 3개이상은 10프로 DC가 됩니다
		 * DC된 총금액: 1350000원
		 */
		
		//임포트
		Scanner sc=new Scanner(System.in);
		
		//변수지정
		String name;
		int su,gap;
		double dc;
		
		//값입력받기
		System.out.print("상품명?");
		name=sc.nextLine();
		System.out.print("수량?");
		su=Integer.parseInt(sc.nextLine());
		System.out.println("가격?");
		gap=Integer.parseInt(sc.nextLine());
		
		//계산하기(if값)
		
		if(su>=3) {
			dc=su*gap*0.9;
		}
		else
			dc=su*gap;
		
		//계산하기(삼항연산자)
		dc=(su>=3)?su*gap*0.9 : su*gap;
		
		
		//결과출력
		System.out.println("=====================================");
		System.out.println(name+" "+su+"개는 총 "+(su*gap)+"원입니다");
		System.out.println("3개이상 구매시 10%dc입니다");
		System.out.println("if총금액: "+(int)dc+"원");
		System.out.println("삼항연산자 총금액은: "+(int) dc+"원입니다");
	}

}
