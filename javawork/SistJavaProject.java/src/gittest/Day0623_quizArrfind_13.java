package gittest;

import java.util.Scanner; //스캐너 임포트 변수 선언

public class Day0623_quizArrfind_13 {

	public static void main(String[] args) {
		//이름을 입력해서 없으면 없다고 있으면 몇번째 있는지 알려주세요
		//끝이라고 쓰면 종료


		Scanner sc=new Scanner(System.in);

		String name; //스캐너로 이름 입력함수
		String stuname [] = {"가","나","다","라","마"};
		boolean not;

		while(true) {
			System.out.println("이름입력 하시오");
			name=sc.nextLine();
			
			not = false;//불리언 false
			
			//끝 쓰면종료
			if(name.equals("끝")) {
				System.out.println("끝낫다");
				break;
			}
			//이름 맞는지체크
			for(int i=0; i<stuname.length; i++ ) {
				if(name.equals(stuname[i])) {//스캐너로 입력받은값이 stuname 안에 값이랑 비교해서 맞을경우
					not =true;
				}

			}
			if(not) {
				System.out.println("맞다");
			}
			else {
				System.out.println("아니다");
			}
			
		}

	}

}
