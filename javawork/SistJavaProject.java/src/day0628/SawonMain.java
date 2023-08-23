package day0628;

import java.util.Scanner;

public class SawonMain {
public static void getSawon(Sawon[] sawon) {
	
	//제목
	Sawon.getTitle();
	
	for(Sawon s : sawon) 
		System.out.println(s.getSawonName()+"\t"+s.getPay()+"\t"+s.getFamSu()
		+"\t"+s.getTimeSu()+"\t"+s.getFamilySudang()+"\t"+s.getTimeSudang()
		+"\t"+s.getTotalPay());
	
	
}
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int inwon; //몇명인지 입력
		
		Sawon [] sawon;
		System.out.println("입력할 직원수는?");
		inwon = Integer.parseInt(sc.nextLine()); //몇명 다음 오는것에 문자형 오면 버퍼 와서 인티저 사용
		
		//배열할당
		sawon = new Sawon[inwon];
		
		//인원수만큼 데이타 입력
		for(int i=0; i<inwon; i++) { //i<inwon; == i<sawon.length;
			
			//sawon 생성
			sawon[i] = new Sawon();
			
			System.out.println("사원명?");
			String name=sc.nextLine();
			
			System.out.println("급여?");
			int pay = Integer.parseInt(sc.nextLine());
			
			System.out.println("가족수?");
			int femsu= Integer.parseInt(sc.nextLine());
			
			System.out.println("시간?");
			int timesu=Integer.parseInt(sc.nextLine());
			
			//SETTER로 SAWON 클래스에 데이터넣기
			sawon[i].setSawonName(name);
			sawon[i].setPay(pay);
			sawon[i].setFamSu(femsu);
			sawon[i].setTimeSu(timesu);			
			
		}
		//출력
		getSawon(sawon);
	}

}
