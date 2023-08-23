package day0630;

import java.util.Scanner;

abstract class Command{
	public abstract void write();
}
/////////////////////////////////////
class Insert1 extends Command{

	@Override
	public void write() {
		System.out.println("추가");

	}

}
///////////////////////////////////
class List extends Command{

	@Override
	public void write() {
		System.out.println("조회");

	}

}
//////////////////////////////////////////
class Modify extends Command{

	@Override
	public void write() {
		System.out.println("수정");

	}

}
///////////////////////////////////////////
class Delete1 extends Command{

	@Override
	public void write() {
		System.out.println("삭제");

	}

}
////////////////////////////////////////////
public class OracleCRUD_06 {

	public static void main(String[] args) {

		Scanner sc= new Scanner(System.in);
		int n; //스캐너 입력받는 값
		Command command = null;

		exit : while(true) {
			System.out.println("1.추가 2.조회 3.수정 4.삭제 0:종료");
			System.out.println("=================================");			

			n=Integer.parseInt(sc.nextLine());

			switch(n) {
			case 1 :
				command  = new Insert1();				
				break;
			case 2 :
				command  = new List();				
				break;
			case 3 : 
				command  = new Modify();				
				break;
			case 4 : 
				command  = new Delete1();				
				break;
			case 0 :				
				System.out.println("종료합니다");
				break exit;
			default :
				System.out.println("잘못입력했으니 재입력해주세요");
				break;

			}
			if(n<=4) {
				command.write(); // 입력받은 n값이 4랑 같거나 작을경우 출력

			}



		}


	}

}
