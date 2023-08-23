package day0703;

public class ExException_01 {

	public static void main(String[] args) {
		System.out.println("프로그램 시작!!!");
		try {
			//에러발생할수있는 가능코드
		int num=3/0; //정수를 0으로 나누면 에러발생
		} catch(ArithmeticException e) { //에러에 대한 해결 , 처리
			System.out.println(e.getMessage());
			//e.printStackTrace(); 뭐때문에 에러나는지 콘솔창에 알려줌, 자세한 예외정보 출력
		}
		System.out.println("프로그램 종료!!!");

	}

}
