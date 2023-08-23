package day0629;

public class FoodBaedalMain {

	public static void main(String[] args) {
		//일반적인생성~출력
		System.out.println("일반적인 생성~출력");
		Food food = new Food();
		food.order();
		food.bedal();
		System.out.println();
		
		
		//다형적 생성~ 출력
		System.out.println("다형적 생성~출력");
		FoodGage gage = new Food();
		gage.order();
		gage.bedal();
		System.out.println();
	}

}
