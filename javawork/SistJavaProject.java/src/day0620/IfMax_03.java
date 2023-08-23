package day0620;

import java.util.Scanner;

public class IfMax_03 {

	public static void main(String[] args) {
		// 2개의 숫자를 입력받았을때 Max,Min 값 구해보기
		
		//임포트
		Scanner sc=new Scanner(System.in);
		
		//변수지정
		int x,y,max;
		
		//값 입력받기
		System.out.println("**두개의 숫자를 입력하시오**");
		x=sc.nextInt();
		y=sc.nextInt();
		
		//입력받은 두수 출력
		System.out.println("입력한 두수: "+x+","+y);
		
		//두 숫자중 max , min 값 구분하기
		/*if(x>y) {
			System.out.println("max=x");
		}
		else
			System.out.println("max=y");*/
		
		//삼항연산자로 x,y중 max 값구하기
		max=(x>y)?x:y;
		
		//출력
		System.out.println("두수중에서 더 큰값은 "+max+"입니다");
		
		//삼항연산자를 이용하여 출력문에서 첫번쨰수가 더 작다 or 더 크다 구하기
		System.out.println("첫번째 수가 더 "+(x>y?"크다":"작다"));
		
		
	}

}
