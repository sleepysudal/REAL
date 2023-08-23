package day0621;

public class ForSum_08 {

	public static void main(String[] args) {
		// for문으로 합계구하기
		//1~10까지 합계
		int sum=0; //합계 구하는 변수
		for(int i=1;i<=10;i++) {
			sum+=i; //sum=sum+i...합계변수에 i를 누적시킨다
		}
		System.out.println("1부터 10까지의 합은 "+sum+"입니다");
		
		//while문으로도 합계구해보기
		int total=0;
		int i=1;
		while(i<=10) {
			total=total+i;
			i++;
		}
		System.out.println("1부터 10까지의 합은 "+total+"입니다");
	
	//결과 출력시 1~500까지의 합은 125250입니다
		int total2=0;
		int a=1;
		for(;a<=500;a++) {
			total2+=a;
		}
		System.out.println("1에서 "+(a-1)+"까지의 합은"+total2+"입니다");//for문을 빠져나올땐 1증가한다
	}
	
	

}
