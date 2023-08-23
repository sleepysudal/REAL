package day0629;

//class 가 class : extends
//class 가 interface : implements
//interface 가 interface : extends
//implements는 다중구현 가능하다

public class Food implements FoodGage{

	@Override
	public void order() {
		
		System.out.println(SHOPNAME);
		//SHOPNAME = "돈까스집"; FINAL을 안붙여도 생략되잇는거라 변경못함
		System.out.println("음식을 주문합니다");
	}

	@Override
	public void bedal() {
		
		System.out.println(SHOPNAME);
		System.out.println("음식을 배달합니다");
	}
	
}