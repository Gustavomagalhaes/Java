public class UF1 {

	public static void main(String[] args) {
		System.out.println("HELLO WORLD");

		// ------------------- signed Integers in Java ---------------------
		//
		// byte = 1 byte (2**1)*2 = 4-bit
		// short = 2 bytes (2**2)*2 = 8-bit
		// int = 4 bytes (2**4)*2 = 32-bit
		// long = 8 bytes (2**8)*2 = 64-bit
		//
		// ------------------------- Floating points -----------------------
		//
		// float = 32 bit
		// double = 64 bit

		int a = Integer.MAX_VALUE; // Maximum of 10 digits
		int b = -1;
		int c = a + b;

		System.out.println(a + " plus " + b + " is " + c);

		// ------------------------ CONDITIONALS ---------------------------

		int var1 = 9;
		if (var1 < 10)
			System.out.println("Conditional test");
		if (var1 == 10)
			System.out.println("FAIL");

		if (var1 < 10) {
			System.out.println("Conditional test 2");
			if (var1 == 9)
				System.out.println("Working!");
		}

		float x = 0;
		float y = .01f;

		if (x * x + y * y < 1)
			System.out.println("Inside the circle");
		else if (x * x + y * y == 1)
			System.out.println("On the circle");
		else
			System.out.println("Outside the circle");

		// Question: Which value of variable make the condition true in each
		// case supposing
		// variable was declared to be an int?

		myMethod();
		int variable = 25;
		if (variable < 100)
			System.out.println("99 or lower. Including negative numbers");
		if (variable < 100 && variable >= 0)
			System.out.println("From 0 to 99");
		if (variable < 100 && variable % 2 == 0 && variable >= 0)
			System.out
					.println("Positive numbers lower than 100 divisible by 2");
		if (variable % 2 == 0 && variable % 3 == 0 && variable >= 0)
			System.out.println("Divisible by 2 AND 3 and a positive number");
		if ((variable % 2 == 0 || variable % 3 == 0) && variable >= 0)
			System.out.println("Divisible by 2 OR 3 and a positive number");

		// ------------------------- LOOPS and ARRAYS ----------------------

		// System.out.println("\n"); ERROR
		// int i;
		// int[] arr = new int[100];
		// for (i = 100; i >= 0; i = i-1)
		// {
		// if (i%2 == 0 || i%3 == 0){
		// System.out.print(i + " ");
		// arr[i] = 1;
		// }
		// else
		// arr[i] = 0;
		// }
		//
		// int sum = 0;
		// for (int j = 0; j < 100; j++)
		// sum = sum + arr[j];
		// System.out.print(arr[sum] + " ");

		// --------------------- INTEGER REPRESENTATIONS ------------------
		// BINARY base-2 needs 2 digits. 1 or 0
		// DECIMAL base-10 needs 10 digits. 0 - 9
		// HEXADECIMAL base-16 needs 16 digits. 0 - F

		// f b (16) == 15*16^2-1 + 11*16^1-1 ---> 240 + 11 = 251(10)

		// Unicode takes 2 bytes(16 bits) represented by 4 groups of 4.

		// 16 bits have 2^16 = 65536 characters.

		// 1010011(2) == 1*2^6 + 0*2^5 + 1*2^4 + 0*2^3 + 0*2^2 + 1*2^1 + 1.
		// == 64 + 16 + 2 + 1 == 83(10)

		// Maximum value of LONG = (2^64)/2 = 2^64

		// a / b if it is a float or int in the operator (b) it's going to be a
		// float or int division.

		float[] array1 = new float[90];
		int[] array2 = new int[100];
		System.out.print("\n");
		System.out.println(array1.length);
		System.out.println(array2.length);
		
		for (int i = 0; i < array1.length; i++) //If i <= array.length RUNTIME ERROR 
			array1[i] = (float) (i+1.5);
		
		myMethod();
		System.out.println(array1[0]);
		System.out.println(array1[1]);
		System.out.println(array1[2]);
		
		myMethod();
		System.out.println(sumInterval(1,10));
		
		myMethod();
		int s1 = sumInterval(1,3);
		int s2 = sumInterval(4,7);
		int s3 = sumInterval(8,10);
		
		System.out.println("Sum of " + (s1+s2+s3));
		
		myMethod();
		
		//abs(int a) return the absolute value of an int value. HOMEWORK
		//pow(double a, double b)
		
		System.out.println((-3)%5);
		
	}
	
	public static int sumInterval(int a, int b) {
		int sum = 0;
		for (int i = a; i <= b; i++)
			sum = sum+i;
		return sum;
	}
	
	public static void myMethod() { 
		System.out.println("\n* Developed by Gustavo Magalhaes Pereira *\n");
	}
	
}
