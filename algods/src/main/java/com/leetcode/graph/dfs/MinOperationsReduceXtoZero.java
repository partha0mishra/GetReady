package com.leetcode.graph.dfs;
/** TODO Anki
 * 1658. Minimum Operations to Reduce X to Zero
 * You are given an integer array nums and an integer x. In one operation, you can either remove the 
 * leftmost or the rightmost element from the array nums and subtract its value from x. 
 * Note that this modifies the array for future operations.

Return the minimum number of operations to reduce x to exactly 0 if it's possible, otherwise, return -1.
Example 1:

Input: nums = [1,1,4,2,3], x = 5
Output: 2
Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
Example 2:

Input: nums = [5,6,7,8,9], x = 4
Output: -1
Example 3:

Input: nums = [3,2,20,1,1,3], x = 10
Output: 5
Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
 

Constraints:

1 <= nums.length <= 105
1 <= nums[i] <= 104
1 <= x <= 109
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
public class MinOperationsReduceXtoZero {
	/**
	 * Approach 02: 
	 * Note: Array Operations can have better ways of handling such things
	 * If we transpose this problem to finding subarray with sum=x and then find the max length of that, we are done.
	 * O(N)/ O(1)
	 */
	public int minOperations(int[] nums, int x) {
		if(x==0) return 0;// we don't have to remove anything
		int maxLen=0, i=0, j=0, sum=0;
		x=-x;
        for(int n: nums) x+=n;
		if(x==0) return nums.length;// we have to remove everything
		if(x < 0) return -1;
        for(i=0, j=0; i< nums.length && j <=i;) {
        	if(sum < x) {
        		sum+=nums[i];
        		i+=1;
        	}else {
        		if(sum == x) {
        			maxLen=Math.max(maxLen, i-j);
        		}
        		sum-=nums[j];
        		j++;
        	}
        }
        if(sum == x) maxLen=Math.max(maxLen, i-j);
		
        return maxLen ==0 ? -1:nums.length - maxLen;
    }
	/*
	 * Approach 01: intuition of DFS
	 * O(2^N) O(N) TLE
	 */
//	int minOps;
//	public int minOperations(int[] nums, int x) {
//		minOps=Integer.MAX_VALUE;
//        dfs(nums, x, 0, 0, nums.length-1);// array, target, opsNumber, leftIndex, rightIndex
//        return minOps==Integer.MAX_VALUE? -1: minOps;
//    }
//	private void dfs(int[] nums, int target, int ops, int left, int right) {
//		if(target ==0) {minOps=Math.min(minOps, ops); return;}
//		if(target < 0 || ops> minOps || left > right) return;// no chance
//		dfs(nums, target-nums[left], ops+1, left+1, right);
//		dfs(nums, target-nums[right], ops+1, left, right-1);
//	}
	public static void main(String[] args) {
		MinOperationsReduceXtoZero morxz= new MinOperationsReduceXtoZero();
//		assertEquals(2,morxz.minOperations(new int[] {1,1,4,2,3}, 5));
//		assertEquals(2,morxz.minOperations(new int[] {2,3,4,1,1}, 5));
//		assertEquals(-1,morxz.minOperations(new int[] {5,6,7,8,9}, 4));
//		assertEquals(5,morxz.minOperations(new int[] {3,2,20,1,1,3}, 10));
		assertEquals(16,morxz.minOperations(new int[] {8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309},134365));
		assertEquals(-1,morxz.minOperations(new int[] {1241,8769,9151,3211,2314,8007,3713,5835,2176,8227,5251,9229,904,1899,5513,7878,8663,3804,2685,3501,1204,9742,2578,8849,1120,4687,5902,9929,6769,8171,5150,1343,9619,3973,3273,6427,47,8701,2741,7402,1412,2223,8152,805,6726,9128,2794,7137,6725,4279,7200,5582,9583,7443,6573,7221,1423,4859,2608,3772,7437,2581,975,3893,9172,3,3113,2978,9300,6029,4958,229,4630,653,1421,5512,5392,7287,8643,4495,2640,8047,7268,3878,6010,8070
				,7560,8931,76,6502,5952,4871,5986,4935,3015,8263,7497,8153,384,1136}, 894887480));
	}
}
