package com.leetcode.dp.kadane;
/** DUPLICATE (not the SRK movie)
 * 121. Best time to buy and sell stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete AT MOST ONE transaction (i.e., buy one and sell one share of the stock), 
 * design an algorithm to find the maximum profit.
 * Note that you cannot sell a stock before you buy one.
 * Example 1:
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
import static org.junit.Assert.assertEquals;
public class BuyAndSellStock {
	/* Approach 02: Kadane's 
	 * The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. 
	 * Since no body has mentioned this so far, I thought it's a good thing for everybody to know.
	 * All the straight forward solution should work, but if the interviewer twists the question slightly by giving 
	 * the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, you might end up being confused.
	 * Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array, 
	 * and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.*/
	public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
        	int diff=prices[i]-prices[i-1];
        	// decide what to do, go with History or Start afresh
        	// History => localMax+diff
        	// Start afresh => 0
        	maxCur=Math.max(0, maxCur+diff);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }
	/* Approach 01: Regular*/
//	public int maxProfit(int[] prices) {
//		if(prices.length <=1) return 0;
//		int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE, result=0;
//		for(int p: prices) {
//			if(p < min) {
//				min=p;
//				max=p;
//			}
//			if(p > max) {
//				max=p;
//			}
//			int r=max-min;
//			if(r> result) result=r;
//		}
//		return result;
//    }
	public static void main(String[] args) {
		BuyAndSellStock instance = new BuyAndSellStock();
		assertEquals(5,instance.maxProfit(new int[] {7,1,5,3,6,4}));
		assertEquals(0,instance.maxProfit(new int[] {7,6,4,3,1}));
		assertEquals(2,instance.maxProfit(new int[] {2,4,1}));
	}

}
