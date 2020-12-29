package com.leetcode.binarySearch;
/**
 * 69 Sqrt(x) - EASY
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 * Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.
 * Example 1:
 * Input: 4
 * Output: 2
 * 
 * Example 2:
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.
 */
import static org.junit.Assert.assertEquals;
public class CalculateSQRT {
	public int mySqrt(int x) {
		if(x<=1) return x; // special cases of 0 and 1
		int left=1, right=x; // start from 1. we don't want mid to become Zero.
		while(left < right) {
			int mid=left+(right-left)/2;
			if(mid > x/mid) right=mid; // since mid*mid can cause overflow
			else left=mid+1;
		}
		return left-1;
    }
	public static void main(String[] args) {
		CalculateSQRT instance = new CalculateSQRT();
		assertEquals(0,instance.mySqrt(0));
		assertEquals(1,instance.mySqrt(1));
		assertEquals(1,instance.mySqrt(2));
		assertEquals(2,instance.mySqrt(4));
		assertEquals(2,instance.mySqrt(8));
		assertEquals(46339,instance.mySqrt(2147395599));
		assertEquals(46340,instance.mySqrt(2147483647));
	}

}
