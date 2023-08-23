package day0703;

import java.util.List;
import java.util.Vector;

//가장 많이 사용하는 인터페이스 List
//List 인터페이스를 구현한 Vector, ArrayList
//순차적으로 데이터 들어감, 중복데이터 허용
//처음 생성시 일정한 개수로 생성 그 이상의 데이터를 넣으면 공간이 자동증가
public class List_12 {

	public static void main(String[] args) {
		//List<String>list = new Vector<String>();
		Vector<String>list = new Vector<String>();
		
		System.out.println("초기 할당 크기: "+list.capacity());
		System.out.println("초기 데이터 크기: "+list.size());
		
		list.add("사과");
		list.add("포도");
		list.add("키위");
		list.add("사과"); //중복가능
		list.add("바나나");
		list.add("오렌지");
		
		System.out.println("초기 할당 크기: "+list.capacity());
		System.out.println("초기 데이터 크기: "+list.size());
		
		System.out.println("출력#1");
		//for문 list는 랭스아니고 size
		for(int i=0; i<list.size();i++) {
			String s =list.get(i);
			System.out.println(s);
		}
		System.out.println("출력#2");
		//for~each문 list는 랭스말고 size
		for(String s:list) {
			System.out.println(s);
		}
		System.out.println("출력#3");
		Object[]ob = list.toArray();
		for (int i=0; i<ob.length; i++) {
			System.out.println(ob[i]);
		}
	}

}
