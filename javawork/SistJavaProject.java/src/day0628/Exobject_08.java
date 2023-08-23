package day0628;

class Apple{
	private String writer;
	private String subject;
	private static String msg="HappyDay!!";
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public static String getMsg() {
		return msg;
	}
	public static void setMsg(String msg) {
		Apple.msg = msg;
	}
	
	
}


///////////////////////////////////////////
public class Exobject_08 {
	public static void writeApple(Apple app) { //(Apple app):애플이라는 클래스를 통째로 가져옴
		System.out.println("***apple 클래스 출력***");
		System.out.println("작성자 : "+app.getWriter());		
		System.out.println("제목: "+app.getSubject());
		
	}

	public static void main(String[] args) {
		//같은클래스내에선 생성자 생성 생략가능해서 바로 writeApple 가져와서 쓸수잇음
		
		System.out.println("Apple 클래스의 메시지 출력 ");
		System.out.println(Apple.getMsg());
		
		//1. 생성자
		Apple a1 = new Apple();
		
		//1-1 setter 입력
		a1.setSubject("악기 재밌다");
		a1.setWriter("김은희");
		
		//2. 생성자
		Apple a2 = new Apple();
		
		//2-1 setter 입력
		a2.setSubject("모르겠다");
		a2.setWriter("장항준");
		
		//1-2, 2-2 같은 클래스내의 writer apple에 apple 클래스 가져온거 이용해서 출력하기
		writeApple(a1); //writeApple이용해서 세터값 a1 변경한거 출력 ,setter 값은 못가져옴
		writeApple(a2); //writeApple이용해서 세터값 a2 변경한거 출력, setter 값은 못가져옴
		
		
	
		
		
	

	}

}
