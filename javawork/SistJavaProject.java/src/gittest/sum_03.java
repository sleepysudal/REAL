package gittest;

import java.util.Scanner;

public class sum_03 {

	public static void main(String[] args) {
		// n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
		//첫째 줄에 n (1 ≤ n ≤ 10,000)이 주어진다.
		//1부터 n까지 합을 출력한다.

		//임포트
		Scanner sc=new Scanner(System.in);

		//변수지정
		int n;
		int sum=0;

		//n값 입력받기
		System.out.println("몇까지 합할지 알려주세요");
		n=sc.nextInt();

		//for문
		for(int a=1; a<=10000; a++) {
			sum+=a;
			if(a==(n))
				break;			

		}
		System.out.println("1부터 "+n+"까지의 값은 "+sum+"입니다");


	}

}
