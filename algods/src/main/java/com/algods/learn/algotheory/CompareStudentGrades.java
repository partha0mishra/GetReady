package com.algods.learn.algotheory;
/* Implement a Comparator<> Interface
 * 
 */
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Collections;

public class CompareStudentGrades {
	class Student{
		private String name;
		private int grade;
		public Student(String n, int g) {this.name=n;this.grade=g;}
		public int getGrade() {return this.grade;}
		public String getName() {return this.name;}
	}
	class StudentComparator implements Comparator<Student>{
		@Override
		public int compare(Student o1, Student o2) {
			int diff=o1.grade - o2.grade;
			if(diff == 0) return o1.name.compareTo(o2.name);
			else return diff;
		}
	}
	public static void main(String[] args) {
		CompareStudentGrades instance= new CompareStudentGrades();
		String[] names= {"one","two","three","four","five","six","seven","eight","nine","ten"};
		ArrayList<Student> students= new ArrayList<Student>();
		Random random= ThreadLocalRandom.current();
		for(int i=0; i<100; i++) {
			students.add(instance.new Student(names[random.nextInt(10)],random.nextInt(10)*10));
		}
		Collections.sort(students,instance.new StudentComparator());
		for(Student s: students) {
			System.out.println(s.grade+" "+s.name);
		}
	}

}
