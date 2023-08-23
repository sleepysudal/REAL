package day0621;

public class ExWhile_03 {

	public static void main(String[] args) {
		// while for 비교
		//10 9 8 7 6 5 4 3 2 1 0
		int i=10;

		while(i>=0) {
			System.out.print(i--+" ");

		}
		System.out.println();//한줄띄우기

		//for문(똑같이 i=10으로 초기화하고 써도됨,
		for(int a=10; a>=0; a--) {
			System.out.print(a+" ");
		}
		System.out.println();
		
		
	}

}
