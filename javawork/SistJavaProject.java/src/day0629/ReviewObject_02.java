package day0629;

class Starbucks{
	private String menu; //메뉴
	private String store; //지점
	private String goods; //텀블러 등등
	
	//setter , getter 자동생성 (빈화면 우클릭 - source -generate set get)
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getStore() {
		return store;
	}
	public void setStore(String store) {
		this.store = store;
	}
	public String getGoods() {
		return goods;
	}
	public void setGoods(String goods) {
		this.goods = goods;
	}

	public static void getTitle() {
		System.out.println("오늘의 일기");
		System.out.println("========================================");
	}
}


////////////////////////////////////////////////////////
public class ReviewObject_02 {

	public static void main(String[] args) {
		
		//스타벅스 클래스의 겟타이틀 가져와서 출력 
		Starbucks.getTitle();
		
		//1 생성
		Starbucks s1 = new Starbucks();
		
		//1-1 setter 입력 및 수정
		s1.setStore("코엑스");
		s1.setMenu("민트초코프라푸치노");
		s1.setGoods("아이스박스");
		
		String menu=s1.getMenu();
		String Goods=s1.getGoods();
		String store =s1.getStore();
		
		//1-2 getter 이용 출력
		System.out.println("나는 스타벅스 "+store+"매장에 왔습니다");
		System.out.println(menu+"를 주문합니다");
		System.out.println(Goods+"를 샀어요");
		

	}

}
/*출력내용
 * 나는 스타벅스 코엑스매장에 왔습니다
 * 아이스 아메리카노를 주문합니다
 * 우산을 샀어요*/
 