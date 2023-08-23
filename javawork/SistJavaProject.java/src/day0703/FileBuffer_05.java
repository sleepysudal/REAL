package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileBuffer_05 {

	public static void read01() {
		String fileName = "C:\\Test\\file\\memo.txt";
		BufferedReader bu = null; //기본값 주기
		FileReader fi = null; //기본값 주기
		
		try {
			
			fi = new FileReader(fileName);
			
			System.out.println("***메모 읽기 시작***");
			
			bu = new BufferedReader(fi);
			
			//여러줄 읽어야하므로 while 사용
			while(true) {
				//메모장에서 한줄씩 읽어오기
				String s = bu.readLine();
				//마지막줄일경우 null값 읽어와서 null일경우 와일문 탈출
				if(s==null)
					break;
				
				System.out.println(s);
			}
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("파일이 없어요"+e.getMessage());
		} 
		catch (IOException e) {		
			
		} finally {
			//자원은 항상반대로 반납
			try {
				
				bu.close();
				fi.close();
			
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		read01();
		System.out.println("***메모 읽기 종료***");

	}

}
