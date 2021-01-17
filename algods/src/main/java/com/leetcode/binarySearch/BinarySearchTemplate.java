package com.leetcode.binarySearch;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
/**
 * Binary Search: Template
 * Just using a little QuickSort to sort the array.
 */
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BinarySearchTemplate {
	public boolean search(int[] nums, int n) {
		int left=0, right=nums.length;
		while(left < right) {
			int mid=left+(right-left)/2;
			if(nums[mid] >= n) right=mid;
			else left=mid+1;
		}
		return (nums[left]==n);
	}
	public static void main(String[] args) {
		int[] num0= {1,3,5,7,9,10,12,14,16,18};
		BinarySearchTemplate bs= new BinarySearchTemplate();
		assertFalse(bs.search(num0, 0));// false
		assertTrue(bs.search(num0, 1));// true
		//*
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
		Arrays.sort(nums);
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
		
		BinarySearchTemplate instance = new BinarySearchTemplate();
		long tStart, tEnd;
		for(int i: searchNums) {
			tStart=System.currentTimeMillis();
			boolean result=instance.search(nums, i);
			tEnd=System.currentTimeMillis();
			System.out.println("Search Time: "+(tEnd-tStart)+" : "+result+" for num : "+i);
		}
	//*/	
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%5d",n);
		System.out.println();
	}
}
