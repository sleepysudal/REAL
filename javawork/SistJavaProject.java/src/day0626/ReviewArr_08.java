package day0626;

public class ReviewArr_08 {

	public static void main(String[] args) {
		// 해당 배열을 for문을 이용하여 출력하시오
		//1. ex>0번지 : 영환이
		
		String [] names ={"영환이","일환이","이환이","삼환이","사환이"};
		
		for(int i=0; i<names.length; i++) {
			System.out.print(i+"번째 "+names[i]+" ");
		}
		System.out.println();
		
		//2. 해당배열을 가로로출력하시오 
		int []nums = {2,4,5,7,8};
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i]+" ");
		}
		System.out.println();
		
		//3. flowers
		String []flowers = {"개나리","사루비아","철쭉","무궁화","장미"};
		for(int i=0; i<flowers.length; i++) {
			System.out.print((i+1)+". "+flowers[i]+" ");
		}
		System.out.println();
		
		//4. colors
		String [] colors = {"빨강색","파랑색","주황색","초록색","보라색"};
		for(int i=0; i<colors.length; i++) {
			System.out.print((i+1)+"번째 "+colors[i]+" ");
		}
		
		
		

	}

}
