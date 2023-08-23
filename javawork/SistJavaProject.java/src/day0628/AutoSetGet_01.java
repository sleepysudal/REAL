package day0628;

class MyDate{
	//변수
	private int year;
	private int month;
	private int day;
	
	//디폴트 생성자 숨어있다...명시적 생성자 만들면
	public MyDate() {
		
	}
	//명시적생성자...3개의 인자값을 수정과 동시에 생성하는
	public MyDate(int year, int month, int d) {
		this.year=year;
		this.month=month; //변수값이랑 이름같으면 this. 붙여야됨
		day=d; //이름이 다르면 this 안써도됨 
		
	}
	
	
	//getter,setter
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}

}


/////////////////////////////////////////////////////////
public class AutoSetGet_01 {

	public static void main(String[] args) {
		
		//객체생성
		MyDate date =new MyDate();
		
		date.setYear(2023);
		date.setMonth(6);
		date.setDay(28);
		
		System.out.println(date.getYear()+"년 "+date.getMonth()+"월 "+date.getDay()+"일");
		
		//명시적 생성
		MyDate date1= new MyDate(2020,8,10);
		System.out.println(date1.getYear()+"년 "+date1.getMonth()+"월 "+date1.getDay()+"일");
	
	}

}
