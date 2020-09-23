package com.algods.leetcode.sweepLine;

/**
 * CAR Pooling
 * You are driving a vehicle that has capacity empty seats initially available for passengers.  The vehicle only drives east (ie. it cannot turn around and drive west.)

Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.  The locations are given as the number of kilometers due east from your vehicle's initial location.

Return true if and only if it is possible to pick up and drop off all passengers for all the given trips. 

 

Example 1:

Input: trips = [[2,1,5],[3,3,7]], capacity = 4
Output: false
Example 2:

Input: trips = [[2,1,5],[3,3,7]], capacity = 5
Output: true
Example 3:

Input: trips = [[2,1,5],[3,5,7]], capacity = 3
Output: true
Example 4:

Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
Output: true
 
 

Constraints:

trips.length <= 1000
trips[i].length == 3
1 <= trips[i][0] <= 100
0 <= trips[i][1] < trips[i][2] <= 1000
1 <= capacity <= 100000
 */
//import java.util.Arrays;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
public class CarPooling {
	/* Approach 02: Sweep Line
	 * Clever - since max trips = 1000, use boarding and off-boarding*/
	public boolean carPooling(int[][] trips, int capacity) {    
		  int stops[] = new int[1001]; 
		  for (int t[] : trips) {
		      stops[t[1]] += t[0];
		      stops[t[2]] -= t[0];
//		      System.out.println(stops[t[1]]+" "+stops[t[2]]);
		  }
		  for (int i = 0; capacity >= 0 && i < 1001; ++i) capacity -= stops[i];
		  return capacity >= 0;
		}
	/* Approach 01: brute force*/
//	public boolean carPooling(int[][] trips, int capacity) {
//		// getting max and min from one iteration
//		int start=trips[0][1];
//		int end=trips[0][2];
//		
//		for(int[] t: trips) {
//			if(t[1] < start) start=t[1];
//			if(t[2] > end) end=t[2];
//		}
//		
//		int[] load= new int[end-start];
//		
//		for(int[] t: trips) {
//			for(int i=t[1]; i< t[2]; i++) {
//				load[i-start]+=t[0];
//				if(load[i-start] > capacity) return false;
//			}
//		}
////		for(int l: load) System.out.println(l);
//		
//		return true;
//    }
	public static void main(String[] args) {
		CarPooling instance = new CarPooling();
		assertFalse(instance.carPooling(new int[][] {{2,1,5},{3,3,7}}, 4));
		assertTrue(instance.carPooling(new int[][] {{2,1,5},{3,3,7}}, 5));
		assertTrue(instance.carPooling(new int[][] {{2,1,5},{3,5,7}}, 3));
		assertTrue(instance.carPooling(new int[][] {{3,2,7},{3,7,9},{8,3,9}}, 11));
		assertTrue(instance.carPooling(new int[][] {{9,3,4},{9,1,7},{4,2,4},{7,4,5}}, 23));
	}

}
