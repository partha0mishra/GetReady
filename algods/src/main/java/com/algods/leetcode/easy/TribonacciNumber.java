package com.algods.leetcode.easy;
/**
 * 1137. N-th Tribonacci Number
 * 
 * The Tribonacci sequence Tn is defined as follows: 

T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

Given n, return the value of Tn.

 

Example 1:

Input: n = 4
Output: 4
Explanation:
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4
Example 2:

Input: n = 25
Output: 1389537
 

Constraints:

0 <= n <= 37
The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
import static org.junit.Assert.assertEquals;
public class TribonacciNumber {
	public int tribonacci(int n) {
        int a=0,b=1,c=1,tb,tc;
        while(n>0) {
        	tc=c;tb=b;c=a+b+c;b=tc;a=tb;n--;
        }
        return a;
    }
	public static void main(String[] args) {
		TribonacciNumber instance= new TribonacciNumber();
		assertEquals(0,instance.tribonacci(0));
		assertEquals(1,instance.tribonacci(1));
		assertEquals(1,instance.tribonacci(2));
		assertEquals(2,instance.tribonacci(3));
		assertEquals(4,instance.tribonacci(4));
		assertEquals(7,instance.tribonacci(5));
		assertEquals(2082876103,instance.tribonacci(37));
	}

}
