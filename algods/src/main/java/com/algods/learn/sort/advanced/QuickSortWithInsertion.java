package com.algods.learn.sort.advanced;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.algods.learn.sort.elementary.InsertionSort;

import java.util.HashSet;

public class QuickSortWithInsertion {
	private static final int CUTOFF=7;
	public void sort(int[] nums) {
		// first task would be to shuffle, although we might already have a shuffled array here
		shuffle(nums);
		sort(nums,0,nums.length-1);
	}
	private void shuffle(int[] nums) {
		Random random=ThreadLocalRandom.current();
		for(int i=0; i<nums.length; i++) {
			swap(nums,i,random.nextInt(i+1));
		}
//		printArray(nums);
	}
	private void swap(int[] nums, int a, int b) {
		int temp=nums[a];
		nums[a]=nums[b];
		nums[b]=temp;
	}
	private void sort(int[] nums, int lo, int hi) {
		if(hi <=lo ) return;
		if(hi -lo <= CUTOFF){
			new InsertionSort().sort(nums, lo, hi);
			return;
		}
		int j=partition(nums, lo, hi);// j is put at the right place
//		System.out.println("J: "+nums[j]);
//		printArray(nums);
		sort(nums, lo, j-1);// sort left subarray
		sort(nums, j+1, hi);// sort right subarray
	}
	private int partition(int[] nums, int lo, int hi) {
		int i=lo, j=hi+1;
		while(true) {
			while(nums[++i]< nums[lo])
				if(i==hi) break;
			while(nums[--j]> nums[lo]) {}
//				if(j==lo) break;// this check is not really needed
//			printArray(nums);
			if(i >=j ) break;
			swap(nums, i,j);
		}
//		printArray(nums);
		swap(nums, j, lo);
//		printArray(nums);
		return j;
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=100000;
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
		
		QuickSortWithInsertion instance= new QuickSortWithInsertion();
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
		for(int n: nums) System.out.printf("%3d",n);
		System.out.println();
	}

}
