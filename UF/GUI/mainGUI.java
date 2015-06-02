package GUI;
import javax.swing.JFrame;

public class mainGUI {
	public static void main(String[] args) {
		
//		Winds janela = new Winds();
		//TextoSenha janela = new TextoSenha();
		ButtonGUI janela = new ButtonGUI();
//		Check janela = new Check();
//		Radio janela = new Radio();
//		Combo janela = new Combo();
//		Lists janela = new Lists();
//		MultiList janela = new/ MultiList();
//		Mouse janela = new Mouse();
		
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setSize(300, 200);
		janela.setVisible(true);
	}
}
