package homework2;

//Gustavo Magalhaes Pereira. Checksum.java

import java.util.Random;

public class Checksum {
				
	public static int calculateChecksum(int[] arr) { 	
		int a = 0;
		int len = arr.length;
		for (int i = 0; i < len; i = i + 1) {
			int c = len - 1 - i;
			a = a + arr[i] * (int)Math.pow(10, c); }
		return -(a%10); 
	}
	
	private static int[] makeRandDigits(int len) {
		int[] array = new int[len];
		Random generator = new Random();
		for (int i = 0; i < len; i++) {
			array[i] = generator.nextInt(9);
		}
		return array;
	}
	
	private static String arrToString(int[] arr) {
		String arrstr = "";
		for (int i = 0; i < arr.length; i++) {
			arrstr = arrstr + arr[i];
		} 
		return arrstr;
	}
	
	private static String concatDigits(int[] arr) {
		String arrstr = "";
		for (int i = 0; i < arr.length; i++) {
			arrstr = arrstr + arr[i];
		} 
		return arrstr;
	}

	private static int[] breakCode(String code) {
		int times = code.length()/5;
		int[] brokenCode = new int[times];
		int count = 0;
		for (int i = 0; i < times; i++) {
			brokenCode[i] = Integer.parseInt(code.substring(count,count+5));
			count=count+5;
		}
		return brokenCode;
	}
	
	public static void main(String args[]) {		
		int[] arr = makeRandDigits(50);
		HW2_part1.printArray(arr);
		String code = arrToString(arr);
		System.out.println(concatDigits(arr));
		int[] brokenCode = breakCode(code);
		int checksum = calculateChecksum(brokenCode);
		System.out.println("Checksum is " + checksum);		  
	}
} 

