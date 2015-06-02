package homework4;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

// 14.19 (Count words) Write a program that counts the 
// number of words in President Abraham Lincoln's Gettysburg
// address from http://cs.armstrong.edu/liang/data/Lincoln.txt .

public class Exercise3 {
	
	public static void main(String[] args) throws IOException {
		String address = "http://cs.armstrong.edu/liang/data/Lincoln.txt";
		URL url = new URL(address);
		Scanner input = new Scanner(url.openStream());
		int count = 0;
		while (input.hasNextLine()) {
			String line = input.nextLine();
			if (!line.isEmpty()) {
				String[] words = line.split(" ");
				count += words.length;
			}
		}
		System.out.println(count+" words");
		input.close();
		}
	}