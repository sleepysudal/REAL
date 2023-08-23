package day0616;

public class PrintfTest_05 {

	public static void main(String[] args) {
		//Printf는 문자열을 구성해서 출력
		//문자열뒤에 따라오는 데이터(%)를 순서대로 배치
		//%d: 정수 %f는 실수 %s:문자열 
		//%사용시에는 printf 써야함 ln 쓰거나 안쓰면 오류
		
		int num1=10,num2=20;
		int num3=num1+num2;
		
		
		
		
		
		//기존방식으로 printf로 출력
		System.out.println(num1+"+"+num2+"="+num3);
		
		System.out.printf("num1의 값은 %d, num2의 값은 %d, num3의 값은 %d입니다",num1,num2,num3);
	}

}
