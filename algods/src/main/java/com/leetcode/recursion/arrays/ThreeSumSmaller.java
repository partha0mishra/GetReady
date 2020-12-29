package com.leetcode.recursion.arrays;

import java.util.Arrays;

/* 259. 3Sum Smaller
 * Given an array of n integers nums and an integer target, find the number of index triplets i, j, k with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.

Follow up: Could you solve it in O(n2) runtime?

 

Example 1:

Input: nums = [-2,0,1,3], target = 2
Output: 2
Explanation: Because there are two triplets which sums are less than 2:
[-2,0,1]
[-2,0,3]
Example 2:

Input: nums = [], target = 0
Output: 0
Example 3:

Input: nums = [0], target = 0
Output: 0
 

Constraints:

n == nums.length
0 <= n <= 300
-100 <= nums[i] <= 100
-100 <= target <= 100
 */
import static org.junit.Assert.assertEquals;
public class ThreeSumSmaller {
	public int threeSumSmaller(int[] nums, int target) {
		if(nums.length < 3) return 0;
		int count=0;
        Arrays.sort(nums);
        for(int i=0; i< nums.length; i++)
        	for(int j=i+1; j< nums.length; j++)
        		for(int k=j+1; k< nums.length; k++)
        			if(nums[i]+nums[j]+nums[k] < target) count+=1;
        			else break;
        return count;
    }
	public static void main(String[] args) {
		ThreeSumSmaller tss= new ThreeSumSmaller();
		assertEquals(2,tss.threeSumSmaller(new int[] {-2,0,1,3}, 2));
		assertEquals(0,tss.threeSumSmaller(new int[] {0}, 0));
		assertEquals(0,tss.threeSumSmaller(new int[] {}, 0));
		assertEquals(22,tss.threeSumSmaller(new int[] {-3,-2,-1,0,1,2,3,4}, 1));
		assertEquals(40,tss.threeSumSmaller(new int[] {-3,-2,-1,0,1,2,3,4}, 4));
	}

}
