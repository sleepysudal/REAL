package day0623;

import java.util.Scanner;

public class ArrayIntFind_12 {

	public static void main(String[] args) {
		//숫자를 입력해서 그 숫자가 몇번째에 있는지 찾기
		//없으면 없다고, 있으면 그 숫자가 몇번째 있는지 찾기
		//0입력시 종료: while(true){break}

		//변수 지정 및 임포트
		Scanner sc = new Scanner(System.in);
		int []data = {1,2,3,4,5,6,7,8,9,10};
		int su;//입력함수
		boolean flag;

		while(true) {
			System.out.println("검색할 숫자 입력하세요(0입력시 종료)");
			su=sc.nextInt();

			//0입력시 종료
			if(su==0) {
				System.out.println("종료합니다");
				break;
			}
			//있다 없다 초기값
			flag = false; //찾으면 true

			//값 찾기
			for(int i=0; i<data.length; i++) {
				if(su==data[i]) {
					flag= true;
					System.out.println((i+1)+"번째에서 찾았다");
				}

			}
			if(!flag)//flag ==false 여전히찾지못햇다
				System.out.println(su+"는 데이터에 없습니다");
		}



	}

}
