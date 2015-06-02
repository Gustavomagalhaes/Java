/* Tipos primitivos ->
 * (boolean , char , short int ou long , float ou double.)
 * double variavel = 100.2;
 * float variavel = 100.2f;
 * char variavel = 'a';
 * String e uma classe e nao um tipo primitivo.
 * (&& and) (|| or)
 * Operadores Unarios: ++(+1) --(-1) -(negativo) !(not)
 * Operador Condicional (ternario): a = x ? b : c; boolean x = true or false.
 * Casting ->
 * int teste1 = 10;
 * int teste2 = 5;
 * float result = (float) teste1/teste2;
 */
package ModelsCIn;
import java.util.Scanner;

public class Tools1 {
	//Modificador public permite acessar a classe em outra classe.
	public static void main(String[] args){ // Metodo main eh executado junto com o programa.
		int var1 = 10;
		float var2 = 10.0f;
//		private String variavel = "1234"; //Modificador private so permite acessar a variavel dentro da classe
		
		System.out.println("Estruturas de controle"); // Metodo da API Java para imprimir. 
		
		if (var1 >= var2) {
			// instrucao 1
			System.out.println("v1 maior v2");
		} else if (var1 <= var2) {
			// caso instrucao 1 falhe
			System.out.println("v1 menor v2");
		} else {
			// caso todas falhem
			System.out.println("NADA");
		}
		switch (var1) {
		case 10:
			// Caso a var1 tiver valor 10
			System.out.println("var1 eh 10");
			break;								// Precisa utilizar break em cada case.
		case 20:
			System.out.println("var1 eh 20");
			break;
		default:
			// Caso nenhum case esteja definido
			System.out.println("default");
		}
		
//		//Tipo de retorno: VOID (nao necessita retorno)
//		public void metodo(String teste) {
//			System.out.println("Metodo "+teste);
//		}
		
		/* Garbage Collector elimina objetos da memoria quando
		 * nao sao mais referenciados.
		 */
		
		/* Modificadores:
		 * public		- (classe, atributos e metodos)
		 * protected	- (atributos e metodos para mesmo pacote)
		 * private		- (atributos e metodos para mesma classe)
		 * static		- (atributos e metodos para mesmo pacote)
		 * final
		 * native
		 * transient
		 * synchronized
		 */

		System.out.println("Modulo 4");
		/* Variavel primitiva guarda seu valor
		 * Variavel de objeto guarda um endereco para ele.
		 */
		
		String x = "teste";
		String y = "Teste";
		boolean resultado;
		
		resultado = x.equals(y); // Retorna true ou false da igualdade
		System.out.println(resultado);
		
		resultado = x.equalsIgnoreCase(y); // Ignora maiusculas
		System.out.println(resultado);
		
		String texto = "vamos achar as palavras";
		int comeco = texto.indexOf("achar"); // Mostra o comeco da palavra
		System.out.println(comeco);
		
		String pegarParte = texto.substring(0,4); // pega uma string do indice
		System.out.println(pegarParte);          // 0 ate o 3.
		
		char letter = texto.charAt(1); // pega uma letra no indice
		System.out.println(letter);
		
		
		/////////////////////////////////////////
		Scanner input = new Scanner(System.in);
		/////////////////////////////////////////
		
		System.out.println("Digite um nome: ");
		String palavra = input.nextLine();
		
		System.out.print("Digite a idade: ");
		int numero = input.nextInt();

		System.out.println(palavra+" "+numero);
		
		int tamanho = palavra.length();
		System.out.println("tamanho "+tamanho);
	}
}
