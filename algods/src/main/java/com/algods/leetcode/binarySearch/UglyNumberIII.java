package com.algods.leetcode.binarySearch;
/*
 * 1201. Ugly Number III - MEDIUM
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive integers which are divisible by a or b or c.
 * Example 1:
 * Input: n = 3, a = 2, b = 3, c = 5
 * Output: 4
 * Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
 * Example 2:
 * Input: n = 4, a = 2, b = 3, c = 4
 * Output: 6
 * Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
 * Example 3:
 * Input: n = 5, a = 2, b = 11, c = 13
 * Output: 10
 * Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
 * Example 4:
 * Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
 * Output: 1999999984
 * Constraints:
 * 1 <= n, a, b, c <= 10^9
 * 1 <= a * b * c <= 10^18
 * It's guaranteed that the result will be in range [1, 2 * 10^9]
 */
import static org.junit.Assert.assertEquals;

public class UglyNumberIII {
	public int nthUglyNumber(int n, int a, int b, int c) {
        int left=1, right=(int)2e9;
        while(left < right) {
        	int mid=left+(right-left)/2;
        	if(isEnough(mid, n, a, b, c)) right=mid;
        	else left=mid+1;
        }
        return left;
    }
	private boolean isEnough(long m, long n, long a, long b, long c) {
		long count= m/a + m/b + m/c - m/lcm(a,b) -m/lcm(b,c) -m/lcm(c,a) + m/lcm(a,lcm(b,c));
		if(count >= n) return true;
		return false;
	}
	long gcd(long a, long b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }
    long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
	public static void main(String[] args) {
		UglyNumberIII instance= new UglyNumberIII();
		assertEquals( 4,instance.nthUglyNumber(3, 2,  3,  5));
		assertEquals( 6,instance.nthUglyNumber(4, 2,  3,  4));
		assertEquals(10,instance.nthUglyNumber(5, 2, 11, 13));
		assertEquals(1999999984,instance.nthUglyNumber(1000000000, 2,  217983653,  336916467));
	}

}
