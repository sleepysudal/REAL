package day0621;

public class ExWhile_04 {

	public static void main(String[] args) {
		
		int i=1;
		while(i<10) {
			System.out.println("java"+i);//먼저 출력 java1
			i++; 
		}
		System.out.println("종료");
		
		i=1;
		while(true)
		{
			System.out.println("java"+i);
			i++;
			
			if(i>=10)
			break;
		}
		System.out.println("종료");
	}

}
