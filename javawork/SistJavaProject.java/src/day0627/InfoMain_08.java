package day0627;

public class InfoMain_08 {

	public static void main(String[] args) {
		Info_08 in1=new Info_08("홍길동",22, "서울시 강남구");

		//getMethod 변수지정
		String name = in1.getStuName();
		int age = in1.getAge();
		String addr = in1.getAddr();

		System.out.println("이름은 "+name+"이고 나이는 "+age+"이고 주소는 "+addr+"입니다");

		Info_08 in2 = new Info_08("홍길",22,"서울시 고백구");
		System.out.println("이름은 "+in2.getStuName()+"이고 나이는"+in2.age+"세 이며 주소는 "+in2.addr+"입니다");

		//디폴트 생성자로 생성
		Info_08 in3 = new Info_08();
		System.out.println("이름: "+in3.getStuName()+"\n나이: "+in3.getAge()+"\n주소: "+in3.getAddr());
		



	}

}
