package day0627;

public class Quiz_09 {
	/*
	멤버는 private, 디폴트생성자
	[쇼핑목록]
	쇼핑장소: 이마트
	목록1
	상품명 : 손선풍기
	가격 : 25000원

	목록2
	상품명: 핸드폰충전기
	가격:30000원

	목록3
	상품명: 다이슨청소기
	가격:1000000원
	 */

	//인스턴스 변수
	static String jangso="이마트";
	private String name; //null
	private int price;//0		


	//set메서드	
	public void setname(String name) {
		this.name=name;
	}
	public void setprice(int price) {
		this.price=price;
	}	

	//get메서드	
	public String getname() {
		return name;
	}
	public int getprice() {
		return price;
	}
}
