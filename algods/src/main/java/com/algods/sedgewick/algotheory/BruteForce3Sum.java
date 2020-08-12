package com.algods.sedgewick.algotheory;
/**
 * 3 Sum: Brute Force
 * O(n3) - takes around a min for a random integer set of 10K
 */
import java.util.Random;

public class BruteForce3Sum {
	public boolean findSum(int[] n, int sum) {
		for(int i=0; i< n.length; i++) {
			for(int j=i+1; j< n.length; j++) {
				for(int k=j+1; k< n.length; k++)
					if(n[i]+n[j]+n[k] == sum) return true;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		final int NUM_ARRAY_SIZE=10000;// This is the max order within acceptable response (~ 1 min)
		final int SUM_ARRAY_SIZE=5;
		
		int[] nums= new int[NUM_ARRAY_SIZE];
		int[] sum= new int[SUM_ARRAY_SIZE];
		Random random= new Random();
		for(int i=0; i< NUM_ARRAY_SIZE; i++) {nums[i]= random.nextInt(NUM_ARRAY_SIZE);}
		for(int i=0; i< SUM_ARRAY_SIZE; i++) {sum[i]= random.nextInt(/*NUM_ARRAY_SIZE*/SUM_ARRAY_SIZE);}
		BruteForce3Sum instance= new BruteForce3Sum();
		for(int s:sum) {
			System.out.println("finding sum: "+s);
			long tStart=System.currentTimeMillis();
			boolean result=instance.findSum(nums, s);
			long tEnd=System.currentTimeMillis();
			System.out.println((tEnd-tStart)+" : "+result);
		}
		
	}

}
