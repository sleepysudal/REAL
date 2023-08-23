package day0622;

import java.util.Scanner;

public class StartWith_03 {

	public static void main(String[] args) {
		// 이름을 반복해서 입력해서 이씨가 몇명인지 알아보자
		//종료 ==끝
		Scanner sc=new Scanner(System.in);
		String name;
		int count=0;
		
		while(true) {
			System.out.println("이름입력:(끝이면 종료)");
			name=sc.nextLine();
			
			//BREAK
			if(name.equals("끝"))					
			break;
			
			//조건
			if(name.startsWith("이"))
				count++;
		}
		System.out.println("이씨성을 가진사람은 총"+count+"명 입니다");
	}

}
