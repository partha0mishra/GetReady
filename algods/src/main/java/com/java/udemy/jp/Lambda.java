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

interface Exec2{
	public int exec();
}

class Runner2{
	public void run(Exec2 e) {
		System.out.println("new runner run ");
		int value=e.exec();
		System.out.println("Returned value: "+value);
	}
}
// () -> System.out.println("hello there")

/*
 * () -> {
			System.out.println("putting multiple statements");
			System.out.println("hello there");
		}
 */
// () -> 42
/*
 * () -> {
 * 		return 42;
 * 		}
 */
/*
 * () -> {
			System.out.println(">> Lambda returning value");
			return 42;
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
		System.out.println("== returning a value ==");
		new Runner2().run(() -> 42);
		new Runner2().run(() -> {
			System.out.println(">> Lambda returning value");
			return 42;
		});
	}
}
