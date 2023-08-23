package day0704;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class FileWriter_05 {

	public static void fileWrite() {
		FileWriter fw = null; //여기안은 메서드 안이기때문에 초기값 지정안하면 무조건 에러 발생함
		String FileName = "C:\\Test\\file\\filetest1.txt";

		try {
			fw=new FileWriter(FileName); //파일 생성 ( 같은 이름이 있어도 새로 생성)

			//파일에 내용 추가
			fw.write("Have a Nice Day!!!\n");//메모장 줄넘김
			fw.write(new Date().toString());
			System.out.println("**파일 저장 성공!!**");

		} catch (IOException e) {			
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
	public static void fileWrite2() {
		FileWriter fw =null;
		String fileName="C:\\Test\\file\\filetest2.txt";
		
		try {
			fw=new FileWriter(fileName,true); //추가모드
					
			fw.write("내이름은 홍길동\n");
			fw.write("=======================\n");			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	

	public static void main(String[] args) {
		fileWrite();
		fileWrite2();
	}

}
