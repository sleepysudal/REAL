package day0620;

import java.util.Scanner;

public class IfOperReview_02 {

	public static void main(String[] args) {
		/*
		 * (평가메시지: 90점이상 참잘함 80점이상 잘함 80점미만 다음기회에 삼항연산자)
		 * 학점 90점이상 A 80점이상 B 80점 미만 C if문
		 * 점수를 입력하세요
		 * 88
		 * =================================
		 * 점수: 88점
		 * 평가메세지: 잘함
		 * 학점: B
		 */
		//import
		Scanner sc=new Scanner(System.in);
		
		//변수지정
		int score;
		String grade;
		
		//값 입력
		System.out.println("점수를 입력하세요: ");
		score=sc.nextInt();//점수
		
		//삼항연산자로 평가메세지 출력
		System.out.println("==================================");
		System.out.println("점수: "+score+"점");		
		grade =(score>=90)?"참잘함":
			(score>=80)?"잘함":"다음기회에";
		System.out.println("평가메세지: "+grade);
		
		//if문으로 학점출력			
		if(score>=90) {
			System.out.println("학점: A");
		}
		else if(score>=80) {
			System.out.println("학점: B");
		}
		else {
			System.out.println("학점: C");
		}
		/* 
		 * 
		 * if(score>=90)
		 * grade="A";
		 * else if(score>=80)
		 * grade="B";
		 * else
		 * grade="C";
		 * 
		 * System.out.println("학점: "+grade);
		 * */
		
		
		
	}

}
