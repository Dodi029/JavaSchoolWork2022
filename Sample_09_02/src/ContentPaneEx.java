// 스윙 GUI 프로그램 만들기 

import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
	public ContentPaneEx() {
		setTitle("Contentpane과 JFrame ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			// 종료버튼이 클릭될 때 프레임을 닫고 응용 프로그램이 종료되도록 함, 윈도우 창 뿐만 아니라 프로그램도 종료시킴 
		
		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(300, 150);
		setVisible(true);
	}
	
	public static void main(String[] args){
		new ContentPaneEx();
	}
}
