package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileException_04 {

	public static void read() {
		String fileName = "C:\\Test\\file\\monday.txt";
		BufferedReader br =null; //메서드 안에선 초기값 줘야함
		FileReader fr = null; //메서드 안에선 초기값 줘야함

		try{
			fr = new FileReader(fileName);

			System.out.println("파일 열었어요!!!!");

			br = new BufferedReader(fr);
			
			//여러줄 읽어야 하므로 while
			while(true) {
				//메모장에서 내용을 한줄씩 읽어온다
				String s=br.readLine();
				
				//마지막 줄일경우 null값을 읽어서, null 값 일경우 빠져나가기
				if(s==null)
					break;
				
				System.out.println(s);
			}

		}catch(FileNotFoundException e) {

			e.printStackTrace();
			System.out.println("파일이 없어요"+e.getMessage());
			
		}catch(IOException e) {
			
		}finally {
			//자원은 항상 반대로 반납
			try {
				br.close();
				fr.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}

	}

	public static void main(String[] args) {
		read();
		System.out.println("***메모 정상종료***");

	}

}
