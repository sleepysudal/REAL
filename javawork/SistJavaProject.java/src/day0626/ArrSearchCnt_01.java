package day0626;

import java.util.Scanner;

public class ArrSearchCnt_01 {

	public static void main(String[] args) {
		//성을 입력시 그 성씨를 가진 사람과 총 인원 수를 출력해라
		//종료 라고 하면 프로그램 종료

		String [] names = {"김선호","나나","이효리","엄정화","김완선","보아","유재석","하하"
				,"김연진","이진"};

		Scanner sc =new Scanner(System.in);
		int cnt=0; //검색할때마다 0으로 초기화 필요 
		String search;//입력할 성씨
		boolean check;//맞는지 틀린지 확인하는 논리변수

		//몇번 안에 찾을지 없으니 while 문 사용
		while(true){ 
			//이름 입력 받기
			System.out.println("검색할 성을 입력하시오");
			search=sc.nextLine();

			//"종료" 입력 받을시 프로그램 종료시키기
			if(search.equals("종료")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			//맞는지 틀린지 초기값 설정
			check=false;

			//맞을경우 
			for(int i=0; i<names.length; i++) {
				if((names[i]).startsWith(search)) {
					check=true;
					cnt++;
					System.out.println((i+1)+": " +names[i]);					
				}				
			}
			

			//틀린 경우
			//if(!check) {
			//	System.out.println(search+" 그 성씨가 없습니다");
			//}
			if(check)//check==true
				System.out.println("\t총"+cnt+"명 검색");
			else //!check
				System.out.println(search+"씨 성을 가진사람은 없습니다");
		}
	}

}

