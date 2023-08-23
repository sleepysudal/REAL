package day0629;

/* 원하는 입력결과
 * 학생명 Java Oracle Html 총점 평균 평가
 * */

public class Sungjuk_03 {
	private static String schoolname; //학교명
	private String name; //학생명
	private int Oracle,Java,Html; //오라클 자바 html 점수	
	
	//자동으로 set get 생성
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOracle() {
		return Oracle;
	}
	public void setOracle(int oracle) {
		Oracle = oracle;
	}
	public int getJava() {
		return Java;
	}
	public void setJava(int java) {
		Java = java;
	}
	public int getHtml() {
		return Html;
	}
	public void setHtml(int html) {
		Html = html;
	}	
	public static String getSchoolname() {
		return schoolname;
	}
	public static void setSchoolname(String schoolname) {
		Sungjuk_03.schoolname = schoolname;
	}
	
	//총점
	public int getTot() {
		return Java+Oracle+Html;
	}
	
	//평균
	public double getAverage() {
		return getTot()/3.0;
	}
	//평가
	public String getPyungga() {
		if(getAverage()>=60) {
			return "합격";			
		}
		else 
			return "불합격";
	}
	
	 
}
