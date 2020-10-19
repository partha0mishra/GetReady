package com.algods.sedgewick.algotheory;

import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HashSet3Sum {
	public boolean findSum(int[] n, int sum) {
		HashSet<Integer> hm=new HashSet<Integer>();
		for(int i: n) hm.add(i);// All numbers are added.
		
		for(int i=0; i<n.length-1; i++)
			for(int j=i+1; j<n.length; j++) {
				int diff=sum-(n[i]+n[j]);
				if(hm.contains(diff)) return true;
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
		searchNums[0]=nums[NUM_ARRAY_SIZE/2];
		searchNums[1]=nums[NUM_ARRAY_SIZE - NUM_ARRAY_SIZE/4];
		searchNums[2]=nums[NUM_ARRAY_SIZE - NUM_ARRAY_SIZE/10];
//		hm.clear();
//		for(int i=0;i< searchNums.length;) {
//			int tempNum=nums[random.nextInt(NUM_ARRAY_SIZE)];
//			if(hm.contains(tempNum)) {
//				continue;
//			}else {
//				searchNums[i++]=tempNum;
//				hm.add(tempNum);
//			}
//		}
		System.out.println("SearchNums: "+searchNums[0]+" "+searchNums[1]+" "+searchNums[2]);
		
		int sum=searchNums[0]+searchNums[1]+searchNums[2];
		HashSet3Sum instance=new HashSet3Sum();
		long tStart=System.currentTimeMillis();
		boolean result=instance.findSum(nums, sum);
		long tEnd=System.currentTimeMillis();
		System.out.println("Search   time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis Sort & Search
		SortNSearch3Sum ss3s= new SortNSearch3Sum();
		tStart=System.currentTimeMillis();
		result=ss3s.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("SS3S     time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis BruteForce
		BruteForce3Sum brute= new BruteForce3Sum();
		tStart=System.currentTimeMillis();
		result=brute.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Brute    time: "+(tEnd-tStart)+" result: "+result);
		
		sum=searchNums[0]+1;
		tStart=System.currentTimeMillis();
		result=instance.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Search   time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis Sort & Search
		tStart=System.currentTimeMillis();
		result=ss3s.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("SS3S     time: "+(tEnd-tStart)+" result: "+result);
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
		// vis-a-vis Sort & Search
		tStart=System.currentTimeMillis();
		result=ss3s.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("SS3S     time: "+(tEnd-tStart)+" result: "+result);
		// vis-a-vis BruteForce
		tStart=System.currentTimeMillis();
		result=brute.findSum(nums, sum);
		tEnd=System.currentTimeMillis();
		System.out.println("Brute    time: "+(tEnd-tStart)+" result: "+result);
	}

}
