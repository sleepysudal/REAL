package day0616;

public class OperTest_07 {

	public static void main(String[] args) {
		//기본자료형은_8개
		//1.논리형_true, false 
		boolean b=false;
		
		//2.문자형
		//반드시 하나의 문자 16비트 유니코드값 표현
		//자바에서 char 문자하나 2byte
		//기본적으로는 정수형, 아스키코드
 		char ch='A';
 		
 		//3.정수형
 		byte a=-128; //1byte -128~127까지 가능
 		short s=32000;//16bit
 		int c= 6700000;//32bit
 		long num=100L;//64bit, 뒤에 L,1을 붙여야 long
 		//THE value of the local variable a is not used 오류는 변수지정후 사용하지않아서 생기는오류다 
 		//System.out.println("byte="+a);처럼 한번 사용해주면 오류안뜬다.
 		
 		//4.실수형
 		double d=42356.14526; //64bit, 8byte 소수점 
 		float f= 3.123123f;//32bit
 		
 		//int,float는 똑같이 32bit사용하지만 기본적으로 실수형이 정수형보다 큰 타입으로 처리된다
 		
 		//출력 
 		System.out.println("bool="+b);
 		System.out.println("not bool="+!b);
 		System.out.println("char="+ch);//대문자 A는 아스키코드 정수:65
 		System.out.println("char="+(ch+1));//66 		
 		System.out.println("ch="+(char)(ch+1));//B
 		System.out.println("Double="+d);//정밀도 15자리
 		System.out.println("Float="+f);//정밀도 8자리
 		//printf %f:실수 %d 정수 %s문자 \n줄띄우기 \t 탭거리늘리기
 		//전체자리수 10자리 소수점2자리
 		System.out.printf("d=%10.2f\n",d);
 		//소주점1자리
 		System.out.printf("d=%.1f",d); 		
 		
 		
	}
}
