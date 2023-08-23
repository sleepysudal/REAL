package day0627;

public class MemoryCnt_04 {
	//인스턴스 변수
	static int count = 0; //static 쓰면 같이 써서 1 2 나옴 , 기존은 각각써서 1 1 나옴

	//생성자
	public MemoryCnt_04() {
		count++;
		System.out.println(count);
	}
	public static void main(String[]args) {
		MemoryCnt_04 mem1 =new MemoryCnt_04();
		MemoryCnt_04 mem2 =new MemoryCnt_04();
	}
}
