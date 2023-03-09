import javax.swing.*;
import java.awt.*;

public class CalculatorEx extends JFrame {
	public CalculatorEx() {
		setTitle("계산기 프레임");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		
		GridLayout grid = new GridLayout();
		grid.setVgap(5);
		
		Container c2 = getContentPane();
		// c2.setLayout(grid);
		c2.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		c.add(new JLabel("수식입력"), BorderLayout.NORTH);
		c.add(new JTextField(15), BorderLayout.NORTH);		
		for (int i = 0; i < 10; i++) {
			c2.add(new JButton(Integer.toString(i)), BorderLayout.CENTER);
		}
//		c2.add(new JButton("CE"), BorderLayout.CENTER);
//		c2.add(new JButton("계산"), BorderLayout.CENTER);
//		c2.add(new JButton("+"), BorderLayout.CENTER);
//		c2.add(new JButton("-"), BorderLayout.CENTER);
//		c2.add(new JButton("x"), BorderLayout.CENTER);
//		c2.add(new JButton("/"), BorderLayout.CENTER);
		
		c.add(new JButton("CE"), BorderLayout.CENTER);
		c.add(new JButton("계산"), BorderLayout.CENTER);
		c.add(new JButton("+"), BorderLayout.CENTER);
		c.add(new JButton("-"), BorderLayout.CENTER);
		c.add(new JButton("x"), BorderLayout.CENTER);
		c.add(new JButton("/"), BorderLayout.CENTER);
		
		c.add(new JLabel("계산결과"), BorderLayout.SOUTH);
		c.add(new JTextField(15), BorderLayout.SOUTH);

		
		setSize(300, 200);
		setVisible(true);
	}
	public static void main(String[] args) {
		new CalculatorEx();
	}
}
