package day0621;

public class DoWhile_05 {

	public static void main(String[] args) {
		int i=1;
		
		System.out.println("while문 결과");
		//선조건: 조건 안맞으면 실행 안함, 참일동안 반복함
		
		while(i>5) {
			//출력후 증가
			System.out.println(i++);
			
			//System.out.println(i);//위에거랑 같음
			//i++
		}
		System.out.println("Do~While문 결과");
		//후조건: 조건 나중에 온다.조건 안맞아도 한번 실행
		
		i=1;
		do {
			//출력후 증가
			System.out.println(i++);
			
		}while(i<5);

	}

}
