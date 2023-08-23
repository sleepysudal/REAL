package day0621;

public class ExFor_07 {

	public static void main(String[] args) {
		//초기값이 조건 안맞으면 한번도 반복안됨
		for(int i=5; i<=1; i++) {
			System.out.print(i);
		}
		System.out.println("\n============================================");

		int i;
		for(i=1;i<=10;i++) {
			System.out.print(i+" ");
		}
		System.out.println("\n빠져나온 후의 i값: "+i);


		int a=10;
		for(;a<=50;a+=5) { /*초기값을 반복문 바깥에서 주었을경우 생략가능(;은 써야함)*/
			System.out.print(a+" ");
		}
		System.out.println("\n빠져나온후의 a값: "+a);

		//hello를 가로로 5번 반복하시오
		
		for(int n=5;n>=1;n--) {
			System.out.print("\thello");
		}
		System.out.println();
		
		System.out.println("1부터 10까지의 숫자중 짝수만 가로로 출력하기");
		for (int c=1; c<=10; c++) {
			if(c%2==0)//c는 2로 나눳을때 나머지가 0나옴 << 짝수
			//if(c%2==1)//c는2로 나눳을대 나머지 1 <<홀수
				//continue; 홀수값 들 스킵 되서 짝수만나옴
				System.out.print(c+" ");			
		}
		System.out.println("\n=================================================");
		
		System.out.println("1부터 20까지 숫자중 10의 약수만 제외하고 출력");
		
		for(int d=1; d<=20; d++) {
			if(10%d==0) //약수는 나머지가 0
				continue;
			System.out.print(d+" ");
		}
		
		
	}

}
