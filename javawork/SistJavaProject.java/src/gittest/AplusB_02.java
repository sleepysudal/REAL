package gittest;
import java.util.Scanner;
public class AplusB_02 {

	public static void main(String[] args) {
		//임포트
		Scanner sc= new Scanner(System.in);

		//변수지정
		int a,b,t;		

		//값입력
		//System.out.println("몇번 더할건지");
		t=sc.nextInt();
		int array[] =new int[t]; //a+b 값 받을때 쓰는거

		//몇번 물어볼건지 몇번 값받는지
		for(int i=0; i<t; i++) {
			//System.out.println("두 정수 a,b 값 입력해라");
			a=sc.nextInt();
			b=sc.nextInt();
			array[i] = a+b;

		}
		System.out.println();
		for(int i=0; i<t; i++) {
			System.out.println(array[i]);

		}
	}
}