package day0703;

import java.util.StringTokenizer;

public class StringToken_07 {

	public static void main(String[] args) {
		//문자열을 특정문자로 분리하는 방법들
		
		String str = "red,magenta,gray,pink,yellow";
		
		System.out.println("String 객체의 split을 이용한 분리");
		String []arrColors =str.split(",");
		System.out.println("총"+arrColors.length+"개");
		
		for(int i=0; i<arrColors.length; i++) {
			System.out.println((i+1)+":"+arrColors[i]);
		}
		
		
		System.out.println("StringTokenizer 객체를 이용한 분리");
		StringTokenizer st= new StringTokenizer(str, ","); //str 읽어오고 콤마 구분
		System.out.println("총 토큰수: "+st.countTokens());
		
		//토큰읽어올땐 while문으로 불러옴
		while(st.hasMoreTokens()) { //다음토큰이 있으면 true, 없으면 false
			System.out.println(st.nextToken()); //다음토큰 얻기
		}
		
	}

}
