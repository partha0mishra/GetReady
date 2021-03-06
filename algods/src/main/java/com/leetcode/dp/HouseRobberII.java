package com.leetcode.dp;
// TODO Anki
/* House Robber II
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have a security system connected, 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 * Given a list of non-negative integers nums representing the amount of money of each house, 
 * return the maximum amount of money you can rob tonight without alerting the police.
 * Example 1:
 * Input: nums = [2,3,2]
 * Output: 3
 * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2), because they are adjacent houses.
 * Example 2:
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 3:
 * Input: nums = [0]
 * Output: 0
 * Constraints:
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * Hint #1  
 * Since House[1] and House[n] are adjacent, they cannot be robbed together. 
 * Therefore, the problem becomes to rob either House[1]-House[n-1] or House[2]-House[n], 
 * depending on which choice offers more money. 
 * Now the problem has degenerated to the House Robber, which is already been solved.
 */
public class HouseRobberII {
	/* Trying out DP in single loop
	 * Feeling good !!
	 */
	public int rob(int[] nums) {
		int n=nums.length;
		if(n == 1 ) return nums[0];// no neighbor scenario
		int p12=0,p11=0, p22=0,p21=0;
		for(int i=0; i< n; i++) {
			if(i < n-1) {// calculations for the first one 0 -> n-1
				int curr1=Math.max(p11, p12+nums[i]);
				p12=p11; p11=curr1;
			}
			if(i > 0) {// calculations for the second case 1-> n
				int curr2=Math.max(p21, p22+nums[i]);
				p22=p21; p21=curr2;
			}
		}
		return Math.max(p11,p21);
    }
	/* Learning phase - continued from HouseRobber 
	 * MAX(rob(from 0 to n-1), rob(from 1 to n))
	 */
//	public int rob(int[] nums) {
//		int n=nums.length;
//		if(n == 1 ) return nums[0];// no neighbor scenario
//		return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
//    }
//	private int rob(int[] nums, int start, int end) {
//		int prev2=0, prev1=0;
//		for(int i=start; i<=end; i++) {
//			int curr=Math.max(prev1, prev2+nums[i]);
//			prev2=prev1;
//			prev1=curr;
//		}
//		return prev1;
//	}
	/* Earlier Approaches - less learning, more doing :( */
//	public int rob(int[] nums) {
//		int n=nums.length;
//		if(n == 1 ) return nums[0];// no neighbor scenario
//		return Math.max(rob(nums,0,n-2), rob(nums,1,n-1));
//    }
//
//	private int rob(int[] nums, int start, int end) {
//		int rob=0,norob=0;
//		for(int i=start; i<= end; i++) {
//			int currentRob=norob+nums[i];
//			norob=Math.max(rob, norob);
//			rob=currentRob;
//		}
//		return Math.max(rob, norob);
//	}
}
