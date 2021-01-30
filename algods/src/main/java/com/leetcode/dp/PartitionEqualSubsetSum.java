package com.leetcode.dp;

import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/* 416. Partition Equal Subset Sum
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

Example 1:

Input: nums = [1,5,11,5]
Output: true
Explanation: The array can be partitioned as [1, 5, 5] and [11].
Example 2:

Input: nums = [1,2,3,5]
Output: false
Explanation: The array cannot be partitioned into equal sum subsets.
 

Constraints:

1 <= nums.length <= 200
1 <= nums[i] <= 100
 */
import java.util.*;
public class PartitionEqualSubsetSum {
	/**
	 * Approach 03: DP
	 * this is anyway 0/1 knapsack
	 * we need only previous row, 
	 * might as well calculate from right to preserve previous results in the same row
	 */
	public boolean canPartition(int[] nums) {
        int sum=0;
        for(int num: nums) sum+=num;
        if((sum & 1) ==1) return false;// sum needs to be even
        sum/=2;
        boolean[] dp=new boolean[sum+1];
        dp[0]=true;
        for(int num: nums)
        	for(int i=sum; i>0; i--) {
//        		if(i >= num) dp[i]=dp[i-num] || dp[i];// dp[i] could be already true from last iteration
        	}
        return dp[sum];
    }
	/* Approach 02: Adding memoization 
	 * Approach 01: 
	 * sum has to be EVEN, of course
	 * > Recurrence relationship (either consider the current number or don't) : 0/1 knapsack
	 * canPartition(target, n)= canPartition(target - nums[n],n-1) || canPartition(target,n-1)
	 * 
	 * Base case: target ==0 : true, target < 0: false;
	 */
//	HashMap<Integer,Boolean> memo;
//	public boolean canPartition(int[] nums) {
//        int sum=0;
//        for(int n: nums) sum+=n;
//        if(sum %2 !=0 || sum==0 ) return false;
//        sum/=2;
//        memo=new HashMap<>();
//        return find(sum,nums,nums.length-1);
//    }
//	
//	private boolean find(int target, int[] nums, int n) {
//		if(target ==0 ) return true;// found
//		if(target < 0 || n< 0) return false;// can't be found
//		if(!memo.containsKey(target)) {
//			memo.put(target,
//					find(target-nums[n],nums, n-1) || find(target,nums,n-1));
//		}
//		return memo.get(target);
//	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum instance= new PartitionEqualSubsetSum();
		int[] nums= {1,5,11,5};
		assertTrue(instance.canPartition(nums));
		int[] nums1= {1,2,3,4,5};
		assertFalse(instance.canPartition(nums1));
		int[] nums2= {1,3,3,5};
		assertTrue(instance.canPartition(nums2));
		int[] nums3= {1,2,5};
		assertFalse(instance.canPartition(nums3));
	}

}
