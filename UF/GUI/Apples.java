package GUI;
import javax.swing.JOptionPane;

public class Apples {
	public static void main(String[] args) {
		
		String nome = JOptionPane.showInputDialog("Nome");
		String cpf = JOptionPane.showInputDialog("CPF");
		String idade = JOptionPane.showInputDialog("Idade");
		String universidade = JOptionPane.showInputDialog("Universidade");
		String curso = JOptionPane.showInputDialog("Curso");
		String dados = nome+"/n "+cpf+" "+idade+" "+universidade+" "+curso;
		
		/*
		int num1 = Integer.parseInt(number1);
		int num2 = Integer.parseInt(number2);
		int sum = num1 + num2;
		*/
		
		JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso", "Cadastro", JOptionPane.PLAIN_MESSAGE);
	}
}
