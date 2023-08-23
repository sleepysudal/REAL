package day0628;
/*
 * 메서드 작성요령
 * 접근 제한자(public)+지정예약어(static)+결과리턴형(void or int or String)+메서드명(){};
 * 1.반복적인 코드를 줄여서 코드의 관리가 용이
 * 2.하나의 메서드는 한가지 기능만을 수행하도록 작성 
 **/







public class Method_11 {
	public static boolean aaa() {
		return false;
	}
	public static int bbb() {
		return 33;
	}
	public static int ccc(int x,int y) { //자바에선 이름 같은거 메서드 생성자가능(오버로딩) 대신에 ()값이 달라야한다
		int z=x+y;
		return z;
	}
	
	public static void main(String[] args) {
		boolean a=aaa();
		System.out.println("a= "+a);
		
		int b= bbb();
		System.out.println("b= "+b);

		int c=ccc(10,20);
		System.out.println("c= "+c);
	}

}
