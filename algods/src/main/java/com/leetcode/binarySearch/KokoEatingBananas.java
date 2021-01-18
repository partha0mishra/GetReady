package com.leetcode.binarySearch;
/**
 * 875. Koko Eating Bananas
 * Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  
 * The guards have gone and will come back in H hours.
 * Koko can decide her bananas-per-hour eating speed of K.  
 * Each hour, she chooses some pile of bananas, and eats K bananas from that pile.  
 * If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during this hour.
 * Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
 * Return the minimum integer K such that she can eat all the bananas within H hours.
 * Example 1:
 * Input: piles = [3,6,7,11], H = 8
 * Output: 4
 * Example 2:
 * Input: piles = [30,11,23,4,20], H = 5
 * Output: 30
 * Example 3:
 * Input: piles = [30,11,23,4,20], H = 6
 * Output: 23
 * Constraints:
 * 1 <= piles.length <= 10^4
 * piles.length <= H <= 10^9
 * 1 <= piles[i] <= 10^9
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;

public class KokoEatingBananas {
	/**
	 * Very similar to LC 1011 and LC 410 mentioned above. 
	 * Let's design a feasible function, given an input speed, 
	 * determine whether Koko can finish all bananas within H hours with hourly eating speed. 
	 * Obviously, the lower bound of the search space is 1, and upper bound is max(piles), 
	 * because Koko can only choose one pile of bananas to eat every hour.
	 * 
	 * Binary Search: O(N log W)/ O(1) -> N= no of piles, W= max size of piles
	 */
	public int minEatingSpeed(int[] piles, int H) {
        int left=1;// min rate of eating
        int right=Arrays.stream(piles).max().getAsInt();// max rate of eating
        while(left < right) {
        	int mid= left+ (right-left)/2;
        	if(isFeasible(piles,mid,H)) right=mid;
        	else left=mid+1;
        }
        return left;
    }
	private boolean isFeasible(int[] piles, int rate, int hours) {
		int count=0;
		for(int p: piles) {
//			count+=p/rate;
//			count+=(p%rate > 0)? 1:0;
			count+=(p-1)/rate+1;
			if(count > hours) return false;
		}
		return true;
	}
	public static void main(String[] args) {
		KokoEatingBananas instance = new KokoEatingBananas();
		assertEquals(4,instance.minEatingSpeed(new int[] {3,6,7,11}, 8));
		assertEquals(30,instance.minEatingSpeed(new int[] {30,11,23,4,20}, 5));
		assertEquals(23,instance.minEatingSpeed(new int[] {30,11,23,4,20}, 6));
//		assertEquals(4,instance.minEatingSpeed(new int[] {3,6,7,11}, 8));
	}

}
