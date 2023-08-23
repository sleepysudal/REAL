package day0627;

class ObTestA{
	private int x;
	private static int y;
	
	//x
	public void setX(int xx){ //set 메서드는 수정이목적이라 반드시 인자값 보내야함
		this.x=xx; //이름이 틀릴떈 굳이 디스안붙여도 안나긴함
		//x=xx; 이름이 틀릴땐 this 생략가능
	}
	//x 
	public void getX() {
		System.out.println("x= "+this.x);
	}
	
	//y
	public static void setY(int yy) {
		//this.y=yy; 레퍼런스변수는 this를 가지고 있지않다
		//일반멤버변수 호출못함...static 변수만 호출가능
		ObTestA.y=yy;
	}
	//y
	public static void getY() {
		System.out.println("y="+ObTestA.y);
	}
	
}
public class ExObTest_06 {

	public static void main(String[] args) {
		
		//x는 생성..private 붙히는 순간 에러...메서드로 접근해야
		/*obTestA oa1 = new obTestA();
		System.out.println(oa1.x);
		//y는 클래스 명으로 호출
		System.out.println(obTestA.y);*/
	
		//private 변수이므로 메서드 만들어서 호출가능...변수에 직접 접근안됨
		ObTestA oa1=new ObTestA();
		oa1.setX(20);
		oa1.getX();
		
		ObTestA oa2=new ObTestA();
		oa2.setX(50);
		oa2.getX();
		
		//ObTestA.y=200; //private 이므로 멤버 y에 직접 접근못함
	    //y호출 ... 클래스명으로 호출
		ObTestA.setY(100);
		ObTestA.getY();
	
	}
	
}
