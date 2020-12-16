package com.java.udemy.jp;

public class IfStatement {
	public static void main(String[] args) {
		if(4 == 4) System.out.println("True");
		int time=10;
		if(time > 6) System.out.println("Good morning");
		
		
		int loop=0;
		while(loop < 10) {
			System.out.println(loop++);
			if(loop ==5) break;
		}
	}
}
