package com.algods.leetcode.arrays;
/* Longest Mountain in Array
 * Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

Example 1:

Input: [2,1,4,7,3,2,5]
Output: 5
Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
Example 2:

Input: [2,2,2]
Output: 0
Explanation: There is no mountain.
Note:

0 <= A.length <= 10000
0 <= A[i] <= 10000
Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
 */
import static org.junit.Assert.assertEquals;
public class LongestMountain {
	public int longestMountain(int[] A) {
		if(A.length < 2) return 0;
        boolean upward=false, mountain=false;
        int count=1, maxCount=0, current=A[0];
        for(int i=1; i< A.length; i++) {
        	int n=A[i];
        	if(n < current) {
        		if(upward || mountain) {// first time or regular
        			mountain=true;
        			count+=1;
        			upward=false;// upward is done
        		}
        	}else if(n > current) {
        		if(mountain) {
        			maxCount=Math.max(count, maxCount);
        			mountain=false;
        			count=2;// including the previous one which was lower
        		}else {
        			count+=1;
        		}
        		upward=true;
        	}else {// n== current
        		if(mountain) {
        			maxCount=Math.max(count, maxCount);
        		}
        		count=1;
        		mountain=false;
    			upward=false;
        	}
        	
        	current=n;
        }
        if(mountain) maxCount=Math.max(count, maxCount);
        return maxCount;
    }
	public static void main(String[] args) {
		assertEquals(5,(new LongestMountain().longestMountain(new int[] {2,1,4,7,3,2,5})));
		assertEquals(0,(new LongestMountain().longestMountain(new int[] {2,2,2})));
		assertEquals(0,(new LongestMountain().longestMountain(new int[] {1,2,2,2})));
		assertEquals(0,(new LongestMountain().longestMountain(new int[] {1,2,3})));
		assertEquals(3,(new LongestMountain().longestMountain(new int[] {1,2,1})));
		assertEquals(3,(new LongestMountain().longestMountain(new int[] {1,2,1,2})));
		assertEquals(3,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0,1,2,3})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0,1,2,3,4})));
		assertEquals(5,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0,1,2,3,2})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0,1,2,3,3})));
		assertEquals(4,(new LongestMountain().longestMountain(new int[] {1,2,1,2,1,0,0,1,2,3,3,2})));
		assertEquals(3,(new LongestMountain().longestMountain(new int[] {0,1,0,0,1,0,0,1,1,0,0,0,1,1,0,1,0,1,0,1,0,0,0,1,0,0,1,1,0,1,1,1,1,1,0,0,1,0,1,1,0,0,0,0,0,0,0,0,1,1,0,0,1,1,1,1,0,0,0,1,0,0,1,1,0,0,0,1,0,0,1,1,0,0,0,0,1,0,0,1,1,1,1,1,1,1,0,1,1,0,1,1,1,0,0,0,1,0,1,1})));
	}
}
