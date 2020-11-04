package com.algods.learn.radix;

import java.util.Arrays;

public class KeyIndexedCounting {
	public void sort(char[] input) {
		int R=26;// Radix - 26 small letters
		int N=input.length;
		int[] count=new int[R+1];
		char[] aux= new char[N];
		
		// computing frequencies of [R]
		for(int i=0; i<N; i++) count[input[i] -'a' +1]++;
		// compute cumulates
		for(int i=0; i<R; i++) count[i+1]+=count[i];
		// move to aux array
		for(int i=0; i<N; i++) aux[count[input[i] - 'a']++]=input[i];
		// copy
		System.arraycopy(aux, 0, input, 0, N);
//		input=aux;
	}
	public static void main(String[] args) {
		KeyIndexedCounting instance= new KeyIndexedCounting();
		char[] input01= {'d','a','c','f','f','b','d','b','f','b','e','a'};
//		String[] input02= {"one","two","three","four","five","six","seven","eight","nine","ten"};
		instance.sort(input01);
		System.out.println(Arrays.toString(input01));
	}
}
