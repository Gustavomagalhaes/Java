import java.util.Scanner;

public class palidromo {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Digite a palavra: ");
		String word = input.nextLine();
		String wordReverse = "";
		
		for (int i = 0; i < word.length(); i++){
			wordReverse = word.substring(i,i+1)+wordReverse;
		}
		if (word.equalsIgnoreCase(wordReverse)){
			System.out.println("Palindromo");
		} else {
			System.out.println("Nao e palindromo");
		}
	}

}
