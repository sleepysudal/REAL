package day0626;

public class ArrNumsChange_02 {

	public static void main(String[] args) {
		int[]arr= {1,5,25,67,89,11,123,145,171,219,218};
		//출력
		System.out.println("원래데이터 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		//데이터 거꾸로 변경하기
		for(int i=0; i<arr.length/2; i++) { //i를 절반만큼만 반복할것
			int temp =arr[i];
			arr[i]= arr[arr.length-1-i];//10개일때 0 하고 9번이랑 바꾸기
			arr[arr.length-1-i]=temp;
		}
		System.out.println("\n순서바꾼후데이터 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
		
		//selection sort(오름차순 정렬)
		//Arrays.sort(arr): 배열 arr을 정렬한다
		//선택정렬: 가장작은숫자를 앞으로 보내자
		
		//기준데이터는 0부터 끝에서 두번째까지
		for(int i=0; i<arr.length-1; i++) {
			//비교하는 데이터는 기준 다음 값부터 끝까지
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]>arr[j]) {
					int temp=arr[i];
					arr[i]= arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.println("\n오름차순 정렬후 데이터 : ");
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
		}
	}
}
