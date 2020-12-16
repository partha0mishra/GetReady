package com.java.udemy.jp;

class Person {
	String name;
	int age;

	public Person(String n, int a) {
		this.name = n;
		this.age = a;
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
	}
}
