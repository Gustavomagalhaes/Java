package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Check extends JFrame {
	private JTextField txt;
	private JCheckBox bold;
	private JCheckBox italic;
	
	public Check() {
		super ("CheckBoxes");
		setLayout(new FlowLayout());
		
		txt = new JTextField ("This is Sparta", 18);
		txt.setFont(new Font ("serif", Font.PLAIN, 18));
		add(txt);
		
		bold = new JCheckBox ("Negrito");
		add (bold);
		italic = new JCheckBox ("It‡lico");
		add (italic);
		
		HandlerClass handler = new HandlerClass();
		bold.addItemListener(handler);
		italic.addItemListener(handler);
	}
	
	private class HandlerClass implements ItemListener {
		public void itemStateChanged(ItemEvent event) {
			Font font = null;
			
			if (bold.isSelected() && italic.isSelected()) {
				font = new Font ("Serif", Font.BOLD + Font.ITALIC, 18);
				
			} else if (bold.isSelected()) {
				font = new Font ("Serif", Font.BOLD, 18);
				
			} else if (italic.isSelected()) {
				font = new Font ("Serif", Font.ITALIC, 18);
				
			} else {
				font = new Font ("Serif", Font.PLAIN, 18);
			} 
			txt.setFont(font); 
		}
	}
}
