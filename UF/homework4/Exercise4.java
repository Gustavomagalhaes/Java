package homework4;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.*;

// 12.9 (Game: display three cards) Display a frame that contains 
// three labels. Each label displays a card. All three cards are 
// distinct and selected randomly.

@SuppressWarnings("serial")
public class Exercise4 extends JFrame {
	
	public static final int SET_SIZE = 3;
	public static final int NUMBER_RANGE = 54;
	
	JPanel jp = new JPanel();
	JLabel label1 = new JLabel();
	JLabel label2 = new JLabel();
	JLabel label3 = new JLabel();
	
	public int card1;
	public int card2;
	public int card3;
	
	public Exercise4 (Integer[] cardIndex) {
		this.card1 = cardIndex[0];
		this.card2 = cardIndex[1];
		this.card3 = cardIndex[2];
		
		String path = "/Users/gustavopereira/Documents/Eclipse/UF/src/homework4/cards/";
		String imageType = ".png";
		
		label1.setIcon(new ImageIcon(path+card1+imageType));
		label2.setIcon(new ImageIcon(path+card2+imageType));
		label3.setIcon(new ImageIcon(path+card3+imageType));
		
		jp.add(label1);
		jp.add(label2);
		jp.add(label3);
		
		add(jp);
		validate();
	}
	
	public static void main(String[] args) {
		
		Integer[] cardIndex = new Integer[SET_SIZE];
		Random random = new Random();
		Set<Integer> set = new HashSet<Integer>(SET_SIZE);
		
		while (set.size() < SET_SIZE) {
			while (set.add(random.nextInt(NUMBER_RANGE)+1) != true);
		}
		assert set.size() == SET_SIZE;
		cardIndex = set.toArray(new Integer[0]);
		
		Exercise4 window = new Exercise4(cardIndex);
		
		window.setTitle("Game: display three cards");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(500,500);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
//		window.pack();

	}
}
