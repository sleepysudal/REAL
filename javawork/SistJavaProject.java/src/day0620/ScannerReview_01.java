package day0620;

import java.util.Calendar;
import java.util.Scanner;

public class ScannerReview_01 {

	public static void main(String[] args) {
		/*
		 * 태어난 연도: 1997
		 * 이름: 홍길동
		 * 핸드폰번호: 010-1234-5678
		 * 주소: 서울시 동작구
		 * ================================
		 *         [개인정보]
		 *         이름: 홍길동
		 *         나이: 26세
		 *         연락처: 010-1234-5678
		 *         주소: 서울시 동작구
		 */
		//import
		Scanner sc=new Scanner(System.in);
		Calendar calendar=Calendar.getInstance();
		
		//변수선언
		String name,phone,address;
		int birth;			
		int currentyear=calendar.get(calendar.YEAR);
		
		//입력
		System.out.print("태어난 연도: ");
		//birth =sc.nextInt();//nextint 다음 라인오면 버퍼생김
		birth=Integer.parseInt(sc.nextLine());
		
		System.out.print("이름: ");
		name = sc.nextLine();
		
		System.out.print("핸드폰번호: ");
		phone = sc.nextLine();
		
		System.out.print("주소: ");		
		address =sc.nextLine();
		
		System.out.println("=======================================");
		
		//나이계산
		int myage=currentyear-birth;
		
		//결과출력
		System.out.println("\t[개인정보]");
		System.out.println("이름: "+name);
		System.out.println("나이: "+myage);
		System.out.println("연락처: "+phone);
		System.out.println("주소: "+address);
		
	}

}
