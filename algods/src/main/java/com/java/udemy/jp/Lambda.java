package com.java.udemy.jp;

interface Executable{// functional interface - an interface with a single method. e.g. comparable/ runnable
	public void execute();
}
class Runner{
	public void run(Executable e) {
		System.out.println("Executing code block ...");
		e.execute();
	}
}
// () -> System.out.println("hello there")
/*
 * () -> {
			System.out.println("putting multiple statements");
			System.out.println("hello there");
		}
 */

public class Lambda {
	public static void main(String[] args) {
		// Java 6/ 7 way of executing other code
		Runner runner= new Runner();
		runner.run(new Executable(){
			public void execute() {
				System.out.println("hello there");
			}
		});
		System.out.println("================================");
		// Lambda way
		runner.run(() -> System.out.println("hello there"));
		System.out.println("======== Passing multiple lines of code ========");
		runner.run(() -> {
			System.out.println("putting multiple statements");
			System.out.println("hello there");
		});
	}
}
