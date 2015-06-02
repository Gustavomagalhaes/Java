package homework4;

import java.awt.Color;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); 
		frame.setTitle("Timer: Gustavo Magalhães Pereira"); 
		frame.setLocationRelativeTo(null); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		JLabel label = new JLabel();
		label.setFont(new Font("Monospaced", Font.PLAIN,100));
		label.setForeground(Color.BLACK); 
		label.setBackground(new Color(1.f, 1.f, 1.f)); 
		label.setOpaque(true);
		DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		long lastTime = 0, currTime; Calendar cal;
		while (true) {
			currTime = System.currentTimeMillis(); 
			if (currTime - lastTime > 1000) {
			lastTime = currTime;
			cal = Calendar.getInstance(); label.setText(dateFormat.format(cal.getTime()))
			; frame.add(label); frame.pack();
			} 
		}
	}
}
