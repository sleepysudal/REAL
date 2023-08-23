package day0623;

import java.util.Scanner;

public class SuMatch_03 {

	public static void main(String[] args) {
		// 랜덤수를 발생시킨 후 그 숫자를 맞춰보자
		Scanner sc=new Scanner(System.in);

		//1~100사이의 랜덤수 발생
		int rnd=(int)(Math.random()*100)+1;

		int su; //랜덤수 맞출 입력할 숫자
		int cnt=0; //횟수
		
		while(true) {
			cnt++;
			System.out.print(cnt+":");
			su=sc.nextInt();

			if(su>rnd) {
				System.out.println(su+"보다 작습니다");
			}
			else if(su<rnd) {
				System.out.println(su+"보다 큽니다");
			}
			else {
				System.out.println("맞았습니다 정답은"+rnd+"입니다");
				break;
			}
		}
		System.out.println("게임종료 시도한 횟수는"+cnt+"회입니다");		

	}
}
