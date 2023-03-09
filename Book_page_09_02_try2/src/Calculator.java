import javax.swing.*;
import java.awt.*;


public class Calculator extends JFrame {
	public Calculator() {
		setTitle("계산기 프레임 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		
		c.add(new NorthPanel(), BorderLayout.NORTH);
		c.add(new CenterPanel(), BorderLayout.CENTER);
		c.add(new SouthPanel(), BorderLayout.SOUTH);
		
		setSize(300, 200);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
	
	
	class NorthPanel extends JPanel {
		public NorthPanel() {
			// setBackground(Color.YELLOW);
			Container c = getContentPane();
			c.setLayout(new FlowLayout(FlowLayout.LEFT));
			
			GridLayout grid = new GridLayout(4, 2);
			grid.setVgap(5);

			c.setLayout(grid);
			
			c.add(new JLabel("수식입력"));
			c.add(new JTextField(15));
		}
	}
	
	class SouthPanel extends JPanel {
		public SouthPanel() {
			GridLayout grid = new GridLayout(4, 2);
			grid.setVgap(5);
			
			Container c = getContentPane();
			c.setLayout(grid);
			
			c.add(new JLabel("계산결과"));
			c.add(new JTextField(15));
		}
	}
	
	class CenterPanel extends JPanel{
		public CenterPanel() {
			Container c = getContentPane();
			c.setLayout(new FlowLayout(FlowLayout.RIGHT));
			
			for (int i = 0; i < 10; i++) {
				c.add(new JButton(Integer.toString(i)));
			}
			c.add(new JButton("CE"));
			c.add(new JButton("계산"));
			
			c.add(new JButton("+"));
			c.add(new JButton("-"));
			c.add(new JButton("x"));
			c.add(new JButton("/"));
		}
	}
}
