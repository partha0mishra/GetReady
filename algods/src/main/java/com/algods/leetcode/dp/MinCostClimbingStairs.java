package com.algods.leetcode.dp;
// TODO Anki
/* Minimum cost climbing stairs
 * On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. 
You need to find minimum cost to reach the top of the floor, 
and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
Note:
cost will have a length in the range [2, 1000].
Every cost[i] will be an integer in the range [0, 999].
 */
public class MinCostClimbingStairs {
	/* Recurrence relationship:
	 * minCost(i)=min(minCost(i-1) + cost(i-1), minCost(i-2)+cost[i-2])
	 * O(N)/ O(N)
	 */
	int[] dp;
	public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        dp=new int[n];
        dp[0]=cost[0];
        dp[1]=cost[1];
        for(int i=2; i< n; i++) {
        	dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
	public static void main(String[] args) {
		MinCostClimbingStairs mccs= new MinCostClimbingStairs();
		System.out.println(mccs.minCostClimbingStairs(new int[] {10,15}));
		System.out.println(mccs.minCostClimbingStairs(new int[] {10,8}));
		System.out.println(mccs.minCostClimbingStairs(new int[] {10,15,20}));
		System.out.println(mccs.minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
	}

}
