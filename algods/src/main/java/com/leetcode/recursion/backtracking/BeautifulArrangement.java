package com.leetcode.recursion.backtracking;
/**
 * Beautiful Arrangement
 * Suppose you have n integers from 1 to n. We define a beautiful arrangement as an array that is constructed by 
 * these n numbers successfully if one of the following is true for the ith position (1 <= i <= n) in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
Given an integer n, return the number of the beautiful arrangements that you can construct.

Example 1:

Input: n = 2
Output: 2
Explanation: 
The first beautiful arrangement is [1, 2]:
Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
The second beautiful arrangement is [2, 1]:
Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 15
 */
import java.util.*;
import static org.junit.Assert.assertEquals;
public class BeautifulArrangement {
	int count;
	public int countArrangement(int n) {
		count=0;// otherwise when the function is called multiple times the global variable will get aggregated
        backtrack(n,1,new HashSet<Integer> ());// nums, index, used
		return count;
    }
	private void backtrack(int n, int index, HashSet<Integer> used) {
		if(index > n) {count+=1; return;}
		for(int i=1; i <= n; i++) {
			if(isBeautiful(i, index, used)) {
				used.add(i);
				backtrack(n, index+1, used);
				used.remove(i);
			}
		}
	}
	private boolean isBeautiful(int num, int index, HashSet<Integer> used) {
		return used.contains(num) ? false: (num %index ==0 || index%num ==0);
	}
	public static void main(String[] args) {
		BeautifulArrangement ba= new BeautifulArrangement();
		assertEquals(1, ba.countArrangement(1));
		assertEquals(2, ba.countArrangement(2));
		assertEquals(3, ba.countArrangement(3));
		assertEquals(8, ba.countArrangement(4));
		assertEquals(10, ba.countArrangement(5));
		assertEquals(36, ba.countArrangement(6));
		assertEquals(41, ba.countArrangement(7));
		assertEquals(132, ba.countArrangement(8));
		assertEquals(250, ba.countArrangement(9));
		assertEquals(700, ba.countArrangement(10));
		assertEquals(750, ba.countArrangement(11));
		assertEquals(4010, ba.countArrangement(12));
		assertEquals(4237, ba.countArrangement(13));
		assertEquals(10680, ba.countArrangement(14));
		assertEquals(24679, ba.countArrangement(15));
	}
}
