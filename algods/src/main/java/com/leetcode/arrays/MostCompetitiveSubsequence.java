package com.leetcode.arrays;
/**
 * Find the most competitive subsequence
 * Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

 

Example 1:

Input: nums = [3,5,2,6], k = 2
Output: [2,6]
Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
Example 2:

Input: nums = [2,4,3,3,5,4,9,6], k = 4
Output: [2,3,3,4]
 

Constraints:

1 <= nums.length <= 105
0 <= nums[i] <= 109
1 <= k <= nums.length
 */
import java.util.*;
public class MostCompetitiveSubsequence {
	/*
	 * 01 Brute force: TLE : O(N2) in worst case
	 * 02 Using TreeSet: O(NlogN)/ O(N)
	 */
	public int[] mostCompetitive(int[] nums, int k) {
        int n=nums.length;
        int[] result= new int[k];
        TreeSet<Integer> indices= new TreeSet<>((i1,i2) -> {
    		int diff=Integer.compare(nums[i1], nums[i2]);
    		return diff==0? Integer.compare(i1,i2): diff;
    	});
        for(int i=0; i< n-k; i++) indices.add(i);// first set
        int r=0, x=-1;
        for(int i=0; i<k; i++) {// filling up the spots
        	indices.add(n-k+i);// add a number
        	while(x < r) x=indices.pollFirst();
        	r=x;x-=1;
        	result[i]=nums[r];
        }
        for(int rx: result) System.out.printf("%2d", rx);
        System.out.println();
        return result;
    }
	public static void main(String[] args) {
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {3,5,2,6}, 2);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 1);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 2);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 3);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 4);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 5);
		new MostCompetitiveSubsequence().mostCompetitive(new int[] {2,4,3,3,5,4,9,6}, 6);
	}

}
