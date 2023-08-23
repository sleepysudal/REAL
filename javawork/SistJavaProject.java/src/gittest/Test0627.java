package gittest;

public class Test0627 {
	//인스턴스 변수 지정
	private String store="이마트";
	private String name;
	int price;
	private int su;
	
	//set메서드
	public void setstore(String store) {
		this.store=store;
	}
	public void setname(String name) {
		this.name=name;
	}
	public void setprice(int price) {
		this.price=price;
	}
	public void setsu(int su) {
		this.su=su;
	}
	
	//get메서드
	public  String getstore() {
		 return store;
	}
	public  String getname() {
		return name;
	}
	public int getprice() {
		return price;
	}
	public int getsu() {
		return su;
	}
	
	
	
}
