package com.leetcode.dp.kadane;

import java.util.Arrays;

/***
 * GAS Station
 * 
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1.

Note:

If there exists a solution, it is guaranteed to be unique.
Both input arrays are non-empty and have the same length.
Each element in the input arrays is a non-negative integer.
Example 1:

Input: 
gas  = [1,2,3,4,5]
cost = [3,4,5,1,2]

Output: 3

Explanation:
Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 4. Your tank = 4 - 1 + 5 = 8
Travel to station 0. Your tank = 8 - 2 + 1 = 7
Travel to station 1. Your tank = 7 - 3 + 2 = 6
Travel to station 2. Your tank = 6 - 4 + 3 = 5
Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
Therefore, return 3 as the starting index.
Example 2:

Input: 
gas  = [2,3,4]
cost = [3,4,3]

Output: -1

Explanation:
You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
Travel to station 0. Your tank = 4 - 3 + 2 = 3
Travel to station 1. Your tank = 3 - 3 + 3 = 3
You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
Therefore, you can't travel around the circuit once no matter where you start.
 */
import static org.junit.Assert.assertEquals;
public class GasStation {
	/* Approach 02: Borrowing from Kadane's*/
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int index=-1, balance=0, totalGas=0, totalCost=0;
		for(int i=0; i< gas.length; i++) {
			if(index == -1) index=i;
			totalGas+=gas[i];
			totalCost+=cost[i];
			balance+=gas[i]-cost[i];
//			System.out.println(balance);
			if(balance < 0) {
				balance=0;
				index=-1;
			}
		}
		return (totalGas < totalCost) ? -1:index;
	}
	/* Approach 01: Brute Force. Works, was expecting TLE */
//	public int canCompleteCircuit(int[] gas, int[] cost) {
//		if(Arrays.stream(gas).sum() < Arrays.stream(cost).sum()) return -1;
//		for(int start=0; start< gas.length; start++) {
//			if(gas[start] < cost[start]) continue;
//			int i=start, balance=0;
//			while(true) {
//				balance+=gas[i]-cost[i];
//				System.out.println("["+i+"] : balance "+balance);
//				if(balance < 0) break;
//				i++;
//				if(i == gas.length) i=0;// wrap
//				if(i == start) return start;
//			}
//		}
//        return -1;
//    }
	public static void main(String[] args) {
		GasStation instance = new GasStation();
		assertEquals(3,instance.canCompleteCircuit(new int[] {1,2,3,4,5}, new int[] {3,4,5,1,2}));
		assertEquals(-1,instance.canCompleteCircuit(new int[] {2,3,4}, new int[] {3,4,3}));
		assertEquals(1,instance.canCompleteCircuit(new int[] {0,1}, new int[] {1,0}));
		assertEquals(1,instance.canCompleteCircuit(new int[] {0,1,1}, new int[] {1,0,1}));
	}

}
