

package homework4;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.*;

@SuppressWarnings("serial")
public class PokerGame extends JFrame {
	
	public static final int SET_SIZE = 8;
	public static final int NUMBER_RANGE = 52;
	
	public JPanel row = new JPanel(new GridBagLayout());
	public GridBagConstraints c = new GridBagConstraints();

	public JFrame frame = new JFrame("Controler");
	public JButton deal = new JButton("Deal");
	public JButton shuffle = new JButton("Shuffle");
	public JButton startOver = new JButton("Start Over");

	public JButton label1 = new JButton(); 
	public JLabel label2 = new JLabel();
	public JLabel label3 = new JLabel();
	public JLabel label4 = new JLabel();
	public JButton label5 = new JButton();
	public JLabel label6 = new JLabel();
	public JButton label7 = new JButton(); 
	public JLabel label8 = new JLabel();
	
	public int card1;
	public int card2;
	public int card3;
	public int card4;
	public int card5;
	public int card6;
	public int card7;
	public int card8;
	
	public Integer[] cardIndex = new Integer[SET_SIZE];
	
	public boolean shufflePressed = false;
	public int clicks = 0;
	
	public String path = "/Users/gustavopereira/Documents/Eclipse/UF/src/homework4/cards/";
	public String imageType = ".png";
	
	public PokerGame () {
		
		frame.setLayout(new GridLayout(1,3));
		frame.setLocation(600,600);
		frame.setSize(500,100);
		
		frame.add(deal);
		deal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (shufflePressed) {
					
					clicks++;
					
					if (clicks == 1) {
						System.out.println("3 cards");
						
						card1 = cardIndex[0];
						card2 = cardIndex[1];
						card3 = cardIndex[2];
						card4 = cardIndex[3];
						
						label1.setIcon(new ImageIcon(path+"b1fv"+imageType));
						
						c.gridx = 0;
						c.gridy = 0;
						c.insets = new Insets(5,5,5,5);
						row.add(label1,c);
						label1.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								label1.setIcon(new ImageIcon(path+card1+imageType));
							}});
						
						label2.setIcon(new ImageIcon(path+card2+imageType));
						label3.setIcon(new ImageIcon(path+card3+imageType));
						label4.setIcon(new ImageIcon(path+card4+imageType));
						
						c.gridx = 0;
						c.gridy = 1;
						row.add(label2,c);
						
						c.gridx = 1;
						c.gridy = 1;
						row.add(label3,c);
						
						c.gridx = 2;
						c.gridy = 1;
						row.add(label4,c);
						
					} else if (clicks == 2) {
						System.out.println("+1 card");
						
						card5 = cardIndex[4];
						card6 = cardIndex[5];
						
						label5.setIcon(new ImageIcon(path+"b1fv"+imageType));
						c.gridx = 1;
						c.gridy = 0;
						row.add(label5,c);
						label5.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								label5.setIcon(new ImageIcon(path+card5+imageType));
							}});
						
						label6.setIcon(new ImageIcon(path+card6+imageType));
						c.gridx = 3;
						c.gridy = 1;
						row.add(label6,c);
						
					} else if (clicks == 3) {
						System.out.println("Last card");
						
						card7 = cardIndex[6];
						card8 = cardIndex[7];
					
						label7.setIcon(new ImageIcon(path+"b1fv"+imageType));
						c.gridx = 2;
						c.gridy = 0;
						row.add(label7,c);
						label7.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								label7.setIcon(new ImageIcon(path+card7+imageType));
							}});
						
						label8.setIcon(new ImageIcon(path+card8+imageType));
						c.gridx = 4;
						c.gridy = 1;
						row.add(label8,c);
						
					} else {
						System.out.println("End of game");
					}
					
					add(row);
					validate();
				} else {
					System.out.println("Shuffle the cards first");
				}}});
				
			
		frame.add(shuffle);
		shuffle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (clicks == 0) {
					System.out.println("SHUFFLED");
					shufflePressed = true;
					
					Random random = new Random();
					
					Set<Integer> set = new HashSet<Integer>(SET_SIZE);
					
					while (set.size() < SET_SIZE) {
						while (set.add(random.nextInt(NUMBER_RANGE)+1) != true);
					}
					assert set.size() == SET_SIZE;
					cardIndex = set.toArray(new Integer[0]);
				
				} else {
					System.out.println("Game already started. Can't shuffle.");
				}}});
				
		
		frame.add(startOver);
		startOver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				row.removeAll();
				row.updateUI();
				shufflePressed = false;
				clicks = 0;
				
				System.out.println("Start Over");
			}});
		
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		
		PokerGame window = new PokerGame();
		window.setTitle("Poker Game: Flop-Turn-River");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,300);
		window.setLocation(600,280);
		window.setVisible(true);
	
	}
	private class Evt implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			
		}
	}
}
