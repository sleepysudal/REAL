package day0623;

import java.util.Random;

public class Random_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r=new Random();
		
		System.out.println("0~9사이의 난수를 발생시켜보자");
		for(int i=1; i<=3; i++) {
			int n=r.nextInt(10); //소수점없애기위해서 10곱합
			System.out.println(n);
		}
		System.out.println("1~10사이의 난수발생");
		for(int i=1; i<=3; i++) {
			int n=r.nextInt(10)+1; //1~10사이
			System.out.println(n);
			
		}
	}

}
