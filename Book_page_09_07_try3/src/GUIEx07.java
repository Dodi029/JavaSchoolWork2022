import javax.swing.*;
import java.awt.*;

public class GUIEx07 extends JFrame{
   public GUIEx07() {
      super("계산기 프레임");
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      Container c = getContentPane();
      
      c.add(new SouthPanel(),BorderLayout.SOUTH);
      c.add(new NorthPanel(),BorderLayout.NORTH);
      c.add(new CenterPanel(),BorderLayout.CENTER);
      setSize(300,300);
      setVisible(true);
   }
   public static void main(String[] args) {
      new GUIEx07();
   }
}

class NorthPanel extends JPanel{
   public NorthPanel() {
      setBackground(Color.GREEN);
      setLayout(new FlowLayout(FlowLayout.RIGHT));
      add(new JLabel("수식 입력"));
      add(new JTextField(15));
   }
}

class CenterPanel extends JPanel{
   JButton b[] = {new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/")};
   public CenterPanel() {
      setBackground(Color.WHITE);
      setLayout(new GridLayout(4,4,5,5));
      for(int i=0; i<10; i++) {
         JButton b = new JButton(Integer.toString(i));
         add(b);
      }
      add(new JButton("CE"));
      add(new JButton("계산"));
      for(int i=0; i<b.length; i++) {
         b[i].setBackground(Color.PINK);
         add(b[i]);
      }
   }
}

class SouthPanel extends JPanel{
   public SouthPanel() {
      setBackground(Color.GREEN);
      setLayout(new FlowLayout(FlowLayout.LEFT));
      add(new JLabel("계산 결과"));
      add(new JTextField(15));
   }
}