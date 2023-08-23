package day0704;

public class Shop {
	private String SangName; //상품명
	private int su; //수량
	private int dan; //가격	
	
	
	//디폴트생성자
	public Shop() {
		
	}
	
	//명시적 생성자
	public Shop(String SangName, int su, int dan) {
		this.SangName=SangName;
		this.su=su;
		this.dan=dan;
	}

	public String getSangName() {
		return SangName;
	}

	public void setSangName(String sangName) {
		SangName = sangName;
	}

	public int getSu() {
		return su;
	}

	public void setSu(int su) {
		this.su = su;
	}

	public int getDan() {
		return dan;
	}

	public void setDan(int dan) {
		this.dan = dan;
	}
	
	

}
