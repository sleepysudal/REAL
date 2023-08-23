package day0620;

import java.util.Scanner;

public class QuizOper_06 {

	public static void main(String[] args) {
		/*
		 *이름을 입력하세요
		 *강민호
		 *3과목의 점수를 입력하세요
		 *39
		 *88
		 *99
		 *======================================
		 *3과목점수: 39,88,99
		 *평균: 75.33333333333
		 *--------------------------------
		 *합격조건: 평균이 70점 이상이고, 각과목이 40점이상이면 합격***************
		 *---------------------------------------------
		 *강민호님은 불합격입니다 
		 */
		
		//임포트
		Scanner sc= new Scanner(System.in);
		
		//변수지정
		String name,total;
		int kor,eng,math;
		double avg;
		
		//값 입력받기
		System.out.println("이름을 입력하세요");
		name=sc.nextLine();
		System.out.println("3과목의 점수를 입력하세요");
		kor=sc.nextInt();
		eng=sc.nextInt();
		math=sc.nextInt();
		
		//평균구하기
		avg=(kor+eng+math)/3.0;
		
		//합격조건(if문으로)
	    /*
		if((avg>=70)&&(kor>=40)&&(eng>=40)&&(math>=40)) {
	    	total = "합격";
	    }
	    else {
	    	total = "불합격";
	    }
	    */
	    //삼항 합격조건
	    total =(avg>=70&&kor>=40&&eng>=40&&math>=40)?"합격":"불합격";
	    
	    //결과출력
	    System.out.println("======================================================");
	    System.out.println("3과목점수: "+kor+","+eng+","+math);
	    System.out.println("평균: "+avg);
	    System.out.println("------------------------------------------------------");
	    System.out.println("***합격조건: 평균이 70점이상이고, 각과목이 40점이상이면 합격****");
	    System.out.println("------------------------------------------------------");
	    System.out.println(name+"님은 "+total+"입니다");
	    
		
		

	}

}
