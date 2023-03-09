//// 다양한 KeyEvent와 KeyListener 활용 
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//
//public class KeyListenerEx extends JFrame {
//	private JLabel[] KeyMessage;
//	
//	public KeyListenerEx() {
//		setTitle("KeyListener 예제");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Container c = getContentPane();
//		c.setLayout(new FlowLayout());
//		
//		c.addKeyListener(new MyKeyListener());
//		
//		KeyMessage = new JLabel[3];
//		KeyMessage[0] = new JLabel("getKeyCode()");
//		KeyMessage[1] = new JLabel("getKeyChar()");
//		KeyMessage[2] = new JLabel("getKeyText()");
//		
//		for (int i = 0; i < KeyMessage.length; i++) {
//			c.add(KeyMessage[i]);
//			KeyMessage[i].setOpaque(true);
//			KeyMessage[i].setBackground(Color.YELLOW);
//		}
//		
//		setSize(300, 150);
//		setVisible(true);
//		c.setFocusable(true);
//		c.requestFocus();
//	}
//	
//	class MyKeyListener extends KeyAdapter{
//		public void KeyPressed(KeyEvent e) {
//			int KeyCode = e.getKeyCode();
//			char KeyChar = e.getKeyChar();
//			
//			KeyMessage[0].setText(Integer.toString(KeyCode));
//			KeyMessage[1].setText(Character.toString(KeyChar));
//			KeyMessage[2].setText(e.getKeyText(KeyCode));
//		}
//	}
//	
//	public static void main(String[] args) {
//		new KeyListenerEx();
//	}
//}

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class KeyListenerEx extends JFrame {
private JLabel [] keyMessage;
public KeyListenerEx() { setTitle("keyListener 예제");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Container c = getContentPane();
c.setLayout(new FlowLayout());
c.addKeyListener(new MyKeyListener());
keyMessage = new JLabel [3];
keyMessage[0] = new JLabel(" getKeyCode() "); keyMessage[1] = new JLabel(" getKeyChar() "); keyMessage[2] = new JLabel(" getKeyText() ");
for(int i=0; i<keyMessage.length; i++) { c.add(keyMessage[i]); keyMessage[i].setOpaque(true); keyMessage[i].setBackground(Color.YELLOW);
}
setSize(300,150); setVisible(true); c.setFocusable(true); c.requestFocus();
}
class MyKeyListener extends KeyAdapter { public void keyPressed(KeyEvent e) {
int keyCode = e.getKeyCode(); char keyChar = e.getKeyChar();
keyMessage[0].setText(Integer.toString(keyCode)); keyMessage[1].setText(Character.toString(keyChar));
keyMessage[2].setText(e.getKeyText(keyCode)); }
}
public static void main(String [] args) {
new KeyListenerEx(); }
}