package day0622;

public class QuizForWhile_01 {
	public static void quiz1() {
		//가로로 출력_for_1 2 3 4 5 그리고 다음줄에 종료 라고 출력하시오
		int a;
		for (a=1; a<=5; a++) {
			System.out.print(a+" ");

		}
		System.out.println("\n종료");
	}
	public static void quiz2() {
		//가로로 출력_for_ 1 2 4 5 7 8 10 

		for(int a=1; a<=10; a++) {
			if(a%3==0)
				continue;
			System.out.print(a+" ");//이게 if 컨티뉴보다 위에잇으면 3 6 9 다 나옴 
		}
		System.out.print("\n종료");
	}
	public static void quiz3() {
		//안녕을 가로로 3번 출력하시오
		String a="안녕";
		for(int b=1; b<=3; b++) {
			System.out.print(a+" ");
		}
		System.out.print("\n종료");	
	}
	public static void quiz4() {
		//1부터 10까지 짝수만 가로로 출력하시오
		for(int a=1; a<=10; a++) {
			if(a%2==1)//홀수
				continue;
			System.out.print(a+" ");
		}
		System.out.print("\n종료");
	}
	public static void quiz5() {
		//1부터 10까지의 합은 55입니다
		int sum=0;
		for(int a=1; a<=10; a++) {
			sum+=a;
		}
		System.out.println("1부터 10까지의 합은 "+sum);
	}
	public static void main(String[] args) {
		//quiz1();
		//quiz2();
		//quiz3();
		//quiz4();
		//quiz5();

	}

}
