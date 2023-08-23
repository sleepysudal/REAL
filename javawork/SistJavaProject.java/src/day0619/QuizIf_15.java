package day0619;

import java.util.Scanner;

public class QuizIf_15 {

	public static void main(String[] args) {
		//점수를 입력하여 평가를 출력하시오
		//당신의 점수는? 88
		//=======================================================
		//90점이상: 장학생 80점이상:우수상 80점미만:재시험
		//======================================================
	    //당신은 88점이므로 평가는 우수상~~~
		
		//1. if문 사용
		
		//변수 지정
		Scanner sc= new Scanner(System.in);
		int score;
		String grade;
		
		//입력
		System.out.println("당신의 점수는? ");
		score=sc.nextInt();
		System.out.println("==================================");
		//점수별 출력
		if
		(score>=90) {
			System.out.println("당신은"+score+"이므로 평가는 장학생");
		}
		else if(score>=80) {
			System.out.println("당신은"+score+"이므로 평가는 우수상");
		}
		else {
			System.out.println("당신은"+score+"이므로 재시험");
		}
		
		/*
		//2.삼항연산자 사용
		  
		  //변수지정
		  int score;
		  String grade;
		  
		  //입력
		  Scanner sc= new Scanner(System.in);
		  System.out.print("당신의 점수는? ");
		  score=sc.nextInt();
		  System.out.println("=======================================");
		  
		  //점수별 평가
		  grade=(score>=90)?"장학생":
			  (score>=80)?"우수상":"재시험";
			  
			  //결과 출력
			  System.out.println("당신은 "+score+"점이므로 평가는 "+grade); 
		  	*/
		  
	}

}
