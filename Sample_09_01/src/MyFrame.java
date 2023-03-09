// 300 x 300 크기의 스윙 프레임 만들기 
// 300 x 300 크기의 스윙 프레임을 작성 

import javax.swing.*;

public class MyFrame extends JFrame {
	public MyFrame() {
		setTitle("300 x 300 스윙 프레임 만들기 ");
		setSize(300, 300);						// 프레임 크기 300 x 300 
		setVisible(true);						// 프레임 출력 
	}
	
	public static void main(String[] args) {
		MyFrame frame = new MyFrame();
	}
}
