package com.algods.leetcode;
/*
 * 5464. Water Bottles
 * Given numBottles full water bottles, you can exchange numExchange empty water bottles for one full water bottle.
 * The operation of drinking a full water bottle turns it into an empty bottle.
 * Return the maximum number of water bottles you can drink.
 * 
 * Input: numBottles = 9, numExchange = 3
 * Output: 13
 * Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
 * Number of water bottles you can drink: 9 + 3 + 1 = 13.
 * 
 * Input: numBottles = 15, numExchange = 4
 * Output: 19
 * Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
 * Number of water bottles you can drink: 15 + 3 + 1 = 19.
 * 
 * Input: numBottles = 5, numExchange = 5
 * Output: 6
 * 
 * Input: numBottles = 2, numExchange = 3
 * Output: 2
 */
public class WaterBottlesExchange {
	public int numWaterBottles(int numBottles, int numExchange) {
        int result=numBottles;
        if (numBottles == 0) return 0;// starting with 0 bottles
        if (numExchange == 0) return numBottles;// can't exchange 
        
        while(numBottles >= numExchange) {
        	int fullExchanges =0;
            int residuals=0;
        	
        	fullExchanges =  numBottles/numExchange;
        	residuals = numBottles%numExchange;
        	numBottles = fullExchanges+residuals;
        	result+=fullExchanges;
        }
        
        return result;
    }
	public static void main(String[] args) {
		System.out.println("5,5 => "+ new WaterBottlesExchange().numWaterBottles(5, 5));
		System.out.println("2,3 => "+ new WaterBottlesExchange().numWaterBottles(2, 3));
		System.out.println("0,0 => "+ new WaterBottlesExchange().numWaterBottles(0, 0));
		System.out.println("10,0 => "+ new WaterBottlesExchange().numWaterBottles(10, 0));
		System.out.println("9,3 => "+ new WaterBottlesExchange().numWaterBottles(10, 0));
		System.out.println("15,4 => "+ new WaterBottlesExchange().numWaterBottles(15, 4));
	}

}
