package GUI;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Radio extends JFrame {
	private JTextField txt;
	
	private Font plainF;
	private Font boldF;
	private Font italicF;
	private Font bolditalicF;
	
	private JRadioButton plainbutton;
	private JRadioButton boldbutton;
	private JRadioButton italicbutton;
	private JRadioButton bolditalicbutton;
	
	private ButtonGroup group;
	
	public Radio(){
		super("Radio Title");
		setLayout(new FlowLayout());
		txt = new JTextField ("Gustavo Ž foda", 18);
		add(txt);
		
		plainbutton = new JRadioButton("plain", true);
		boldbutton = new JRadioButton("bold", false);
		italicbutton = new JRadioButton("italic", false);
		bolditalicbutton = new JRadioButton("bold and italic", false);
		
		add(plainbutton);
		add(boldbutton);
		add(italicbutton);
		add(bolditalicbutton);
		
		group = new ButtonGroup();
		group.add(plainbutton);
		group.add(boldbutton);
		group.add(italicbutton);
		group.add(bolditalicbutton);
		
		plainF = new Font ("Serif", Font.PLAIN, 18);
		boldF = new Font ("Serif", Font.BOLD, 18);
		italicF = new Font ("Serif", Font.ITALIC, 18);
		bolditalicF = new Font ("Serif", Font.BOLD + Font.ITALIC, 18);
		
		txt.setFont(plainF);
		
		plainbutton.addItemListener(new HandlerClass(plainF));
		boldbutton.addItemListener(new HandlerClass(boldF));
		italicbutton.addItemListener(new HandlerClass(italicF));
		bolditalicbutton.addItemListener(new HandlerClass(bolditalicF));
		
	}
	
	public class HandlerClass implements ItemListener { 
		private Font font;
		
		public HandlerClass(Font f) { 
			font = f;
		}
		
		public void itemStateChanged (ItemEvent event) {
			txt.setFont(font);
		}
		
	}

}
