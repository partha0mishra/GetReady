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
* The queue size need not be the same as the window’s size.
* Remove redundant elements and the queue should store only elements that need to be considered.
 */
public class SlidingWindowMaximum {
	/* Approach 01: Brute Force
	 * O(n2) - check each window and calculate max
	 */
	public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        if(k==0 || n <2) return nums;
        int r=n-k+1;
        int[] result=new int[r];
        for(int i=0; i<= n-k; i++) {
        	int max=nums[i];
        	for(int j=1; j< k; j++) {
        		max=Math.max(max, nums[i+j]);
        	}
        	result[i]=max;
        }
        return result;
    }
	public static void main(String[] args) {
		SlidingWindowMaximum instance= new SlidingWindowMaximum();
		instance.maxSlidingWindow(new int[] {1,3,-1,-3,5,3,6,7}, 3);
	}
}
