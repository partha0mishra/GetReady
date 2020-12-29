package com.leetcode.recursion.dp.decisionmaking;
/*
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * 
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) 
 * with the following restrictions:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * 
 * Example:
 * Input: [1,2,3,0,2]
 * Output: 3 
 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
 */
public class BuySellStock {
	
    public int maxProfit(int[] prices) {
    	// boundary condition: only 1 day
        if(prices.length <=1 ) return 0;
        
        // boundary condition: only 2 days
        if(prices.length ==2)// if the first day is higher, no profit. else buy today and sell tomorrow
        	return prices[0]>prices[1]? 0:prices[1]-prices[0];
        
        int[][] profits=new int[prices.length][2];
        // dp[i][0/1] -> [0] when we don't have a stock, [1] when we have a stock 
        profits[0][0]=0;// understood
        profits[0][1]= -prices[0];// bought it today 
        profits[1][0]= Math.max(profits[0][0], profits[0][1]+prices[1]);
        profits[1][1]= Math.max(-prices[1], profits[0][1]);
        
        for(int i=2; i<prices.length; i++) {// Cooldown can kick in only from 2nd day
        	profits[i][0]=Math.max(profits[i-1][0], profits[i-1][1]+prices[i]);
        	profits[i][1]=Math.max(profits[i-1][1], profits[i-2][0]-prices[i]);
        }
        return profits[prices.length -1][0];
    }
	public static void main(String[] args) {
		BuySellStock instance= new BuySellStock();
		int[] prices1= {1,2,3,0,2};
		System.out.println(instance.maxProfit(prices1));
	}

}
