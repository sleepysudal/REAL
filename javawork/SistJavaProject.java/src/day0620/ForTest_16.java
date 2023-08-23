package day0620;

public class ForTest_16 {

	public static void main(String[] args) {
		//1. 1~5까지 출력하시오
		for(int i=1; i<=5; i++)
		{		
			System.out.print(i+" ");

		}
		System.out.println();

		for(int i=5; i>=1; i--) {
			System.out.print(i+" ");
		}
		System.out.println();

		//0,2,4,6,8,10
		for(int i=0; i<=10; i+=2) /*i가 2씩 증가*/{
			System.out.print(i+" ");
		}
		System.out.println();
		//3,6,9,12,15
		for(int i=3; i<=15; i+=3)/*i가 3씩 증가*/ {
			System.out.print(i+" ");
		}
		System.out.println();
		//I LOVE JAVA_0
		//I LOVE JAVA_1
		//I LOVE JAVA_2
		//I LOVE JAVA_3
		for(int i=0; i<=3; i++){
			System.out.println("I Love Java_"+i);
			
		}
	}
}