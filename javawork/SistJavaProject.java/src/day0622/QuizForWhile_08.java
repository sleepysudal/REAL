package day0622;

import java.util.Scanner;

public class QuizForWhile_08 {
	public static void Quiz1() {
		//나이를 반복해서 입력받는다(스캐너 )
		//0이되면 빠져나와서 출력한다 (break)
		//나이가 50이상일 경우 a변수 증가 (old>=50 if(a++)
		//나이가 30이상일경우 b변수 증가
		//그 나머지는 c변수 증가
		//=================================
		//50세이상: 3명
		//30세이상: 2명
		//그이외: 1명

		Scanner sc=new Scanner(System.in);
		int old;
		int a=0;
		int b=0;
		int c=0;

		while(true) {
			System.out.println("나이입력 해주세요");
			old=sc.nextInt();	

			if(old==0) {
				System.out.println("나이 입력 종료");
				break;
			}
			if(old<0) {
				continue;
			}
			if(old>=50) { //50이상인 경우 a변수 증가
				a++;
			}
			else if(old>=30) { //old가 30이상인 경우 b변수 증가
				b++;
			}
			else{ //다 아닌경우 c변수증가
				c++;
			}

		}
		System.out.println("=========================================");
		System.out.println("50세 이상: "+a+"명");
		System.out.println("30세 이상: "+b+"명");
		System.out.println("그 이외: "+c+"명");

	}
	public static void Quiz2() {
		//Q. 총 10개의 다양한 숫자(양수,음수)를 입력받아 양수의 갯수와 음수의 갯수를 구하시오
		/* 1: 45 (plus++)
		 * 2: -23 (minus++)
		 * 3. 0  
		 * (syso println)
		 * ======================
		 * 양수갯수: 6
		 * 음수갯수: 3
		 */
		//임포트
		Scanner sc=new Scanner(System.in);		
		
		//변수 지정
		int number; //입력 함수
		int plus=0; //양수 개수
		int minus=0; //음수 개수

		for(int i=1; i<=10; i++) { //개수 딱 정해져잇을때 for 아닐때 while
			System.out.println(i+"번"+" 숫자를 입력해주세요");
			number=sc.nextInt();

			//0 입력시 무효로 하고 다시입력하기
			if(number==0) {				
				i--;
				continue;
			}
			//양수 입력조건
			if(number>0) { 
				plus++;				
			}
			//음수 입력조건
			if(number<0) {
				minus++;
			}			
		}
		System.out.println("=========================================");
		System.out.println("양수갯수: "+plus);
		System.out.println("음수갯수: "+minus);		
	}
	public static void main(String[] args) {
		//Quiz1();
		Quiz2();

	}

}
