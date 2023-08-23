package day0615;

public class SpecialChar_05 {

	public static void main(String[] args) {
		//문자열 내에서 특별한 의미로 해석되는 문자를 이스케이프 시퀀스(Escape sequence)
		//이스케이프 시퀀스(Escape Sequence)는 \로 시작합니다.
		/*
		 * \t : 다음 탭 위치로 이동
		 * \n : 다음줄로 이동
		 * \" : 쌍따옴표
		 * \' : 홑따옴표
		 * \\ : 백슬래시 기능
		 */
		System.out.println("Apple\tMellon");
		System.out.println("Orange\tKiwi\tBanana");
		System.out.println("Apple\\");
		System.out.println("Apple\"");
		System.out.println("Apple\'");
		System.out.println("\"Hello\"");//"Hello" 출력됨
		System.out.println("c:\\");//c:\ 출력됨
		//Q:	"red","green","blue" 결과값으로 출력
		System.out.println("\\\\Q:\t\"red\",\"green\",\"blue\"");
	}

}
  