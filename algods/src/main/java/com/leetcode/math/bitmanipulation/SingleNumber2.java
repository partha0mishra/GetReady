package com.leetcode.math.bitmanipulation;
/**
 * Single Number 2
 * 
 * Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

 

Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
 

Constraints:

1 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each element in nums appears exactly three times except for one element which appears once.
 

Follow up: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
import java.util.*;
public class SingleNumber2 {
	/**
	 * Approach 01: Brute
	 * Keep in hashmap for the 1st and 3rd time and see which one's duplicate
	 * O(N)/ O(N)
	 */
	public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> numCount= new HashMap<>();
        int result=0;
        for(int n: nums){
            int c=numCount.getOrDefault(n,0);
            if(c != 1) result^=n;
            numCount.put(n,c+1);
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
