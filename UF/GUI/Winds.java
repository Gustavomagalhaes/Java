package GUI;
import java.util.Scanner;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Winds extends JFrame {

	private JLabel item1;
	
	public Winds () {
		super ("Título da minha janela");
		setLayout (new FlowLayout());
		
		/*
		Scanner input = new Scanner(System.in);
		System.out.print("Digite um texto: ");
		String texto = input.nextLine();
		*/
		
		item1 = new JLabel ("texto");
		item1.setToolTipText("Gustavo também");
		add(item1);
	}
}
