package com.algods.learn.radix;

import java.util.Arrays;

public class LSDSort {
	public void sort(String[] words) {
		int n=words.length;// how many words
		int width=words[0].length();// size of words
		int R=256;// Radix, considering extended ASCII
		String[] aux=new String[n];// Auxiliary array
		
		
		for(int i=width-1; i>=0; i--) {
			int[] count= new int[R+1];
			// key-indexed counting from rightmost letter to the first one (0th)
			for(int j=0; j< n; j++) count[words[j].charAt(i)+1]++;// counts
			for(int j=0; j< R; j++) count[j+1]+=count[j]; // cumulative counts
			for(int j=0; j< n; j++) aux[count[words[j].charAt(i)]++]=words[j];// moving to aux array
			System.arraycopy(aux, 0, words, 0, n);// copy back to words array.
		}
	}
	public static void main(String[] args) {
		LSDSort instance= new LSDSort();
		String[] words= {"bed","bug","dad","yes","zoo","now","for","tip","ilk","dim","tag","jot","sob","nob","sky","hut","men","egg","few","jay","owl","joy","rap","gig","wee","was","wad","fee","tap","tar","dug","jam","all","bad","yet"};
		instance.sort(words);
		System.out.println(Arrays.toString(words));
	}

}
