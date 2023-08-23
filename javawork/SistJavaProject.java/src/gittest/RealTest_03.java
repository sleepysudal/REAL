package gittest;

import java.util.Scanner;

public class RealTest_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		int score;
		int count=0;
		int a=0;
		int b=0;
		int c=0;


		while(true) {
			System.out.println("점수를 입력해줘");
			score=sc.nextInt();
			count++;
			
			if(score==0) {				
				break;
			}
			if(score>100 || score<0) {
				count--;
				continue;
			}
			if(score>=90) {
				a++;
			}
			else if(score>=80) {
				b++;
			}
			else {
				c++;
			}			
			
		}
		System.out.println("90점이상은 "+a+"명입니다");
		System.out.println("80점이상은 "+b+"명입니다");
		System.out.println("70점이상은 "+c+"명입니다");
		System.out.println("시험본 학생수는 "+count+"명입니다");
	}
}
