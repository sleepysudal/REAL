package day0623;

public class ArrInt_06 {

	public static void main(String[] args) {
		// 선언하면서 초기값들을 동시에 저장할 수 있다
		int []arr= {1,2,3,4,5};
		System.out.println("개수: "+arr.length);//배열의 길이 출력

		System.out.println();//줄띄우기

		//System.out.println("출력_1: ex) 1==>5");
		for(int i=0; i<arr.length; i++) { //for 문
			System.out.println("출력_"+(i+1)+": "+(i+1)+"==>"+arr[i]);
		}
		System.out.println();//줄 띄우기

		System.out.println("출력_2:"); //foreach 문
		for(int i: arr) {
			System.out.print("\t"+i);
		}


	}

}
