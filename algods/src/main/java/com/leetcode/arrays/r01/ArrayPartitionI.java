package com.leetcode.arrays.r01;
/** 
 * 561. Array Partition I
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer, 
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.

Example 1:
Input: [1,4,3,2]

Output: 4
Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
Note:
n is a positive integer, which is in the range of [1, 10000].
All the integers in the array will be in the range of [-10000, 10000].
 * */
import java.util.Arrays;
public class ArrayPartitionI {
	/** Knowing max value - use counts 
	 * Since sorting is O(nlogn), an alternative is to use the Count
	 * use number+10000 as the index and populate counts
	 * use boolean flag odd=true, flip it and add to result
	 * 
	 * population of counts array = O(N)
	 * */
	public int arrayPairSum(int[] nums) {
        int[] counts=new int[20001];// first 10000 for negative values and last 10000 for positive ones
        for(int n: nums) {
            counts[10000+n]++; // keeping the count
        }
        int result=0;
        boolean odd=true;
        for(int i=0; i< counts.length; i++){
            while(counts[i] >0){// odds and evens
                if(odd) {
                    result+=(i-10000); 
                }
                odd=!odd;
                counts[i]--;
            }
        }
        return result;
    }
	/* Sort and take odd ones*/
//	public int arrayPairSum(int[] nums) {
//        Arrays.sort(nums);
//        int result=0;
//        for(int i=0; i< nums.length; i+=2) result+=nums[i];
//        return result;
//    }
}
