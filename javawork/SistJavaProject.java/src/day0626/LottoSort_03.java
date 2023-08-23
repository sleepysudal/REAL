package day0626;

import java.util.Arrays;

public class LottoSort_03 {

	public static void main(String[] args) {
		int [] lotto = new int[6];

		for(int i=0; i<lotto.length; i++) {
			//1부터 45까지의 랜덤수 발생
			lotto[i]=(int)(Math.random()*45)+1;

			//중복처리
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					i--; //같은 번지에 다시값을 구하기위해서
					break; //지금 for문을 벗어나 i++로 이동
				}
			}

		}
		//Arrays.sort(lotto); //오름차순 정렬
		//오름차순 정렬(기준 :처음~끝에서 2번째 // 비교:시작다음값~끝)
		for (int i=0; i<lotto.length-1; i++) {
			for(int j=i+1; j<lotto.length; j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]= lotto[j];
					lotto[j]=temp;
				}
			}
		}
		//출력
		for(int i=0; i<lotto.length; i++) {
			System.out.printf("%5d",lotto[i]);
		}
		System.out.println();

	}

}
