package day0628;

class Score{
	private String stuName;
	private int java;
	private int oracle;
	private int html;
	
	static final String TITLE = "중간고사 시험결과";

	
	//자동 SETTER , 자동 GETTER
	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}

	public int getJava() {
		return java;
	}

	public void setJava(int java) {
		this.java = java;
	}

	public int getOracle() {
		return oracle;
	}

	public void setOracle(int oracle) {
		this.oracle = oracle;
	}

	public int getHtml() {
		return html;
	}

	public void setHtml(int html) {
		this.html = html;
	}	
	
	//합계메서드
	public int getTotal() {
		int total=java+oracle+html;
		return total;
	}
	//평균메서드
	public double getAvg() {
		return getTotal()/3.0;
		//double a= getTotal()/3.0;
		//return a;
	}
}

////////////////////////////////////////////////
public class ExObject_07 {

	public static void main(String[] args) {
		
		//1.생성
		Score s1=new Score();
		
		//1-1set 입력
		s1.setStuName("김지윤");
		s1.setJava(99);
		s1.setOracle(88);
		s1.setHtml(56);		
		
		//1-2get 출력
		System.out.println("***"+Score.TITLE+"***");
		System.out.println("학생명: "+s1.getStuName()+"\n자바점수: "+s1.getJava()+"점"+"\n오라클점수: "+s1.getOracle()+"점"+"\nHTML점수: "+s1.getHtml()+"점");
		System.out.println("합계점수: "+s1.getTotal()+"점");
		System.out.println("평균: "+s1.getAvg()+"점");
		System.out.println("====================================================");
		
		//2.생성
		Score s2 = new Score();
		
		//2-1 set 입력
		s2.setStuName("김동현");
		s2.setJava(79);
		s2.setOracle(68);
		s2.setHtml(76);
		
		//2-2 get 출력
		System.out.println("***"+Score.TITLE+"***");
		System.out.println("학생명: "+s2.getStuName()+"\n자바점수: "+s2.getJava()+"점"+"\n오라클점수: "+s2.getOracle()+"점"+"\nHTML점수: "+s2.getHtml()+"점");
		System.out.println("합계점수: "+s2.getTotal()+"점");
		System.out.println("평균: "+s2.getAvg()+"점");
	}

}
