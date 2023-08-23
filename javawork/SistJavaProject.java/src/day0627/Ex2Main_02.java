package day0627;



public class Ex2Main_02 {
	public static void main(String args[]) {
		System.out.println(EX2Object_02.width);
		System.out.println(EX2Object_02.height);

		//클래스 변수
		EX2Object_02.width=10;
		EX2Object_02.height=20;
		
		System.out.println(EX2Object_02.width);
		System.out.println(EX2Object_02.height);
		
		//인스턴스 생성후 변수 호출가능
		EX2Object_02 card1 = new EX2Object_02();
		
		System.out.println(card1.kind); //null
		System.out.println(card1.number); //0
		
		card1.kind = "Heart";
		card1.number=4;
		
		System.out.println(card1.kind);
		System.out.println(card1.number);
		
		//인스턴스 변수 생성후 변경후 출력
		EX2Object_02 name = new EX2Object_02();
		System.out.println(name.name); //null 
		name.name = "다이아몬드";
		System.out.println(name.name);//다이아몬드
		
	}
}
