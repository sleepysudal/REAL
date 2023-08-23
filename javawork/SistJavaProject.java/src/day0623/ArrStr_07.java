package day0623;

public class ArrStr_07 {

	public static void main(String[] args) {
		// 문자형 배열 str1, str2 ... 선언과 동시에초기화
		String str1[]= {"계란" , "훈제란", "구운계란","삶은계란","타마고"};
		String str2[]=new String[5];//5개의 문자열이 들어가도록 메모리할당 ,null로 초기화
		
		//str2에 문자열넣기
		str2[0]="빨강";
		str2[1]="주황";
		str2[4]="파랑";
		
		//str1을 변수i 를 이용해서 출력 for문
		//음식1은: 김밥
		//음식2는: 피자
		System.out.println("for 문 음식 출력");
		for(int i=0; i<str1.length; i++ ) {
			System.out.println("음식"+(i+1)+": "+str1[i]);
		}
		System.out.println();//한줄 띄우기
	
		//str1출력 (김밥 피자 스파게티 햄버거 짜장면)
		System.out.println("for each문으로 음식 출력");
		for(String s1:str1) {
			System.out.print(s1+" ");
		}
		System.out.println("");//한줄띄우기
		
		//str2 for
		System.out.println("for문으로 str2 출력");
		for(int i=0; i<str2.length; i++) {
			System.out.println("음식"+(i+1)+": "+str2[i]);
		}
		System.out.println();//한줄띄우기
	    
		//str2 for each
		System.out.println("for each문 str2 출력");
		for(String s2:str2) {
			System.out.print(s2+" ");
		}
	}

}
