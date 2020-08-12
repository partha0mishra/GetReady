package com.algods.sedgewick.algotheory;
/**
 * Binary Search:
 * Just using a little QuickSort to sort the array.
 */
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.algods.sedgewick.sort.advanced.QuickSort;

public class BinarySearch {
	public boolean search(int[] nums, int n) {
//		printArray(nums);
		int lo=0, hi=nums.length-1;
//		if(n > nums[hi] || n< nums[lo]) return false;
		while(lo <= hi) {
			int mid=lo+(hi-lo)/2;
			if(n > nums[mid]) lo=mid+1;
			else if(n < nums[mid]) hi=mid-1;
			else return true;
		}
		return false;
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
		QuickSort quickSort= new QuickSort();
		long tStart=System.currentTimeMillis();
		quickSort.sort(nums);
		long tEnd=System.currentTimeMillis();
		System.out.println("Sort   time: "+(tEnd-tStart));
		// Searching time
		int[] searchNums=new int[10];
		searchNums[0]=0;// 
		hm.clear();
		for(int i=1;i< searchNums.length;) {
			int tempNum=nums[random.nextInt(NUM_ARRAY_SIZE)];
			if(hm.contains(tempNum)) {
				continue;
			}else {
				searchNums[i++]=tempNum;
				hm.add(tempNum);
			}
		}
		
		BinarySearch instance = new BinarySearch();
		for(int i: searchNums) {
			tStart=System.currentTimeMillis();
			boolean result=instance.search(nums, i);
			tEnd=System.currentTimeMillis();
			System.out.println("Search Time: "+(tEnd-tStart)+" : "+result+" for num : "+i);
		}
		
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%5d",n);
		System.out.println();
	}
}
