package com.algods.leetcode.math;
/* 172. Factorial Trailing Zeroes
 * Given an integer n, return the number of trailing zeroes in n!.
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 * Example 1:
 * Input: n = 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 * Input: n = 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Example 3:
 * Input: n = 0
 * Output: 0
 * Constraints:
 * 1 <= n <= 104
 * */
import static org.junit.Assert.assertEquals;
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
        int result=0;
        n/=5;
        while(n > 0) {
        	result+=n;
        	n/=5;
        }
        return result;
    }
//	public int trailingZeroes(int n) {
//        int result=0, div=5, d=1;
//        while(d > 0) {
//        	d=n/div;
//        	result+=d;
//        	div*=5;
//        }
//        return result;
//    }
	public static void main(String[] args) {
		assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(0));
		assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(1));
		assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(2));
		assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(3));
		assertEquals(0, new FactorialTrailingZeroes().trailingZeroes(4));
		assertEquals(1, new FactorialTrailingZeroes().trailingZeroes(5));
		assertEquals(2, new FactorialTrailingZeroes().trailingZeroes(10));
		assertEquals(6, new FactorialTrailingZeroes().trailingZeroes(25));
		assertEquals(12, new FactorialTrailingZeroes().trailingZeroes(50));
		assertEquals(24, new FactorialTrailingZeroes().trailingZeroes(100));
	}
}
