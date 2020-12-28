package com.leetcode.dfs;
/* 1306. Jump Game III
 * Given an array of non-negative integers arr, you are initially positioned at start index of the array. 
 * When you are at index i, you can jump to i + arr[i] or i - arr[i], check if you can reach to any index with value 0.
 * Notice that you can not jump outside of the array at any time.
 * Example 1:
 * Input: arr = [4,2,3,0,3,1,2], start = 5
 * Output: true
 * Explanation: 
 * All possible ways to reach at index 3 with value 0 are: 
 * index 5 -> index 4 -> index 1 -> index 3 
 * index 5 -> index 6 -> index 4 -> index 1 -> index 3 
 * Example 2:
 * Input: arr = [4,2,3,0,3,1,2], start = 0
 * Output: true 
 * Explanation: 
 * One possible way to reach at index 3 with value 0 is: 
 * index 0 -> index 4 -> index 1 -> index 3
 * Example 3:
 * Input: arr = [3,0,2,1,2], start = 2
 * Output: false
 * Explanation: There is no way to reach at index 1 with value 0.
 * Constraints:
 * 1 <= arr.length <= 5 * 10^4
 * 0 <= arr[i] < arr.length
 * 0 <= start < arr.length
 * 
 */
import java.util.HashSet;
import static org.junit.Assert.*;
public class JumpGame3 {
	/* O(n) time as we're going to visit one index only once at max 
	 * O(n) space - dfs stack */
	/* Approach 02: Since the values are all non-negative, we can bypass the Visited HS */
	public boolean canReach(int[] arr, int start) {
        if(start <0 || start >= arr.length || arr[start]<0) return false;
        if(arr[start] == 0) return true;
//  THIS WON'T WORK      arr[start]=-1;
        arr[start]=-arr[start];
        return canReach(arr,start+arr[start]) || canReach(arr,start-arr[start]);
    }	
	/* Approach 01: regular and Generic. Good enough  */
//	HashSet<Integer> visited=new HashSet<>();
//	public boolean canReach(int[] arr, int start) {
//        if(start <0 || start >= arr.length || visited.contains(start)) return false;
//        if(arr[start] == 0) return true;
//        visited.add(start);
//        return canReach(arr,start+arr[start]) || canReach(arr,start-arr[start]);
//    }
	public static void main(String[] args) {
		assertTrue(new JumpGame3().canReach(new int[] {4,2,3,0,3,1,2}, 5));
		assertTrue(new JumpGame3().canReach(new int[] {4,2,3,0,3,1,2}, 0));
		assertFalse(new JumpGame3().canReach(new int[] {3,0,2,1,2}, 2));
	}

}
