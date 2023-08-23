package day0704;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class SwingCalc_09 extends JFrame {
	
	Container cp;
	JLabel lblResult,lbl1,lbl2; //결과 나오는 곳,숫자1제목,숫자2제목
	JTextField tfSu1,tfSu2; //입력하는 곳
	JButton btnAdd; //이벤트 발생 버튼
	
	public SwingCalc_09(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,400,500);
		cp.setBackground(new Color(255,255,200));		
		setDesign();
		setVisible(true);	
	}
	public void setDesign() {
		this.setLayout(null);
		lbl1 =new JLabel("숫자1");
		lbl2 =new JLabel("숫자2");
		
		lbl1.setBounds(20, 20, 50, 30);  //크기 지정
		this.add(lbl1);
		lbl2.setBounds(20, 60, 50, 30);  //크기 지정
		this.add(lbl2);
		
		tfSu1=new JTextField();
		tfSu1.setBounds(70, 20, 60, 30);  //크기지정
		this.add(tfSu1);
		tfSu2=new JTextField();
		tfSu2.setBounds(70, 60, 60, 30); //크기 지정
		this.add(tfSu2);
		
		btnAdd=new JButton("숫자더하기");
		btnAdd.setBounds(30,120,150,50); //크기 지정
		this.add(btnAdd);
		
		lblResult=new JLabel("결과 나오는 곳");
		lblResult.setBounds(10,180,250,60); //크기 지정
		this.add(lblResult);
		
		
		//버튼 이벤트 익명내부 클래스 형식으로 만들기
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {				
				
				String su1=tfSu1.getText(); //텍스트필드1의 text받아오기
				String su2=tfSu2.getText(); //텍스트필드2의 text받아오기					 
				 
				int total=Integer.parseInt(su1)+Integer.parseInt(su2);	
				
				lblResult.setText(su1+"+"+su2+"="+total); //문자형 정수형 같이 형변환할때
				
				/*
				 * int su1=Integer.parseInt(tfSu1.getText());
				 * int su2=Integer.parseInt(tfSu2.getText());
				 * int sum=su1+su2;
				 * 형변환해서 출력하는 2가지방법 
				 * String s = String.valueOf(sum);
				 * String s= sum+"";
				 * String s =su1+"+"+su2+"="+sum;
				 * */
				
				
				
			
				
			}
		}); 
			
		}
		
	
	
	
	public static void main(String[] args) {
		
		new SwingCalc_09("간단계산 연습");
	}

}
