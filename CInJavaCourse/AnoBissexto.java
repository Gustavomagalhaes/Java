import java.util.Scanner;

public class AnoBissexto {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Digite o ano: ");
		int ano = input.nextInt();
		
		if (ano < 0){
			System.out.println(ano+" nao e um ano valido");
		} else {
			if ((ano%4==0) && ((ano%100!=0) || (ano%100==0) && (ano%400==0))){
				System.out.println(ano+" e bissexto");
			} else {
				System.out.println(ano+" nao e bissexto");
			}
		}
	}
}
