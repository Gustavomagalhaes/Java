package homework4;

import java.util.Scanner;

// 14.1 (NumberFormatException) Listing 9.5, Calculator.java, is a simple 
// command-line calculator. Note that the program terminates if any
// operand is nonnumeric. Write a program with an exception handler that
// deals with nonnumeric operands; Your program should display a message
// that informs the user of the wrong operand type before exiting.

public class Exercise1 {

	public static void main(String[] args) {
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.print("Calculator: ");
			String index = input.nextLine();
			
			int result = 0; 
			String[] tokens = index.split(" ");
			
			switch (tokens[1].charAt(0)) {
				case '+': result = Integer.parseInt(tokens[0]) + Integer.parseInt(tokens[2]);
				break;
				case '-': result = Integer.parseInt(tokens[0]) - Integer.parseInt(tokens[2]);
				break;
				case '*': result = Integer.parseInt(tokens[0]) * Integer.parseInt(tokens[2]);
				break;
				case '/': result = Integer.parseInt(tokens[0]) / Integer.parseInt(tokens[2]);
				break;
				default: System.out.println("Invalid operator");
				System.exit(1);
			}
		System.out.println(tokens[0] + ' ' + tokens[1] + ' ' + tokens[2] + " = " + result);
		} catch (NumberFormatException e) {
			System.out.println("Wrong operand type: Nonnumeric");
		}
	}
}
