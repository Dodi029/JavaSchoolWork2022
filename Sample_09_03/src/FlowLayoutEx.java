// FlowLayout 배치관리자 활용 
// 수평 간격이 30, 수직 간격을 40픽셀로 하고 LEFT 로 정렬 배치하는 FlowLayout 배치관리자를 가진 컨탠트팬에 5개의 버튼 컴포넌트를 부착한 스윙 응용프로그램 작성 

import javax.swing.*;
import java.awt.*;

public class FlowLayoutEx extends JFrame {
	public FlowLayoutEx() {
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new JButton("add"));
		c.add(new JButton("sub"));
		c.add(new JButton("mul"));
		c.add(new JButton("div"));
		c.add(new JButton("Calculate"));
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new FlowLayoutEx();
	}
}
