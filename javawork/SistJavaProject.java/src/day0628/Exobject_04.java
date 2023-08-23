package day0628;

class MyInfo{
	private String name;
	private int age;
	private String hp;
	public static final String ADDR="Seoul"; //ADDR은 파이널 안써도 올대문자 작성 절대 못고치게 final
	
	
	//각각의 setter, getter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	//3개의 멤버를 한번에 변경할 메서드
	public void setData(String name,int age,String hp) {
		this.name=name;
		this.age=age;
		this.hp=hp;
		
	}
	//3개의 멤버를 한번에 
	public void getData() {
		System.out.println("이름: "+name+"나이: "+age+"핸드폰번호: "+hp);
	}


}


////////////////////////////////////////////////////////////////////////
public class Exobject_04 {

	public static void main(String[] args) {
		
		//생성1
		MyInfo in1= new MyInfo();
		
		//setter
		in1.setName("김영준");
		in1.setAge(99);
		in1.setHp("010-1234-5678");
		
		//getter
		String name=in1.getName();
		int age= in1.getAge();
		String hp=in1.getHp();
		
		//출력
		System.out.println("이름: "+name+" 나이: "+age+" 핸드폰번호: "+hp);
		System.out.println("사는 지역: "+MyInfo.ADDR);
		System.out.println("===============================================");
		
		//생성2
		MyInfo in2= new MyInfo();
		
		//setdata,getdata 이용해서 출력
		System.out.println("사는지역: "+MyInfo.ADDR);
		in2.setData("김영준", 27, "010-1234-5678");
		in2.getData();
	
	}
	

}
