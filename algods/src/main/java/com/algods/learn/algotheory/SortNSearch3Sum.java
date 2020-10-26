package com.algods.learn.algotheory;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import com.algods.learn.sort.advanced.QuickSort;

public class SortNSearch3Sum {
	public boolean findSum(int[] n, int sum) {
		QuickSort quickSort= new QuickSort();
		quickSort.sort(n);
//		printArray(n);
		BinarySearch binarySearch = new BinarySearch();
		for(int i=0; i<n.length; i++)
			for(int j=i+1; j<n.length; j++) {
//				System.out.println("Searching "+(10*i+j)+" for "+(sum-(n[i]+n[j])));
				int diff=sum-(n[i]+n[j]);
				if(binarySearch.search(n,diff)) 
					return true;
			}
		return false;
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=10000;
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
//				System.out.println(newNum);
			}
		}
		
		int[] searchNums=new int[3];
		hm.clear();
		for(int i=0;i< searchNums.length;) {
			int tempNum=nums[random.nextInt(NUM_ARRAY_SIZE)];
			if(hm.contains(tempNum)) {
				continue;
			}else {
				searchNums[i++]=tempNum;
				hm.add(tempNum);
			}
		}
		
		int sum=searchNums[0]+searchNums[1]+searchNums[2];
		SortNSearch3Sum instance=new SortNSearch3Sum();
		long tStart=System.currentTimeMillis();
		boolean result=instance.findSum(nums, sum);
		long tEnd=System.currentTimeMillis();
		System.out.println("Search   time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis BruteForce
		BruteForce3Sum brute= new BruteForce3Sum();
		tStart=System.currentTimeMillis();
		result=brute.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Brute    time: "+(tEnd-tStart)+" result: "+result);
		
		sum=searchNums[0];
		tStart=System.currentTimeMillis();
		result=instance.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Search   time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis BruteForce
		tStart=System.currentTimeMillis();
		result=brute.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Brute    time: "+(tEnd-tStart)+" result: "+result);
		
		sum=0;
		tStart=System.currentTimeMillis();
		result=instance.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Search   time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis BruteForce
		tStart=System.currentTimeMillis();
		result=brute.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Brute    time: "+(tEnd-tStart)+" result: "+result);
	}
	private static void printArray(int[] nums) {
		for(int n: nums) System.out.printf("%5d",n);
		System.out.println();
	}
}
