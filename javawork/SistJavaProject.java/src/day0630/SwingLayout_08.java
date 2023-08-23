package day0630;

import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingLayout_08 extends JFrame{
	
	Container cp;
	JButton btn1;
	
	public SwingLayout_08(String title) {
		
		super(title);
		cp = this.getContentPane();
		
		this.setBounds(500, 100, 700, 700);	
		
		cp.setBackground(new Color(255,255,200));
		
		//버튼생성
		btn1 = new JButton("위쪽");
		//프레임에 버튼 추가
		//프레임 기본레이아웃이 BorderLayout
		//BorderLayout 추가시 위치 지정 필수
		
		//this.add(btn1, BorderLayout.NORTH);//위쪽에 버튼 위치함
		//this.add(btn1, BorderLayout.SOUTH); //아래쪽에 버튼 위치함
		this.add("North", btn1); //첫글자 대문자로 작성
		
		//생성과 동시에 프레임추가 위치지정
		this.add("South",new JButton("아래쪽"));	//프레임에서 아래쪽에 버튼을 추가시키고 버튼의 이름은 아래쪽으로 정함	
		this.add("West",new JButton("왼쪽")); //프레임에서 왼쪽에 버튼을 추가시키고 버튼의 이름은 왼쪽으로 정함
		this.add("East",new JButton("오른쪽"));  //프레임에서 오른쪽에 버튼을 추가시키고 버튼의 이름은 오른쪽으로 정함
		this.add("Center",new JButton("가운데")); //프레임에서 가운데에 버튼을 추가시키고 버튼의 이름은 가운데로 정함
		
		//버튼1에 속성
		btn1.setBackground(Color.blue);  //버튼배경의 색상
		btn1.setForeground(Color.green); //버튼안에 글자색상
		
		
		
		this.setVisible(true);
	}

	public static void main(String[] args) {
		
		new SwingLayout_08("스윙 레이아웃 연습");

	}

}
