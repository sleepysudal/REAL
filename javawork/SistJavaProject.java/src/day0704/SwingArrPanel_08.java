package day0704;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SwingArrPanel_08 extends JFrame implements ActionListener {
	
	Container cp;

	//버튼배열선언
	JButton []btn =new JButton[6];
	String []btnLabel= {"Red","Green","Gray","Cyan","Yellow","White"}; //제목으로 들어가는애
	Color []btnColor = {Color.RED,Color.GREEN,Color.GRAY,Color.CYAN,Color.YELLOW,Color.WHITE};

	public SwingArrPanel_08(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,500,400);
		cp.setBackground(new Color(255,255,200));		
		setDesign();
		setVisible(true);	
	}

	public void setDesign() {
		//panel 기본이 Flowlayout
		JPanel panel = new JPanel();
		panel.setBackground(Color.orange);
		//프레임에 패널을 추가_상단 하단...
		this.add(panel, BorderLayout.NORTH); //프레임의 위쪽에 패널을 추가하겠다
		
		//버튼 생성
		for(int i=0;i<btn.length;i++) {
			
			btn[i]=new JButton(btnLabel[i]);
			btn[i].setBackground(btnColor[i]);			
			
			//패널에 추가
			panel.add(btn[i]);
			
			//버튼 6개에 이벤트 추가
			btn[i].addActionListener(this);				
		
		}			
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob=e.getSource();
		
		for(int i=0; i<btn.length; i++) {
			//배경색변경
			if(ob==btn[i]) {
				//배경색
				cp.setBackground(btnColor[i]);
				
				//제목바꾸기
				this.setTitle("color: "+btnLabel[i]);
			}
			
		}
	}


	public static void main(String[] args) {
		
		new SwingArrPanel_08("스윙 배열 연습");
		
	}

}
