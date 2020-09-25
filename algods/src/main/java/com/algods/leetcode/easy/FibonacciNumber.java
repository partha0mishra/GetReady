package com.algods.leetcode.easy;
/**
 * 509. Fibonacci Number
 * 
 * The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

 

Example 1:

Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
Example 2:

Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
Example 3:

Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 

Note:

0 ≤ N ≤ 30.
 */
import static org.junit.Assert.assertEquals;
public class FibonacciNumber {
	public int fib(int N) {
		int a=0, b=1, tmp;
        while(N>0) {
        	tmp=b;b+=a;a=tmp;N--;
        }
        return a;
    }
	public static void main(String[] args) {
		FibonacciNumber instance= new FibonacciNumber();
		assertEquals(1,instance.fib(2));
		assertEquals(2,instance.fib(3));
		assertEquals(3,instance.fib(4));
		assertEquals(0,instance.fib(0));
		assertEquals(832040,instance.fib(30));
	}

}
