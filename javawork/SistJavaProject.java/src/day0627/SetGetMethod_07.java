package day0627;

//같은패키지안에 잇을때 클래스명 같으면 에러
class Student{
	private String name; //null
	private int age; //0
	
	//setter_method
	//인스턴스 변수에 저장된 데이터를 수정할 목적(set변수명)
	//저장수정용도이므로 리턴값(결과값)이 없다(void)
	public void setName(String name) {
		this.name=name;		
	}
	public void setAge(int age) {
		this.age=age;
	}	
	
	//getter_method
	//인스턴스변수에 저장된 데이터를 조회할 목적으로 사용(get변수명)
	//데이터를 얻는 목적이므로 호출데이터를 넘겨줄 필요가 없으므로 인자값(파라메타값)이 없다.
	//실행결과를 돌려주므로 "return 결과값"으로 지정
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
////////////////////////////////
public class SetGetMethod_07 {

	public static void main(String[] args) {
		//1. 객체 생성
		Student stu1 = new Student();
		
		//2. 참조변수명으로 set메서드 호출
		stu1.setName("김영준");
		stu1.setAge(27);
		
		//3. 조회 출력
		String name=stu1.getName();
		int age = stu1.getAge();
		
		//4.출력
		System.out.println(name+" "+age);
		
		//1. 객체생성
		Student stu2 =new Student();
		//2. 참조변수명으로 set 메서드 호출
		stu2.setName("호시노똉컨");
		stu2.setAge(27);
		//3. 조회출력
		String name2=stu2.getName();
		int age2=stu2.getAge();
		//4. 출력
		System.out.println(name2+" "+age2);
	}

}
