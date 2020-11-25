package com.algods.learn.algotheory;
/*
 * Trying out how TreeSet<> works for a bespoke Comparable object
 */
import java.util.*;
class Temp implements Comparable<Temp>{
	int id, val;
	public Temp(int i, int v) {this.id=i; this.val=v;}
	@Override
	public int compareTo(Temp t) {
		int diff=Integer.compare(val, t.val);
		return (diff ==0)? Integer.compare(id, t.id): diff;
	}
	@Override
	public String toString() {
		return ""+id+" > "+val;
	}
}
public class MyTestClass {
	public static void main(String[] args) {
		TreeSet<Temp> ts=new TreeSet<>();
		ts.add(new Temp(1,1));
		ts.add(new Temp(2,1));
		ts.add(new Temp(2,2));
		ts.add(new Temp(2,2));
		while(!ts.isEmpty()) System.out.println(ts.pollFirst());
	}
}
