package com.leetcode.recursion.dp.decisionmaking;
// TODO Anki
/**
 * House Robber
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and 
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 * Constraints:
 * 0 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
public class HouseRobber {
	/* Recurrence Relationship: rob(i)= Math.max(rob(i-1), rob(i-2)+nums[i]) */
	/* Learning 03: DP, as we only need robNminus1 and robNminus2 values
	 * O(N) O(1)
	 */
	public int rob(int[] nums) {
		int n=nums.length;
		int rnm1=0, rnm2=0;
		for(int i=0; i< n; i++) {
			int current=Math.max(rnm1, rnm2+nums[i]);
			rnm2=rnm1;
			rnm1=current;
		}
		return rnm1;
	}
	/* Learning 02: Recursion with Memo
	 * O(N) O(N)
	 */
//	public int rob(int[] nums) {
//		int[] memo=new int[nums.length];
//		Arrays.fill(memo, -1);
//		return rob(nums, nums.length -1,memo);
//	}
//	private int rob(int[] nums, int n,int[] memo) {
//		if(n <0) return 0;
//		if(memo[n]==-1)
//			memo[n]=Math.max(rob(nums,n-1,memo), rob(nums, n-2, memo)+nums[n]);
//		return memo[n];
//	}
	
	/* Learning 01: Restarting DP learning
	 * Recursion O(2^N) O(2^N) - Sure TLE
	 */
//	public int rob(int[] nums) {
//		return rob(nums, nums.length -1);
//	}
//	private int rob(int[] nums, int n) {
//		if(n <0) return 0;
//		else return Math.max(rob(nums,n-1), rob(nums, n-2)+nums[n]);
//	}
	/* Approach 03: DP 
	 * Quite like a Buy and Sell stocks with 1 day cooling*/
//	public int rob(int[] nums) {
//		int rob=0, norob=0;
//		for(int i=0; i< nums.length; i++) {
//			int currentRob=norob+nums[i];// to rob the current one, the previous one can't be robbed
//			norob=Math.max(rob, norob);// max of last house's status carries on if this one is not robbed
//			rob=currentRob;
//		}
//		return Math.max(rob, norob);
//    }
	/* Approach 02: Greedy, BackTracking, Memoization - First time. YEY !!
	 * Note: TLE without Memoization*/
//	int result;
//	HashMap<Integer,Integer> memo;
//	public int rob(int[] nums) {
//		result=0;
//		memo=new HashMap<Integer, Integer>();
//		result=robHelp(nums, 0);
//        return result;
//    }
//	private int robHelp(int[]nums, int index) {
////		System.out.println(index+" "+tempResult);
//		if(index >= nums.length) return 0;
//		int localMax=0, tempResult;
//		for(int i=index; i< nums.length; i++) {
//			if(memo.containsKey(i)) {
////				System.out.println("got from memo");
//				tempResult=memo.get(i);
//			}else {
//				tempResult=nums[i]+robHelp(nums, i+2);
//			}
//			if(tempResult > localMax) localMax=tempResult;
//		}
////		System.out.println("localmax: "+index+" "+localMax);
//		memo.put(index, localMax);
//		return localMax;
//	}
	/* Approach 01: Naive and Wrong - uses only alternating sums*/
//	public int rob(int[] nums) {
//		int oddSum=0, evenSum=0;
//        for(int i=0; i< nums.length; i++) {
//        	if(i%2==0) evenSum+=nums[i];
//        	else oddSum+=nums[i];
//        }
//        return Math.max(oddSum, evenSum);
//    }
	public static void main(String[] args) {
		HouseRobber instance= new HouseRobber();
//		assertEquals(4,instance.rob(new int[] {1,2,3,1}));
//		assertEquals(12,instance.rob(new int[] {2,7,9,3,1}));
//		assertEquals(11,instance.rob(new int[] {2,1,2,9}));
		assertEquals(4173,instance.rob(new int[] {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}));
	}

}
