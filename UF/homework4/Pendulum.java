package homework4;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
 
@SuppressWarnings("serial")
public class Pendulum extends JPanel implements Runnable {
 
    private double angle = Math.PI / 2;
    private int length;
    private double velocity = 0.1;
    private double resume;
    private boolean stopped = false;
    
    JFrame frame = new JFrame("Controler");
    
    JButton upButton = new JButton("Up");
    JButton downButton = new JButton("Down");
    JButton stopButton = new JButton("Stop");
    JButton resumeButton = new JButton("Resume");
 
    public Pendulum(int length) {
        this.length = length;
        setDoubleBuffered(true);
        frame.setLayout(new GridLayout(2,2));
        frame.setLocationRelativeTo(null);
        frame.setSize(300, 300);
        
        frame.add(upButton);
        upButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVelocityUp();
			}});
        
        frame.add(downButton);
        downButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVelocityDown();
			}});
        
        frame.add(stopButton);
        stopButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVelocityStop();
			}});
        
        frame.add(resumeButton);
        resumeButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				setVelocityResume();
			}});
        frame.setVisible(true);
    }
 
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());
        g.setColor(Color.BLACK);
        int anchorX = getWidth() / 2, anchorY = getHeight() / 4;
        int ballX = anchorX + (int) (Math.sin(angle) * length);
        int ballY = anchorY + (int) (Math.cos(angle) * length);
        g.drawLine(anchorX, anchorY, ballX, ballY);
        g.fillOval(anchorX - 3, anchorY - 4, 7, 7);
        g.fillOval(ballX - 7, ballY - 7, 14, 14);
    }
 
    public double getVelocity() {
    	return velocity;
    }
    
    public void setVelocityUp() {
    	if (stopped == false) {
    		velocity = velocity + 0.1;
    		System.out.println("VELOCITY UP: "+getVelocity());
    	} else {
    		System.out.println("RESUME TO CONTINUE");
    	}
    }
    
    public void setVelocityDown() {
    	if (stopped == false) {
	    	if (velocity-0.1 < 0.0) {
	    		velocity = 0.0;
	    		System.out.println("Velocity already zero");
	    	} else {
	    		velocity = velocity - 0.1;
	    		System.out.println("VELOCITY DOWN: "+getVelocity());
	    	}
    	} else {
    		System.out.println("RESUME TO CONTINUE");
    	}
    }
    
    public void setVelocityStop() {
    	if (velocity == 0.0) {
    		System.out.println("ALREADY STOPPED: "+getVelocity());
    		stopped = true;
    	} else {
    		resume = getVelocity();
    		velocity = 0.0;
    		stopped = true;
    		System.out.println("STOPPED: "+getVelocity());
    	}
    }
    
    public void setVelocityResume() {
    	if (stopped == false) {
    		System.out.println("NOT STOPPED: "+getVelocity());
    	} else {
    	velocity = resume;
    	stopped = false;
    	System.out.println("RESUMED: "+getVelocity());
    	}
    }
    
    public void run() {
        double angleAccel;
        double angleVelocity = 0.0;
        while (true) {
            angleAccel = -9.81 / length * Math.sin(angle);
            angleVelocity += angleAccel * getVelocity();
            angle += angleVelocity * getVelocity();
            repaint();
            try { 
            	Thread.sleep(15); 
            } catch (InterruptedException ex) {}
        }
    }
 
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(2 * length + 50, length / 2 * 3);
    }
 
    public static void main(String[] args) {
        JFrame f = new JFrame("Pendulum");
        Pendulum p = new Pendulum(200);
        f.add(p);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocation(200, 200);
        f.setSize(500, 500);
        f.setVisible(true);
        new Thread(p).start();
    }
    
    private class Evt implements ActionListener {
    	public void actionPerformed(ActionEvent arg0) {
    		
    	}
    }
}
