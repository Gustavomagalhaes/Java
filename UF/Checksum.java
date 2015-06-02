
//Gustavo Magalhaes Pereira. Checksum.java

import java.util.Scanner;

public class Checksum {
				
	public static void main(String args[]) {
		
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number: ");
		String number = input.nextLine();
		
		//(b)69965579276730427686282958494648749061031820236938

		//(c)55965579276730427636282958434648743061031820236938

		int[] brokenCode = new int[] {
				Integer.parseInt(number.substring(0,5)),
				Integer.parseInt(number.substring(5,10)),
				Integer.parseInt(number.substring(10,15)),
				Integer.parseInt(number.substring(15,20)),
				Integer.parseInt(number.substring(20,25)),
				Integer.parseInt(number.substring(25,30)),
				Integer.parseInt(number.substring(30,35)),
				Integer.parseInt(number.substring(35,40)),
				Integer.parseInt(number.substring(40,45)),
				Integer.parseInt(number.substring(45,50))
				};
		
		int checksum = calculateChecksum(brokenCode);
				    
		System.out.println("Checksum is " + checksum);
				  
	}
	
	public static int calculateChecksum(int[] arr) { 	
		int a = 0;
		int len = arr.length;
		for (int i = 0; i < len; i = i + 1) {
			int c = len - 1 - i;
			a = a + arr[i] * (int)Math.pow(10, c); }
		return -(a%10); 
	}
} 

