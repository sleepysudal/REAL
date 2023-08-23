package day0626;

import java.util.Scanner;

public class QuizFind_05 {

	public static void main(String[] args) {
		/*숫자를 입력받아서 배열의 몇번째에 있는지 출력하고 없을경우 없습니다 라고출력하세요
		 *(0이면 종료)
		 *입력값: 11
		 *11은 2번째에 있어요!
		 *입력값: 100
		 * 100은 없습니다
		 *입력값: 0
		 *종료합니다(프로그램 종료) */

		int []arrNums = {11,23,45,63,5,13,17,28,12,86,2}; //arrNums 배열과 내부값지정
		Scanner sc= new Scanner(System.in); //스캐너 임포트
		int su; //입력하는 값		
		boolean not; //논리변수명 지정

		//입력받기
		while(true) {
			System.out.print("숫자를 입력하시오");
			su=sc.nextInt();

			//0이면 종료
			if(su==0) {
				System.out.println(su+"이 나왔으므로 종료합니다");
				break; //while문 빠져나가면서 종료
			}
			
			not=false; //반복문 안에서 찾았을경우 true로 변경해줄것
			
			//입력받은값이 맞을 경우, 배열 개수만큼 반복해서 입력한숫자찾기
			for(int i=0; i<arrNums.length; i++) {
				if(su==arrNums[i]) {
					not=true;
					System.out.println(su+"는 "+(i+1)+"번째에 있습니다!");
				}
			}

			//입력받은값이 틀린경우 , 배열에 없는경우 find는 여전히 false
			if(!not) {
				System.out.println(su+" 는 없습니다");
			}
		}


	}

}
