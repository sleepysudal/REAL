package day0622;

import java.util.Scanner;

public class QuizForWhile_02 {
	public static void Quiz1() {
		//점수를 입력하면 합계를 구하시오
		//1~100 이 아니면 제외(continue)
		//0을 입력시 프로그램 종료

		/*임포트 및 변수지정*/
		Scanner sc=new Scanner(System.in);

		/*변수 지정*/
		int score;//입력할점수
		int sum=0; //합계	

		while(true) {
			/*점수 입력*/
			System.out.println("점수를 입력하시오 (0 입력시 종료됩니다)");
			score=sc.nextInt();

			/*break문 0입력시 종료*/
			if(score==0) 
				break;
			//점수 잘못쓰면 끝나는게 아니고 다시 반복쓸수있게
			if(score<0||score>100) //score에 입력받은값이 1보다 작거나 100보다 클시 스킵 0은 종료
				continue;

			//합계
			sum+=score; //sum=sum+score 위 조건에 충족된값들만 다 저장됨
		}
		System.out.println("총합계: "+sum);//위에 sum에 저장된 score 점수값 다 더해서 최종출력
	}
	public static void Quiz2() {
		//점수를 반복해서 입력하면 합계를 구하시오
		//끝이라고 입력시 프로그램 종료

		//임포트
		Scanner sc=new Scanner(System.in);

		//변수지정
		String score;
		int sum=0;
		int count=0;
		double avg;

		while(true) {
			//점수입력
			System.out.println("1~100 사이 입력(끝이면 종료)");
			score=sc.nextLine();

			//끝 입력시 프로그램 종료
			if(score.charAt(0)=='끝')				
				break;

			//continue(1보다 작거나 100보다 큰경우 카운트 합계안되고 넘어감)
			if(Integer.parseInt(score)<1 || Integer.parseInt(score)>100)
				continue;

			//합계계산
			sum+=Integer.parseInt(score);

			//총 입력한 숫자의 개수 계산
			count++;
		}
		//평균계산
		avg=(double)sum/count; //(double) 안쓰면 뒤에 소수점 자리 생략되서 정확한값이안나옴

		//결과 출력		
		System.out.println("끝을 입력했으므로 계산을 종료합니다");
		System.out.println("============================================");
		System.out.println("총합계: "+sum+"점");
		System.out.println("총 입력한 숫자: "+count+"개");
		System.out.println("평균값: "+avg+"점");

	}
	public static void Quiz3() {
		/*
		 총 5개의 정수를 입력받아 합계를 구하시오
		 만약 1~100 이 아닐경우 다시입력(continue)
		 [출력결과 예시]
		 1번점수: 88
		 2번점수: 99
		 3번점수: 200
		 잘못입력했어요
		 3번점수: 33
		 4번점수: 
		 ==============
		 합계: **점
		 평균: **점		 
		 */

		//임포트
		Scanner sc=new Scanner(System.in);

		//변수지정
		int score;
		int sum=0;
		int count=0;
		int i;
		double avg;
		int c=5;
		int arr[]=new int[c];
	
			//점수 입력받기+몇번 점수 출력햇는지 계속띄워주기
			for(i=0; i<c; i++) {
				System.out.println("점수를 입력하세요(1~100 아닐경우 재입력)");
				System.out.println((i+1)+"번점수: ");
				score=sc.nextInt();
				//점수가 1보다 작거나 100보다 클경우 재입력해라
				if(score<1 || score>100) {
					System.out.println("\t잘못입력했어요 다시 입력해주세요");
					i--;
					continue;
				}
				arr[i]+=score;
				//점수 입력값 다 더하기
				sum+=score;

				//입력한 점수의 총 갯수
				count++;
			}
		
		//평균계산
		avg=(double)sum/count;

		for(i=0;i<c;i++) {
			System.out.println(arr[i]);
		}
		
		//최종출력
		System.out.println("============================================");
		System.out.println("총합계: "+sum+"점");
		System.out.println("평균: "+avg+"점");		
	}
		public static void Quiz4() {

		}
		public static void Quiz5() {

		}
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			//Quiz1();
			//Quiz2();
			Quiz3();
			//Quiz4();
			//Quiz5();
		}


	}
