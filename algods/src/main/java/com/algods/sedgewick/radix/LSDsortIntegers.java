package com.algods.sedgewick.radix;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.algods.sedgewick.sort.advanced.MergeSort;
import com.algods.sedgewick.sort.advanced.QuickSort;

public class LSDsortIntegers {
	private static final int BITS_PER_BYTE = 8;
	public void sort(int[] a) {
		final int BITS=32; // each int is of 32 bits
		final int R=1<<BITS_PER_BYTE; // each byte is between 0 and 255
		final int MASK=R-1; //0xFF
		final int w=BITS/BITS_PER_BYTE; // 4 bytes per int
		
		int n=a.length;// these many numbers to sort
		int[] aux= new int[n];// auxiliary array needed for each round
		
		for(int d=0; d<w; d++) {
			// compute frequency counts of the bit at position d
			int[] count= new int[R+1];
			for(int i=0; i< n; i++) {
				int c=(a[i] >> BITS_PER_BYTE*d) & MASK;// TODO
				count[c+1]++;
			}
			// compute cumulates
			for(int i=0; i<R; i++) count[i+1]+=count[i];
			// for most significant byte, 0x80-0xFF comes before 0x00-0x7F
            if (d == w-1) {
                int shift1 = count[R] - count[R/2];
                int shift2 = count[R/2];
                for (int r = 0; r < R/2; r++)
                    count[r] += shift1;
                for (int r = R/2; r < R; r++)
                    count[r] -= shift2;
            }
            // move data
            for (int i = 0; i < n; i++) {
                int c = (a[i] >> BITS_PER_BYTE*d) & MASK;
                aux[count[c]++] = a[i];
            }

            // copy back
            for (int i = 0; i < n; i++)
                a[i] = aux[i];
		}
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=10000000;
		int[] nums1= new int[NUM_ARRAY_SIZE];
		int[] nums2= new int[NUM_ARRAY_SIZE];
		int[] nums3= new int[NUM_ARRAY_SIZE];
		Random random= ThreadLocalRandom.current();
		// NOT Dealing with Duplicates yet
		//for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		HashSet<Integer> hm= new HashSet<Integer>();
		for(int i=0; i< NUM_ARRAY_SIZE; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE*10);
			if(hm.contains(newNum)) {
				continue;
			}else {
				nums1[i]=newNum;
				nums2[i]=newNum;
				nums3[i++]=newNum;
				hm.add(newNum);
			}
		}
		
		LSDsortIntegers instance= new LSDsortIntegers();
		long tStart=System.currentTimeMillis();
		instance.sort(nums1);
		long tEnd=System.currentTimeMillis();
		System.out.println("Radix Sorting    Time: "+(tEnd-tStart));
		MergeSort mergeSort= new MergeSort();
		tStart=System.currentTimeMillis();
		mergeSort.sort(nums2);
		tEnd=System.currentTimeMillis();
		System.out.println("Merge Sorting    Time: "+(tEnd-tStart));
		QuickSort quickSort= new QuickSort();
		tStart=System.currentTimeMillis();
		quickSort.sort(nums3);
		tEnd=System.currentTimeMillis();
		System.out.println("Quick Sorting    Time: "+(tEnd-tStart));
//		printArray(nums);
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%3d",n);
		System.out.println();
	}

}
