package day0621;

import java.util.Scanner;

public class ScannerFor_11 {
	public static void numSum() {
		// 합계를 구할숫자는? 100
		//1부터 100까지의 합은 5050입니다
		//임포트
		Scanner sc=new Scanner(System.in);
		int n; //입력할수 
		int sum=0;

		//입력
		System.out.println("합계를 구할숫자는?");
		n=sc.nextInt();

		//조건

		for(int i=1; i<=n; i++) {
			sum+=i;
		}
		System.out.println("1부터 "+n+"까지의 합은 "+sum);
	}
	public static void factorialTest() {
		//1!=1
		//2!=2
		//3!=6
		//10! 출력
		int multiply=1;
		for (int i=1; i<=10; i++) {
			multiply*=i;
			System.out.println(i+"! ="+multiply);
		}
	}

	public static void QuizFact() {
		Scanner sc=new Scanner(System.in);
		int su;
		int multiply=1;

		System.out.println("팩토리얼 구할 숫자 입력");
		su=sc.nextInt();

		for (int i=1; i<=su; i++) {
			multiply*=i;
		}		
		System.out.println(su+"!="+multiply);
	}
	public static void main(String[] args) {
		numSum();
		factorialTest();
		QuizFact();
	}


}

