package com.algods.sedgewick.sort.advanced;
/**
 * 3-way partitioning for QuickSort with Duplicates
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;

public class QuickSortWithDuplicates {
	public void sort(int[] nums) {
		// first task would be to shuffle, although we might already have a shuffled array here
//		shuffle(nums); // generation is Randomized anyway
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
//		printArray(nums, lo, hi);
		int i=lo, lt=lo, gt=hi;// taking nums[lt] as pivot
		while(i<=gt) {
			if(nums[i] < nums[lt]) swap(nums, lt++, i++);
			else if(nums[i] > nums[lt]) swap(nums, i, gt--);
			else i++;
		}
//		printArray(nums, lo, hi);
		sort(nums, lo, lt-1);// sort left subarray
		sort(nums, gt+1, hi);// sort right subarray
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=10000000;
		int[] nums= new int[NUM_ARRAY_SIZE*5];
		Random random= ThreadLocalRandom.current();
		// NOT Dealing with Duplicates yet
		//for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		HashSet<Integer> hm= new HashSet<Integer>();
		for(int i=0; i< NUM_ARRAY_SIZE *5; ) {// let's make sure the numbers are distinct
			int newNum= random.nextInt(NUM_ARRAY_SIZE);
//			if(hm.contains(newNum)) {
//				continue;
//			}else {
				nums[i++]=newNum;
//				hm.add(newNum);
//			}
		}
		
		int[] tempNums=new int[nums.length*2];
		for(int i=0, j=nums.length; i<nums.length; i++,j++) {
			tempNums[i]=nums[i];
			tempNums[j]=nums[i];
		}
		nums=tempNums;
//		printArray(nums);
		QuickSortWithDuplicates instance= new QuickSortWithDuplicates();
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
//		printArray(nums);
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%4d",n);
		System.out.println();
	}
	private static void printArray(int[] nums, int lo, int hi) {
		for(int i=lo; i<=hi; i++) System.out.printf("%4d",nums[i]);
		System.out.println();
	}
}
