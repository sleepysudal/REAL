package day0621;

public class QuizFor_09 {

	public static void main(String[] args) {
		// Q1 1 2 4 5 7 8 10 continue 이용해서 출력(3의배수가없네)



		for(int i=1; i<=10; i++) {
			if(i%3==0)			
				continue;
			System.out.print(i+" ");
		}
		System.out.println();
		//Q2 continue 이용해서 홀수값:1 홀수값:3 세로로출력 
		for(int i=1; i<=10; i++) {
			if(i%2==0)//<<짝수 (i%2==1) 은 홀수
				continue;
			System.out.println("홀수값: "+i);
		}
		//Q3 1부터 100까지 중에서 홀수의 합을 구하시오
		int sum=0; //홀수 합계 구할 변수
		int sum2=0;

		for(int i=1; i<=100; i++) {
			if(i%2==1)
				sum+=i;
			else
				sum2+=i;
		}
		System.out.println("홀수의 합: "+sum);
		System.out.println("짝수의 합: "+sum2);

		//while(true)문을 이용해서 1~100사이의 짝수합구하기
		int a= 1;
		int sum3=0;
		while(true) {
			/*a++;
			if(a%2==1)//홀수			
				continue;//위에 홀수나올경우 제외함
				sum3+=a;		
			if(a==100)
				break; */
			a++;
			if(a%2==0)
				sum3+=a;
			if(a==100)//if(a>100) 이거도됨
				break;
		}

		System.out.println("1~100사이 짝수합: "+sum3);
	}

}
