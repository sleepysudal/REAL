package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//score.txt 를 읽고 몇개인지 구하고 총점, 평균까지 구해서 출력
public class FileException_06 {

	public static void scoreRead() {
		
		//변수 선언
		String fileName = "C:\\Test\\file\\score.txt";
		BufferedReader br = null; //기본값 주기
		FileReader fr = null; //기본값 주기
		int cnt = 0; //총 갯수
		int total = 0; //총 합계
		double avg = 0; //평균

		//파일읽기
		try {
			System.out.println("시험 점수 공개");

			fr=new FileReader(fileName);
			br=new BufferedReader(fr);

			while(true) {
				String s=br.readLine();
				//더이상 값이 없으면 종료
				if(s==null)
					break;
				cnt++; //읽은갯수
				total+= Integer.parseInt(s); //합계
				System.out.println(s); //읽은값들 출력
			}
			//평균구하기
			avg=(double)total/cnt;
			System.out.println("총갯수: "+cnt);
			System.out.println("총점: "+total);
			System.out.printf("평균: %.2f",avg);
		}catch (FileNotFoundException e) {
			e.printStackTrace();			
		} 
		catch (IOException e) {		

		} finally {
			//자원은 항상 오픈한 반대순서로 닫기
			try {
				
				br.close();
				fr.close();


			} catch (IOException e) {

				e.printStackTrace();
			}
		}

	}





	public static void main(String[] args) {
		scoreRead();
		System.out.println("\n***정상종료***");
		

	}

}
