package day0623;

public class ArrayMaxMin_10 {

	public static void main(String[] args) {
		// 
		int []data = {5,120,44,66,23,65,88,99,158};

		System.out.println("data의 길이: "+data.length);

		int max =data [0]; //첫 데이터를 무조건 최대값에 저장
		int min= data [0]; //첫 데이터를 무조건 최소값에 저장

		//두번쨰 값 부터 끝까지 max와 비교 +min 값도
		for(int i=1; i<data.length; i++) {
			if(max<data[i]) {
				max=data[i];
			}
			if(min>data[i]) {
				min=data[i];
			}
			
		}
		/*for(int i=1; i<data.length; i++) {
			if(max<data[i]) {
				max=data[i];
			}
			}
		 * for(int i=1; i<data.length; i++) {
			if(min>data[i]) {
				min=data[i];
			}
		}
		 */
		

		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}

}
