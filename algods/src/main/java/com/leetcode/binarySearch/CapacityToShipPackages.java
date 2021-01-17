package com.leetcode.binarySearch;
/** TODO Anki
 * 1011. Capacity To Ship Packages Within D Days - MEDIUM
 * 
 * A conveyor belt has packages that must be shipped from one port to another within D days.
 * The i-th package on the conveyor belt has a weight of weights[i].  
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights). 
 * We may not load more weight than the maximum weight capacity of the ship.
 * Return the least weight capacity of the ship that will result in all the packages 
 * on the conveyor belt being shipped within D days.
 * 
 * Example 1:
 * Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
 * Output: 15
 * Explanation: 
 * A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
 * 1st day: 1, 2, 3, 4, 5
 * 2nd day: 6, 7
 * 3rd day: 8
 * 4th day: 9
 * 5th day: 10
 * 
 * Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts 
 * like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 
 * Example 2:
 * Input: weights = [3,2,2,4,1,4], D = 3
 * Output: 6
 * Explanation: 
 * A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
 * 1st day: 3, 2
 * 2nd day: 2, 4
 * 3rd day: 1, 4
 * Example 3:
 * Input: weights = [1,2,3,1,1], D = 4
 * Output: 3
 * Explanation: 
 * 1st day: 1
 * 2nd day: 2
 * 3rd day: 3
 * 4th day: 1, 1
 * 
 * Constraints:
 * 1 <= D <= weights.length <= 50000
 * 1 <= weights[i] <= 500
 */
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
/*
 * Binary search probably would not come to our mind when we first meet this problem. 
 * We might automatically treat weights as search space and then realize we've entered a dead end after wasting lots of time. 
 * In fact, we are looking for the minimal one among all feasible capacities. 
 * We dig out the monotonicity of this problem: if we can successfully ship all packages within D days with capacity m, 
 * then we can definitely ship them all with any capacity larger than m. Now we can design a condition function, 
 * let's call it feasible, given an input capacity, it returns whether it's possible to ship all packages within D days. 
 * This can run in a greedy way: if there's still room for the current package, we put this package onto the conveyor belt, 
 * otherwise we wait for the next day to place this package. If the total days needed exceeds D, we return False, 
 * otherwise we return True. 
 * Next, we need to initialize our boundary correctly. 
 * Obviously capacity should be at least max(weights), otherwise the conveyor belt couldn't ship the heaviest package. 
 * On the other hand, capacity need not be more than sum(weights), because then we can ship all packages in just one day.
 * Now we've got all we need to apply our binary search template:
 */
public class CapacityToShipPackages {
	/**
	 * Copied: Simpler implementation
	 */
	public int shipWithinDays(int[] weights, int D) {
	    int lo = 0;

	    for(int w: weights){
	      lo = Math.max(lo, w);
	    }  
	    
	    int hi = lo * weights.length / D;// Brilliant !!

	    while(lo<hi){
	      int mi = (hi+lo)/2;
	      int days = findDays(weights, mi);
	      if(days<=D){// Straight-forward
	        hi=mi;
	      }else{
	        lo=mi+1;
	      }
	    }

	    return lo;
	  }
	  
	  int findDays(int[] weights, int cap){
	    int ans = 1;
	    int sum = 0;
	    for(int w: weights){
	      sum+=w;
	      if(sum>cap){
	        ans++;
	        sum=w;
	      }
	    } 
	    return ans;
	  }
//	public int shipWithinDays(int[] weights, int D) {
////        int left=Arrays.stream(weights).max().getAsInt();
////        int right=Arrays.stream(weights).sum();
//		// DYI :D
//		int left=0,right=0;
//        for(int w: weights){
//            left=Math.max(left,w);// max
//            right+=w;// sum
//        }
////        System.out.println("max: "+left+" sum: "+right);
//        while(left < right) {
//        	int mid= left+(right-left)/2;
//        	if(isEnough(weights,mid,D)) right=mid;
//        	else left=mid+1;
//        }
//        return left;
//    }
//	private boolean isEnough(int[] weights, int capacity, int days) {
//		int count=0, total=0;
//		for(int w: weights) {
//			total+=w;
//			if(total > capacity) {
//				total=w;
//				count++;
//				if(count == days) return false;
//			}
//		}// count < days and total < capacity. 
//		// So, in worst case, the last day will take care of the residual in 'total'
//		return true;
//	}
	public static void main(String[] args) {
		CapacityToShipPackages instance= new CapacityToShipPackages();
		assertEquals(15,instance.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
		assertEquals( 6,instance.shipWithinDays(new int[] {3,2,2,4,1,4}, 3));
		assertEquals( 3,instance.shipWithinDays(new int[] {1,2,3,1,1}, 4));
		assertEquals(15,instance.shipWithinDays(new int[] {1,2,3,4,5,6,7,8,9,10}, 5));
	}
}
