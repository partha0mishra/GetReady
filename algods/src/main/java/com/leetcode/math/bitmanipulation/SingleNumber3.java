package com.leetcode.math.bitmanipulation;
/**
 * Single Number 3
 * 
 * Given an integer array nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in any order.

Follow up: Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

 

Example 1:

Input: nums = [1,2,1,3,2,5]
Output: [3,5]
Explanation:  [5, 3] is also a valid answer.
Example 2:

Input: nums = [-1,0]
Output: [-1,0]
Example 3:

Input: nums = [0,1]
Output: [1,0]
 

Constraints:

2 <= nums.length <= 3 * 104
-231 <= nums[i] <= 231 - 1
Each integer in nums will appear twice, only two integers will appear once.
 */
import java.util.*;
public class SingleNumber3 {
	/**
	 * Approach 02: Bit Operations - NOT DONE YET
	 * O(N)/ O(1)
	 */
	public int[] singleNumber(int[] nums) {
		int seenOnce=0, seenTwice=0, index=0;
		int[] result= new int[2];
		for(int n:nums) {
			int so=seenOnce, st=seenTwice; 
			seenOnce=~seenTwice&(seenOnce^n);
			seenTwice=~seenOnce&(seenTwice^n);
		}
        return result;
    }
	/**
	 * Approach 01: HashSet
	 * O(N) O(N)
	 */
//	public int[] singleNumber(int[] nums) {
//		HashSet<Integer> tempSet= new HashSet<Integer>();
//		int[] result=new int[2];
//		
//		for(int i=0; i< nums.length; i++) {
//			if(tempSet.contains(nums[i])) {
//				tempSet.remove(nums[i]);
//			}else {
//				tempSet.add(nums[i]);
//			}
//		}
//		Iterator<Integer> itSet=tempSet.iterator();
//		int i=0;
//		while(itSet.hasNext()) {
//			result[i++]=itSet.next();
//		}
//        return result;
//    }
}
