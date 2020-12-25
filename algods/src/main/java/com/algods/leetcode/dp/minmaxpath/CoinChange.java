package com.algods.leetcode.dp.minmaxpath;
// TODO Anki
/**
 * 322. Coin Change
 * You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

 

Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0
Example 4:

Input: coins = [1], amount = 1
Output: 1
Example 5:

Input: coins = [1], amount = 2
Output: 2
 

Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
public class CoinChange {
	/* Using more generic form - calculating 'ways' 
	 * O(S*N)/ O(N) 
	 * */
	public int coinChange(int[] coins, int amount) {
		if(coins == null || coins.length ==0 || amount <=0) return 0;
		int[] dp= new int[amount+1];
		dp[0]=0;
		for(int i=1; i<= amount; i++) {
			dp[i]=Integer.MAX_VALUE;
			for(int j=0; j< coins.length; j++) {
				if(coins[j] <= i && dp[i-coins[j]] != -1) {// of course
					dp[i]=Math.min(dp[i], dp[i-coins[j]]+1);
				}
			}
			if(dp[i] == Integer.MAX_VALUE) dp[i]=-1;
			System.out.println(i+" "+dp[i]);
		}
		return dp[amount];
	}
	
	/* (could have been done using backtracking - resulting in TLE)
	 * DP Top Down - copied from LC Solution
	 * O(S*N)/ O(S)
	 * S => amount, N=number of coins. In worst case, we need to iterate through all the coins for each amount up to S
	 * Space needed for memoization of each value till S
	 * */
//	public int coinChange(int[] coins, int amount) {
//		if(amount < 1) return 0;
//		return findMin(coins, amount, new int[amount]);
//	}
//
//	private int findMin(int[] coins, int remaining, int[] count) {
//		if(remaining < 0) return -1;// dead end
//		if(remaining == 0) return 0;// valid
//		if(count[remaining-1] !=0) return count[remaining-1];
//		int min=Integer.MAX_VALUE;
//		for(int coin: coins) {
//			int result=findMin(coins,remaining-coin,count);
//			if(result >= 0 && result < min)
//				min=1+result;
//		}
//		count[remaining-1]=(min==Integer.MAX_VALUE)? -1:min;
//		return count[remaining-1];
//	}
	public static void main(String[] s) {
		CoinChange cc= new CoinChange();
		assertEquals(1,cc.coinChange(new int[] {1,2,5},1));
		assertEquals(1,cc.coinChange(new int[] {1,2,5},2));
		assertEquals(1,cc.coinChange(new int[] {1,2,5},5));
		assertEquals(3,cc.coinChange(new int[] {1,2,5},11));
		assertEquals(-1,cc.coinChange(new int[] {2},3));
		assertEquals(0,cc.coinChange(new int[] {1},0));
		assertEquals(1,cc.coinChange(new int[] {1},1));
		assertEquals(2,cc.coinChange(new int[] {1},2));
	}
}
