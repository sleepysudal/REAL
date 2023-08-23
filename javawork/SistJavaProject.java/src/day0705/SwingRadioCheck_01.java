package day0705;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SwingRadioCheck_01 extends JFrame implements ActionListener {
	Container cp;	
	JRadioButton [] rb = new JRadioButton[4]; //하나만 선택하고 싶을때
	JCheckBox[]cb= new JCheckBox[4];
	JLabel lblMessage; //라디오버튼, 체크박스 결과값 출력
	JPanel pTop,pBottom;//라디오버튼, 체크박스 올릴 패널
	Color []colors = {Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY};

	public SwingRadioCheck_01(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,600,500);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		setVisible(true);	
	}
	public void setDesign() {
		//상단패널에 보더로 감싼 4개의 radio버튼 만들기
		String []str1= {"검정","파랑","싸이언","다크그레이"};
		pTop =new JPanel();
		pTop.setBorder(new TitledBorder("글자색"));
		this.add("North",pTop);

		//라디오버튼 하나만 선택되도록 그룹을 지어줌
		ButtonGroup bg =new ButtonGroup();

		for(int i=0; i<rb.length; i++) {
			rb[i]= new JRadioButton(str1[i],i==2?true:false);//라디오 버튼 생성
			rb[i].addActionListener(this);//라디오버튼에 액션 추가
			pTop.add(rb[i]); //4개의 버튼을 각각 탑패널에 추가한다
			bg.add(rb[i]); //버튼그룹에 추가
		}
		ImageIcon icon = new ImageIcon("C:\\Test\\img\\07.png");

		lblMessage = new JLabel("Have a Nice Day!!!",icon,JLabel.CENTER);
		lblMessage.setHorizontalTextPosition(JLabel.LEFT);
		lblMessage.setBorder(new LineBorder(Color.lightGray,2));//라인 굵기
		this.add("Center",lblMessage);

		//하단패널에 보더로 감싼 4개의 checkbox 버튼 만들기
		pBottom = new JPanel();
		pBottom.setBorder(new TitledBorder("가능언어"));
		this.add("South",pBottom);

		String []str2= {"한국어","일본어","영어","중국어"};

		for(int i=0; i<cb.length; i++) {
			cb[i]=new JCheckBox(str2[i],i==1?true:false);//체크 박스 버튼 생성
			cb[i].addActionListener(this);//체크버튼에 액션추가
			pBottom.add(cb[i]);//4개의 버튼을 각각 바텀패널에 추가한다
			bg.add(cb[i]); //버튼그룹에 추가
		}


	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource(); //명확한 객체를 선택하기위해서

		//라디오버튼 호출처리, 메세지를 컬러별로 출력
		for(int i=0; i<rb.length; i++) {
			if(ob==rb[i]) {
				lblMessage.setForeground(colors[i]);
				lblMessage.setFont(new Font("", Font.BOLD, 20));
			}

		}
		//체크박스 버튼
		String lang = "나의 가능언어는 ";

		for(int i=0; i<cb.length; i++) {

			if(cb[i].isSelected())
			{
				lang+=cb[i].getText()+"";
			}

		}
		lblMessage.setText(lang);

		//클래스 타입비교
		if(ob instanceof JCheckBox)
			lblMessage.setText(lang);
		else if(ob instanceof JRadioButton)
			lblMessage.setText("Have a Nice Day!!");
	}

	public static void main(String[] args) {
		new SwingRadioCheck_01("라디오 체크 연습");

	}

}
