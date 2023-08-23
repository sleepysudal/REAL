package day0621;

public class ExForWhile_10 {

	public static void test1() {
		//for 문으로 1부터 5까지의 합 구하기
		int sum=0;
		for(int a=1; a<=5; a++) {
			sum+=a;
		}
		System.out.println("1~5까지의 총합: "+sum);
	}
	public static void test2() {
		//1~10까지의 홀수합_for문
		int sum=0;
		for(int a=1; a<=10;a++) {
			if(a%2==1)
			sum+=a;
		}
		System.out.println("총합계는 "+sum);
	}
	public static void test3() {
		//100까지의 합은 5050 100은 변수로 처리해서 출력하시오
		int sum =0;
		int n=100;
		int i=0;
		while(true) {		
			if(i<=n) {
				i++;
				sum+=i;
			}
			if(i==n) {
				break;
			}
			

		}
		System.out.println("100까지의 합:  "+sum);
	}

	public static void main(String[] args) {
		test1();
		test2();
		test3();
	}

}
