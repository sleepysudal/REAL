package day0620;

import java.util.Scanner;

public class IfMaxNum_04 {

	public static void main(String[] args) {
		/*
		 3개 
		 */
		//임포트
		Scanner sc=new Scanner(System.in);
		//변수지정
		int x,y,z;
		int max;
		
		//값입력받기
		System.out.println("3개의 수 입력");
		x=sc.nextInt();
		y=sc.nextInt();
		z=sc.nextInt();
		
		//입력받은값 출력
		System.out.println("입력한 수: "+x+","+y+","+z);
		
		//if문
		if(x>y && x>z) {
			max = x;
		}
		else if(y>x && y>z) {
			max = y;
		}
		else {
			max = z;
		}
			
			
			//삼항연산자
			max=(x>y && x>z)?x:(y>x && y>z)?y:z;			
		
			 
			 //결과출력
			 System.out.println("=================================");
			 System.out.println("***if문***");
			 System.out.println("가장큰수: "+max);
			 System.out.println("***삼항연산자***");
			 System.out.println("가장큰수: "+max);
	}
}


