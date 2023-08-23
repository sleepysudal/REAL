package day0630;

class Market{

	private String sangpum;
	private int su;
	
	//생성자 : 생성하면서 초기화
	//디폴트 생성자
	public Market() {
		sangpum = "딸기";
		su=5;
	}
	//명시적 생성자
	public Market(String sangpum, int su) {
		this.sangpum=sangpum;
		this.su= su;
	}
	//메서드
	public void getMarket() {
		System.out.println("상품명: "+sangpum);
		System.out.println("수량: "+su);
	}
}
/////////////////////////////////////

class MyMarket extends Market {
	
	private int price;
	
	public MyMarket() {
		//super();
		price=5000;
	}
	public MyMarket(String sangpum, int su, int price) {
		super(sangpum,su);
		this.price=price;

	}
	@Override
	public void getMarket() {	
		
		super.getMarket();
		System.out.println("단가: "+price);
	}
	
}
///////////////////////////////////

public class ReviewInheri_01 {

	public static void main(String[] args) {
		
		//디폴트생성자
		MyMarket m1= new MyMarket();
		m1.getMarket();
		System.out.println();
		
		//명시적생성자
		MyMarket m2= new MyMarket("오렌지",10,10000);
		m2.getMarket();
		
		
	}

}
