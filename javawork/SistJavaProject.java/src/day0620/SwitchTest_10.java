package day0620;

import java.util.Scanner;

public class SwitchTest_10 {

	public static void main(String[] args) {	
		
		
		//변수 지정
		int n=3;
		
		
		switch(n)		
		{
		case 1:
			System.out.println("n is 1");
		break;
		case 2:
			System.out.println("n is 2");
		break;
		case 3:
			System.out.println("n is 3");
		break;
		case 4:
			System.out.println("n is 4");
		default:
			System.out.println("n is > 4");
		}
		
		String msg = "happy";
		switch(msg)
		{
			case "Hello":
				System.out.println("안녕");
				break;
			case "happy":
				System.out.println("행복하다");
				break;
			case "nice":
				System.out.println("좋다");
				break;
		}
		
		//점수 이용하여 학점구하기
		int score = 89;
		char grade;
		
		switch(score/10)
		{
		case 10:
		case 9:
			grade='A';
		break;
		case 8:
			grade='B';
			break;
		case 7:
			grade='C';
		break;
		case 6:
			grade='D';
		break;
		default:
			grade='F';			
		}
		System.out.println(score+"점은"+grade+"등급이야");
	}

}
