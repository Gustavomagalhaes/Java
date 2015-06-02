package homework2;

//Gustavo Magalhaes Pereira. HW2_part1.java

public class HW2_part1 {

	public static void printArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		} System.out.println();
	}
	
	public static int[] posDivisors(int x) {
		int count = 0;
		for (int i = 1; i <= x; i++) {
			if (x%i==0)
				count++;
		}
		int[] div = new int[count];
		int index = 0;
		for (int j = 1; j <= x; j++) {
			if (x%j==0) {
				div[index] = j;
				index++;
			}
		} 
		return div;
	}
	
	public static boolean isPrime(int x) {
		for (int i = 2; 2*i<x; i++) {
			if (x%i==0)
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int[] p = posDivisors(35);
		printArray(p);
		int x = 3511;
		System.out.println(isPrime(x));
		x = 3513;
		System.out.println(isPrime(x));
	}
	
	
}
