package day0704;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingGrid_06 extends JFrame implements ActionListener{

	Container cp;	
	//이미지 아이콘
	ImageIcon icon1 = new ImageIcon("C:\\Test\\img\\01.png");
	ImageIcon icon2 = new ImageIcon("C:\\Test\\img\\02.png");
	ImageIcon icon3 = new ImageIcon("C:\\Test\\img\\04.png");
	ImageIcon icon4 = new ImageIcon("C:\\Test\\img\\05.png");

	//버튼선언
	JButton btn1,btn2,btn3,btn4;

	public SwingGrid_06(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,300,400);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		setVisible(true);	
	}

	private void setDesign() {
		//버튼 4개생성
		this.setLayout(new GridLayout(2,2));//버튼을 2행 2열로 배치
		btn1 = new JButton("hello",icon1);
		btn1.setVerticalTextPosition(JButton.BOTTOM);//텍스트 새로위치
		btn1.setHorizontalTextPosition(JButton.CENTER);//텍스트 가로위치
		this.add(btn1);
		
		btn1.setRolloverIcon(icon2); //마우스 올렸을때 아이콘
		btn1.setPressedIcon(icon3); //클릭시 아이콘
		
		//2
		btn2 = new JButton(icon4);
		this.add(btn2);		
		
		//3
		btn3=new JButton("JAVA");
		this.add(btn3);		
				
	    //4
		btn4=new JButton("Hi!!",icon2);
		this.add(btn4);
		
		//버튼에 액션이벤트 추가
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);		

	}
	//액션
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();//어떤 메서드를 호출하는지 명확하게하기위해

		//메세지 다이얼로그 형태로 보여주기
		if(ob==btn1) {
			JOptionPane.showMessageDialog(this, "1번 이미지입니다"); 
		}
		else if(ob==btn2) {
			JOptionPane.showMessageDialog(this, "2번 이미지입니다"); 
		}
		else if(ob==btn3) {
			JOptionPane.showMessageDialog(this, "3번 이미지입니다"); 
		}

		else if(ob==btn4) {
			JOptionPane.showMessageDialog(this, "4번 이미지입니다"); 
		}
	}

	public static void main(String[] args) {

		new SwingGrid_06("그리드 레이아웃");
	}

	

}
