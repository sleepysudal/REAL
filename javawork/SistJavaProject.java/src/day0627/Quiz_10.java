package day0627;

public class Quiz_10 {

	//인스턴스 변수
	private String sangpum; //상품명
	int su; //수량
	int dan; //단가
	static String SHOPNAME="롯데마트";
	
	//상품 SET메서드
	public void setsangpum(String sangpum) {
		this.sangpum=sangpum;
	}
	//수 SET메서드
	public void setsu(int su) {
		this.su=su;
	}
	//단가 SET메서드
	public void setdan(int dan) {
		this.dan=dan;
	}
	
	
	//GET 상품 메서드
	public String getsangpum() {
		return sangpum;
	}
	//GET 수 메서드
	public int getsu() {
		return su;
	}
	//GET 단가 메서드
	public int getdan() {
		return dan;
	}
}
