package com.leetcode.recursion.math.bitmanipulation;
/* 461. Hamming Distance
 * 
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.

Note:
0 ≤ x, y < 231.

Example:

Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 * */
public class HammingDistance {
	/* Approach 02: Doing it the 'bit manipulation' way */
	public int hammingDistance(int x, int y) {
		return Integer.bitCount(x^y);
	}
	/* Approach 01: Regular. Works at 100 percentile though*/
//	public int hammingDistance(int x, int y) {
//		int result=0;
//        while(x > 0 || y > 0) {
//        	// in fact, this was faster
//        	// if(x%2 != y%2) result++
//        	if((x&1) != (y&1)) result++; 
//        	x>>=1;
//        	y>>=1;
//        }
//        return result;
//    }
}
