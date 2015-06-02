package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonGUI extends JFrame {
	
	private JButton reg;
	private JButton custom;
	
	public ButtonGUI() {
		super ("Bot��es LOL");
		setLayout(new FlowLayout());
		
		Icon Android = new ImageIcon(getClass().getResource("Android-64.png"));
		Icon Windows = new ImageIcon(getClass().getResource("Windows-64.png"));
		
		reg = new JButton("Bot��o 1", Windows);
		add(reg);
		
		custom = new JButton("Bot��o 2",Android);
		//custom.setRolloverSelectedIcon(Windows);
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener {
		public void actionPerformed (ActionEvent event) {
			JOptionPane.showMessageDialog(null, String.format("%s",event.getActionCommand()));
		}
	}
	
}
