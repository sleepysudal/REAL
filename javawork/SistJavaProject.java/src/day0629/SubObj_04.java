package day0629;

import day0629_1.SuperObj;

public class SubObj_04 extends SuperObj{
	
	String addr; //주소값
	
	public SubObj_04(String name, int age,String addr) {
		super(name, age); //반드시 상속받은게 먼저 와야됨, 반드시 첫줄 부모생성자호출
		this.addr=addr;  //this.addr 이 먼저 오면 에러남
		
	}
	public void write() {
		System.out.println("이름: "+this.name);
		System.out.println("나이: "+this.age);
		System.out.println("주소: "+this.addr);
	}
	
}
