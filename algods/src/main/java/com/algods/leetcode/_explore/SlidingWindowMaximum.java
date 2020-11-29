package com.algods.leetcode._explore;
/* 
 * 239. Sliding Window Maximum
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

 

Example 1:

Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
Example 2:

Input: nums = [1], k = 1
Output: [1]
Example 3:

Input: nums = [1,-1], k = 1
Output: [1,-1]
Example 4:

Input: nums = [9,11], k = 2
Output: [11]
Example 5:

Input: nums = [4,-2], k = 2
Output: [4]
 

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
1 <= k <= nums.length
* Hints:
* How about using a data structure such as deque (double-ended queue)?
* The queue size need not be the same as the window�s size.
* Remove redundant elements and the queue should store only elements that need to be considered.
 */
import java.util.*;
public class SlidingWindowMaximum {
	/* REF: 
	 * https://leetcode.com/problems/sliding-window-maximum/discuss/458121/Java-All-Solutions-(B-F-PQ-Deque-DP)-with-Explanation-and-Complexity-Analysis
	 * 
	 */
	/* Approach 02: Priority Queue : Still TLE as PQ.remove() is O(n)
	 * O(nk), O(k) for space for the PQ
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
		int n=nums.length;
		if(k==0 || n <2) return nums;
		int r=n-k+1;
		int[] result=new int[r];
		// keeping indices in PQ while the comparison is based on the numbers.
		// since numbers can be duplicates
		PriorityQueue<Integer> pq= new PriorityQueue<>((i1,i2) -> Integer.compare(nums[i2], nums[i1]));
		for(int i=0; i< n; i++) {
			pq.offer(i);
			if(i >= k-1) {// for k=3. result starts at i=0,1,2 (k-1) 
				result[i-k+1]=nums[pq.peek()];// i-k+1= 2-3+1=0 result[0]=max
				pq.remove(i-k+1);// remove index 0
			}
		}
		return result;
	}
	/* Approach 01: Brute Force TLE
	 * O(nk), O(1) - check each window and calculate max
	 */
//	public int[] maxSlidingWindow(int[] nums, int k) {
//        int n=nums.length;
//        if(k==0 || n <2) return nums;
//        int r=n-k+1;
//        int[] result=new int[r];
//        for(int i=0; i<= n-k; i++) {
//        	int max=nums[i];
//        	for(int j=1; j< k; j++) {
//        		max=Math.max(max, nums[i+j]);
//        	}
//        	result[i]=max;
//        }
//        return result;
//    }
	public static void main(String[] args) {
		SlidingWindowMaximum instance= new SlidingWindowMaximum();
		int[] result=instance.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
		for(int r: result) {
			System.out.print(r+" ");
		}
	}
}
