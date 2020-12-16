package com.java.udemy.jp;

import java.util.Scanner;
public class DoWhileLoop {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int num=0;
		do {
			System.out.println("How many times you want to print (enter 5):");
			num=scanner.nextInt();
		}while(num !=5);
		System.out.println("got "+num);
	}
}
