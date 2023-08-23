package day0623;

import java.util.Scanner;

public class QuizArrFind_13 {

	public static void main(String[] args) {
		//이름을 입력해서 없으면 없다고 있으면 몇번째 있는지 알려주세요
		//끝이라고 쓰면 종료
		Scanner sc=new Scanner(System.in); //스캐너
		String []stuNames= {"가길동","나길동","다길동","라길동","마길동","바길동",
				"사길동","아길동","자길동"};
		
		String name; //입력함수
		boolean not; //논리함수 

		while(true) {
			//이름 입력받기
			System.out.println("이름을 입력해주세요(끝이라고 치면 종료)");
			name=sc.nextLine();

			//끝입력시 종료
			if(name.equals("끝")) {
				System.out.println("종료합니다");
				break;
			}

			//없다고 말하기 
			not=false;

			//이름 찾기			
			for(int i=0; i<stuNames.length; i++) {
				if(name.equals(stuNames[i])) {
					not=true;
					System.out.println((i+1)+"번째에서 찾았다");
				}
			}
			if(!not) {
				System.out.println(name+"은 검색한 이름에 명단이 없습니다");
			}
		}
	}
}




