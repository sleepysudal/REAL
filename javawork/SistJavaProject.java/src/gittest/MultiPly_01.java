package gittest;

import java.util.Scanner;

public class MultiPly_01 {

	public static void main(String[] args) {
		/*      2 * 1 = 2
		        2 * 2 = 4
				2 * 3 = 6
				2 * 4 = 8
				2 * 5 = 10
				2 * 6 = 12
				2 * 7 = 14
				2 * 8 = 16
				2 * 9 = 18
		 */
		//임포트
		Scanner sc=new Scanner(System.in);
		//변수지정		
		int n;
		//값 입력
		System.out.println("n값 입력해주세요");
		n=sc.nextInt();
		//for 문 
		for (int a=1; a<=9; a++)
		{
			System.out.println(n+"*"+a+"="+(n*a));
		}		


	}

}
