package com.algods.leetcode;
/**
 * Best time to buy and sell stock
 * 
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
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
	/* Approach 02: Kadane's*/
	public int maxProfit(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
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
