package day0704;

import java.util.ArrayList;

public class ArrayList_01 {

	public static void main(String[] args) {
		
		String [] flowers = {"장미","프리지아","다알리아","수국"};
		
		//객체 삽입, 삭제할 수 있는 컨테이너 클래스를 생성
		ArrayList<String>list = new ArrayList<String>();
		
		//데이터 담기
		for(String f: flowers)
			list.add(f); //삽입
		
		System.out.println("size: "+list.size());
		
		System.out.println("#출력1_for");
		for(int i=0; i<list.size(); i++) {
			String s=list.get(i);
			System.out.println(s);
		}
		System.out.println("출력2 for ~each");
		for(String s:list)
			System.out.println(s);
			
			
		
	}

}
