package day0627;

public class QuizMain_09 {

	public static void main(String[] args) {		
		
		System.out.println("\t[쇼핑 목록]");
		
		System.out.println("쇼핑장소: "+Quiz_09.jangso);
		
		Quiz_09 q1= new Quiz_09();
		q1.setname("손선풍기");
		q1.setprice(25000);
		
		String name=q1.getname();
		int price=q1.getprice();
		
		System.out.println("상품명: "+name);
		System.out.println("가격: "+price+"원");
		
		System.out.println("===============================================");
		
		Quiz_09 q2 = new Quiz_09();
		q2.setname("핸드폰충전기");
		q2.setprice(35000);
		
		System.out.println("쇼핑장소: "+q2.jangso);
		System.out.println("상품명: "+q2.getname());
		System.out.println("가격: "+q2.getprice());
		
		System.out.println("==================================================");
		Quiz_09 q3 = new Quiz_09();
		q3.setname("다이슨청소기");
		q3.setprice(10000000);
		
		System.out.println("쇼핑장소: "+q3.jangso);
		System.out.println("상품명: "+q3.getname());
		System.out.println("가격: "+q3.getprice());
		
		
		
		
		
		
		

	}

}
