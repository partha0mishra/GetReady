package com.java.udemy.jp;

interface Executable{// functional interface - an interface with a single method. e.g. comparable/ runnable
	public void execute();
}
interface Exec2{
	public int exec();
}
interface Exec3{
	public int exec(int a);
}
interface Exec4{
	public int exec(int a, int b);
}
class Runner{
	public void run(Executable e) {
		System.out.println("Executing code block ...");
		e.execute();
	}
	public void run(Exec2 e) {
		System.out.println("run with exec 2 ");
		int value=e.exec();
		System.out.println("Returned value: "+value);
	}
	public void run(Exec3 e) {
		System.out.println("run with exec 3 ");
		int value=e.exec(2);// of no use
		System.out.println("Result "+value);
	}
	public void run(Exec4 e) {
		System.out.println("run with exec 3 ");
		int value=e.exec(2,3);// overridden if other values are supplied
		System.out.println("Result "+value);
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
// (int a) -> 8
/* 
 * (int a) -> {
			System.out.println("Passed Value: "+a);
			return a*a;
			}
 */
// (a, b) -> 1
// (int a, int b) -> 1
/* 
 * (a, b) -> {
			System.out.println("Passed Values: "+a+", "+b);
			return a*b;
		}
 */
/*
 * (int a, int b) -> {
			System.out.println("Passed Values: "+a+", "+b);
			return a*b;
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
		runner.run(() -> 42);
		runner.run(() -> {
			System.out.println(">> Lambda returning value");
			return 42;
		});
		
		runner.run((int a) -> 8);
		runner.run((int a) -> {
			System.out.println("Passed Value: "+a);
			return a*a;
		});
		runner.run((int a, int b) -> 1);// static value return
		runner.run((int a, int b) -> {
			System.out.println("Passed Values: "+a+", "+b);
			return a*b;
		});
		runner.run((a, b) -> 1);// inferred type parameters
		runner.run((a, b) -> {
			System.out.println("Passed Values: "+a+", "+b);
			return a*b;
		});
	}
}
