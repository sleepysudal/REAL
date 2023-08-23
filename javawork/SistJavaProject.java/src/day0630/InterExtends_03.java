package day0630;

interface InterAA{
	public void eat();
	public void go();
}
////////////////////////////
interface InterBB extends InterAA{
	public void ride();
}
///////////////////////////////
class InterImpl2 implements InterBB{

	@Override
	public void eat() {
		System.out.println("배고픈데 먹자");

	}

	@Override
	public void go() {
		System.out.println("어디든 가자");

	}

	@Override
	public void ride() {

		System.out.println("자전거 타고놀아");
	}

}
////////////////////////////////////
public class InterExtends_03 {

	public static void main(String[] args) {
		//3개 모두호출
		InterImpl2 i1= new InterImpl2();
		i1.eat();
		i1.go();
		i1.ride();
		
		System.out.println("=================================");

		//다형성 호출
		InterBB bb =new InterImpl2();
		bb.eat();
		bb.go();
		bb.ride();
	}

}
