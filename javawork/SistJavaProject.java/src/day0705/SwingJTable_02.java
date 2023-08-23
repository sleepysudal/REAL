package day0705;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SwingJTable_02 extends JFrame {

	Container cp;
	JTable table;
	JLabel lblTitle;
	JLabel lblOut;

	public SwingJTable_02(String title) {
		super(title);
		cp=this.getContentPane();
		this.setBounds(200,100,500,600);
		cp.setBackground(new Color(255,255,200));
		setDesign();
		setVisible(true);	
	}

	public void setDesign() {
		String [][] data = {{"김영준","서울","010-1234-5678"},
				{"최성현","경기","010-2345-6789"},
				{"장미란","인천","010-3456-7890"},
				{"박세리","제주","010-4567-8901"}};
		String []title = {"이름","주소","연락처"};

		lblTitle = new JLabel("JTable 연습",JLabel.CENTER);
		lblOut=new JLabel("결과출력....",JLabel.CENTER);

		table=new JTable(data, title);
		JScrollPane pane = new JScrollPane(table);

		//테이블에 마우스 이벤트 추가
		table.addMouseListener(new TableEvent());
		
		this.add("North",lblTitle);
		this.add("Center",pane);
		this.add("South",lblOut);

	}
	//테이블클릭시 발생하는 마우스 이벤트
	class TableEvent extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			
			super.mouseClicked(e);
			//System.out.println("테이블클릭!!!");
			//선택한 행번호 얻기
			int rowNum=table.getSelectedRow();
			
			String str = "이름: "+table.getValueAt(rowNum, 0)//로우넘의 0번지열
			+", 주소: "+table.getValueAt(rowNum, 1)//로우넘의 1번지열
			+", 연락처: "+table.getValueAt(rowNum, 2); //로우넘의 2번지열
			
			lblOut.setText(str);
		}
	}

	public static void main(String[] args) {

		new SwingJTable_02("스윙 테이블 연습");
	}

}
