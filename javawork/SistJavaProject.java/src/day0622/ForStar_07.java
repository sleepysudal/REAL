package day0622;

public class ForStar_07 {

	public static void main(String[] args) {
		//중첩(다중)for문으로 별모양 찍기
		/*System.out.println("별 모양 찍기");
		for(int i=1; i<=5; i++) { //행갯수
			for(int j=1; j<=5; j++) { //열갯수
				System.out.println("*");
			}
			System.out.println();
		}*/
		//1행에서는 1개 2행에서는 2개 3행 3개 4행 4개 5행 5개

		/*System.out.println("별모양 찍기");
		for(int i=1; i<=5; i++) { //행갯수
			if(i==1) {
				System.out.println("*");
			}
			if(i==2) {
				System.out.println("**");
			}
			if(i==3) {
				System.out.println("***");
			}
			if(i==4) {
				System.out.println("****");
			}
			if(i==5) {
				System.out.println("*****");
			}
		}
		System.out.println();*/
		System.out.println("별 모양 찍기");


		for(int i=1; i<=5; i++) { //행갯수
			for(int j=1; j<=i; j++) { //열갯수
				System.out.print("*");
			}
			for(int j=0; j>i; j++) { //열갯수
				System.out.print(" ");
			}
			System.out.println();			
			
		}
		System.out.println();
		
		//3번
		for(int i=1; i<=5; i++) { //행갯수
			for(int j=5; j>=i; j--) { //열갯수(i가 1일때 5번 2일대 4번)
				System.out.print("*");				
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
