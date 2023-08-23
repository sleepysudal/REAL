package day0629;

import java.util.Scanner;

public class SungjukMain_03 {

	public static void getSungjuk_03(Sungjuk_03 s) {
		System.out.println(s.getName()+"\t"+s.getJava()+"\t"+s.getOracle()+"\t"+s.getHtml()+"\t"+s.getTot()+"\t"+s.getAverage()+"\t"
				+s.getPyungga());
	}
	
	public static void main(String[] args) {
		
		//스캐너 임포트
		Scanner sc = new Scanner(System.in);
		
		//스캐너값 받을 인원 변수지정
		int inwon; 
		
		Sungjuk_03 [] sj;
		String schoolName; //학교이름
		
		System.out.println("입력할 인원수: ");//배열할당
		inwon=Integer.parseInt(sc.nextLine()); 
		
		System.out.println("학교명?");
		schoolName = sc.nextLine();
		Sungjuk_03.setSchoolname(schoolName);
		
		//인원수만큼 배열할당
		sj=new Sungjuk_03[inwon];
		
		//인원수 입력
		for(int i=0; i<inwon; i++) {
			System.out.println((i+1)+"번 학생이름?");
			String name=sc.nextLine();
			
			System.out.println("자바와 오라클 HTML 점수입력");
			int Java=Integer.parseInt(sc.nextLine());
			int Oracle=Integer.parseInt(sc.nextLine());
			int Html=Integer.parseInt(sc.nextLine());
			
			//i번째 학생성적 생성
			sj[i]=new Sungjuk_03();
			
			//set
			sj[i].setName(name);
			sj[i].setJava(Java);
			sj[i].setOracle(Oracle);
			sj[i].setHtml(Html);			
			
		}
		//결과출력
		System.out.println("***결과출력******");
		System.out.println("학교명: "+Sungjuk_03.getSchoolname());
		System.out.println("학생명\t자바점수\t오라클점수\tHTML점수\t총점\t평균\t평가");
		System.out.println("==================================================================");
		
		for(Sungjuk_03 s : sj) // 성적03 sj배열
			getSungjuk_03(s); //겟성적 불러오기
		

	}

}
