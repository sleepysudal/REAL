package day0628;

public class MethodOb_13 {
	public static void hello(int age,double height) {
		System.out.println("안녕 디지몬");
		System.out.println("제나이는 "+age+"세입니다");
		System.out.println("저의 키는 "+height+"cm입니다");
		
	}
	
	public static void main(String[] args) {
		System.out.println("메서드 연습시작!!!");
		hello(33, 173.8);
		goodbye();
		System.out.println("메서드 연습끝");

	}
	public static void goodbye() {
		System.out.println("담에봐요~~");
	}

}
