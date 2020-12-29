package com.leetcode.recursion.arrays;
import java.util.Arrays;
/* Smallest Range II
 * Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, 
 * and add x to A[i] (only once).
 * After this process, we have some array B.
 * Return the smallest possible difference between the maximum value of B and the minimum value of B.
 * Example 1:
 * Input: A = [1], K = 0
 * Output: 0
 * Explanation: B = [1]
 * Example 2:
 * Input: A = [0,10], K = 2
 * Output: 6
 * Explanation: B = [2,8]
 * Example 3:
 * Input: A = [1,3,6], K = 3
 * Output: 3
 * Explanation: B = [4,6,3]
 * Note:
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 * 0 <= K <= 10000
 */
import static org.junit.Assert.*;
public class SmallestRange2 {
	/* Approach 01: from https://leetcode.com/problems/smallest-range-ii/discuss/173377/C%2B%2BJavaPython-Add-0-or-2-*-K
	 * O(nlogn) for sorting
	 * */
	public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n=A.length, min=A[0], max=A[n-1], diff=max-min;
        for(int i=0; i< n-1; i++) {
        	max=Math.max(max, A[i]+2*K);
        	min=Math.min(A[i+1], A[0]+2*K);
        	diff=Math.min(diff,max-min);
        }
        return diff;
    }

	public static void main(String[] args) {
		SmallestRange2 sr2= new SmallestRange2();
		assertEquals(0,sr2.smallestRangeII(new int[] {1}, 1));
		assertEquals(0,sr2.smallestRangeII(new int[] {0}, 1));
		assertEquals(0,sr2.smallestRangeII(new int[] {1}, 0));
		assertEquals(6,sr2.smallestRangeII(new int[] {0,10}, 2));
		assertEquals(3,sr2.smallestRangeII(new int[] {1,3,6}, 3));
	}

}
