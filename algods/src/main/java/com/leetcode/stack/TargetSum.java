package com.leetcode.stack;
/* Target Sum
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

Find out how many ways to assign symbols to make sum of integers equal to target S.

Example 1:

Input: nums is [1, 1, 1, 1, 1], S is 3. 
Output: 5
Explanation: 

-1+1+1+1+1 = 3
+1-1+1+1+1 = 3
+1+1-1+1+1 = 3
+1+1+1-1+1 = 3
+1+1+1+1-1 = 3

There are 5 ways to assign symbols to make the sum of nums be target 3.
 

Constraints:

The length of the given array is positive and will not exceed 20.
The sum of elements in the given array will not exceed 1000.
Your output answer is guaranteed to be fitted in a 32-bit integer.
 */
import java.util.*;
public class TargetSum {
	/* 1D DP more elegant 
	 * Map takes more space than array and is also SLOWER */
	public int findTargetSumWays(int[] nums, int s) {
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 1);
        for (int num : nums) {
            Map<Integer, Integer> dp2 = new HashMap<>();
            for (int tempSum : dp.keySet()) {
                int key1 = tempSum + num;
                dp2.put(key1, dp2.getOrDefault(key1, 0) + dp.get(tempSum));
                int key2 = tempSum - num;
                dp2.put(key2, dp2.getOrDefault(key2, 0) + dp.get(tempSum));
            }
            dp = dp2;
        }
        return dp.getOrDefault(s, 0);
    }
	/* DP 1D - since we only need to store the last row's value
	 * O(L*N) / O(L)
	 */
//	public int findTargetSumWays(int[] nums, int S) {
//        int[] dp = new int[2001];
//        dp[nums[0] + 1000] = 1;
//        dp[-nums[0] + 1000] += 1;
//        for (int i = 1; i < nums.length; i++) {
//            int[] next = new int[2001];
//            for (int sum = -1000; sum <= 1000; sum++) {
//                if (dp[sum + 1000] > 0) {
//                    next[sum + nums[i] + 1000] += dp[sum + 1000];
//                    next[sum - nums[i] + 1000] += dp[sum + 1000];
//                }
//            }
//            dp = next;
//        }
//        return S > 1000 ? 0 : dp[S + 1000];
//    }
	/* DP 2D
	 * O(L*N)/ O(L*N)
	 */
//	public int findTargetSumWays(int[] nums, int S) {
//        int[][] dp = new int[nums.length][2001];// adding 1000 since Sum can be from -1000 to 1000
//        dp[0][nums[0] + 1000] = 1;// dp[i][sum]=count
//        dp[0][-nums[0] + 1000] += 1;// 
//        for (int i = 1; i < nums.length; i++) {
//            for (int sum = -1000; sum <= 1000; sum++) {
//                if (dp[i - 1][sum + 1000] > 0) {// had some count = the only ones that were resulted
//                    dp[i][sum + nums[i] + 1000] += dp[i - 1][sum + 1000];
//                    dp[i][sum - nums[i] + 1000] += dp[i - 1][sum + 1000];
//                }
//            }
//        }
//        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
//    }
	/* Memoization for a sum at an index. Significantly faster 
	 * O(<Range of Sum> * <Length of Array>) / O(L*N)*/
//	HashMap<Integer,Integer> memo;
//	public int findTargetSumWays(int[] nums, int S) {
//		memo=new HashMap<>();
//        return findWays(nums,0,0,S);// int[], position, sum-so-far, targetSum
//    }
//	private int findWays(int[] n, int pos, int sum, int target) {
//		if(pos == n.length) return (sum == target)? 1:0;
//		if(!memo.containsKey(sum*1000+pos)) {
//			memo.put(sum*1000+pos, findWays(n, pos+1, sum+n[pos], target)+ findWays(n, pos+1, sum-n[pos], target));
//		}
//		return memo.get(sum*1000+pos);
//	}
	/* Recursion + Backtracking: O(2^n) O(n) recursion stack */
//	public int findTargetSumWays(int[] nums, int S) {
//        return findWays(nums,0,0,S);// int[], position, sum-so-far, targetSum
//    }
//	private int findWays(int[] n, int pos, int sum, int target) {
//		if(pos == n.length) return (sum == target)? 1:0;
//		
//		return findWays(n, pos+1, sum+n[pos], target)+ findWays(n, pos+1, sum-n[pos], target);
//	}
	public static void main(String[] args) {
		System.out.println(new TargetSum().findTargetSumWays(new int[] {1,1,1,1,1}, 3));
		System.out.println(new TargetSum().findTargetSumWays(new int[] 
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30}, 3));
		System.out.println(new TargetSum().findTargetSumWays(new int[] 
				{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20}, 3));
	}
}
