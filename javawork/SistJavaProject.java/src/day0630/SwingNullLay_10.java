package day0630;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingNullLay_10 extends JFrame implements ActionListener {
	Container cp;
	JButton btn1,btn2;

	public SwingNullLay_10(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,300,400);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		setVisible(true);
	}
	//디자인
	public void setDesign() {
		//기본 레이아웃 없애기
		this.setLayout(null);

		btn1=new JButton("◀");
		btn2=new JButton("▶");

		//위치직접지정
		btn1.setBounds(50,100,80,30);
		btn2.setBounds(150,100,80,30);

		//프레임에 올리기
		this.add(btn1);
		this.add(btn2);

		//색상
		btn1.setBackground(Color.red); //버튼색
		btn2.setBackground(Color.blue); //버튼색
		btn1.setForeground(Color.white); //글자색
		btn2.setForeground(Color.white); //글자색

		//버튼에 이벤트 발생		
		//이벤트 핸들러랑 이벤트 발생객체 연결
		btn1.addActionListener(this);//상속받았으니까 this ,부모거와 btn1 연결
		btn2.addActionListener(this);//상속받았으니까 this ,부모거와 btn2 연결

	}
	//액션
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object ob=e.getSource();//어떤 메서드를 호출하는지 명확하게하기위해

		//메세지 다이얼로그 형태로 보여주기
		//JOptionPane.showMessageDialog(this, "버튼클릭"); 
		if(ob==btn1) {
			JOptionPane.showMessageDialog(this, "왼쪽으로 이동"); 
		}
		else if(ob==btn2) {
			JOptionPane.showMessageDialog(this, "오른쪽으로 이동"); 
		}

	}

	public static void main(String[] args) {
		new SwingNullLay_10("레이아웃 이벤트");

	}	


}
