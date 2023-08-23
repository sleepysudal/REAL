package day0620;

import java.util.Scanner;

public class LeapYear_13 {

	public static void main(String[] args) {
		/*년도를 입력후 윤년인지 평년인지 출력하기
		 * 공식 
		 * 년도를 4로 나누어서 나머지가 0이고
		 * 년도를 100으로 나눠서 나머지가 0이 아니거나 << 평년공식이라안써도될듯
		 * 년도를 400으로 나눠서 나머지가 0이면 윤년*/


		//임포트 
		Scanner sc=new Scanner(System.in);

		//변수지정
		int year;

		//값입력
		System.out.println("연도를 입력하세요");
		year=sc.nextInt();

		//if문
		if(year%4==0 && year%100!=0 ||year%400==0) {
			System.out.println(year+"년도는 윤년이다");
		}else {
			System.out.println(year+"년도는 평년이다");
		}
	}
}


