package day0616;

public class ParseIntArgs_03 {

	public static void main(String[] args) {
		/*[결과출력]
		 * 내이름은 홍길동
		 * 자바점수는 88
		 * 오라클점수는 77
		 * 두과목의 합계는 165점입니다*/
	    
		String Name=args[0];
	    int JavaScore=Integer.parseInt(args[1]);
	    int OracleScore=Integer.parseInt(args[2]);
	    
	    
	    //출력
		
		System.out.println("[결과출력]");
		System.out.println("내이름은" +Name);
		System.out.println("자바점수는 "+JavaScore);
		System.out.println("오라클점수는 "+OracleScore);
		System.out.println("두과목의 합계는 "+(JavaScore+OracleScore));
	}

}
