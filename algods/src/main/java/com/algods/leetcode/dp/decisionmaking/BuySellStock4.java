package com.algods.leetcode.dp.decisionmaking;
/* Best Time to Buy and Sell Stock IV
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * Notice that you may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).
 * Example 1:
 * Input: k = 2, prices = [2,4,1]
 * Output: 2
 * Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.
 * Example 2:
 * Input: k = 2, prices = [3,2,6,5,0,3]
 * Output: 7
 * Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 * Constraints:
 * 0 <= k <= 109
 * 0 <= prices.length <= 104
 * 0 <= prices[i] <= 1000
 */
public class BuySellStock4 {
	/* Copied:
	 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/discuss/54113/A-Concise-DP-Solution-in-Java
	 * */
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k >= len / 2) return quickSolve(prices);
        
        int[][] t = new int[k + 1][len];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < len; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
            }
        }
        return t[k][len - 1];
    }
    

    private int quickSolve(int[] prices) {
        int len = prices.length, profit = 0;
        for (int i = 1; i < len; i++)
            // as long as there is a price gap, we gain a profit.
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        return profit;
    }
}
