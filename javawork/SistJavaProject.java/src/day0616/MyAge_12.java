package day0616;
import java.util.Calendar;
public class MyAge_12 {

	public static void main(String[] args) {
		//매개변수 args에서 실행시 이름과 태어난 연도를 보낸후 출력하세요(name. myBirth)
		//이름: 홍길동
		//태어난 연도: 1995년도
		//나이: 28세
		//현재년도는 Calendar import하여 구할수있다.
		
		//1.import
		Calendar calendar=Calendar.getInstance();
		
		//2.변수
		String name=args[0];
		int myBirth=Integer.parseInt(args[1]);
		int currentyear=calendar.get(calendar.YEAR);//현재년도
		
		//3.계산
		int myAge=currentyear-myBirth;
		
		//4.출력
		System.out.println("이름: "+name);
		System.out.println("태어난 연도: "+myBirth+"년도");
		System.out.println("나이: "+myAge+"세");
		
	    /*내가 한거 
	    String name=args[0];
		int year=Integer.parseInt(args[1]);
		int old=Integer.parseInt(args[2]);
		
		Calendar cal=Calendar.getInstance();
		
		System.out.println("이름 : "+name);
		System.out.println("태어난 연도: "+year+"년도");
		System.out.println("나이: "+old+"세");*/
	}
		

}
