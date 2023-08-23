package day0621;

public class ExWhile_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//while 문으로 1부터 10까지 출력

		//변수지정
		int n=0;

		while(n<10) {
			n++;
			System.out.printf("%4d",n);
		}
		System.out.println();//그냥 한줄 띄기

		//다른방법
		n=0;//n울 0으로 초기화
		while(n<10) {
			System.out.printf("%4d",++n);//n++ 하면 n이 0으로 먼저나오고 그다음증가 0~9 ++n은 증가되고나서 1~10
		}
		System.out.println(); //한줄 띄기

		n=0;//n을 0으로 초기화
		while(true) {
			System.out.printf("%4d",++n);
			//무한루프에 빠지므로 반드시 break문을 주어야한다
			if(n==10)
				break;
		}
		System.out.println();//한줄 띄우기
		
		n=0;//n을 0으로 초기화
		while(++n<=10) {
			System.out.printf("%4d",n);//조건에서 증감식잇어서 출력엔 증감체크필요x
		}
	}

}
