package com.leetcode._explore;
/* Maximize Distance to Closest Person
 * You are given an array representing a row of seats where seats[i] = 1 represents a person sitting in the ith seat, and seats[i] = 0 represents that the ith seat is empty (0-indexed).

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to the closest person.

 

Example 1:


Input: seats = [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (i.e. seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: seats = [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat (i.e. seats[3]), the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
Example 3:

Input: seats = [0,1]
Output: 1
 

Constraints:

2 <= seats.length <= 2 * 104
seats[i] is 0 or 1.
At least one seat is empty.
At least one seat is occupied.
 */
import static org.junit.Assert.assertEquals;
public class MaxDistanceClosestPerson {
	public int maxDistToClosest(int[] seats) {
        int start=-1, end=-1, maxDist=-1;
        if(seats[0]==1) start=0;
        for(int i=0; i< seats.length; i++) {
        	if(seats[i]==1) {
        		end=i;// end the interval and then check what's ended
        		if(start < 0) {// first seat was empty
        			maxDist=i;
        		}else {
        			int distance=(end-start)/2;
        			if(distance > maxDist) {
        				maxDist=distance;
        			}
        		}
        		start=i;
        		end=-1;
        	}
        }
        if(start != -1 && end==-1) {// no seat at the end
    		int distance=seats.length -1 - start;
    		if(distance > maxDist) maxDist=distance;
    	}
        
        return maxDist;
    }
	public static void main(String[] args) {
		MaxDistanceClosestPerson instance = new MaxDistanceClosestPerson();
		assertEquals(1,(instance.maxDistToClosest(new int[] {0,1})));//1
		assertEquals(1,(instance.maxDistToClosest(new int[] {1,0})));//1
		assertEquals(2,(instance.maxDistToClosest(new int[] {0,0,1})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {1,0,0})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {0,0,1,0})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {0,1,0,0})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {0,0,1,0,0})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {0,0,1,0,0,0,1})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {1,0,0,1,0,0,0,1})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {1,0,0,0,1,0,0,0,1})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {1,0,0,0,0,1,0,0,0,1})));
		assertEquals(3,(instance.maxDistToClosest(new int[] {1,0,0,0,0,0,1,0,0,0,1})));
		assertEquals(3,(instance.maxDistToClosest(new int[] {1,0,0,0,0,0,1,0,0,0,0,0,1})));
		assertEquals(3,(instance.maxDistToClosest(new int[] {1,0,0,0,1,0,0,0,0,0,1})));
		assertEquals(2,(instance.maxDistToClosest(new int[] {1,0,0,0,1,0,1})));
		assertEquals(3,(instance.maxDistToClosest(new int[] {1,0,0,0})));
		assertEquals(1,(instance.maxDistToClosest(new int[] {1,0,1})));
		assertEquals(1,(instance.maxDistToClosest(new int[] {1,0,1,0})));
	}

}
