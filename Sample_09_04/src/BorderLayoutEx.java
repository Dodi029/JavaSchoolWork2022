// BorderLayout 배치관리자를 사용하는 예 
// BorderLayout 배치 관리자를 사용하여 컨텐트팬에 5개의 버튼 컴포넌트를 삽입하라 

import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
	public BorderLayoutEx() {
		setTitle("BorderLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout(30, 20));
		c.add(new JButton("Calculate"), BorderLayout.CENTER);
		c.add(new JButton("add"), BorderLayout.NORTH);
		c.add(new JButton("sub"), BorderLayout.SOUTH);
		c.add(new JButton("mul"), BorderLayout.EAST);
		c.add(new JButton("div"), BorderLayout.WEST);
		
		setSize(300, 200);								// 프레임 크기 300 x 200 설정 
		setVisible(true);								// 프레임을 화면에 출력 
	}
	public static void main(String[] args) {
		new BorderLayoutEx();
	}
}
