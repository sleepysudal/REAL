package day0703;

import java.io.IOException;
import java.io.InputStream;

public class FileException_03 {

	public static void main(String[] args) {
		
		InputStream is = System.in;
		
		int a = 0;
		
		System.out.println("한글자 입력: ");
		try {
			a = is.read();
		} catch (IOException e) {
		
			//e.printStackTrace();
			System.out.println("오류: "+e.getMessage());
		}
		System.out.println("***3초뒤출력***");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("입력값: "+(char)a);
	}

}
