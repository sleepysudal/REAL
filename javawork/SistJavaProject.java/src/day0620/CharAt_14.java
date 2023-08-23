package day0620;

public class CharAt_14 {
	public static void main(String[]args) {
		//변수 지정
		String juminNum="971034-3345678";
		//index순서 01234567.....
		char seventh=juminNum.charAt(7);
		//System.out.println(seventh);
		//남자입니다1 or 여자입니다2 or 2000년 이후 남자입니다3 or 2000년 이후 여자입니다4

		if(seventh=='1')//세븐스가 1이면 남자다 
		{ 
			System.out.println("남자입니다");
		}
		else if(seventh=='2')//세븐스가 2이면 여자다
		{
			System.out.println("여자입니다");
		}
		else if(seventh=='3') //세븐스가 3이면 2000년이후 남자다
		{
			System.out.println("2000년이후 남자입니다");
		}
		else if(seventh=='4') //세븐스가 4이면 2000년이후 여자다
		{
			System.out.println("2000년이후 여자입니다");
		}
		else
			System.out.println("오류입니다");

	}
}
