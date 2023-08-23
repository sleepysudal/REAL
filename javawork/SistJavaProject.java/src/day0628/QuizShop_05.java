package day0628;

class MyShop{
	private String sangpumName;
	private String ipgoday;
	private String chulgoday;

	//3개의 데이터를 한번에 수정할수있는 메서드
	public void setdata(String sangpumName, String ipgoday, String chulgoday) {
		this.sangpumName=sangpumName;
		this.ipgoday=ipgoday;
		this.chulgoday=chulgoday;
	}
	//3개의 데이터를 한번에 출력할수있는 메서드
	public void getdata() {
	 System.out.println("상품명: "+sangpumName+"\n입고일: "+ipgoday+"\n출고일: "+chulgoday);
	}
	/*public String getdata(){
	String s="상품명: "+sangpumName+"\n입고일: "+ipgoday+"\n출고일: "+chulgoday;
	return s;
	}
	*/
	//스트링 값만 리턴한다 string  출력할때는 출력문에서 한다

}

////////////////////////////////////////////////
public class QuizShop_05 {

	public static void main(String[] args) {
		
		MyShop s1= new MyShop();
		System.out.println("***상품입고***");
		s1.setdata("키보드", "2023-06-01", "2023-06-20");
		s1.getdata();
		
		System.out.println("===========================================");
		
		MyShop s2= new MyShop();		
	    s2.setdata("모니터", "2023-06-04", "2023-06-23");
	    s2.getdata();
	    
	    /*myshop shop1=new myshop()
	     * shop1.setdata("모니터","2011-1-1","2012-1-1");
	     * system.out.println(shop1.getdata());*/

	}

}
