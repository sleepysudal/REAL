package day0621;

public class ExFor_06 {

	public static void main(String[] args) {
		// for문
		//1~10까지 가로로 출력
		int i;
		for(i=1; i<=10; i++) {
			System.out.print(i+" ");
		}
		System.out.println("\n종료");

		//10~1까지 가로로 출력

		for(i=10; i>0; i--) {
			System.out.print(i+" ");
		}
		System.out.println("\n종료");

		//1~50까지 출력하는데 3씩 증가하게
		for(i=1; i<=50; i+=3) {
			System.out.print(i+" ");
		}
		System.out.println("\n종료");

		//continue
		//1~20까지 출력하는데 1 2 3 4 5 6 7 8 9 11 12 
		for(i=1; i<=20; i++) {			
			//5의 배수를 빼고 출력
			if(i%5==0)//5로 나누면 나머지 0 = 5의 배수
				continue;//i++로 이동
			//break; //반복문 빠져나감
			System.out.print(i+" ");
		}
		System.out.println("\n종료");
	}

}
