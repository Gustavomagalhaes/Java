package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mouse extends JFrame {
	
	private JPanel mousepanel;
	private JLabel statusbar;
	
	public Mouse() {
		super("Mouse Events");
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.WHITE);
		add(mousepanel, BorderLayout.CENTER);
		
		statusbar = new JLabel ("default");
		add(statusbar, BorderLayout.SOUTH); // bottom of the screen
		
		Handlerclass handler = new Handlerclass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
	}
	
	private class Handlerclass implements MouseListener, MouseMotionListener {
		public void mouseClicked (MouseEvent event) {
			statusbar.setText(String.format("Clicked at %d,%d", event.getX(), event.getY()));
		}
		public void mousePressed (MouseEvent event) {
			statusbar.setText("You pressed down the mouse");
		}
		public void mouseReleased (MouseEvent event) {
			statusbar.setText("You released the button");
		}
		public void mouseEntered (MouseEvent event) {
			statusbar.setText("You entered the area");
			mousepanel.setBackground(Color.BLUE);
		}
		public void mouseExited (MouseEvent event) {
			statusbar.setText("The mouse had left the window");
			mousepanel.setBackground(Color.WHITE);
		}
		// These are mouse motion event
		public void mouseDragged(MouseEvent event) {
			statusbar.setText("You are dragging the mouse");
			
		}
		public void mouseMoved(MouseEvent event) {
			statusbar.setText("You moved the mouse");
		}
	}

}
