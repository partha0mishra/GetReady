package com.algods.sedgewick.sort.elementary;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class SelectionSort {
	public void sort(int[] nums) {
		System.out.println("Before sort >> ");
		printArray(nums);
		for(int i=0; i<nums.length; i++) {
			int min=i;
			for(int j=i+1; j< nums.length; j++) {
				if(nums[j] < nums[min]) min=j;
			}
			swap(nums, min, i);
		}
		System.out.println("After  sort >> ");
		printArray(nums);
	}
	private void swap(int[] nums, int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=1000;
		int[] nums= new int[NUM_ARRAY_SIZE];
		Random random= ThreadLocalRandom.current();
		// NOT Dealing with Duplicates yet
		//for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		HashSet<Integer> hm= new HashSet<Integer>();
		for(int i=0; i< NUM_ARRAY_SIZE; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE*10);
			if(hm.contains(newNum)) {
				continue;
			}else {
				nums[i++]=newNum;
				hm.add(newNum);
			}
		}
//		printArray(nums);
		
		SelectionSort instance= new SelectionSort();
		long tStart=System.currentTimeMillis();
		instance.sort(nums);
		long tEnd=System.currentTimeMillis();
		System.out.println("Sorting    Time: "+(tEnd-tStart));
//		printArray(nums);
		// let's see how long it takes to go through with O(N)
		tStart=System.currentTimeMillis();
		for(int i=0; i< nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				System.out.println("wrong: "+nums[i]+" > "+nums[i+1]);
				break;
			}
		}
		tEnd=System.currentTimeMillis();
		System.out.println("Validation Time: "+(tEnd-tStart));
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%4d",n);
		System.out.println();
	}
}
