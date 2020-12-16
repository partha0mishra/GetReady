package com.java.udemy.jp;

class Person {
	static int num=0;
	final int x;
	String name;
	public static void showName() {
		// System.out.println(name); 
		// WONT WORK
		// We may not have an object when the class is there
	}
	public int getNum() {
		// instance method can access static variables
		// coz when we have an object, the class is already there
		return num;
	}
	int age;
	public Person(String n) {
		this(n,0);
		// "this" keyword to call another constructor.
		// has to be the first line
	}
	public Person(String n, int a) {
		this.name = n;
		this.age = a;
		num+=1;
		x=age %10;// that's the only time it's set
	}

	String getName() {
		return this.name;
	}

	int getAge() {
		return this.age;
	}
	
	void tellName() {
		System.out.println("Hallo, ich bin "+name+" !!");
	}
	
	void futileChangeAge(int age) {
		age=age;
	}
}

public class ClassAndObjects {
	public static void main(String[] args) {
		Person jeff = new Person("Jeff", 30);
		Person sarah = new Person("Sarah", 40);
		Person[] people = new Person[2];
		people[0] = jeff;
		people[1] = sarah;
		for (int i = 0; i < people.length; i++) {
			System.out.println("Name: " + people[i].getName() + ", Age: " + people[i].getAge());
			people[i].tellName();
		}
		System.out.println("Age :"+jeff.getAge());
		jeff.futileChangeAge(20);
		System.out.println("Age :"+jeff.getAge());
		System.out.println("Number of people: "+Person.num);
	}
}
