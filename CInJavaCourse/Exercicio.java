import java.util.Scanner;
// Syso + Ctrl + Space for Windows

public class Exercicio {
	public static void main(String[] args){

//Exercicio 1

		System.out.print("Digite um numero: ");
		Scanner input = new Scanner(System.in);
		int numero = input.nextInt();
		int i = 1;
		if (numero%2==0){
			System.out.println("Par");
		} if (numero%3 == 0){
			System.out.println("Multiplo de 3");
		} while (i <= 10){
			System.out.println(numero*i);
			i +=1;
		}
		
//Exercicio 3
		
		System.out.print("Digite um numero: ");
		int num1 = input.nextInt();
		System.out.print("Digite um numero: ");
		int num2 = input.nextInt();
		System.out.print("Digite um numero: ");
		int num3 = input.nextInt();
		
		System.out.println(num1*num2*num3 + " <- Produto");

//Exercicio 3

		if ((num1>num2) && (num1>num3)){
			System.out.print(num1 + " <- Maior");
		} else if ((num2>num1) && (num2>num3)){
			System.out.print(num2 + " <- Maior");
		} else if ((num3>num1) && (num3>num2)){
			System.out.print(num3 + " <- Maior");
		} else { 
			System.out.print("Numero maior repetido: ");
		}
	}
}
	