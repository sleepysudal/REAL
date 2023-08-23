package day0616;

public class QuizDataType_10 {

	public static void main(String[] args) {
		/*매개변수(args)를 이용하여 출력해보세요 
		 * [시험결과]
		 * Java=88, Jsp=77, Spring=99
		 * 총점:264 점
		 * 평균: 88.00 점*/
		
		//1.변수선언&계산
		
		int Javascore= Integer.parseInt(args[0]);
		int Jspscore= Integer.parseInt(args[1]);
		int Springscore=Integer.parseInt(args[2]);
		
		int Total=Javascore+Jspscore+Springscore;
		int count=3; //3과목을 의미하는 변수
		
		//double Average1=Total/count;//결과가 무조건 int
		double Average2=(double)Total/count;//결과가 double
		
		//출력
		System.out.println("[시험결과]");
		System.out.printf("Java=%d, Jsp=%d, Spring=%d\n",Javascore,Jspscore,Springscore);
		System.out.println("총점: "+Total+"점");
		System.out.printf("평균: %.2f점",Average2);

	}

}
