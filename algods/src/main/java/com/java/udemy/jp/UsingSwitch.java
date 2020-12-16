package com.java.udemy.jp;

import java.util.Scanner;

public class UsingSwitch {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		System.out.println("Please enter a command: ");
		String cmd=scanner.nextLine();
		switch(cmd.toLowerCase()) {
		case "up":
			System.out.println("going up ... ");
			break;
		case "down":
			System.out.println("going down ...");
			break;
		default:
			System.out.println("... just idling ...");
		}
	}

}
