package homework4;

import java.util.Random;
import java.util.Scanner;

// 14.3 (ArrayIndexOutOfBoundsException) Write a program that meets the 
// following requirements:
//		*Creates an array with 100 randomly chosen integers.
//		*Prompts the user to enter the index of the array, then displays
//		 the corresponding element value. If the specified index is out
//		 of bounds, display the message Out of Bounds.

public class Exercise2 {
	
	public static void main(String[] args) {
		int[] array = new int[100];
		Random generator = new Random();
		
		for (int i=0; i<100; i++) {
			array[i] = generator.nextInt(100);
		}
		try {
			@SuppressWarnings("resource")
			Scanner input = new Scanner(System.in);
			System.out.print("Enter the index of the array: ");
			int index = input.nextInt();
			System.out.println(array[index]);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Out of Bounds");
		}
	}
}
