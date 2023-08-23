//다음과 같이 결과가 나오도록 자바클래스를 구현해보세요
//컴파일 명령어 : javac MyInfo.java
//실행명령어 java MyInfo 영어영문 2
//결과:
public class MyInfo{
	public static void main(String[] args){
		System.out.println("[학생 개인정보]");
		System.out.println("==============");
		System.out.println("전공:  "+args[0]+"학과");
		System.out.println("학년:  "+args[1]+"학년");
	}
}
