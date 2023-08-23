package day0616;

public class DateType_08 {

	public static void main(String[] args) {
		byte a= 127;//-128~127 범위틀리면오류남
		byte b= (byte)128;//더 작은 자료형으로 변환(디모션_값손실)
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		int x=7;
		int y=4;
		
		System.out.println(x/y);//정수형끼리의 계산결과는 무조건 int타입
		System.out.println((double)x/y);//계산 시 x를 double로 변환해서 계산:결과는 double
		System.out.println(x/(double)y);
		
		//강제형변환
		
		double d=100.0;
		int i=100;
		int result=(int)d+i;//int result=d+i;경우 큰 double이 작은 int로 가면 에러남
		double result2=d+i;//작은거가 큰거 들어갈땐 형변환안해줘도됨
		
		System.out.println("d"+d);
		System.out.println("i"+i);
		System.out.println("result1="+result);
		System.out.println("result2="+result2);
	}

}
