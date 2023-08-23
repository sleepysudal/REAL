package day0629;
/*추상클래스는 new로 생성못함
 * 추상메서드가 하나라도 존재하는 클래스를 추상클래스라 한다
 * 추상클래스 - 일반메서드 . 추상에서도 둘다 존재가능*/


abstract class Fruit{
	static final String Message="오늘은 비많이 오는날";

	//일반메서드
	public void getTitle(){
		System.out.println("우리는 추상클래스 공부중");
	}
	
	//추상메서드(미완의 메서드...선언문만 있고 구현부인 몸통이없다)
	abstract public void showMessage(); //추상메서드는 오버라이딩을 할목적으로 씀
}
///////////////////////////////////////

class Apple extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Apple_message");
		System.out.println(Fruit.Message);
	}
}
/////////////////////////////////////////
class Banana extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Banana_message");
		
	}
}
///////////////////////////////////////////
class Orange extends Fruit{
	@Override
	public void showMessage() {
		System.out.println("Orange_Message");
		
	}
}
/////////////////////////////////////////////////////////////
public class ExAbstract_08 {

	public static void main(String[] args) {
		//일반생성_메서드 호출
		Apple apple = new Apple();
		Banana banana = new Banana();
		Orange orange=new Orange();

		apple.showMessage();
		banana.showMessage();
		orange.showMessage();
		
		//다형성
		//다형성은 하나의 변수로 여러가지 일을 처리할떄 이용
		//부모클래스명 변수명 = new 자식클래스명();
		//생성방법이 틀린것뿐이지 상속은 fruit 하나 부모 한명에 자식 여러명일때
		
		Fruit fruit;
		
		fruit = new Apple(); 
		fruit.showMessage();		
		
		fruit = new Banana();
		fruit.showMessage();
		
		fruit = new Orange();		
		fruit.showMessage();
		
		fruit.getTitle();
		

	}

}
