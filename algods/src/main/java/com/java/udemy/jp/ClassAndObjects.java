package com.java.udemy.jp;

class Person{
	String name;
	int age;
	public Person(String n, int a) {
		this.name=n;
		this.age=a;
	}
	String getName() {
		return this.name;
	}
	int getAge() {
		return this.age;
	}
}
public class ClassAndObjects {
	public static void main(String[] args) {
		Person jeff=new Person("Jeff",30);
		System.out.println("Name: "+jeff.getName()+", Age: "+jeff.getAge());
	}
}
