package com.java.udemy.jp;

public class Arrays {
	public static void main(String[] args) {
		int value=7;
		int[] values;
		values=new int[3];
		System.out.println(values[0]);
		values[0]=10;
		System.out.println(values[0]);
		values[1]=10; values[2]=20;
		for(int i=0; i< values.length; i++)
			System.out.println("values ["+i+"] : "+values[i]);
		int[] numbers= {123,234,456};
		for(int n: numbers) System.out.println(n);
	}
}
