package com.java.udemy.jp;

interface Executable{
	public void execute();
}
class Runner{
	public void run(Executable e) {
		System.out.println("Executing code block ...");
		e.execute();
	}
}
public class Lambda {
	public static void main(String[] args) {
		// Java 6/ 7 way of executing other code
		Runner runner= new Runner();
		runner.run(new Executable(){
			public void execute() {
				System.out.println("hello there");
			}
		});
	}
}
