package com.algods.learn.radix;

import java.util.Arrays;

public class MSDSort {
	private static final int BITS_PER_BYTE =   8;
    private static final int BITS_PER_INT  =  32;   // each Java int is 32 bits 
    private static final int R             = 256;   // extended ASCII alphabet size
    private static final int CUTOFF        =  15;   // cutoff to insertion sort
	public void sort(String[] a) {
		int n=a.length;
		String[] aux= new String[n];
		sort(a,0,n-1,0,aux);
	}
	private int charAt(String s, int d) {// some strings might be shorter than the other
		if(d == s.length()) return -1;
		return s.charAt(d);
	}
	private void sort(String[] a, int lo, int hi, int d, String[] aux) {
		// cutoff to insertion sort for small subarrays
        if (hi <= lo + CUTOFF) {
            insertion(a, lo, hi, d);
            return;
        }

        // compute frequency counts
        int[] count = new int[R+2];
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            count[c+2]++;
        }

        // transform counts to indicies
        for (int r = 0; r < R+1; r++)
            count[r+1] += count[r];

        // distribute
        for (int i = lo; i <= hi; i++) {
            int c = charAt(a[i], d);
            aux[count[c+1]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) 
            a[i] = aux[i - lo];


        // recursively sort for each character (excludes sentinel -1)
        for (int r = 0; r < R; r++)
            sort(a, lo + count[r], lo + count[r+1] - 1, d+1, aux);
	}
	// insertion sort a[lo..hi], starting at dth character
    private static void insertion(String[] a, int lo, int hi, int d) {
        for (int i = lo; i <= hi; i++)
            for (int j = i; j > lo && less(a[j], a[j-1], d); j--)
                exch(a, j, j-1);
    }
    // is v less than w, starting at character d
    private static boolean less(String v, String w, int d) {
        // assert v.substring(0, d).equals(w.substring(0, d));
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if (v.charAt(i) < w.charAt(i)) return true;
            if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }
    // exchange a[i] and a[j]
    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
	public static void main(String[] args) {
		MSDSort instance= new MSDSort();
		String[] words= {"bed","bug","dad","yes","zoo","now","for","tip","ilk","dim","tag","jot","sob","nob","sky","hut","men","egg","few","jay","owl","joy","rap","gig","wee","was","wad","fee","tap","tar","dug","jam","all","bad","yet"};
		instance.sort(words);
		System.out.println(Arrays.toString(words));
		String[] words2= {"she","sells","seashells","by","the","sea","shore","the","shells","she","sells","are","surely","seashells"};
		instance.sort(words2);
		System.out.println(Arrays.toString(words2));
	}

}
