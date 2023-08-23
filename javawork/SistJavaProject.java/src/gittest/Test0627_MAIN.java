package gittest;

public class Test0627_MAIN {

	public static void main(String[] args) {
		System.out.println("****상품입고****");
		System.out.println("==============================================");
		
		Test0627 t2 = new Test0627();
		t2.setstore("이마트");
		t2.setname("딸기");
		t2.price=5000;  //그냥 형식만 되잇으면 t2.이름 = x; 쓸수잇음
		t2.setsu(5); //private 된 경우는 set 메서드 써야하고
		
		System.out.println("구매한곳: "+t2.getstore());
		System.out.println("구매한것: "+t2.getname());
		System.out.println("구매가격: "+t2.getprice());
		System.out.println("구매수량: "+t2.getsu());

	}

}
