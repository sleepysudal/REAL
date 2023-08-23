package day0628;

class Student{
	private String sname; //학생이름
	private String hp; //핸폰번호
	private int grade; //학년
	
	//명시적 생성자
	public Student(String sname, String hp, int grade) {
		this.sname=sname;
		this.hp=hp;
		this.grade=grade;
	}
	//멤버값 출력데이터
	public void getdata() {
		System.out.println("이름: "+sname);
		System.out.println("연락처: "+hp);
		System.out.println("학년: "+grade);
	}	
	
}

/////////////////////////////////////////////
public class ArrObject_09 {

	public static void main(String[] args) {
		
		/*
		//1. 생성자
		Student []stu = new Student[3];
		
		//값 할당
		stu[0]=new Student("가나다", "010-1234-5678", 1);
		stu[1]=new Student("라마바", "010-2345-6789", 2);
		stu[2]=new Student("사아자", "010-3456-7890", 3);
		*/
		
		//생성하면서 바로 초기화
		Student[]stu = {
		new Student("가나다", "010-1234-5678", 1),
		new Student("라마바","010-2345-6789",2),
		new Student("사아자","010-3456-7890",3)};
		
		//출력#1
		for(int i=0; i<stu.length;i++) {
						
			stu[i].getdata();			
			System.out.println("========================================");
			
		}
		
		//출력#2
		for(Student s1:stu) {
			s1.getdata();
			System.out.println("===========================================================");
			
		}
		
				
		

	}

}
