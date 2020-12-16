package com.java.udemy.jp;

import java.util.Scanner;

public class GettingUserInput {
	public static void main(String[] args) {
		// scanner object
		Scanner scanner= new Scanner(System.in);
		// prompt
		System.out.println("Enter a line of text: ");
		// wait for the user input
		String line=scanner.nextLine();
		// Show it back
		System.out.println(line);
		
		// Double value
		System.out.println("Enter a double value: ");
		// get the value
		double d=scanner.nextDouble();
		// Show it
		System.out.println(d);
	}
}
