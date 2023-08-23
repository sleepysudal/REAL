package day0630;

import day0630.Outer.Inner;

//내부클래스 -특정클래스 내에 또다른 클래스가 정의됨
//하나의 멤버처럼 사용가능(외부의 모든멤버들을 자신의 멤버처럼 사용가능)
//상속이 하나인 단점을 어느정도 보완해준다.

class OuterObj{
	class InnerObj{
		public void write() {
			System.out.println("내부클래스의 메서드");
		}
	}
	public void showMsg() {
		System.out.println("외부 클래스의 메서드");
		System.out.println("외부에서 내부클래스 메서드 호출");
		
		InnerObj inobj = new InnerObj();
		inobj.write();
	}	
}
public class InnerClass_11 {

	public static void main(String[] args) {
		OuterObj outobj = new OuterObj();
		outobj.showMsg();
		System.out.println("------------------------------------");
		
		//내부클래스의 메서드 선언..외부통해서만 접근가능(2가지방법)
		//1.OuterObj.InnerObj obj = new OuterObj().new InnerObj();
		//1.obj.write();
		
		OuterObj.InnerObj obj = outobj.new InnerObj();
		obj.write();
		//////////////////////////////
	}
}
