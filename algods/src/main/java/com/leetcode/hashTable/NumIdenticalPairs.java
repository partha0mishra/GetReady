package com.leetcode.hashTable;
/**
 * 1512.
 * Given an array of integers nums.

A pair (i,j) is called good if nums[i] == nums[j] and i < j.

Return the number of good pairs.
 */
public class NumIdenticalPairs {

	public int numIdenticalPairs(int[] nums) {
		int pairs=0;
        for(int i=0; i<nums.length-1; i++){
        	for(int j=i+1; j<nums.length; j++) {
        		if (nums[i]==nums[j]) {
        			pairs +=1;
        		}
        	}
        }
        return pairs;
    }
	public static void main(String[] args) {
		int[] nums4= {1,2,3,1,1,3};// should return 4
		System.out.println(new NumIdenticalPairs().numIdenticalPairs(nums4));
		
		int[] nums6= {1,1,1,1};// should return 6
		System.out.println(new NumIdenticalPairs().numIdenticalPairs(nums6));
		
		int[] nums0= {1,2,3};// should return 0
		System.out.println(new NumIdenticalPairs().numIdenticalPairs(nums0));
	}

}
