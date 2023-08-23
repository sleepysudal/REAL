package day0623;

import java.util.Scanner;

public class ArrScannerSum_09 {

	public static void main(String[] args) {
		/*
		 * 1번재 값: 55 <<내가 입력
		 * 2번째 값: 77
		 * 3번째 값: 88
		 * 4번째 값: 49
		 * 5번째 값: 29
		 * 
		 * ===============================
		 * [입력값 확인]
		 * 1번지값: 55
		 * 2번지값: 77
		 * 3번지값: 88
		 * 4번지값: 49
		 * 5번지값: 29
		 * 
		 * ===============================
		 * 총합계 : 298
		 * */
		//임포트
		Scanner sc=new Scanner(System.in);
		
		int []data;
		data = new int [5];		
		
		int sum=0; //합계
		
		//값 입력
		for(int i=0; i<data.length; i++) {
			System.out.print((i+1)+"번째 값: ");
			data[i]=sc.nextInt();
			sum+=data[i];
			
		}
		
		//출력
		System.out.println("");
		System.out.println("==========================");
		System.out.println("[입력값 확인]");
		
		for(int i=0; i<data.length; i++) {
			System.out.println((i+1)+"번째 값 : "+data[i]);
		}
        System.out.println("");
		System.out.println("===========================");
        System.out.println("총합계 : "+sum);
	}

}
