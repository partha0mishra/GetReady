package com.leetcode.recursion.dp.distinctways;
// TODO Anki
/* 1155. Number of Dice Rolls With Target Sum
 * You have d dice, and each die has f faces numbered 1, 2, ..., f.

Return the number of possible ways (out of fd total ways) modulo 10^9 + 7 to roll the dice so the sum of the face up numbers equals target.

 

Example 1:

Input: d = 1, f = 6, target = 3
Output: 1
Explanation: 
You throw one die with 6 faces.  There is only one way to get a sum of 3.
Example 2:

Input: d = 2, f = 6, target = 7
Output: 6
Explanation: 
You throw two dice, each with 6 faces.  There are 6 ways to get a sum of 7:
1+6, 2+5, 3+4, 4+3, 5+2, 6+1.
Example 3:

Input: d = 2, f = 5, target = 10
Output: 1
Explanation: 
You throw two dice, each with 5 faces.  There is only one way to get a sum of 10: 5+5.
Example 4:

Input: d = 1, f = 2, target = 3
Output: 0
Explanation: 
You throw one die with 2 faces.  There is no way to get a sum of 3.
Example 5:

Input: d = 30, f = 30, target = 500
Output: 222616187
Explanation: 
The answer must be returned modulo 10^9 + 7.
 

Constraints:

1 <= d, f <= 30
1 <= target <= 1000
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
public class NumDiceRollsToTargetSum {
	
	/**
	 * Backtracking with memo
	 * O(f ^ d)/ O(d * target)
	 * TLE at 30,30,500 
	 */
	public int numRollsToTarget(int d, int f, int target) {
		int[][] dp=new int[d+1][target+1];// dice no, amount
		return backtrack(d,f,0,target,dp);
	}
	private int backtrack(int d, int f, int diceNo, int remaining, int[][] dp) {
		if(remaining ==0 && diceNo == d) {
			dp[diceNo][remaining]=1;
			return 1;
		}
		if(remaining < 0 || diceNo == d) return 0;// no chance
		if(dp[diceNo][remaining] !=0) {
			return dp[diceNo][remaining]; // NOT Making a difference
		}
		// try some pruning
		int start=Math.max(1,remaining - f*(d - diceNo -1));// start from 1 or the max that needs to be started with
		for(int i=start; i<=f; i++) {
			if(remaining -i < (d - diceNo -1)*1) break;// remaining is less than the minimum of rest of the dice
			dp[diceNo][remaining]+=backtrack(d,f,diceNo+1,remaining-i,dp) % 1000000007;
            dp[diceNo][remaining]=dp[diceNo][remaining] % 1000000007;
		}
		return dp[diceNo][remaining];
	}
	public static void main(String[] args) {
		NumDiceRollsToTargetSum ndrtts= new NumDiceRollsToTargetSum();
		assertEquals(1,(ndrtts.numRollsToTarget(1, 6, 3)));//1
		assertEquals(6,(ndrtts.numRollsToTarget(2, 6, 7)));//6
		assertEquals(1,(ndrtts.numRollsToTarget(2, 5, 10)));
		assertEquals(0,(ndrtts.numRollsToTarget(1, 2, 3)));
		assertEquals(432457640,(ndrtts.numRollsToTarget(10, 10, 55)));
		assertEquals(10,(ndrtts.numRollsToTarget( 3,  6, 15)));
		assertEquals(222616187,(ndrtts.numRollsToTarget(30, 30, 500)));
		assertEquals(87756311,(ndrtts.numRollsToTarget(30, 20, 193)));
	}

}
