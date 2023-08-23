package day0628;

class Member{
	private String stuname; //학생명
	private String gender; //성별
	private String addr; //주소

	static String ban;	//공통인 8층 7강의실은 스태틱 ="한독빌딩 7강의실" 로 여기서 지정해도됨
	static int cnt=0;


	//수정용 메서드
	public void setMembers(String name,String gender, String addr) {
		stuname =name;
		this.gender=gender;
		this.addr=addr;
	}
	//출력용 메서드
	public void getMembers() {
		cnt++;
		System.out.println("***학생"+cnt+"정보***");
		System.out.println("학생명: "+stuname);
		System.out.println("소속학급: "+Member.ban); //같은클래스에서는 클래스명 생략가능+ban
		System.out.println("성별: "+gender); //this 쓰나 안쓰나 똑같음
		System.out.println("주소: "+this.addr); //this 쓰나 안쓰나 똑같음
	}
}



public class ExObject_06 {

	public static void main(String[] args) {

		Member m1= new Member();
		Member.ban="한독빌딩 쌍용교육센터 7강의실"; //다른클래스에서 불러올땐 반드시 클래스.ban
		m1.setMembers("홍길동", "남성", "사랑시 고백구 행복동");
		m1.getMembers();

		Member m2= new Member();	 
		m2.setMembers("가나다","여성","서울");
		m2.getMembers();

	}
}
