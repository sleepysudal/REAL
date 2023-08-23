package day0629;

class Shop{
	String sangpum; //상품명
	int su; //개수
	
	//인자있는 생성자
	public Shop(String sangpum, int su) {
		this.sangpum=sangpum;
		this.su=su;
	}
	//출력메서드
	public void writeShop() {
		System.out.println("상품명: "+sangpum);
		System.out.println("개수: "+su);
	}
	
}
//////////////////////////////////////////////////////
class MyCart extends Shop{
	
	String price;
	
	public MyCart(String sangpum, int su,String price) {
		super(sangpum, su);
		this.price=price;		
	}
	@Override
	public void writeShop() {			
		System.out.println("단가: "+price);
		super.writeShop();
	}
}

/////////////////////////////////////////////////////
public class Inheri_06 {

	public static void main(String[] args) {
				
		MyCart my =new MyCart("아이폰14",2,"1200000");
		my.writeShop();		
		
	}

}
/*Shop클래스
sangpum 상품명
su 개수
인자있는 생성자
출력메서드 writeShop()
-상품과 개수를 출력
=============================
MyCart

price 가격

Shop를 상속받아 생성자완성
writeShop()메서드 오버라이드 해서 가격추가하세요

===================================
메인에서
상품,개수,가격 모두 있는 메서드 출력!!!
*
*/