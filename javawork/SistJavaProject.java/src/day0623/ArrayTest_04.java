package day0623;

public class ArrayTest_04 {

	public static void main(String[] args) {
		//기본형 배열은 객체로 인식
		int [] arr1, arr2; //배열로 선언
		arr1=new int[3]; //이렇게 선언시 반드시 크기 설정해야됨, 메모리할당
		arr2=new int[5];//할당만되도 값은 영어로 초기화
		
		//int[]arr1 = new int[3];
		//int arr2[]=new int[5];
		
		//arr1 배열에 값을 넣는다
		arr1[0]=10;
		arr1[1]=5;
		arr1[2]=2;
		
		arr2[0]=20;
		arr2[1]=30;
		arr2[2]=40;
		arr2[3]=50;
		arr2[4]=60;
		
		//배열의 갯수
		System.out.println(arr1.length); //3(0~2)
		System.out.println(arr2.length); //5(0~4)
	
		System.out.println("arr1 출력");
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println("=========================");
		System.out.println("for문으로 arr1출력");
		for(int i=0; i<3; i++) {
			System.out.println(arr1[i]);
		}
		//arr1을 출력해보는데 범위를 변수화한 for문으로 출력
		System.out.println("for문으로 arr1출력_범위를 변수화");
		for(int i=0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		//arr2를 출력해보는데 범위를 변수화한 for문으로 출력
		System.out.println("for문으로 arr2출력_범위를 변수화");
		for(int i=0; i<arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		//foreach(배열변수자료형 임의의 이름: 변수명) 
		System.out.println("arr1을 for each문으로 출력해보기");
		for(int a1:arr1) {
			System.out.println(a1);
		}
		System.out.println("arr2를 for each문으로 출력해보기 ");
		for(int a2:arr2) {
			System.out.println(a2);
		}
		
	}

}
