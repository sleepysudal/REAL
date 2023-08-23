package gittest;

import java.util.Scanner;

public class AplusB {

	public static void main(String[] args) {
		//임포트
		Scanner sc=new Scanner(System.in);

		//변수입력
		int a,b,t;
		 

		//테스터값 입력
		System.out.println("테스트 횟수를 입력하시오");
		t=sc.nextInt();
		int array[] =new int[t];
		
		System.out.println("두 정수 a와 b를 입력하시오"); //1번질문출력후
		for(int i=0; i<t; i++) {
			a=sc.nextInt();//t의 루틴 갯수 만큼 돔
			b=sc.nextInt();//t의 루틴 갯수 만큼 돔			
			array[i]=a+b;
		}
		
		System.out.println();//입력값과 결과값 사이 한줄띄기		
		
		//결과출력
		for(int i=0; i<t; i++) {		
			System.out.println(array[i]);
		}
	}


}
