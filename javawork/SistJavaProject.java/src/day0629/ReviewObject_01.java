package day0629;

class MyTv{
	
	private String cha;//채널
	private String vol; //볼륨
	public static final String TV="TV 시청목록"; //final 이게머엿지?
	
	//setter getter
	public String getCha() {
		return cha;
	}
	public void setCha(String cha) {
		this.cha = cha;
	}
	public String getVol() {
		return vol;
	}
	public void setVol(String vol) {
		this.vol = vol;
	}
	
	
	/*tv시청목록
	 * 
	 * ebs 채널을 시청합니다
       볼륨은 15입니다
 * ====================
 * 채널: tvn
 * 볼륨: 22*/


}


//////////////////////////////////////////////////////////////////////////
public class ReviewObject_01 {

	public static void main(String[] args) {
		
		//1. 생성
		MyTv tv1=new MyTv();
		
		//1-1 SET 입력 및 수정
		tv1.setCha("ebs");
		tv1.setVol("15");
		
		//MyTv클래스에 놓은 TV 값 가져와서 출력하기
		System.out.println("***"+MyTv.TV+"***");
		
		//한줄 띄우기
		System.out.println();
		
		//1-2 GET 이용해서 SET 수정한값 가져와서 출력 하기
		System.out.println(tv1.getCha()+" 채널을 시청합니다" );
		System.out.println("볼륨은 "+tv1.getVol()+"데시벨입니다");		
		System.out.println("========================================");
		
		/* MyTv tv = new MyTv();
		 * tv.setcha("ebs");
		 * tv.setvol("11")
		 * String c=tv.getCha();
		 * String v=tv.getVol();
		 * system.out.println("볼륨은"+v+"데시벨입니다");
		 * sysetm.out.println("채널은"+c+"데시벨입니다"); */
		
		
		//2. 생성
		MyTv tv2=new MyTv();
		
		//2-1 SET 입력 및 수정
		tv2.setCha("tvn");
		tv2.setVol("18");
		
		//2-2 GET 이용해서 SET에서 수정한값 가져와서 출력하기
		System.out.println(tv2.getCha()+" 채널을 시청합니다" );
		System.out.println("볼륨은 "+tv2.getVol()+"데시벨입니다");

	}

}
