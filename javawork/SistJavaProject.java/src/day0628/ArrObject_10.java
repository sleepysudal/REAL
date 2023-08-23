package day0628;

class MyPersonInfo {
	private String name;
	private String blood;
	private String age;


	public MyPersonInfo(String name, String blood, String age) {
		this.name=name;
		this.blood=blood;
		this.age=age;
	}
	//제목
	public static void title() {
		System.out.println("이름\t혈액형\t나이");
		System.out.println("===============================");

	}
	//출력문
	public void getInfo() {
		System.out.println(name+"\t"+blood+"형\t"+age+"세");
	}

}

//////////////////////////////////////
public class ArrObject_10 {

	public static void main(String[] args) {		

		//생성하면서 바로 초기화
		MyPersonInfo[]my = {
				new MyPersonInfo("가나다", "a", "1"),
				new MyPersonInfo("라마바","b","2"),
				new MyPersonInfo("사아자","c","3")
				};

		System.out.println("총 "+my.length+"명의 정보 출력");
		MyPersonInfo.title(); //클래스가 다르면 소환할때 클래스 .이름();
		

		//출력 for문
		for(int i=0; i<my.length;i++) {			
			my[i].getInfo();
			System.out.println("========================================");

		}
		//출력 for each 문으로 
	//	for(MyPersonInfo info:my)
	//	info.getInfo();

	}

}
