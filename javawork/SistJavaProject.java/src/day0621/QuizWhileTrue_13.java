package day0621;

import java.util.Scanner;

public class QuizWhileTrue_13 {

	public static void main(String[] args) {
		/* 점수를 반복해서 입력하다가 q나 Q를 입력하면
		 while문을 빠져나온뒤 총갯수, 총점, 평균을 출력하시오*/
		 
		//IMPORT
		Scanner sc=new Scanner(System.in);

		//변수지정
		String jumsu; //점수
		int getsu=0; //총갯수		
		int chongjum=0; //총점
		double avg; //평균

		//와일문 입력
		//점수 입력 스캔
		while(true) {
			System.out.println("점수를 입력하시오 Q나 q입력시 종료");
			jumsu=sc.nextLine();
			
			//(q나 Q 입력시 종료)
			//if(jumsu.equals.("q")||jumsu.equals("Q")) //한글이면 똑같아야되므로 이게 좋음
			//if(jumsu.equalsIgnoreCase("q")) //영어일 경우 이게 좋음
			if(jumsu.charAt(0)=='q'||jumsu.charAt(0)=='Q') //이거는 한글자만 가능
			break;
			
			//갯수계산
			getsu++;
			
			//총점 계산
			chongjum+=Integer.parseInt(jumsu);//정수로 변환후 합계 변수에 누적

		}
		//평균 계산
		avg=(double)chongjum/getsu;
		
		//결과 출력
		System.out.println("***결과출력***");
		System.out.println("총갯수 출력: "+getsu+"개");
		System.out.println("총점출력: "+chongjum+"점");
		System.out.printf("평균%.1f점",avg);//printf %.1f시 ,변수 이렇게 써야됨
	}
}