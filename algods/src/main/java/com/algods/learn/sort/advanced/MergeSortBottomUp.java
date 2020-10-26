package com.algods.learn.sort.advanced;
/**
 * Merge sort without recursion
 * Keep merging with slices of array
 * Size of these slices start from 1 and double up
 */
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.HashSet;

public class MergeSortBottomUp {
	public void sort(int[] nums) {
		int n= nums.length;
		int[] aux= new int[n];
		for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int mid  = lo+len-1;
                int hi = Math.min(lo+len+len-1, n-1);
                merge(nums, aux, lo, mid, hi);
            }
        }
	}
	private void merge(int[] nums, int[] aux, int lo, int mid, int hi) {
		for(int i=lo; i<=hi; i++) aux[i]=nums[i];// copy the ranges
		int i=lo, j=mid+1;// start of 2 sub-ranges to merge
		for(int k=lo; k<=hi; k++) {
			if		(i > mid)	nums[k]=aux[j++];// left array is done
			else if	(j > hi)	nums[k]=aux[i++];// right array is done
			else if (aux[j] < aux[i])	nums[k]=aux[j++];
			else						nums[k]=aux[i++];
		}
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
		
		MergeSortBottomUp instance= new MergeSortBottomUp();
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
	private void validate(int[] nums, int lo, int hi) {
		for(int i=lo; i<hi-1; i++) {
			if(nums[i] > nums[i+1]) {
				System.out.println("Debug - wrong: "+nums[i]+" > "+nums[i+1]);
				break;
			}
		}
	}
}
