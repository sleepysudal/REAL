package day0703;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class QuizTokenFile_09 {

	public static void fruit(){
		String fileName ="C:\\Test\\file\\fruit.txt";
		FileReader fr = null;
		BufferedReader br = null;
		int sum =0; //총금액
		// int su=0;
		//int dan = 0;

		try {
			fr = new FileReader(fileName);
			br = new BufferedReader(fr);

			System.out.println("***과일목록***");
			System.out.println("상품\t수량\t단가\t총금액");
			System.out.println("-----------------------------------------");

			while(true) {
				String s = br.readLine();

				if(s==null)
					break;

				String[]data = s.split(",");
				//System.out.println(data[0]+"\t"+data[1]+"\t"+data[2]); 읽어온 값 출력

				//총금액				
				sum=Integer.parseInt(data[1])*Integer.parseInt(data[2]);
				
				//분리
				StringTokenizer st = new StringTokenizer(s,",");
				System.out.println(st.nextToken()+"\t"+st.nextToken()+"\t"+st.nextToken()+"\t"+sum+"원");
				
				//배열개수만큼 반복출력 분리1
				/*String sang =st.nextToken();
				int su = Integer.parseInt(st.nextToken());
				int dan = Integer.parseInt(st.nextToken());
				int total = su*dan; */
				
				//분리2
				//String []data=s.split(",");
				//String sang = data[0];
				//int su = Integer.parseInt(data[1]);
				//int dan = Integer.parseInt(data[2]);
				//int total =su*dan;
			}


		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		}
		catch (IOException e) {

		}finally {
			try {

				br.close();
				fr.close();


			} catch (IOException e) {

				e.printStackTrace();
			}
		}


	}



	public static void main(String[] args) {
		fruit();

	}

}
/*
 ***과일 목록***
 상품 수량 단가 총금액
 -----------------------
 바나나 10 5000 50000원
 * */
