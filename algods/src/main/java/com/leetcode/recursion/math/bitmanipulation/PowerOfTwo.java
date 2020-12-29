package com.leetcode.recursion.math.bitmanipulation;
/* 231. Power of Two
 * Given an integer n, write a function to determine if it is a power of two.

 

Example 1:

Input: n = 1
Output: true
Explanation: 20 = 1
Example 2:

Input: n = 16
Output: true
Explanation: 24 = 16
Example 3:

Input: n = 3
Output: false
Example 4:

Input: n = 4
Output: true
Example 5:

Input: n = 5
Output: false
 

Constraints:

-2^31 <= n <= 2^31 - 1
 * 
 * */
public class PowerOfTwo {
	/* Approach 02: n&(n-1) will be Zero for 2's powers */
	public boolean isPowerOfTwo(int n) {
		if(n<0) return false;
		return (n & (n-1)) ==0;
	}
	/* Approach 01: how many bits are 1 */
//	public boolean isPowerOfTwo(int n) {
//        if(n<0) return false;
//        return Integer.bitCount(n)==1;
//    }
}
